package com.krealid.starter;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import com.parse.ParseInstallation;
import com.krealid.starter.rss.RssItem;

public class StarterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(this, "TRv9jWxwtB4NUJxReIPTx6U1VUlMFgOcnEmk768H", "mpzSOqLl9OtfSvCeLEiUhL9782PL3NLMECEqEkPA");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }

    private RssItem selectedArticle = null;

    public RssItem getSelectedArticle() {
        return selectedArticle;
    }

    public void setSelectedArticle(RssItem article) {
        selectedArticle = article;
    }
}