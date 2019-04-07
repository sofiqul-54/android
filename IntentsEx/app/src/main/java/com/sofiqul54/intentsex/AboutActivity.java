package com.sofiqul54.intentsex;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
TextView nn;
Button btngoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        nn=(TextView)findViewById(R.id.about);
        btngoogle = (Button)findViewById(R.id.btngoogle) ;

        Intent i = getIntent();
        String name = i.getExtras().getString("nn");
        nn.setText(name);

        btngoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri.parse("https://www.google.com/");
                startActivity(intent);
            }
        });

    }
}
