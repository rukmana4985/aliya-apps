package com.project.aliya.base.session;

import android.content.Context;
import android.content.SharedPreferences;

public class PersonalData {
    private final String PREF_NAME = "personaldata";
    private final String USER_DATA = "userdata";

    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    public PersonalData(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public void setUserData(String userData) {
        if (getUserData() != null) clear();
        this.editor.putString(USER_DATA, userData);
        this.editor.commit();
    }

    public String getUserData() {
        return this.sharedPreferences.getString(USER_DATA, null);
    }



    public void clear() {
        this.editor.clear();
        this.editor.commit();
    }
}
