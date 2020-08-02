package com.example.databind;

import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class Click {
    private Timer       timer;

    public void onStartClick(final Data data){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int value = data.value;
                if (value--  < 1){
                    cancel();
                    return;
                }
                Log.e("Click","data : " + data);
                data.key = "left";
                data.value = value;
            }
        },1000 * 1,1000 * 1);
    }
    public void onStopClicked(Data data){
        cancel();
    }
    private void cancel(){
        if (timer != null){
            timer.cancel();
            timer = null;
        }
    }
    public void onStartClicked(View view){

    }
    public void onStopClicked(View view){

    }
    public void onResetClicked(View view){

    }
    public void onResetClicked(Data data){
        data.key = "time";
        data.value = 10;
    }

    public void onBackGroundClicked(View view){

    }
}
