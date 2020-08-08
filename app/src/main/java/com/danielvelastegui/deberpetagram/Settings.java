package com.danielvelastegui.deberpetagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void guardarCuenta(View v){
        Toast.makeText(this, "Cuenta guardada", Toast.LENGTH_SHORT).show();
    }
}