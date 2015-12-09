package com.krealid.starter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.IntentPickerSheetView;
import com.krealid.starter.adapters.ActuExpendedAdapter;
import com.krealid.starter.rss.RssItem;
import com.squareup.picasso.Picasso;

import java.util.Comparator;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Maxime on 24/08/2015.
 */
public class ActuActivity extends AppCompatActivity {

    @Bind(R.id.bottomsheet)
    BottomSheetLayout bottomSheetLayout;
    @Bind(R.id.article_title)
    TextView articleTitle;
    @Bind(R.id.scrollableview)
    RecyclerView recyclerView;
    @Bind(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.appbar)
    AppBarLayout appBarLayout;
    @Bind(R.id.anim_toolbar)
    Toolbar toolbar;

    private RssItem article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        ButterKnife.bind(this);

        /*Récupération des données de l'article choisi*/
       article = ((StarterApplication) this.getApplication()).getSelectedArticle();

        /*Gestion de la toolbar*/
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
        /*Retour à l'activité de listing des articles*/
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ActuActivity.this, ListingActivity.class);
                mainIntent.putExtra("choix", 1);
                ActuActivity.this.startActivity(mainIntent);
                ActuActivity.this.finish();
            }
        });
        articleTitle.setText(article.getTitle());

        /* Gestion de l'image pour le header*/
        ImageView header = (ImageView) findViewById(R.id.header);
        String imgStart = "<img src=\"";
        String imgEnd   = "\" alt";
        String imgBaliseEnd = "/>";
        int indexToStartImg = article.getDescription().indexOf(imgStart);
        int indexToEndImg = (article.getDescription().substring(indexToStartImg)).indexOf(imgEnd);
        int indexToEndBaliseImg = (article.getDescription().substring(indexToStartImg)).indexOf(imgBaliseEnd)+2;

        String articleText = article.getDescription().substring(indexToStartImg+indexToEndBaliseImg);
        String imgLink = article.getDescription().substring(indexToStartImg+imgStart.length(),
                indexToStartImg+indexToEndImg);
        Picasso.with(this).load(imgLink).into(header);

        /* Affichage du texte de l'article*/
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
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
    void share(){
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
