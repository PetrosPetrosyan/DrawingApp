package com.example.pet.drawingapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;



/**
 * Created by Pet on 2/16/2018.
 */

public class DrawingView extends View {

    private Path path = new Path();
    private Paint paint = new Paint();
    private Paint canvasPaint;
    private Canvas canvas;
    //    private Drawable drawable = getResources().getDrawable(R.drawable.example3);
    private Bitmap bitmap, bitmap1;
    private boolean erase = false;
    private View view = findViewById(R.id.view);
    private boolean border = true;
//    private int x=(int)view.getX(),y=(int)view.getY(),h=Math.abs(view.getHeight()),w=Math.abs(view.getWidth());
//    private int bitmaph=bitmap1.getHeight(),bitmapw=bitmap1.getWidth();


//    public Drawable scaleImage (Drawable image, int w,int h) {
//
//        if ((image == null) || !(image instanceof BitmapDrawable)) {
//            return image;
//        }
//
//        Bitmap b = ((BitmapDrawable)image).getBitmap();
//        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, w, h, false);
//        image = new BitmapDrawable(getResources(), bitmapResized);
//
//        return image;
//
//    }

    //    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public DrawingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(6);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
//        drawable.setBounds(x,y,x+w,y+h);
    }
//    public void setBitmap(){
////        drawable.setBounds(x,y,x+w,y+h);
//        bitmap= ((BitmapDrawable)drawable).getBitmap();
//    }

    public void setErase(boolean iserase) {
        paint.setColor(Color.WHITE);
        erase = iserase;
        if (erase) paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        else paint.setXfermode(null);
        paint.setColor(Color.WHITE);
    }

    public void setPaintColor(int r, int g, int b) {
        setErase(false);
        paint.setColor(Color.rgb(r, g, b));
    }

    public void setPaintWidth(float width) {
        paint.setStrokeWidth(width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, 0, canvasPaint);
        canvas.drawPath(path, paint);
    }

    int redValue0 = 240;
    int greenValue0 = 240;
    int blueValue0 = 240;

    private float eventX;
    private float eventY;
    private int pixel, x, y, pixeln;
    private boolean sxal = true, nersum;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        eventX = event.getX();
        eventY = event.getY();

//        scaleImage(drawable,w,h);
//        bitmap= ((BitmapDrawable)drawable).getBitmap();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                bitmap1 = view.getDrawingCache();
                pixel = bitmap1.getPixel((int) eventX, (int) eventY);
//                final  int pixel = bitmap1.getPixel((int)eventX,(int)eventY);
                redValue0 = Color.red(pixel);
                greenValue0 = Color.green(pixel);
                blueValue0 = Color.blue(pixel);
                if (redValue0 > 254 || redValue0 < 1) redValue0 = 300;
                if (blueValue0 > 254 || blueValue0 < 1) blueValue0 = 300;
                if (greenValue0 > 254 || greenValue0 < 1) greenValue0 = 300;
//                if(redValue==45 && greenValue==45 && blueValue==45) border=false;
//                else border=true;
                break;
            case MotionEvent.ACTION_MOVE:

//                bitmap1 = view.getDrawingCache();
                try {
                    bitmap1.getPixel((int) eventX, (int) eventY);
                    sxal = false;
                } catch (IllegalArgumentException e) {
                    sxal = true;
                }
                if (sxal == false) {
                    pixel = bitmap1.getPixel((int) eventX, (int) eventY);
                    int redValue = Color.red(pixel);
                    int greenValue = Color.green(pixel);
                    int blueValue = Color.blue(pixel);
                    if (redValue == redValue0 && greenValue == greenValue0 && blueValue == blueValue0)
                        border = true;
                    else {
                        border = false;
                    }
//                if (border == true) path.lineTo(eventX, eventY);
//                else {canvas.drawPath(path, paint);path.reset();}
                    paint.getColor();
                    if (border == true) {
                        nersum = false;
                        x = (int) eventX - 20;
                        y = (int) eventY - 20;

                        for (x = (int) eventX - 30; x <= (int) eventX + 30 ; x+=6) {
                            path.moveTo(x, y);
                            for (y = (int) eventY-30; y <= (int) eventY +1; y+=6) {
                                if (y > 0) {
                                    if ((x - eventX) * (x - eventX) + (y - eventY) * (y - eventY) < 900) {
                                        try {
                                            pixeln = bitmap1.getPixel(x, y);
                                        } catch (IllegalArgumentException e) {
                                        }
                                        int redValuen = Color.red(pixeln);
                                        int greenValuen = Color.green(pixeln);
                                        int blueValuen = Color.blue(pixeln);
                                        if (redValuen == redValue0 && greenValuen == greenValue0 && blueValuen == blueValue0) {
                                            if (nersum == false) {
                                                nersum = true;
                                                path.moveTo(x, y);
                                            } else {
                                                path.lineTo(x, y);
//                                        path.moveTo(x, y);
                                            }
                                        }
                                    }
                                }
                            }
                            nersum = false;
                        }


                        for (x = (int) eventX - 30; x < (int) eventX + 30; x+=6) {
                            path.moveTo(x, y);
                            for (y = (int) eventY +30; y >= (int) eventY -1;  y-=6) {
                                if (y > 0) {
                                    if ((x - eventX) * (x - eventX) + (y - eventY) * (y - eventY) < 900) {
                                        try {
                                            pixeln = bitmap1.getPixel(x, y);
                                        } catch (IllegalArgumentException e) {
                                        }
                                        int redValuen = Color.red(pixeln);
                                        int greenValuen = Color.green(pixeln);
                                        int blueValuen = Color.blue(pixeln);
                                        if (redValuen == redValue0 && greenValuen == greenValue0 && blueValuen == blueValue0) {
                                            if (nersum == false) {
                                                nersum = true;
                                                path.moveTo(x, y);
                                            } else {
                                                path.lineTo(x, y);
//                                        path.moveTo(x, y);
                                            }
                                        }
                                    }
                                }
                            }
                            nersum = false;
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                canvas.drawPath(path, paint);
                path.reset();
                break;
            default:
                return false;
        }

        invalidate();
        return true;

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }
}
