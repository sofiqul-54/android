package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name, pass;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText) findViewById(R.id.editText2);
        pass=(EditText)findViewById(R.id.editText4);
        btnAdd=(Button)findViewById(R.id.button);

        btnAdd.setOnLongClickListener(new view.onClickListeners(){

        });

    }
}
