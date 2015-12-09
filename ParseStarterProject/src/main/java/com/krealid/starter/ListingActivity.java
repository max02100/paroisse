package com.krealid.starter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import butterknife.ButterKnife;

import com.krealid.starter.adapters.ContactAdapter;
import com.krealid.starter.adapters.EvangilesAdapter;
import com.krealid.starter.adapters.NewsAdapter;
import com.krealid.starter.rss.RssItem;
import com.krealid.starter.rss.RssReader;
import com.krealid.starter.R;
import com.krealid.starter.rss.RssFeed;

/**
 * Created by Maxime on 23/07/2015.
 */
public class ListingActivity extends Activity{

    private RecyclerView recyclerView;
    private ArrayList<RssItem> feeds = new ArrayList<>();
    private int choix;
    public static int mCurCheckPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standard_app_bar_fragment);

        choix = getIntent().getIntExtra("choix", 0);

        Toolbar mToolbar = ButterKnife.findById(this, R.id.toolbar);
        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        recyclerView = ButterKnife.findById(this, R.id.simpleList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        switch (choix){
            case 0:
                new RetrieveFeedTask("http://levangileauquotidien.org/rss/v2/evangelizo_rss-fr.xml",
                        choix)
                        .execute();
                break;
            case 1:
                new RetrieveFeedTask("http://www.paroissesaintrieul.org/index.php?format=feed&type=rss",
                        choix)
                        .execute();
                break;
            case 3:
                ContactAdapter contactAdapter = new ContactAdapter(this);
                recyclerView.setAdapter(contactAdapter);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mainIntent = new Intent(ListingActivity.this, ChoiceActivity.class);
        this.startActivity(mainIntent);
        this.finish();
    }

    private class RetrieveFeedTask extends AsyncTask<Void, Void, Void> {

        private ProgressDialog progressDialog;
        private String link;
        private int choice;

        public RetrieveFeedTask(String link, int choice) {
            super();
            this.link = link;
            this.choice = choice;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(ListingActivity.this,
                    "Veuillez patienter", "Téléchargement en cours");
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            RssFeed feed = null;
            try {
                URL url = new URL(this.link);
                feed = RssReader.read(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ArrayList<RssItem> rssItems = feed != null ? feed.getRssItems() : null;
            feeds = rssItems;
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();

            switch (choice){
                case 0:
                    for (int i = 0; i < feeds.size(); i++) {
                        if( feeds.get(i).getTitle().toLowerCase().contains("vangile de ".toLowerCase() ) == true){
                            RssItem item = feeds.get(i);
                            feeds.clear();
                            feeds.add(item);
                            break;
                        }
                    }
                    EvangilesAdapter evangilesAdapter = new EvangilesAdapter(feeds, ListingActivity.this);
                    recyclerView.setAdapter(evangilesAdapter);
                    break;
                case 1:
                    NewsAdapter newsAdapter = new NewsAdapter(feeds, ListingActivity.this);
                    recyclerView.setAdapter(newsAdapter);
                    break;
            }
        }
    }
}
