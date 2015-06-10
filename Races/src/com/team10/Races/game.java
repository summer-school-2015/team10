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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

/**
 * Created by User on 09/06/2015.
 */
public class game extends Activity implements SensorEventListener/* View.OnTouchListener*/{


    public ImageView mImageView;
    SensorManager sm;
    Sensor accel;
    private int mX;
    private int mY;
    objects[] Walls;
    objects w;
    Random rand = new Random();


    CarModel car;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        accel = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,accel,SensorManager.SENSOR_DELAY_NORMAL);

        FrameLayout main = (FrameLayout)findViewById(R.id.game);
        car = new CarModel(this);
        FrameLayout.LayoutParams imageViewLayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        car.setLayoutParams(imageViewLayoutParams);
        car.changexy(0, 700);
        //main.addView(car);
        w = new objects(this);

        w.setLayoutParams(imageViewLayoutParams);
        w.changexy(rand.nextInt(1920), 0);
        main.addView(w);
        main.addView(car);




    }
    public void onSensorChanged(SensorEvent event) {
        if(w.changexy(0, 100) == 1 && (car.gety() >= w.gety() && car.gety() <= w.gety() + 200))
            finish();

        float a =  - 10 * event.values[0];
        car.changexy(a, 0);
        w.invalidate();
        car.invalidate();
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }




    public void toGame(View v){setContentView(R.layout.game);}
    public void toMenu(View v){setContentView(R.layout.main);}
    public void Exit_on_click(View v){finish();}
    public void Move_on_click(View v){w.changexy(0, 100);
        w.invalidate();
      }

    }


