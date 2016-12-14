package com.krealid.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.IntentPickerSheetView;
import com.krealid.starter.adapters.ActuExpendedAdapter;
import com.krealid.starter.rss.RssItem;
import com.squareup.picasso.Picasso;

import java.util.Comparator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Maxime on 24/08/2015.
 */
public class ActuActivity extends AppCompatActivity {

    @BindView(R.id.bottomsheet)
    BottomSheetLayout bottomSheetLayout;
    @BindView(R.id.article_title)
    TextView articleTitle;
    @BindView(R.id.scrollableview)
    RecyclerView recyclerView;
    @BindView(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.anim_toolbar)
    Toolbar mToolbar;

    private RssItem article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        ButterKnife.bind(this);

        /*Récupération des données de l'article choisi*/
        article = ((StarterApplication) this.getApplication()).getSelectedArticle();

        /*Gestion de la toolbar*/
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        articleTitle.setText(article.getTitle());

        /* Gestion de l'image pour le header*/
        ImageView header = (ImageView) findViewById(R.id.header);
        String imgStart = "<img src=\"";
        String imgEnd = "\" alt";
        String imgBaliseEnd = "/>";
        int indexToStartImg = article.getDescription().indexOf(imgStart);
        int indexToEndImg = (article.getDescription().substring(indexToStartImg)).indexOf(imgEnd);
        int indexToEndBaliseImg = (article.getDescription().substring(indexToStartImg)).indexOf(imgBaliseEnd) + 2;

        String articleText = article.getDescription().substring(indexToStartImg + indexToEndBaliseImg);
        String imgLink = article.getDescription().substring(indexToStartImg + imgStart.length(),
                indexToStartImg + indexToEndImg);
        Picasso.with(this).load(imgLink).into(header);

        /* Affichage du texte de l'article*/
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ActuExpendedAdapter(articleText, this));

        final AppBarLayout.Behavior appBarBehavior = (AppBarLayout.Behavior) ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();

        appBarBehavior.onStopNestedScroll(coordinatorLayout, appBarLayout, recyclerView);
        for (int i = 0; i < appBarLayout.getChildCount(); i++) {
            View childView = appBarLayout.getChildAt(i);
            if (!childView.isClickable()) {
                childView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recyclerView.removeAllViews();
        ((ActuExpendedAdapter) recyclerView.getAdapter()).stopVideo();
    }

    @OnClick(R.id.floating_action_button)
    void share() {
        final Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, article.getTitle() + " : " + article.getLink());
        shareIntent.setType("text/plain");
        IntentPickerSheetView intentPickerSheet = new IntentPickerSheetView(ActuActivity.this, shareIntent, "Partager", new IntentPickerSheetView.OnIntentPickedListener() {
            @Override
            public void onIntentPicked(IntentPickerSheetView.ActivityInfo activityInfo) {
                bottomSheetLayout.dismissSheet();
                startActivity(activityInfo.getConcreteIntent(shareIntent));
            }
        });

        intentPickerSheet.setSortMethod(new Comparator<IntentPickerSheetView.ActivityInfo>() {
            @Override
            public int compare(IntentPickerSheetView.ActivityInfo lhs, IntentPickerSheetView.ActivityInfo rhs) {
                return rhs.label.compareTo(lhs.label);
            }
        });
        bottomSheetLayout.showWithSheetView(intentPickerSheet);
    }
}
