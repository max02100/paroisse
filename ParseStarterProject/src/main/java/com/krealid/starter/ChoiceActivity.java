package com.krealid.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.krealid.starter.R;

import butterknife.ButterKnife;

/**
 * Created by Maxime on 07/09/2015.
 */
public class ChoiceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        ImageButton evangileButton      = ButterKnife.findById(this, R.id.evangileButton);
        ImageButton newsButton          = ButterKnife.findById(this, R.id.newsButton);
        ImageButton horairesButton      = ButterKnife.findById(this, R.id.horairesButton);
        ImageButton mouvementsButton    = ButterKnife.findById(this, R.id.mouvementsButton);
        ImageButton uselessButton       = ButterKnife.findById(this, R.id.uselessButton);
        ImageButton plusButton          = ButterKnife.findById(this, R.id.plusButton);

        evangileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ChoiceActivity.this, ListingActivity.class);
                mainIntent.putExtra("choix", 0);
                ChoiceActivity.this.startActivity(mainIntent);
                ChoiceActivity.this.finish();
            }
        });

        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ChoiceActivity.this, ListingActivity.class);
                mainIntent.putExtra("choix", 1);
                ChoiceActivity.this.startActivity(mainIntent);
                ChoiceActivity.this.finish();
            }
        });

        horairesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ChoiceActivity.this, HorairesActivity.class);
                ChoiceActivity.this.startActivity(mainIntent);
                ChoiceActivity.this.finish();
            }
        });

        mouvementsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ChoiceActivity.this, ListingActivity.class);
                mainIntent.putExtra("choix", 3);
                ChoiceActivity.this.startActivity(mainIntent);
                ChoiceActivity.this.finish();
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ChoiceActivity.this, AboutActivity.class);
                ChoiceActivity.this.startActivity(mainIntent);
                ChoiceActivity.this.finish();
            }
        });

        uselessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ChoiceActivity.this, AboutEvangileActivity.class);
                ChoiceActivity.this.startActivity(mainIntent);
                ChoiceActivity.this.finish();
            }
        });
    }
}