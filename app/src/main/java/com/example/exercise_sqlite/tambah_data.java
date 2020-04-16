package com.example.exercise_sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class tambah_data extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_kontak);
    }

    public void Pindah1(View view) {
        Intent intent1 = new Intent(tambah_data.this,
                MainActivity.class);
        startActivity(intent1);
    }


}
