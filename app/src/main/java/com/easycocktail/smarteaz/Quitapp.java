package com.easycocktail.smarteaz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;

import java.util.Locale;

public class Quitapp {
    private void language_select(Resources res, String locale) {
        Log.e("change language to", " french");

        Configuration config = res.getConfiguration();
        Log.e("    ", locale);
        switch (locale) {
            case "fr":
                //setLocale(Locale.FRANCE);
                config.setLocale(Locale.FRANCE);
                break;
            case "en":
                config.setLocale(Locale.ENGLISH);
                break;
        }
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

    public void createPopUp(){

        String []language = {"Francais", "Anglais"};


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.mainContext);
        builder.setTitle(MainActivity.mainContext.getString(R.string.languages));

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case 0:
                        language_select(MainActivity.mainContext.getResources(),"fr");
                        break;
                    case 1:
                        language_select(MainActivity.mainContext.getResources(),"en");
                        break;

                    default:
                        language_select(MainActivity.mainContext.getResources(),"en");
                        break;
                }
            }
        };

        builder.setItems(language, dialogClickListener);
        builder.show();

    }
    public void createPopUp2(){

        String []yesno = {"Yes", "No"};


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.mainContext);
        builder.setTitle(MainActivity.mainContext.getString(R.string.dialogue1));

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case 0:
                        System.exit(0);
                        break;
                    case 1:

                        break;

                }
            }
        };

        builder.setItems(yesno, dialogClickListener);
        builder.show();

    }
}
