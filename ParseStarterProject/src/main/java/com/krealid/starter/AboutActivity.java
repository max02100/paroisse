package com.krealid.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.IntentPickerSheetView;

import java.util.Comparator;

/**
 * Created by Maxime on 07/09/2015.
 */
public class AboutActivity extends AppCompatActivity {

    protected BottomSheetLayout bottomSheetLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);

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

        FloatingActionButton fabShare = (FloatingActionButton) findViewById(R.id.floating_action_button);
        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,
                        new String[] {"contact@krealid.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                        "Prise de contact via l'application de la Paroisse St Rieul");
                IntentPickerSheetView intentPickerSheet = new IntentPickerSheetView(AboutActivity.this, emailIntent, "Nous contacter", new IntentPickerSheetView.OnIntentPickedListener() {
                    @Override
                    public void onIntentPicked(IntentPickerSheetView.ActivityInfo activityInfo) {
                        bottomSheetLayout.dismissSheet();
                        startActivity(activityInfo.getConcreteIntent(emailIntent));
                    }
                });
                // Sort activities in reverse order for no good reason
                intentPickerSheet.setSortMethod(new Comparator<IntentPickerSheetView.ActivityInfo>() {
                    @Override
                    public int compare(IntentPickerSheetView.ActivityInfo lhs, IntentPickerSheetView.ActivityInfo rhs) {
                        return rhs.label.compareTo(lhs.label);
                    }
                });
                bottomSheetLayout.showWithSheetView(intentPickerSheet);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mainIntent = new Intent(AboutActivity.this, ChoiceActivity.class);
        this.startActivity(mainIntent);
        this.finish();
    }
}
