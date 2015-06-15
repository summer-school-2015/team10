package com.team10.Races;

import android.app.Activity;
import android.content.res.AssetManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.*;
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
    int width, height;
    objects[] Walls;
    objects w, v;
    Random rand = new Random();
    FrameLayout main;
    int flag = 0;
    int i = 0;

    CarModel car;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        accel = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,accel,SensorManager.SENSOR_DELAY_NORMAL);

        main = (FrameLayout)findViewById(R.id.game);
        main.post(new Runnable() {
            @Override
            public void run() {
                width = main.getMeasuredWidth();
                height = main.getMeasuredHeight();

            }
        });
        //text
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("HighScore.txt"));
            String line = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //text ends
        car = new CarModel(this);
        FrameLayout.LayoutParams imageViewLayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        car.setLayoutParams(imageViewLayoutParams);
        //main.addView(car);
        w = new objects(this);
        v = new objects(this);
        w.setLayoutParams(imageViewLayoutParams);
        v.setLayoutParams(imageViewLayoutParams);
        main.addView(w);

        main.addView(car);




    }
    public void onSensorChanged(SensorEvent event) {
        TextView score = (TextView) findViewById(R.id.textView);
        int q = main.getHeight();
        int e = car.getHeight();
        if(flag == 0){car.changexy(0, main.getHeight() - 100, main);
            w.changexy(rand.nextInt(main.getWidth() - 50), 0, main);

            flag = 1;
        }

        if(i == 25){
            v.changexy(rand.nextInt(main.getWidth() - 50), 0, main);
            main.addView(v);}
        i++;
        if(i >= 25)
            v.changexy(0, 10, main);
        w.changexy(0, 10, main);
        score.setText("Score: " + String.valueOf(i));
        if((car.getx() >= w.getx() - 50 && car.getx() <= w.getx() + 50) && (car.gety() >= w.gety() && car.gety() <= w.gety() + 100)) {
            finish();
        }
        if((car.getx() >= v.getx() -  50 && car.getx() <= v.getx() + 50) && (car.gety() >= v.gety() && car.gety() <= v.gety() + 100))
            finish();


        float a =  - 10 * event.values[0];
        car.changexy(a, 0, main);
        w.invalidate();
        car.invalidate();
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }




    public void toGame(View v){setContentView(R.layout.game);}
    public void toMenu(View v){setContentView(R.layout.main);}
    public void Exit_on_click(View v){finish();}


    }


