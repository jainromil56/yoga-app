package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//popup
    Dialog mydialog;
//popup
//progress_restart
    Dialog myDialogRestart;
    //progress_restart
//    onclick full body
    public void second(View view){
        Intent intent =new Intent(this, slidetrial.class);
        startActivity(intent);
    }

//    onclick over



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//for on back pressed
        SharedPreferences sharedPreferences12 = getSharedPreferences("forOnBack",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences12.edit();
        editor.putString("Back","NOT");
        editor.apply();
//for on back pressed over

//      screen on
        SharedPreferences sharedPreferencesScreen = getSharedPreferences("screen",MODE_PRIVATE);
        String screen= (String) sharedPreferencesScreen.getString("ON", String.valueOf(MODE_PRIVATE));
        if (screen.equals("True")){
            Toast.makeText(this, "ok screen on", Toast.LENGTH_SHORT).show();
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
//        screen on over


//        language
        loadLocale();
//        language
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

//        popup
        mydialog = new Dialog(this);

        myDialogRestart= new Dialog(this);
//        popup

        //        change actionbar title, if you dont change it will be according to your systems default language /english
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
//        language

        TextView AsanasPerformed = (TextView)findViewById(R.id.textView10);
        SharedPreferences sharedPreferences = getSharedPreferences("asanas",MODE_PRIVATE);
        int valo= (int) sharedPreferences.getInt("finish", MODE_PRIVATE);
        String asanas = String.valueOf(valo);

        AsanasPerformed.setText(asanas);

        AsanasPerformed();

        Button set_a_goal = findViewById(R.id.button2);
        set_a_goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SetGoal.class);
                startActivity(intent);

                SharedPreferences sharedPreferences = getSharedPreferences("EditSection",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Enabled","OK");
                editor.apply();
            }
        });


        Button Edit = findViewById(R.id.button13);
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SetGoal.class);
                startActivity(intent);
            }
        });

