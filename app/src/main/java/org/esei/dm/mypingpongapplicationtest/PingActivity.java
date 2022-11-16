package org.esei.dm.mypingpongapplicationtest;

import static android.content.Intent.FLAG_ACTIVITY_TASK_ON_HOME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.esei.dm.mypingpongapplicationtest.model.PingPongData;

public class PingActivity extends AppCompatActivity {

    public static final String PINGPONGDATA = "PINGPONGDATA";

    private PingPongData pingPongData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getSerializableExtra(PINGPONGDATA)!=null){
            pingPongData = (PingPongData) this.getIntent().getSerializableExtra(PINGPONGDATA);
            Toast.makeText(this, pingPongData.getMessage()+" : " + pingPongData.getCount(), Toast.LENGTH_SHORT).show();


        }else{
            pingPongData = new PingPongData("Hi Pong!");

        }

        Button button = findViewById(R.id.buttonStartPong);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PingActivity.this, PongActivity.class);
                intent.setFlags(FLAG_ACTIVITY_TASK_ON_HOME);
                pingPongData.increment();
                pingPongData.setMessage("Hi Pong!");
                intent.putExtra(PINGPONGDATA, pingPongData);
                startActivity(intent);

            }
        });




    }

    @Override
    protected void onNewIntent(Intent intent) {
        pingPongData = (PingPongData) intent.getSerializableExtra(PINGPONGDATA);
        Toast.makeText(this, pingPongData.getMessage()+" : " + pingPongData.getCount(), Toast.LENGTH_SHORT).show();
        super.onNewIntent(intent);
    }
}