package com.krealid.starter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bluejamesbond.text.DocumentView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Maxime on 24/09/2015.
 */
public class AboutEvangileActivity extends AppCompatActivity {

    @BindView(R.id.anim_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.text_evangile_about)
    DocumentView textAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_evangile_activity);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        textAbout.setText(this.getResources().getString(R.string.about_evangile));
    }

    @OnClick(R.id.floating_action_button)
    void openWebsite(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://levangileauquotidien.org/"));
        startActivity(browserIntent);
    }
}