//        for week goal
        SimpleDateFormat sdf = new SimpleDateFormat("d");
        Date d = new Date();
        String dayOfTheMonth = sdf.format(d);


        SimpleDateFormat sdf1 = new SimpleDateFormat("W");
        Date d1 = new Date();
        String weekInMonth = sdf1.format(d1);

        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button10 = findViewById(R.id.button10);
        Button button11 = findViewById(R.id.button11);
        Button button12 = findViewById(R.id.button12);
        //        for day of week
        if ("1".equals(dayOfTheMonth)||"8".equals(dayOfTheMonth)||"16".equals(dayOfTheMonth)||"23".equals(dayOfTheMonth)) {
            button6.setTextColor(Color.parseColor("#0089EB"));
        } else if ("2".equals(dayOfTheMonth)||"9".equals(dayOfTheMonth)||"17".equals(dayOfTheMonth)||"24".equals(dayOfTheMonth)) {
            button7.setTextColor(Color.parseColor("#0089EB"));
        } else if ("3".equals(dayOfTheMonth)||"10".equals(dayOfTheMonth)||"18".equals(dayOfTheMonth)||"25".equals(dayOfTheMonth)) {
            button8.setTextColor(Color.parseColor("#0089EB"));
        } else if ("4".equals(dayOfTheMonth)||"11".equals(dayOfTheMonth)||"19".equals(dayOfTheMonth)||"26".equals(dayOfTheMonth)) {
            button9.setTextColor(Color.parseColor("#0089EB"));
        } else if ("5".equals(dayOfTheMonth)||"12".equals(dayOfTheMonth)||"20".equals(dayOfTheMonth)||"27".equals(dayOfTheMonth)) {
            button10.setTextColor(Color.parseColor("#0089EB"));
        } else if ("6".equals(dayOfTheMonth)||"13".equals(dayOfTheMonth)||"21".equals(dayOfTheMonth)||"28".equals(dayOfTheMonth)) {
            button11.setTextColor(Color.parseColor("#0089EB"));
        } else if ("7".equals(dayOfTheMonth)||"14".equals(dayOfTheMonth)||"22".equals(dayOfTheMonth)||"29".equals(dayOfTheMonth)) {
            button12.setTextColor(Color.parseColor("#0089EB"));
        }

        if (weekInMonth=="1"){

        }else if (weekInMonth=="2"){
            button6.setText("8");
            button7.setText("9");
            button8.setText("10");
            button9.setText("11");
            button10.setText("12");
            button11.setText("13");
            button12.setText("14");
        }else if (weekInMonth=="3"){
            button6.setText("15");
            button7.setText("16");
            button8.setText("17");
            button9.setText("18");
            button10.setText("19");
            button11.setText("20");
            button12.setText("21");
        }else if (weekInMonth=="4"){
            button6.setText("22");
            button7.setText("23");
            button8.setText("24");
            button9.setText("25");
            button10.setText("26");
            button11.setText("27");
            button12.setText("28");
        }else if (weekInMonth=="5"){
            button6.setText("29");
            button7.setText("30");
            button8.setText("31");
            button9.setText("1");
            button10.setText("2");
            button11.setText("3");
            button12.setText("4");
        }

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);
            Log.i("dayofweek", "onCreate: "+dayOfTheMonth+" "+weekInMonth+" "+formattedDate);


        SharedPreferences sharedPreferencesGoal = getSharedPreferences("GoalsForWeek",MODE_PRIVATE);
        int WeekGoal=  sharedPreferencesGoal.getInt("num", MODE_PRIVATE);

        TextView textViewweekgoal = findViewById(R.id.textView20);
        textViewweekgoal.setText("WEEK GOAL   0/"+WeekGoal);

        switch(WeekGoal){
            case 1:
            button6.setVisibility(View.VISIBLE);
            button7.setVisibility(View.GONE);
            button8.setVisibility(View.GONE);
            button9.setVisibility(View.GONE);
            button10.setVisibility(View.GONE);
            button11.setVisibility(View.GONE);
            button12.setVisibility(View.GONE);
            break;
            case 2:
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                break;
            case 3:
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                break;
            case 4:
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                button9.setVisibility(View.VISIBLE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                break;
            case 5:
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                button9.setVisibility(View.VISIBLE);
                button10.setVisibility(View.VISIBLE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                break;
            case 6:
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                button9.setVisibility(View.VISIBLE);
                button10.setVisibility(View.VISIBLE);
                button11.setVisibility(View.VISIBLE);
                button12.setVisibility(View.GONE);
                break;
            case 7:
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                button9.setVisibility(View.VISIBLE);
                button10.setVisibility(View.VISIBLE);
                button11.setVisibility(View.VISIBLE);
                button12.setVisibility(View.VISIBLE);
                break;
        }

        LinearLayout EditSection1= findViewById(R.id.editsSection1);
        LinearLayout EditSection2 = findViewById(R.id.editSection2);
        LinearLayout Set_A_Goal = findViewById(R.id.SetAGoal_Section);

        SharedPreferences sharedPreferencesES = getSharedPreferences("EditSection",MODE_PRIVATE);
        String Enable=  sharedPreferencesES.getString("Enabled", String.valueOf(MODE_PRIVATE));

        switch (Enable){
            case "OK":
                EditSection1.setVisibility(View.VISIBLE);
                EditSection2.setVisibility(View.VISIBLE);
                Set_A_Goal.setVisibility(View.GONE);

                break;
                default:
                    EditSection1.setVisibility(View.GONE);
                    EditSection2.setVisibility(View.GONE);
                    Set_A_Goal.setVisibility(View.VISIBLE);
        }

//        for week goal over

    }

    //    when activity gets destroyed from recent apps

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences("saveIt",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("valueis");
        editor.commit();
    }

    //    asanas performed
    public void AsanasPerformed(){
        TextView AsanasPerformed = (TextView)findViewById(R.id.textView10);
        TextView AsanasMinutes = (TextView)findViewById(R.id.textView13);
        SharedPreferences sharedPreferences = getSharedPreferences("asanas",MODE_PRIVATE);
        int valo= (int) sharedPreferences.getInt("finish", MODE_PRIVATE);
        String asanas = String.valueOf(valo);

        AsanasPerformed.setText(asanas);

        double minutes = (double) (valo*48)/60;
        int minu = (int) minutes;
        String min = String.valueOf(minu);
        AsanasMinutes.setText(min);
    }
    //    asanas performed



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        SharedPreferences sharedPreferences = getSharedPreferences("forOnBack",MODE_PRIVATE);
        String valo=  sharedPreferences.getString("Back", String.valueOf(MODE_PRIVATE));

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (valo.equals("OK")){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }  else if (valo.equals("OK1")){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else if (valo.equals("NOT")){
//            exits app
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
//            exits app
        }else {
            this.onDestroy();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent =new Intent(this, MainActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_Report) {
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area,new MessageFragmentReport()).commit();
        } else if (id == R.id.nav_language) {
            chowChangeLanguageDialog();

        } else if (id == R.id.nav_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area,new MessageFragmentSettings()).commit();

        } else if (id == R.id.nav_Restart_progress) {
//            mydialog.setContentView(R.layout.activity_language);
//            mydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            mydialog.show();

            myDialogRestart.setContentView(R.layout.restart_progress_popup);
            myDialogRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialogRestart.show();

            TextView buttonCancel=myDialogRestart.findViewById(R.id.cancel);
            TextView buttonok=myDialogRestart.findViewById(R.id.ok);
            buttonCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialogRestart.dismiss();
                }
            });

            buttonok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialogRestart.dismiss();

