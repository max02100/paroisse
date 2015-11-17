package com.krealid.starter.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.krealid.starter.contact.Contact;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.ButterKnife;
import com.krealid.starter.R;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private ArrayList<Contact> contacts;
    private Context context;
    private final static String alphabet ="abcdefghijklmnopqrstuvwxyz";

    public ContactAdapter(Context context){
        this.context = context;
        this.contacts = new Contact(context).getAllContacts();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.contact_card, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        int id = context.getResources().getIdentifier(String.valueOf(alphabet.charAt(position)),
                "drawable", context.getPackageName());

        Picasso.with(context)
                .load(id)
                .fit()
                .centerCrop()
                .into(holder.mImageView);
        holder.name.setText(contacts.get(position).getName());
        holder.forWhat.setText(contacts.get(position).getForWhat());
        holder.job.setText(contacts.get(position).getJob());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ki", "ok");
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,
                        new String[] {context.getResources().getStringArray(R.array.contact_email)[position]});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                        "Prise de contact via l'application");
                context.startActivity(Intent.createChooser(emailIntent, ""));
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public CardView cardView;
        public TextView name;
        public TextView forWhat;
        public TextView job;
        public ImageButton email;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView  = ButterKnife.findById(itemView, R.id.imageView);
            cardView    = ButterKnife.findById(itemView, R.id.cardNews);
            name        = ButterKnife.findById(itemView, R.id.contact_name);
            forWhat     = ButterKnife.findById(itemView, R.id.contact_for_what);
            job         = ButterKnife.findById(itemView, R.id.contact_job);
            email       = ButterKnife.findById(itemView, R.id.contact_email);
        }
    }
}
