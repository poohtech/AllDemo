package test.esp.com.alldemos.ServiceBase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import test.esp.com.alldemos.R;
import test.esp.com.alldemos.DBHelper;
import test.esp.com.alldemos.MyService;

/**
 * Created by admin on 27/4/16.
 */
public class StartStopService extends Activity {

    Button btnStart;
    Button btnStop;
    ListView lvList;
    ArrayList<String> listdata;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_startstopsetvice);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        lvList = (ListView) findViewById(R.id.lvList);

        dbHelper = new DBHelper(StartStopService.this);
        listdata = dbHelper.gettimedata();
        if (listdata != null && listdata.size() > 0) {
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(StartStopService.this, android.R.layout.simple_list_item_1, listdata);
            lvList.setAdapter(stringArrayAdapter);
        }

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(StartStopService.this, MyService.class));
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(StartStopService.this, MyService.class));
            }
        });

    }
}
