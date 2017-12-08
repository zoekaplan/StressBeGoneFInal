package com.example.zoerebeccakaplan.stressbegone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private ImageView introButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        introButton.setOnClickListener(this);

    }




    private void wireWidgets() {
        introButton = (ImageView) findViewById(R.id.imageView_intro);
    }




    @Override
    public void onClick(View view) {
       Intent i = new Intent(MainActivity.this, FirstQuestion.class);
        startActivity(i);

    }
}
