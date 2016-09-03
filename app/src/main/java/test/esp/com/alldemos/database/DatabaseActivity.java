package test.esp.com.alldemos.database;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import test.esp.com.alldemos.DBHelper;
import test.esp.com.alldemos.R;

/**
 * Created by admin on 3/12/15.
 */
public class DatabaseActivity extends Activity {
    DBHelper dbHelper;
    EditText edtcity, edtname;
    Button btnSave;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        listView = (ListView) findViewById(R.id.lvdata);
        edtcity = (EditText) findViewById(R.id.txtcity);
        edtname = (EditText) findViewById(R.id.txtname);
        btnSave = (Button) findViewById(R.id.btnSave);
        Show_data();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtcity.getText().toString().isEmpty() && !edtname.getText().toString().isEmpty()) {
                    dbHelper = new DBHelper(DatabaseActivity.this);
                    dbHelper.insertdata(edtname.getText().toString().trim(), edtcity.getText().toString().trim());
                    Show_data();
                } else {
                    Toast.makeText(DatabaseActivity.this, "Please Enter name and city", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void Show_data() {
        dbHelper = new DBHelper(DatabaseActivity.this);
        ArrayList<String> dataList = dbHelper.getdata();
        if (dataList != null) {
            System.out.println("===========dataList.size()==========" + dataList.size());
            ArrayAdapter<String> da = new ArrayAdapter<String>(DatabaseActivity.this, android.R.layout.simple_list_item_1, dataList);
            listView.setAdapter(da);
        }
        edtname.setText("");
        edtcity.setText("");
    }
}
