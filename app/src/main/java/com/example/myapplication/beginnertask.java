package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Calendar;

public class beginnertask extends AppCompatActivity {
    Dialog myDialog;
    //   WebView WebViewWithCSS;

//    private ProgressBar progressBar;
//    private int progreeStatus = 0;
//    private Handler handler = new Handler();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginnertask);


        myDialog=new Dialog(this);

        handler1.postDelayed(runnable1,100);
        handler.postDelayed(runnable,100);
        handlertextchange.postDelayed(runnabletextchange,6000);
        handlerover.postDelayed(runnableover,48400);

        loadDataAsanas();

        callText();
    }


    public void callText(){
//        lottie animation
        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.enableMergePathsForKitKatAndAbove(true);

        SharedPreferences sharedPreferences = getSharedPreferences("saveIt",MODE_PRIVATE);
        final int valo= (int) sharedPreferences.getInt("valueis", MODE_PRIVATE);

        TextView textView4 = (TextView)findViewById(R.id.textView4);
        TextView textView5 = (TextView)findViewById(R.id.textView5);
        if(valo==1){
            Toast.makeText(beginnertask.this, "Data found "+valo, Toast.LENGTH_SHORT).show();
            textView4.setText("DOWNWARD FACING DOG");
            textView4.setTextSize(25);
            textView5.setText("");

            //lottie animation
            animationView.setAnimation(R.raw.data);
        }
        if (valo==2){
            textView4.setText("PLANK");
            textView5.setText("");

            //lottie animation
            animationView.setAnimation(R.raw.data);
        }
        if (valo==3){
            textView4.setText("TRIANGLE");
            textView5.setText("");

        }
        if (valo==4){
            textView4.setText("TREE");
            textView5.setText("");
        }
        if (valo==5){
            textView4.setText("WARRIOR 1");
            textView5.setText("");
        }
        if (valo==6){
            textView4.setText("WARRIOR 2");
            textView5.setText("");
        }
        if (valo==7){
            textView4.setText("SEATED FORWARD BEND");
            textView4.setTextSize(25);
            textView5.setText("");
        }
        if (valo==8){
            textView4.setText("BRIDGE POSE");
            textView5.setText("");
        }
        if (valo==9){
            textView4.setText("CHILD'S POSE");
            textView5.setText("");


        }


        if (valo>=10){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("valueis");
            editor.commit();

            handlerover.removeCallbacks(runnableover);
            Intent intent = new Intent(beginnertask.this,slidetrial.class);
            startActivity(intent);
        }

    }


    public void skip(View view){
        handlerover.removeCallbacks(runnableover);
        Intent intent =(Intent) new Intent(this,resttime.class);
        startActivity(intent);
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

        myDialog.setContentView(R.layout.onbackpressed);
        ImageView imageView = (ImageView) myDialog.findViewById(R.id.imageView9);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        Button button=(Button) myDialog.findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        Button buttonleave=(Button) myDialog.findViewById(R.id.button4);
        buttonleave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=(Intent)new Intent(beginnertask.this,MainActivity.class);
                startActivity(intent);

                SharedPreferences sharedPreferences = getSharedPreferences("saveIt",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("valueis");
                editor.commit();


                handlerover.removeCallbacks(runnableover);


            }
        });

        myDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
            }
        });

    }





//    PROGRESS BAR      ---------##

    private void startAnimation(){
        ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
         ObjectAnimator progressAnimator = ObjectAnimator.ofInt(mProgressBar, "progress", 0, 100);
        progressAnimator.setDuration(3000);
        progressAnimator.setInterpolator(new LinearInterpolator());
        progressAnimator.start();

    }


    private void startanim(){
        ProgressBar mProgressBar1 = (ProgressBar) findViewById(R.id.progressBar2);
         ObjectAnimator progressAnimator1 = ObjectAnimator.ofInt(mProgressBar1, "progress", 0, 100);
        progressAnimator1.setDuration(3000);
        progressAnimator1.setStartDelay(3000);
        progressAnimator1.setInterpolator(new LinearInterpolator());
        progressAnimator1.start();
    }




    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this,6000);

            startAnimation();
            startanim();
        }
    };




    private Handler handler1 = new Handler();
    private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            handler1.postDelayed(this,6050);
            ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
            mProgressBar.setProgress(0);
            ProgressBar mProgressBar1 = (ProgressBar) findViewById(R.id.progressBar2);
            mProgressBar1.setProgress(0);
        }
    };

//  asanas performed

    //    saving counts for asanas
    int count= 0;
    //    saving counts for asanas
    private Handler handlerover = new Handler();
    private Runnable runnableover = new Runnable() {
        @Override
        public void run() {
            count++;
            handler1.postDelayed(this,999999999);
            Intent intent  = new Intent(beginnertask.this,resttime.class);
            startActivity(intent);
        }
    };

    public void saveDataDays(){

        SharedPreferences sharedPreferences = getSharedPreferences("asanas",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("finish",count);
        editor.apply();
    }

    public void loadDataAsanas(){
        SharedPreferences sharedPreferences = getSharedPreferences("asanas",MODE_PRIVATE);
        count = sharedPreferences.getInt("finish",MODE_PRIVATE);


    }

    //    when activity gets on recent apps OnPause() override method
    @Override
    protected void onPause() {
        super.onPause();

        saveDataDays();
    }

//  asanas performed

    private Handler handlertextchange = new Handler();
    private Runnable runnabletextchange = new Runnable() {

        int num = 0;
        @Override
        public void run() {
            handler1.postDelayed(this,6050);
            num++;
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(num+"/8 times");
        }
    };



}
