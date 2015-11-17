package com.krealid.starter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bluejamesbond.text.DocumentView;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.krealid.starter.R;

/**
 * Created by Maxime on 24/09/2015.
 */
public class AboutEvangileActivity extends AppCompatActivity {

    protected BottomSheetLayout bottomSheetLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_evangile_activity);

        bottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomsheet);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        DocumentView textAbout = (DocumentView) findViewById(R.id.text_evangile_about);
        textAbout.setText(this.getResources().getString(R.string.about_evangile));

        FloatingActionButton fabShare = (FloatingActionButton) findViewById(R.id.floating_action_button);
        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://levangileauquotidien.org/"));
                startActivity(browserIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mainIntent = new Intent(AboutEvangileActivity.this, ChoiceActivity.class);
        this.startActivity(mainIntent);
        this.finish();
    }
}