//                    clearing shared preferences

//                  MainActivity
                    SharedPreferences sharedPreferences1 = getSharedPreferences("forOnBack",MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                    editor1.remove("Back");
                    editor1.commit();


                    SharedPreferences sharedPreferences2 = getSharedPreferences("asanas",MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                    editor2.remove("finish");
                    editor2.commit();


                    SharedPreferences sharedPreferences3 = getSharedPreferences("EditSection",MODE_PRIVATE);
                    SharedPreferences.Editor editor3 = sharedPreferences3.edit();
                    editor3.remove("Enabled");
                    editor3.commit();

                    SharedPreferences sharedPreferences4 = getSharedPreferences("saveIt",MODE_PRIVATE);
                    SharedPreferences.Editor editor4 = sharedPreferences4.edit();
                    editor4.remove("valueis");
                    editor4.commit();


                    SharedPreferences sharedPreferencesLang = getSharedPreferences("OptionLang",MODE_PRIVATE);
                    SharedPreferences.Editor editorLang = sharedPreferencesLang.edit();
                    editorLang.remove("Lang");
                    editorLang.commit();

                    SharedPreferences sharedPreferences8 = getSharedPreferences("lang",MODE_PRIVATE);
                    SharedPreferences.Editor editor8 = sharedPreferences8.edit();
                    editor8.remove("audio");
                    editor8.commit();


                    SharedPreferences.Editor editor9 = getSharedPreferences("Settings",MODE_PRIVATE).edit();
                    editor9.remove("My_Lang");
                    editor9.commit();

//     beginners task
                    SharedPreferences sharedPreferences10 = getSharedPreferences("saveIt",MODE_PRIVATE);
                    SharedPreferences.Editor editor10 = sharedPreferences10.edit();
                    editor10.remove("valueis");
                    editor10.commit();

//   MessageFragmentReport

                    SharedPreferences sharedPreferences11 = getSharedPreferences("BMI", MODE_PRIVATE);
                    SharedPreferences.Editor editor11 = sharedPreferences11.edit();
                    editor11.remove("finishBMI");
                    editor11.commit();

                    SharedPreferences sharedPreferencesHeight = getSharedPreferences("HEIGHT", MODE_PRIVATE);
                    SharedPreferences.Editor editorHeight = sharedPreferencesHeight.edit();
                    editorHeight.remove("finishHEIGHT");
                    editorHeight.commit();

                    SharedPreferences sharedPreferencesWeight = getSharedPreferences("WEIGHT", MODE_PRIVATE);
                    SharedPreferences.Editor editorWeight = sharedPreferencesWeight.edit();
                    editorWeight.remove("finishWEIGHT");
                    editorWeight.commit();

                    SharedPreferences sharedPreferences12 = getSharedPreferences("BMI", MODE_PRIVATE);
                    SharedPreferences.Editor editor12 = sharedPreferences12.edit();
                    editor12.remove("finishBMI");
                    editor12.commit();

// messageFragmentSettings

                    SharedPreferences sharedPreferences13 = getSharedPreferences("screen",MODE_PRIVATE);
                    SharedPreferences.Editor editor13 = sharedPreferences13.edit();
                    editor13.remove("ON");
                    editor13.commit();

                    SharedPreferences sharedPreferences14 = getSharedPreferences("sound",MODE_PRIVATE);
                    SharedPreferences.Editor editor14 = sharedPreferences14.edit();
                    editor14.remove("result");
                    editor14.commit();

                    SharedPreferences sharedPreferences15 = getSharedPreferences("restTime",MODE_PRIVATE);
                    SharedPreferences.Editor editor15 = sharedPreferences15.edit();
                    editor15.remove("seconds");
                    editor15.commit();

//resttime

                    SharedPreferences sharedPreferences16 = getSharedPreferences("Days",MODE_PRIVATE);
                    SharedPreferences.Editor editor16 = sharedPreferences16.edit();
                    editor16.remove("over");
                    editor16.commit();

//   slideJava

                    SharedPreferences sharedPreferences17 = getSharedPreferences("saveCounter",MODE_PRIVATE);
                    SharedPreferences.Editor editor17 = sharedPreferences17.edit();
                    editor17.remove("counterValue");
                    editor17.commit();

//   relaunching main activity

                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });

        } else if (id == R.id.nav_send) {

        }



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    for language options////////////////////////////////////////////////////////////////////
    int count;
    int countLang;
    private void chowChangeLanguageDialog() {
//        Array of languages to display in alert box
        final String[] listItems = {"English", "हिंदी", "اردو", "French"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose Language...");


        SharedPreferences sharedPreferencesforsound = getSharedPreferences("OptionLang",MODE_PRIVATE);
        countLang = sharedPreferencesforsound.getInt("Lang",MODE_PRIVATE);

        mBuilder.setSingleChoiceItems(listItems, countLang, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                SharedPreferences sharedPreferencesLang = getSharedPreferences("OptionLang",MODE_PRIVATE);
                SharedPreferences.Editor editorLang = sharedPreferencesLang.edit();
                editorLang.putInt("Lang",i);
                editorLang.apply();

                if (i == 0){
//                    french
                    setLocale("en");
                    recreate();

                    count=0;
                    //for audio
                    SharedPreferences sharedPreferences = getSharedPreferences("lang",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("audio",count);
                    editor.apply();
                }else if (i == 1){
//                    hindi
                    setLocale("hi");
                    recreate();

                    count=1;
                    //for audio
                    SharedPreferences sharedPreferences = getSharedPreferences("lang",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("audio",count);
                    editor.apply();
                }else if (i == 2){
//                    urdu
                    setLocale("ur");
                    recreate();

                    count=2;
                    //for audio
                    SharedPreferences sharedPreferences = getSharedPreferences("lang",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("audio",count);
                    editor.apply();
                }else{
//                    english
                    setLocale("fr");
                    recreate();

                    count=3;
                    //for audio
                    SharedPreferences sharedPreferences = getSharedPreferences("lang",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("audio",count);
                    editor.apply();
                }

//                dissmiss alert dialog when language selected
                dialogInterface.dismiss();

            }
        });
        AlertDialog mDialog = mBuilder.create();
//                show alert dialog
        mDialog.show();
    }

    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
//        save data to shared prefernces
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();
    }

    //    load language saved in shared preferences
    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }
//    language options over///////////////////////////////////////////////////////
}





