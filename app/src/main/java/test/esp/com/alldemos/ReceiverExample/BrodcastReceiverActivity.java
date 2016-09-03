package test.esp.com.alldemos.ReceiverExample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import test.esp.com.alldemos.Config;
import test.esp.com.alldemos.Pref;
import test.esp.com.alldemos.R;

/**
 * Created by admin on 29/4/16.
 */
public class BrodcastReceiverActivity extends Activity implements View.OnClickListener {

    Button txtMessageReceiver, txtPhoneReceiver;
    Intent i;
    Switch swonoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_broadcastreceiver);

        txtMessageReceiver = (Button) findViewById(R.id.txtMessageReceiver);
        txtPhoneReceiver = (Button) findViewById(R.id.txtPhoneReceiver);
        swonoff = (Switch) findViewById(R.id.swonoff);

        txtMessageReceiver.setOnClickListener(this);
        txtPhoneReceiver.setOnClickListener(this);
        swonoff.setChecked(Pref.getValue(BrodcastReceiverActivity.this, Config.PREF_CALL_STATE, 0) == 1 ? true : false);

        swonoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Pref.setValue(BrodcastReceiverActivity.this, Config.PREF_CALL_STATE, isChecked == true ? 1 : 0);
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.txtMessageReceiver:

                i = new Intent(this, LogReceiverActivity.class);
                i.putExtra("type", 1);
                startActivity(i);

                break;

            case R.id.txtPhoneReceiver:
                i = new Intent(this, LogReceiverActivity.class);
                i.putExtra("type", 0);
                startActivity(i);

                break;
        }

    }
}
