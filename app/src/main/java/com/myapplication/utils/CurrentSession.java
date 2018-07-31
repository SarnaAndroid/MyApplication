package com.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.myapplication.models.UserData;

import static android.content.Context.MODE_PRIVATE;

public  class CurrentSession {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private UserData userData;
    private Gson gson;
    private String data;

    public CurrentSession(Context context) {
        this.sharedPreferences = context.getSharedPreferences(Constants.Data, MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public  void setUserData(UserData userData){
        gson = new Gson();
        String json = gson.toJson(userData);
        editor.putString(Constants.LOGIN, json);
        editor.apply();
    }

    public UserData getUserData(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(Constants.LOGIN, "");
        userData = gson.fromJson(json, UserData.class);
        return userData;
    }

    public void clearCurrentData(){
        editor.clear();
        editor.commit();
    }
}
