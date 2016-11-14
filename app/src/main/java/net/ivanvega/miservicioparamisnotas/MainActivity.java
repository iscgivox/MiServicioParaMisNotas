package net.ivanvega.miservicioparamisnotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnStart_click(View v) {
        startService(
                new Intent(this, MySuperServiceNotas.class)
        );
    }

    public void btnStopService_click(View v) {
        stopService(
                new Intent(this, MySuperServiceNotas.class)
        );
    }
}