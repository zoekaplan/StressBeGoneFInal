package com.example.zoerebeccakaplan.stressbegone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FeelBetter extends AppCompatActivity implements View.OnClickListener {

    private Button startOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feel_better);
        Log.d("Stringaf", "onClick: click");

        wireWidgets();
        setOnCLickListeners();
    }


    private void wireWidgets() {
        startOver = (Button) findViewById(R.id.button_start_over);
    }

    private void setOnCLickListeners() {
        startOver.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(FeelBetter.this, MainActivity.class);
        startActivity(i);
    }

}
