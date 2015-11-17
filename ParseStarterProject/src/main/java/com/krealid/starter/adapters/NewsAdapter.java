package com.krealid.starter.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.krealid.starter.StarterApplication;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.ButterKnife;
import com.krealid.starter.ActuActivity;
import com.krealid.starter.ListingActivity;
import com.krealid.starter.R;
import com.krealid.starter.rss.RssItem;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<RssItem> mData = new ArrayList<RssItem>();
    public Context context;

    public NewsAdapter(ArrayList data, Context context) {
        this.context = context;
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.news_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final RssItem article = mData.get(position);

        Picasso.with(context)
                .load(mData.get(position).getContent())
                .resizeDimen(R.dimen.image_width, R.dimen.image_height)
                .centerCrop()
                .into(holder.mImageView);

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListingActivity.mCurCheckPosition = position;
                ((StarterApplication) context.getApplicationContext()).setSelectedArticle(article);
                //((DrawerActivity) context).changeFragment(NewFragment.newInstance());
                Intent go = new Intent(context.getApplicationContext(), ActuActivity.class);
                context.startActivity(go);
            }
        });

        holder.title.setText(article.getTitle());
        String intro = mData.get(position).getDescription();
        if(intro != null && intro.length()>0){
            intro = Html.fromHtml( intro ).toString().replace('\n', (char) 32)
                    .replace((char) 160, (char) 32).replace((char) 65532, (char) 32).trim() ;

            if(intro.length() > 50){
                holder.intro.setText(intro.substring(0, 50) + " ...");
            }else{
                holder.intro.setText(intro + " ...");
            }
        }
        
        holder.introButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListingActivity.mCurCheckPosition = position;
                ((StarterApplication) context.getApplicationContext()).setSelectedArticle(article);
                Intent go = new Intent(context.getApplicationContext(), ActuActivity.class);
                context.startActivity(go);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public CardView cardView;
        public TextView title;
        public DocumentView intro;
        public ImageButton introButton;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = ButterKnife.findById(itemView, R.id.news_image);
            cardView = ButterKnife.findById(itemView, R.id.cardNews);
            title = ButterKnife.findById(itemView, R.id.titleActu);
            intro = ButterKnife.findById(itemView, R.id.introActu);
            introButton = ButterKnife.findById(itemView, R.id.introButton);
        }
    }
}
