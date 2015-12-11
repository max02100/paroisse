package com.krealid.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Maxime on 07/09/2015.
 */
public class ChoiceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.plusButton)
    void plusButton(){
        Intent mainIntent = new Intent(ChoiceActivity.this, AboutActivity.class);
        ChoiceActivity.this.startActivity(mainIntent);
    }

    @OnClick(R.id.uselessButton)
    void useLessButton(){
        Intent mainIntent = new Intent(ChoiceActivity.this, AboutEvangileActivity.class);
        ChoiceActivity.this.startActivity(mainIntent);
    }

    @OnClick(R.id.mouvementsButton)
    void mouvementsButton(){
        Intent mainIntent = new Intent(ChoiceActivity.this, ListingActivity.class);
        mainIntent.putExtra("choix", 3);
        ChoiceActivity.this.startActivity(mainIntent);
    }

    @OnClick(R.id.horairesButton)
    void horairesButton(){
        Intent mainIntent = new Intent(ChoiceActivity.this, HorairesActivity.class);
        ChoiceActivity.this.startActivity(mainIntent);
    }

    @OnClick(R.id.newsButton)
    void newsButton(){
        Intent mainIntent = new Intent(ChoiceActivity.this, ListingActivity.class);
        mainIntent.putExtra("choix", 1);
        ChoiceActivity.this.startActivity(mainIntent);
    }

    @OnClick(R.id.evangileButton)
    void evangileButton(){
        Intent mainIntent = new Intent(ChoiceActivity.this, ListingActivity.class);
        mainIntent.putExtra("choix", 0);
        ChoiceActivity.this.startActivity(mainIntent);
    }
}