package com.example.pet.drawingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {

    private ImageView image1,image2,image3;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        view=findViewById(R.id.view);

        image1=findViewById(R.id.image1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                view.setBackgroundResource(R.drawable.kria6);
                Intent intent=new Intent(StartActivity.this,MainActivity.class);
                intent.putExtra("background",1);
                startActivity(intent);
            }
        });
    }
}
