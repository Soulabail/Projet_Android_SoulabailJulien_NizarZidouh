package com.easycocktail.smarteaz;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static API api;
    private Retrofit retrofit;

    public static Context mainContext;
    //public static String CHARG = "com.easycocktail.smarteaz.update.cocktailUpdates";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainContext=this;

        //configureRetroFit();
        actionsdesboutons();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.Language:
                new Quitapp().createPopUp(); // ici c'est pas quitapp mais language

                return true;
            case R.id.Quit:
                new Quitapp().createPopUp2();
                /*new AlertDialog.Builder(MainActivity.mainContext)

                        .setTitle(getString(R.string.LogOut))
                        .setMessage(getString(R.string.dialogue1))
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                            }
                        });*/


                //System.exit(0);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }



        private void createNotification() {
            final NotificationManager mNotification = (NotificationManager) MainActivity.mainContext.getSystemService(NOTIFICATION_SERVICE);
            final Intent launchNotifiactionIntent = new Intent(MainActivity.mainContext, DisplayActivityNotif.class);
            final PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.mainContext,
                    0, launchNotifiactionIntent,
                    PendingIntent.FLAG_ONE_SHOT);



            Notification.Builder builder = new Notification.Builder(MainActivity.mainContext)
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.drawable.icone)
                    .setContentTitle("Notification from SmarTeaz")
                    .setContentText("Welcome to Smarteaz")
                    .setContentIntent(pendingIntent);

            mNotification.notify(1, builder.build());

        }

    private void actionsdesboutons(){
        Button listecocktail = findViewById(R.id.premier);
        Button cocktailrandom = findViewById(R.id.deuxieme);
        Button langue = findViewById(R.id.troisieme);


        cocktailrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.mainContext,"C'est parti !",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.mainContext, displayrandom.class);
            startActivity(intent);
            }
        });
        langue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "createnotif");
               // createNotification();
            }
        });

    }
    private void configureRetroFit(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    api= retrofit.create(API.class);
    }
/*
    private void getRandomCocktail(){

        Map<String, String>data = new HashMap<>();
        data.put("token","trololo");
        data.put("id", "2570");

        api.getCocktailRandom(data).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse apiResponse = response.body();


            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });*/
}


