package com.krealid.starter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;

import com.github.aakira.expandablelayout.Utils;
import com.krealid.starter.R;
import com.krealid.starter.adapters.HeaderHorairesAdapter;

/**
 * Created by Maxime on 08/09/2015.
 */
public class HorairesActivity extends Activity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standard_app_bar_fragment);

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
        recyclerView.setAdapter(new HeaderHorairesAdapter(this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mainIntent = new Intent(HorairesActivity.this, ChoiceActivity.class);
        this.startActivity(mainIntent);
        this.finish();
    }
}