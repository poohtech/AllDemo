package test.esp.com.alldemos.ReceiverExample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import test.esp.com.alldemos.Config;
import test.esp.com.alldemos.DBHelper;
import test.esp.com.alldemos.Pref;

/**
 * Created by admin on 29/4/16.
 */
public class LogReceiver extends BroadcastReceiver {

    String incomingNumber = "";
    TelephonyManager telephonyManager;
    DBHelper dbHelper;

    @Override
    public void onReceive(Context context, Intent intent) {

        dbHelper = new DBHelper(context);

        telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (intent.getAction().equals("android.intent.action.PHONE_STATE") && Pref.getValue(context, Config.PREF_CALL_STATE, 0) == 1) {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                dbHelper.insertCallLogdata(incomingNumber, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()).toString(), 0);
                try {
                    Class<?> classTelephony = Class.forName(telephonyManager.getClass().getName());
                    Method method = classTelephony.getDeclaredMethod("getITelephony");
                    method.setAccessible(true);
                    Object telephonyInterface = method.invoke(telephonyManager);
                    Class<?> telephonyInterfaceClass = Class.forName(telephonyInterface.getClass().getName());
                    Method methodEndCall = telephonyInterfaceClass.getDeclaredMethod("endCall");
                    methodEndCall.invoke(telephonyInterface);
                } catch (Exception e) {
                    System.out.println("=======Exception=====" + e.toString());
                }
            }
        } else if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            final Bundle bundle = intent.getExtras();
            final Object[] pdusObj = (Object[]) bundle.get("pdus");

            for (int i = 0; i < pdusObj.length; i++) {

                SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                incomingNumber = currentMessage.getDisplayOriginatingAddress();
                dbHelper.insertCallLogdata(incomingNumber + "\n\n" + currentMessage.getDisplayMessageBody() + "\n", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()).toString(), 1);

            }
        }

    }

}
