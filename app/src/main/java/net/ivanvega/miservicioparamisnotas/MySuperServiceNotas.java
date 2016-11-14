package net.ivanvega.miservicioparamisnotas;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by SERVIDOR on 11/11/2016.
 */


public class MySuperServiceNotas extends Service {


    private Handler handler =
            new Handler();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        super.onCreate();

        Log.d("MYSIMPLESERVICE","SERVICIO ONCREATE");
        Toast.makeText(this, "SERVICIO ONCREATE", Toast.LENGTH_LONG).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        Log.d("MYSIMPLESERVICE","SERVICIO NICIADO");
        Toast.makeText(this, "SERVICIO INICIADO", Toast.LENGTH_LONG).show();

        handler.postDelayed(runnable, 5000);

        return START_NOT_STICKY;
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            Log.d("HILOCORRIENdo", "HILOCORRIENdo");
            handler.postDelayed(this,2000);
        }

    };

    @Override
    public void onDestroy() {
        Log.d("MYSIMPLESERVICE","SERVICIO PARADO");
        Toast.makeText(this, "SERVICIO PARADO", Toast.LENGTH_LONG).show();

        super.onDestroy();
    }
}
