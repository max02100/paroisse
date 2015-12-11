package com.krealid.starter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.krealid.starter.adapters.ContactAdapter;
import com.krealid.starter.adapters.EvangilesAdapter;
import com.krealid.starter.adapters.NewsAdapter;
import com.krealid.starter.rss.RssFeed;
import com.krealid.starter.rss.RssItem;
import com.krealid.starter.rss.RssReader;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maxime on 23/07/2015.
 */
public class ListingActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.simpleList)
    RecyclerView recyclerView;

    private ArrayList<RssItem> feeds = new ArrayList<>();
    public static int mCurCheckPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standard_app_bar_fragment);
        ButterKnife.bind(this);

        int choix = getIntent().getIntExtra("choix", 0);

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
                recyclerView.setAdapter(new ContactAdapter(this));
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
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }
            feeds = feed != null ? feed.getRssItems() : null;
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();

            switch (choice){
                case 0:
                    for (int i = 0; i < feeds.size(); i++) {
                        if(feeds.get(i).getTitle().toLowerCase().contains("vangile de ".toLowerCase())){
                            RssItem item = feeds.get(i);
                            feeds.clear();
                            feeds.add(item);
                            break;
                        }
                    }
                    recyclerView.setAdapter(new EvangilesAdapter(feeds, ListingActivity.this));
                    break;
                case 1:
                    recyclerView.setAdapter(new NewsAdapter(feeds, ListingActivity.this));
                    break;
            }
        }
    }
}
