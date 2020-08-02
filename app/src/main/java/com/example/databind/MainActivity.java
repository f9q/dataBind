package com.example.databind;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public Data data ;

    private void initData(){
        data = new Data();
        data.key  = "number";
        data.value = 16;
        data.icon = R.mipmap.boy;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();

        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main,new MainFrgmt(),"MainFrgmt").commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
