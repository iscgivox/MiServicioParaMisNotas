package net.ivanvega.miservicioparamisnotas;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by SERVIDOR on 11/11/2016.
 */


public class MySuperServiceNotas extends Service {

     ;
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


            NotificationCompat.Builder nb=
                    new NotificationCompat.Builder(getApplicationContext());
            nb.setSmallIcon(R.mipmap.ic_launcher);
            nb.setTicker("validar a: " );
            nb.setContentTitle("Validar al usuario");
            nb.setContentText("Pedrito " + "\n"
                    + "@pedrito");
            nb.setAutoCancel(true);

            nb.setLights(Color.BLUE, 500, 1000);

            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://sicenet.itsur.edu.mx")
            );
            PendingIntent pi = PendingIntent.getActivity
                    (getBaseContext(), 1001, i, PendingIntent.FLAG_CANCEL_CURRENT) ;
            nb.setContentIntent(pi);
            Notification n = nb.build();

            n.defaults |= Notification.DEFAULT_LIGHTS;
            n.defaults |= Notification.DEFAULT_VIBRATE;
            n.defaults |= Notification.DEFAULT_SOUND;

            NotificationManager  nmc = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);

            nmc.notify(1001, n);

            handler.postDelayed(this,5000);
        }

    };

    @Override
    public void onDestroy() {
        Log.d("MYSIMPLESERVICE","SERVICIO PARADO");
        Toast.makeText(this, "SERVICIO PARADO", Toast.LENGTH_LONG).show();

        super.onDestroy();
    }
}
