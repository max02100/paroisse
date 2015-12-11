package com.krealid.starter.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import com.krealid.starter.R;
import com.krealid.starter.rss.RssItem;

public class EvangilesAdapter extends RecyclerView.Adapter<EvangilesAdapter.ViewHolder> {

    private ArrayList<RssItem> mData = new ArrayList<>();
    public Context context;

    public EvangilesAdapter(ArrayList data, Context context){
        this.context = context;
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.evangile_card, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
       final RssItem article = mData.get(position);
            holder.title.setText(article.getTitle());
            holder.intro.setText(mData.get(position).getDescription().trim());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView title;
        public DocumentView intro;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = ButterKnife.findById(itemView, R.id.cardNews);
            title = ButterKnife.findById(itemView, R.id.titleEvangile);
            intro = ButterKnife.findById(itemView, R.id.introEvangile);
        }
    }
}
