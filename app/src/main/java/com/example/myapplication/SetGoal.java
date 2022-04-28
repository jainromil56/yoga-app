package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

public class SetGoal extends AppCompatActivity {

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);

        myDialog= new Dialog(this);
        LinearLayout days = findViewById(R.id.days);
        LinearLayout daysname = findViewById(R.id.daysname);

        days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.number_picker_setgoal);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();

                showNumberPicker();
            }
        });

        daysname.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.number_picker_setgoal);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();

                showDaysPicker();
            }
        });

//      for days of week
        SharedPreferences sharedPreferencesGoal = getSharedPreferences("GoalsForWeek",MODE_PRIVATE);
        int WeekGoal=  sharedPreferencesGoal.getInt("num", MODE_PRIVATE);


        final String[] values= {"Sunday","Monday", "Saturday"};
        SharedPreferences sharedPreferencesGoalFirst = getSharedPreferences("GoalsForWeekFirst",MODE_PRIVATE);
        int WeekGoalFirst=  sharedPreferencesGoalFirst.getInt("First", MODE_PRIVATE);

        TextView textView4 = findViewById(R.id.textView4);
        TextView textView6 = findViewById(R.id.textView6);
        textView4.setText(WeekGoal+" days");
        textView6.setText(values[WeekGoalFirst]);

    }

    //    number picker
    public void showNumberPicker(){
        //          nuber picker
        //Get the widgets reference from XML layout
        final TextView sec2 = (TextView) findViewById(R.id.textView4);
        final NumberPicker NumSel = (NumberPicker) myDialog.findViewById(R.id.NumberSelector);
        TextView cancel = myDialog.findViewById(R.id.cancel);
        TextView set = myDialog.findViewById(R.id.ok);

        //Set TextView text color
        sec2.setTextColor(Color.parseColor("#0B88C9"));

        //Populate NumberPicker values from minimum and maximum value range
        //Set the minimum value of NumberPicker
        NumSel.setMinValue(1);
        //Specify the maximum value/number of NumberPicker
        NumSel.setMaxValue(7);


        SharedPreferences sharedPreferencesGoal = getSharedPreferences("GoalsForWeek",MODE_PRIVATE);
        int WeekGoal=  sharedPreferencesGoal.getInt("num", MODE_PRIVATE);

        NumSel.setValue(WeekGoal);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        NumSel.setWrapSelectorWheel(true);

//        //Set a value change listener for NumberPicker
//        NumSel.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
//                //Display the newly selected number from picker
//                sec2.setText(newVal+" secs ▼");
//                    sec2.setText("15 secs ▼");
//            }
//        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                String valo = String.valueOf(NumSel.getValue());
                sec2.setText(valo+" days");


                SharedPreferences sharedPreferences = getSharedPreferences("GoalsForWeek",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("num",NumSel.getValue());
                editor.apply();
            }
        });
//        number picker over

    }

    //    number picker
    public void showDaysPicker(){

        //Get the widgets reference from XML layout
        final TextView tv = (TextView) findViewById(R.id.textView6);
        final NumberPicker np = (NumberPicker) myDialog.findViewById(R.id.NumberSelector);
        TextView cancel = myDialog.findViewById(R.id.cancel);
        final TextView set = myDialog.findViewById(R.id.ok);

        //Set TextView text color
        tv.setTextColor(Color.parseColor("#2196F3"));

        //Initializing a new string array with elements
        final String[] values= {"Sunday","Monday", "Saturday"};


        //Populate NumberPicker values from String array values
        //Set the minimum value of NumberPicker
        np.setMinValue(0); //from array first value
        //Specify the maximum value/number of NumberPicker
        np.setMaxValue(values.length-1); //to array last value

        //Specify the NumberPicker data source as array elements
        np.setDisplayedValues(values);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        np.setWrapSelectorWheel(true);


        SharedPreferences sharedPreferencesGoalFirst = getSharedPreferences("GoalsForWeekFirst",MODE_PRIVATE);
        int WeekGoalFirst= sharedPreferencesGoalFirst.getInt("First", MODE_PRIVATE);

        Log.i("dayspicker", "showDaysPicker: "+WeekGoalFirst);
        np.setValue(WeekGoalFirst);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                int newVal=np.getValue();
                tv.setText(values[newVal]);


                SharedPreferences sharedPreferences = getSharedPreferences("GoalsForWeekFirst",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("First",newVal);
                editor.apply();
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();

            }
        });
    }

    public void save(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
//        number picker over

    }

