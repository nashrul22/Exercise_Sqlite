package com.example.exercise_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton push;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        push = findViewById(R.id.tambahkontak);

        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                move();

            }
        });


    }

    public void move(){
        Intent intent = new Intent(MainActivity.this, tambah_data.class);
   startActivity(intent);
    }
}
