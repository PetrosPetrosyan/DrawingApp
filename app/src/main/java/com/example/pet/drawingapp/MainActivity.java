package com.example.pet.drawingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //    private View view;
    private DrawingView drawingView;
    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,button20;
    private Button eraser,brush;
    private SeekBar seekBar;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        view=findViewById(R.id.view);

        textView=findViewById(R.id.text);

//        view.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                float x=event.getX();
//                float y=event.getY();
//                Bitmap bitmap = ((BitmapDrawable)v.getDrawable()).getBitmap();
//                int pixel = bitmap.getPixel((int)x,(int)y);
//                int redValue = Color.red(pixel);
//                int blueValue = Color.blue(pixel);
//                int greenValue = Color.green(pixel);
//                textView.setText(String.valueOf(redValue)+String.valueOf(blueValue)+String.valueOf(greenValue));
//        /*if(redValue == 255){
//            if(blueValue == 0)
//                if(greenValue==0)
//               textViewCol.setText("It is Red");
//            }*/
//                return true;    }
//        });

        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        button10=findViewById(R.id.button10);
        button11=findViewById(R.id.button11);
        button12=findViewById(R.id.button12);
        button13=findViewById(R.id.button13);
        button14=findViewById(R.id.button14);
        button15=findViewById(R.id.button15);
        button16=findViewById(R.id.button16);
        button17=findViewById(R.id.button17);
        button18=findViewById(R.id.button18);
        button19=findViewById(R.id.button19);
        button20=findViewById(R.id.button20);

        eraser=findViewById(R.id.eraser);
        brush=findViewById(R.id.brush);
        seekBar=findViewById(R.id.seekbar);

        drawingView=(DrawingView)findViewById(R.id.view);
//        int background=Integer.parseInt(getIntent().getStringExtra("background"));
//        switch (background) {
//            case 1 :
//                drawingView.setBackgroundResource(R.drawable.kria2);
//                break;
//            case 2 :
//                drawingView.setBackgroundResource(R.drawable.vinni1);
//                break;
//        }

//        drawingView.setBitmap();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(255,0,0);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(0,0,255);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(0,255,0);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(255,0,255);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(255,255,0);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(0,0,0);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(100,38,12);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(0,251,255);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(255,142,246);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(13,65,0);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(0,169,101);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(255,102,0);
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(102,0,36);
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(9,0,80);
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(134,118,0);
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(128,128,128);
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(57,18,18);
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(81,61,0);
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(206,173,0);
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(74,0,89);
            }
        });

        eraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setErase(true);
            }
        });

        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                drawingView.setPaintWidth((float)progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
