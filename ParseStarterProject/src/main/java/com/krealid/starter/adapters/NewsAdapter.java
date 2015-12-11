package com.krealid.starter.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.krealid.starter.ActuActivity;
import com.krealid.starter.ListingActivity;
import com.krealid.starter.R;
import com.krealid.starter.StarterApplication;
import com.krealid.starter.rss.RssItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

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
                .from(context)
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
                Intent go = new Intent(context.getApplicationContext(), ActuActivity.class);
                context.startActivity(go);
            }
        });

        holder.title.setText(article.getTitle());
        String intro = mData.get(position).getDescription();
        if (intro != null && intro.length() > 0) {
            intro = Html.fromHtml(intro).toString().replace('\n', (char) 32)
                    .replace((char) 160, (char) 32).replace((char) 65532, (char) 32).trim();

            if (intro.length() > 50) {
                holder.intro.setText(intro.substring(0, 50) + " ...");
            } else {
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
        @Bind(R.id.news_image)
        ImageView mImageView;
        @Bind(R.id.titleActu)
        TextView title;
        @Bind(R.id.introActu)
        DocumentView intro;
        @Bind(R.id.introButton)
        ImageButton introButton;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
