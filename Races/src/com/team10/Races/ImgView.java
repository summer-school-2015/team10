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
    public int sx = 0;
    public int sy = 0;
    public Bitmap bmp;
    Random rand = new Random();
    protected void onDraw(Canvas canvas) {

    }
    public int changexy(float x, float y, FrameLayout main)
    {
        sx += (int)x;
        int i = main.getWidth();
        sx = sx % main.getWidth();
        if(sx + 50 < 0)
            sx = main.getWidth();

        sy += (int)y;
        if(sy != sy % (main.getHeight())){
            sx = rand.nextInt(main.getWidth());
            sy = sy % main.getHeight();
          return 0;
        }

        return 1;

    }
    public float getx(){return sx;}
    public float gety(){return sy;
    }
}
