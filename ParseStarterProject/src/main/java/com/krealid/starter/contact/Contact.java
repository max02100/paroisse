package com.krealid.starter.contact;

import android.content.Context;

import java.util.ArrayList;

import com.krealid.starter.R;

/**
 * Created by Maxime on 24/07/2015.
 */
public class Contact {

    private Context context;

    private String name, forWhat, job, email;

    public Contact(Context context){ this.context = context;}

    public Contact(String name, String forWhat, String job, String email){
        this.name = name;
        this.forWhat = forWhat;
        this.job = job;
        this.email = email;
    }

    public String getForWhat() {
        return forWhat;
    }

    public void setForWhat(String forWhat) {
        this.forWhat = forWhat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ArrayList<Contact> getAllContacts(){
        String[] contactsNames = this.context.getResources().getStringArray(R.array.contact_name);
        String[] contactsForWhat = this.context.getResources().getStringArray(R.array.contact_for_what);
        String[] contactsJobs = this.context.getResources().getStringArray(R.array.contact_job);
        String[] contactsEmails = this.context.getResources().getStringArray(R.array.contact_email);

        ArrayList<Contact> contactsList = new ArrayList<Contact>();
        for (int i = 0; i < contactsEmails.length; i++) {
            Contact c = new Contact(contactsNames[i], contactsForWhat[i], contactsJobs[i], contactsEmails[i]);
            contactsList.add(c);
        }

        return contactsList;
    }
}
