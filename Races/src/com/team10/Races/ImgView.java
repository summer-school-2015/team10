package com.team10.Races;




import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by User on 10/06/2015.
 */
public class ImgView extends ImageView {
    public ImgView(Context cnt){ super(cnt);}
    public float sx = 0;
    FrameLayout main = (FrameLayout)findViewById(R.id.game);
    public float sy = 0;
    public Bitmap bmp;
    Random rand = new Random();
    protected void onDraw(Canvas canvas) {

    }
    public int changexy(float x, float y)
    {
        sx += x;
        sx = sx % 480;

        sy += y;
        if(sy == sy % 700){
            sx = rand.nextInt(280);
          return 0;
        }
        sy = sy % 800;
        return 1;

    }
    public float gety(){
        return sx;
    }
}
