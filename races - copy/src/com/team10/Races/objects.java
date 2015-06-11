package com.team10.Races;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by User on 08/06/2015.
 */
public class objects extends ImgView{

    public objects(Context cnt) {
        super(cnt);

    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.stena);
        canvas.drawBitmap(bmp, 50 + sx, 50 + sy, null);
    }
}
