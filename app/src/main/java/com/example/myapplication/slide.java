package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Trace;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class slide extends AppCompatActivity {

    private TextToSpeech mTTs;

    Dialog myDialog;
    String newone="value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        myDialog=new Dialog(this);

        mTTs = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i==TextToSpeech.SUCCESS){
                    int result = mTTs.setLanguage(Locale.ENGLISH);

                    if (result== TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS","Language not supported");
                    }else {
                        speak();
                    }
                }
            }
        });

    }

    int count;
    int countsound;
    public void speak(){


        SharedPreferences sharedPreferencesforsound = getSharedPreferences("sound",MODE_PRIVATE);
        countsound = sharedPreferencesforsound.getInt("result",MODE_PRIVATE);

        SharedPreferences sharedPreferences = getSharedPreferences("lang",MODE_PRIVATE);
        count = sharedPreferences.getInt("audio",MODE_PRIVATE);

        if (countsound==1){

        if (count==0){
        mTTs.setPitch(0.5f);
        mTTs.setSpeechRate(0.5f);
        mTTs.speak("english",TextToSpeech.QUEUE_FLUSH,null);
        }else if (count==1){
            mTTs.setPitch(0.5f);
            mTTs.setSpeechRate(0.5f);
            mTTs.speak("Hindi",TextToSpeech.QUEUE_FLUSH,null);
        }else if (count==2){
            mTTs.setPitch(0.5f);
            mTTs.setSpeechRate(0.5f);
            mTTs.speak("urdu",TextToSpeech.QUEUE_FLUSH,null);
        }else if (count==3){
            mTTs.setPitch(0.5f);
            mTTs.setSpeechRate(0.5f);
            mTTs.speak("French",TextToSpeech.QUEUE_FLUSH,null);
        }
        }else if (countsound==0){
            mTTs.shutdown();
            mTTs.stop();
        }
    }

    @Override
    protected void onDestroy() {
        if (mTTs!=null){
        mTTs.stop();
        mTTs.shutdown();
    }

        super.onDestroy();
    }

    //    go to countdown timer
    public void gocount(View view){
        if (mTTs!=null){
            mTTs.stop();
            mTTs.shutdown();
        }

//        Intent intent=new Intent(this,countdown.class);
//        startActivity(intent);
        Intent intent=new Intent(this,beginnertask.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(slide.this,MainActivity.class);
        startActivity(intent);
    }

    //    onclick start from 1
    public void ShowPopup(View view){

        TextView txtclose;
        myDialog.setContentView(R.layout.activity_popup);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counterValue",newone);
        editor.apply();

        LoadData();
    }

    public void ShowPopup1(View view){
        String first="one";
        TextView txtclose;
        myDialog.setContentView(R.layout.activity_popup);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counterValue",first);
        editor.apply();

        LoadData();
    }

    public void ShowPopup2(View view){
        String first="two";
        TextView txtclose;
        myDialog.setContentView(R.layout.activity_popup);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counterValue",first);
        editor.apply();

        LoadData();
    }

    public void ShowPopup3(View view){
        String first="three";
        TextView txtclose;
        myDialog.setContentView(R.layout.activity_popup);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counterValue",first);
        editor.apply();

        LoadData();
    }

    public void ShowPopup4(View view){
        String first="four";
        TextView txtclose;
        myDialog.setContentView(R.layout.activity_popup);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counterValue",first);
        editor.apply();

        LoadData();
    }

    public void ShowPopup5(View view){
        String first="five";
        TextView txtclose;
        myDialog.setContentView(R.layout.activity_popup);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counterValue",first);
        editor.apply();

        LoadData();
    }

    public void ShowPopup6(View view){
        String first="six";
        TextView txtclose;
        myDialog.setContentView(R.layout.activity_popup);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counterValue",first);
        editor.apply();

        LoadData();
    }

    public void ShowPopup7(View view){
        String first="seven";
        TextView txtclose;
        myDialog.setContentView(R.layout.activity_popup);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counterValue",first);
        editor.apply();

        LoadData();
    }

    public void ShowPopup8(View view){
        String first="eight";
        TextView txtclose;
        myDialog.setContentView(R.layout.activity_popup);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counterValue",first);
        editor.apply();

        LoadData();
    }

    public void ShowPopup9(View view){
        String first="nine";
        TextView txtclose;
        myDialog.setContentView(R.layout.activity_popup);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counterValue",first);
        editor.apply();

        LoadData();
    }



//    Load data of saved values
    public void LoadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        String val=sharedPreferences.getString("counterValue", String.valueOf(MODE_PRIVATE));

        myDialog.setContentView(R.layout.activity_popup);
        TextView txtclose;
        txtclose=(TextView) myDialog.findViewById(R.id.gotit);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();

//                removing data
                SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("counterValue");
                editor.commit();

                final String valo=sharedPreferences.getString("counterValue", String.valueOf(MODE_PRIVATE));
                if(valo.equals(String.valueOf("value"))){
                    Toast.makeText(slide.this, "Data not removed", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(slide.this, "Data have been removed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        myDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("counterValue");
                editor.commit();

                final String valo=sharedPreferences.getString("counterValue", String.valueOf(MODE_PRIVATE));
                if(valo.equals(String.valueOf("value"))){
                    Toast.makeText(slide.this, "Data not removed", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(slide.this, "Data have been removed", Toast.LENGTH_SHORT).show();
                }
            }
        });


//        if statements of data loading,heading and paragraphs

        TextView headline=(TextView) myDialog.findViewById(R.id.headline);
        TextView number=(TextView) myDialog.findViewById(R.id.number);
        if (val.equals("value")){
            Toast.makeText(this, "Data loaded", Toast.LENGTH_SHORT).show();
            Log.i("value","data has loaded");
            headline.setText(String.valueOf("MOUNTAIN POSE ONE"));
        }
        if (val.equals("one")){
            Toast.makeText(this, "Data loaded", Toast.LENGTH_SHORT).show();
            headline.setText(String.valueOf("DOWNWARD FACING DOG"));
            number.setText("2");
        }
        if (val.equals("two")){
            Toast.makeText(this, "Data loaded", Toast.LENGTH_SHORT).show();
            headline.setText(String.valueOf("PLANK"));
            number.setText("3");
        }
        if (val.equals("three")){
            Toast.makeText(this, "Data loaded", Toast.LENGTH_SHORT).show();
            headline.setText(String.valueOf("TRIANGLE"));
            number.setText("4");
        }
        if (val.equals("four")){
            Toast.makeText(this, "Data loaded", Toast.LENGTH_SHORT).show();
            headline.setText(String.valueOf("TREE"));
            number.setText("5");
        }
        if (val.equals("five")){
            Toast.makeText(this, "Data loaded", Toast.LENGTH_SHORT).show();
            headline.setText(String.valueOf("WARRIOR 1"));
            number.setText("6");
        }
        if (val.equals("six")){
            Toast.makeText(this, "Data loaded", Toast.LENGTH_SHORT).show();
            headline.setText(String.valueOf("WARRIOR 2"));
            number.setText("7");
        }
        if (val.equals("seven")){
            Toast.makeText(this, "Data loaded", Toast.LENGTH_SHORT).show();
            headline.setText(String.valueOf("SEATED FORWARD BEND"));
            number.setText("8");
        }
        if (val.equals("eight")){
            Toast.makeText(this, "Data loaded", Toast.LENGTH_SHORT).show();
            headline.setText(String.valueOf("BRIDGE POSE"));
            number.setText("9");
        }
        if (val.equals("nine")){
            Toast.makeText(this, "Data loaded", Toast.LENGTH_SHORT).show();
            headline.setText(String.valueOf("CHILD'S POSE"));
            number.setText("10");

        }
    }
}
