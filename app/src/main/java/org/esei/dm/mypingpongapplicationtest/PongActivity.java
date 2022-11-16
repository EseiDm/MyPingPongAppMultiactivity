package org.esei.dm.mypingpongapplicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.esei.dm.mypingpongapplicationtest.model.PingPongData;

public class PongActivity extends AppCompatActivity {

    PingPongData pingPongData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pong);
        Button button = findViewById(R.id.buttonStartPing);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PongActivity.this, PingActivity.class);
                pingPongData.setMessage("Hi Ping!");
                pingPongData.increment();
                intent.putExtra(PingActivity.PINGPONGDATA, pingPongData);
                startActivity(intent);
            }
        });

        pingPongData = (PingPongData) this.getIntent().getSerializableExtra(PingActivity.PINGPONGDATA);
        Toast.makeText(this, pingPongData.getMessage()+" : " + pingPongData.getCount(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        pingPongData = (PingPongData) intent.getSerializableExtra(PingActivity.PINGPONGDATA);
        Toast.makeText(this, pingPongData.getMessage()+" : " + pingPongData.getCount(), Toast.LENGTH_SHORT).show();
        super.onNewIntent(intent);
    }
}