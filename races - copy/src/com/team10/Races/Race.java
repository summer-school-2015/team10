package com.team10.Races;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Race extends Activity  {


   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }







    public void toGame(View v){    Intent intent = new Intent(Race.this, game.class);
        startActivity(intent);}
    public void toMenu(View v){setContentView(R.layout.main);}
    public void Exit_on_click(View v){finish();}

}
