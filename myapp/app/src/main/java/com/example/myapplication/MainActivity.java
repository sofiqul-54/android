package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                sb.append("Name: "+name.getText().toString()+"\n");
                sb.append("Password :"+pass.getText().toString());
                Toast toast = Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }
}
