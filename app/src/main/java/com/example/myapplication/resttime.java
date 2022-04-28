package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class resttime extends AppCompatActivity {
    Dialog myDialog;



    CircularView circularViewWithTimer;
    int counttimer;

    private int count=0;
    private int countday = 0;

//    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resttime);

        myDialog=new Dialog(this);

        loadData();
        loadDataDays();
        mProgressRunnable.run();


    }

    @Override
    public void onBackPressed() {
        myDialog.setContentView(R.layout.onbackpressed);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        LoadData();




    }

    //    Load data of saved values

    public void LoadData() {

        circularViewWithTimer.pauseTimer();

        myDialog.setContentView(R.layout.onbackpressed);
        ImageView imageView = (ImageView) myDialog.findViewById(R.id.imageView9);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                circularViewWithTimer.resumeTimer();

            }
        });

        Button button=(Button) myDialog.findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                circularViewWithTimer.resumeTimer();
            }
        });

        Button buttonleave=(Button) myDialog.findViewById(R.id.button4);
        buttonleave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=(Intent)new Intent(resttime.this,MainActivity.class);
                startActivity(intent);

                SharedPreferences sharedPreferences = getSharedPreferences("saveIt",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("valueis");
                editor.commit();

                count = 0;

                circularViewWithTimer.stopTimer();

            }
        });

        myDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
            }
        });

    }

//    load data over


    private Runnable mProgressRunnable = new Runnable() {
        @Override
        public void run() {

            // for rest time sets from settings

            SharedPreferences sharedPreferencesforsound = getSharedPreferences("restTime",MODE_PRIVATE);
            counttimer = sharedPreferencesforsound.getInt("seconds",MODE_PRIVATE);
            if (counttimer<=9){
                counttimer=10;
            }


            circularViewWithTimer = findViewById(R.id.circular_view);
            CircularView.OptionsBuilder builderWithTimer =
                    new CircularView.OptionsBuilder()
                            .shouldDisplayText(true)
                            .setCounterInSeconds(counttimer)
                            .setCircularViewCallback(new CircularViewCallback() {
                                @Override
                                public void onTimerFinish() {
                                    // Will be called if times up of countdown timer
                                    Toast.makeText(resttime.this, "CircularCallback: Timer Finished ", Toast.LENGTH_SHORT).show();
                                    saving();

                                }

                                @Override
                                public void onTimerCancelled() {

                                    // Will be called if stopTimer is called
                                    Toast.makeText(resttime.this, "CircularCallback: Timer Cancelled ", Toast.LENGTH_SHORT).show();


                                }




                            });

            circularViewWithTimer.setOptions(builderWithTimer);
            circularViewWithTimer.startTimer();

//            mHandler.postDelayed(this,10000);

        }
    };


    //    for saving sharedpreferences data for changing text activity and layout
    public void skip(View view){
        count++;
        circularViewWithTimer.stopTimer();
        Intent intent = (Intent) new  Intent(this,beginnertask.class);
        startActivity(intent);

        if (count>=10){
            countday++;
        }


    }



    public void saving(){
        count++;

        Intent intent = (Intent) new  Intent(this,beginnertask.class);
        startActivity(intent);

        if (count>=10){
            countday++;
        }
    }

    public void check(View view){
        Toast.makeText(this, "OK "+count, Toast.LENGTH_SHORT).show();
    }


    public void saveData(){

        SharedPreferences sharedPreferences = getSharedPreferences("saveIt",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("valueis",count);
        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("saveIt",MODE_PRIVATE);
        count = sharedPreferences.getInt("valueis",MODE_PRIVATE);


    }

    public void saveDataDays(){

        SharedPreferences sharedPreferences = getSharedPreferences("Days",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("over",countday);
        editor.apply();
    }

    public void loadDataDays(){
        SharedPreferences sharedPreferences = getSharedPreferences("Days",MODE_PRIVATE);
        countday = sharedPreferences.getInt("over",MODE_PRIVATE);


    }

    @Override
    protected void onPause() {
        super.onPause();

        saveData();
        saveDataDays();
    }

}
