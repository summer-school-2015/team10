package com.team10.Races;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by User on 08/06/2015.
 */
public class CarModel extends ImgView{
    float pos;

    public CarModel(Context cnt) {
        super(cnt);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.car1);
        canvas.drawBitmap(bmp, sx, sy, null);
    }


}
