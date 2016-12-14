package com.krealid.starter.adapters;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.github.aakira.expandablelayout.Utils;
import com.krealid.starter.R;

/**
 * Created by Maxime on 08/09/2015.
 */
public class HeaderHorairesAdapter extends RecyclerView.Adapter<HeaderHorairesAdapter.ViewHolder> {

    private String[] horairesHeaders = {"Messes en semaine à Senlis", "Messes dominicales"};
    private Context context;
    private SparseBooleanArray expandState = new SparseBooleanArray();

    public HeaderHorairesAdapter(Context context){
        this.context = context;
        for (int i = 0; i < horairesHeaders.length; i++) {
            expandState.append(i, false);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.horaires_header_card, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.title.setText(horairesHeaders[position]);

        String[] joursSemaine = this.context.getResources().getStringArray(R.array.jours_semaine);
        String[] horairesSemaine = this.context.getResources().getStringArray(R.array.horaires_semaine);

        String[] joursWeekend = this.context.getResources().getStringArray(R.array.jours_weekend);
        String[] horairesWeekend = this.context.getResources().getStringArray(R.array.horaires_weekend);

        String text = "";
        if(position == 0){
            for (int i = 0; i < joursSemaine.length ; i++) {
                String jour = "<b>"+joursSemaine[i]+"</b>";
                String horaires = "<br/><font style=\"text-align:justify;text-justify:inter-word;\">"+
                        horairesSemaine[i].replaceAll("//", "<br/>") + "</font><br/><br/>";
                text += jour + horaires;
            }
            holder.listHoraires.setText(Html.fromHtml(text));
        }else if(position == 1){
            for (int i = 0; i < joursWeekend.length ; i++) {
                String jour = "<b>"+joursWeekend[i]+"</b>";
                String textWithList = horairesWeekend[i].replaceAll("¤", "<br/>¤");
                String textHorairesList = textWithList.replaceAll("//", "<br/>");
                String horaires = "<br/><font style=\"text-align:justify;text-justify:inter-word;\">"+
                        textHorairesList.replaceAll("//", "<br/>") + "</font><br/><br/>";
                text += jour + horaires;
            }
            holder.listHoraires.setText(Html.fromHtml(text));
        }
        holder.expandableLayout.setExpanded(expandState.get(position));
        holder.expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
                createRotateAnimator(holder.buttonLayout, 0f, 180f).start();
                expandState.put(position, true);
            }

            @Override
            public void onPreClose() {
                createRotateAnimator(holder.buttonLayout, 180f, 0f).start();
                expandState.put(position, false);
            }
        });

        holder.buttonLayout.setRotation(expandState.get(position) ? 180f : 0f);
        holder.buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                onClickButton(holder.expandableLayout);
            }
        });
    }

    private void onClickButton(final ExpandableLayout expandableLayout) {
        expandableLayout.toggle();
    }

    @Override
    public int getItemCount() {
        return horairesHeaders.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.headerHoraires)
        TextView title;
        @BindView(R.id.horairesList)
        TextView listHoraires;
        @BindView(R.id.expandableLayout)
        ExpandableRelativeLayout expandableLayout;
        @BindView(R.id.button)
        RelativeLayout buttonLayout;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private ObjectAnimator createRotateAnimator(final View target, final float from, final float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.ACCELERATE_DECELERATE_INTERPOLATOR));
        return animator;
    }
}
