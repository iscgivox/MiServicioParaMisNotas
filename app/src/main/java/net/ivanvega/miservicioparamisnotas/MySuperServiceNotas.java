package net.ivanvega.miservicioparamisnotas;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by SERVIDOR on 11/11/2016.
 */


public class MySuperServiceNotas extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
