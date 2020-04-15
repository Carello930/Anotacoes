package com.leaoartes.anotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesAnotation {

    private Context context;
    private SharedPreferences preferences;
    private  SharedPreferences.Editor editor;
    private final String ARCHIVE_ANOTATION = "archive.anotation";
    private final String NAME_KEY = "name";

    public PreferencesAnotation(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(ARCHIVE_ANOTATION, 0);
        editor = preferences.edit();

    }

    public void anotationSave(String anotationSave){
        editor.putString(NAME_KEY, anotationSave);
        editor.commit();
    }

    public String anotationRecover(){
        return preferences.getString(NAME_KEY, "");
    }

}
