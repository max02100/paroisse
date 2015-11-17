package com.krealid.starter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.IntentPickerSheetView;
import com.krealid.starter.adapters.ActuExpendedAdapter;
import com.krealid.starter.R;
import com.squareup.picasso.Picasso;

import java.util.Comparator;

import com.krealid.starter.rss.RssItem;

/**
 * Created by Maxime on 24/08/2015.
 */
public class ActuActivity extends AppCompatActivity {

    protected BottomSheetLayout bottomSheetLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        Context context = this;

        bottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomsheet);

        /*Récupération des données de l'article choisi*/
        final RssItem article = ((StarterApplication) this.getApplication()).getSelectedArticle();

        Log.d("actu", article.getDescription());

        /*Gestion de la toolbar*/
        final Toolbar toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
        /*Retour à l'activité de lisiting des articles*/
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ActuActivity.this, ListingActivity.class);
                mainIntent.putExtra("choix", 1);
                ActuActivity.this.startActivity(mainIntent);
                ActuActivity.this.finish();
            }
        });
        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(article.getTitle());
        collapsingToolbar.setCollapsedTitleTextColor(Color.parseColor("#FFFFFF"));
        collapsingToolbar.setExpandedTitleColor(Color.parseColor("#FFFFFF"));

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
        Picasso.with(context).load(imgLink).into(header);

        /* Gestion du FAB */
        FloatingActionButton fabShare = (FloatingActionButton) findViewById(R.id.floating_action_button);
        /* Partage de l'article */
        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        /* Affichage du texte de l'article*/
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.scrollableview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(new ActuExpendedAdapter(articleText, this));
    }

}
