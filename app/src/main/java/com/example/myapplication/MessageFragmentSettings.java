package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

public class MessageFragmentSettings extends Fragment{

    Dialog myDialog;
    Dialog myNumberDialog;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings, container, false);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        for sound options
        myDialog= new Dialog(getActivity());

//        for countdown timer
        myNumberDialog= new Dialog(getActivity());



//        share with
        LinearLayout share = getActivity().findViewById(R.id.share_with);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
//        share with over
//        sound options
        LinearLayout cardOnclick = getActivity().findViewById(R.id.sound_options1);
        cardOnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.soundoptions);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();

                Toast.makeText(getActivity(), "this works", Toast.LENGTH_SHORT).show();

                loadData();
            }
        });
//    sound options

//        countdown timer
        LinearLayout numberpickerdialog = getActivity().findViewById(R.id.countdownTimer);
        numberpickerdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myNumberDialog.setContentView(R.layout.dialog_numberpicker);
                myNumberDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myNumberDialog.show();

                showNumberPicker();
            }
        });
//        countdown timer


    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//for on back pressed
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("forOnBack",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Back","OK1");
        editor.apply();
//for on back pressed over

//        for screen on
        final Switch screen_switch = (Switch) getActivity().findViewById(R.id.screen_switch);
        screen_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (screen_switch.isChecked()){
                    Toast.makeText(getActivity(), "ON", Toast.LENGTH_SHORT).show();

                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("screen",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("ON","True");
                    editor.apply();

                    getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                }else {
                    Toast.makeText(getActivity(), "OFF", Toast.LENGTH_SHORT).show();

                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("screen",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("ON","False");
                    editor.apply();

                    getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                }
            }
        });
        // for on/off switch
        SharedPreferences sharedPreferencesScreen = getActivity().getSharedPreferences("screen",MODE_PRIVATE);
        String screen= (String) sharedPreferencesScreen.getString("ON", String.valueOf(MODE_PRIVATE));
        if (screen.equals("True")){
            screen_switch.setChecked(true);
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }else {
            screen_switch.setChecked(false);
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
//        for screen on over


//          for rest time
        int seconds;
        TextView sec2 = (TextView) getActivity().findViewById(R.id.sec2);
        SharedPreferences sharedPreferencesforsound = getActivity().getSharedPreferences("restTime",MODE_PRIVATE);
        seconds = sharedPreferencesforsound.getInt("seconds",MODE_PRIVATE);
        if (seconds<=9){
            seconds=10;
        sec2.setText(seconds+" secs  ▼");
        }else {
            sec2.setText(seconds+" secs  ▼");
        }

    }



     int count;
    int countsound;
    public void loadData(){
        Button button = myDialog.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

//        switch
        final Switch mute = myDialog.findViewById(R.id.mute);
        final Switch voice = myDialog.findViewById(R.id.voice);


        // for switches to on or off when activity is created
        SharedPreferences sharedPreferencesforsound = getActivity().getSharedPreferences("sound",MODE_PRIVATE);
        countsound = sharedPreferencesforsound.getInt("result",MODE_PRIVATE);

        if (countsound==0){
            mute.setChecked(true);
            voice.setChecked(false);
        }else if (countsound==1){
            voice.setChecked(true);
            mute.setChecked(false);
            //for sound audio
            count = 1;
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("sound",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("result",count);
            editor.apply();
        }

        mute.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    voice.setChecked(false);

                //for mute audio
                    count = 0;
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("sound",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("result",count);
                    editor.apply();
                }
            }
        });

        voice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    mute.setChecked(false);

                    //for sound audio
                    count = 1;
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("sound",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("result",count);
                    editor.apply();
                }
            }
        });


    }
//    sound options


//    number picker
    public void showNumberPicker(){
        //          nuber picker
        //Get the widgets reference from XML layout
        final TextView sec2 = (TextView) getActivity().findViewById(R.id.sec2);
        final NumberPicker NumSel = (NumberPicker) myNumberDialog.findViewById(R.id.NumberSelector);
        TextView cancel = myNumberDialog.findViewById(R.id.cancel);
        TextView set = myNumberDialog.findViewById(R.id.set);

        //Set TextView text color
        sec2.setTextColor(Color.parseColor("#0B88C9"));

        //Populate NumberPicker values from minimum and maximum value range
        //Set the minimum value of NumberPicker
        NumSel.setMinValue(10);
        //Specify the maximum value/number of NumberPicker
        NumSel.setMaxValue(20);

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
                myNumberDialog.dismiss();

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myNumberDialog.dismiss();
                String valo = String.valueOf(NumSel.getValue());
                sec2.setText(valo+" secs  ▼");


                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("restTime",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("seconds", Integer.parseInt(valo));
                editor.apply();
            }
        });
//        number picker over
    }
};




