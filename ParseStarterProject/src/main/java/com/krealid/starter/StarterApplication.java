package com.krealid.starter;

import android.app.Application;

import com.krealid.starter.rss.RssItem;

public class StarterApplication extends Application {

    @Override
    public void onCreate() {}

    private RssItem selectedArticle = null;

    public RssItem getSelectedArticle() {
        return selectedArticle;
    }

    public void setSelectedArticle(RssItem article) {
        selectedArticle = article;
    }
}