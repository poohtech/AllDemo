package test.esp.com.alldemos;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by admin on 27/4/16.
 */
public class MyService extends Service {

    boolean isRuning = false;
    TimerTask tt;
    Timer timer;

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate");
        isRuning = true;

        timer = new Timer();

        tt = new TimerTask() {
            @Override
            public void run() {
                System.out.println("====================================Manish======================");
                if (isRuning == true) {
                    System.out.println("=======Time=======>>>>" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
                }
            }
        };

        timer.scheduleAtFixedRate(tt, 100, 1000);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
        isRuning = false;
    }

    @Override
    public boolean stopService(Intent name) {
        return super.stopService(name);
    }
}
