package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class countdown extends AppCompatActivity {
    CircularView circularViewWithTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        circularViewWithTimer = findViewById(R.id.circular_view);
        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(10)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {

                                // Will be called if times up of countdown timer
                                Toast.makeText(countdown.this, "CircularCallback: Timer Finished ", Toast.LENGTH_SHORT).show();

                                callactivity();
                            }

                            @Override
                            public void onTimerCancelled() {

                                // Will be called if stopTimer is called
                                Toast.makeText(countdown.this, "CircularCallback: Timer Cancelled ", Toast.LENGTH_SHORT).show();
                            }
                        });

        circularViewWithTimer.setOptions(builderWithTimer);
        circularViewWithTimer.startTimer();
    }

    private void callactivity() {

        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
