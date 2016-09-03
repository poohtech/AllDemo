package test.esp.com.alldemos.ReceiverExample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import test.esp.com.alldemos.R;
import test.esp.com.alldemos.DBHelper;

/**
 * Created by admin on 29/4/16.
 */
public class LogReceiverActivity extends Activity {

    ListView lvPhoneList;
    ArrayList<String> phonelist;
    ArrayAdapter<String> phoneAdapter;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonereceiver);

        lvPhoneList = (ListView) findViewById(R.id.lvPhoneList);
        Loaddata();
    }

    void Loaddata() {
        dbHelper = new DBHelper(LogReceiverActivity.this);
        phonelist = dbHelper.getLogdata(getIntent().getIntExtra("type", 0));
        if (phonelist != null && phonelist.size() > 0) {
            phoneAdapter = new ArrayAdapter<String>(LogReceiverActivity.this, android.R.layout.simple_list_item_1, phonelist);
            lvPhoneList.setAdapter(phoneAdapter);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

    }
}
