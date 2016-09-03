package test.esp.com.alldemos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by admin on 3/12/15.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String dbName = "dbUser";

    public DBHelper(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query_userdata = "CREATE TABLE " + Config.user_data + " (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,city TEXT)";
        db.execSQL(Query_userdata);

        String Query_time = "CREATE TABLE " + Config.time_data + " (id INTEGER PRIMARY KEY AUTOINCREMENT,current_time TEXT)";
        db.execSQL(Query_time);

        String Query_msg_phone = "CREATE TABLE " + Config.call_log + " (id INTEGER PRIMARY KEY AUTOINCREMENT,log_number TEXT,log_time TEXT,log_type INTEGER)";
        db.execSQL(Query_msg_phone);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Config.user_data + "");
        db.execSQL("DROP TABLE IF EXISTS " + Config.time_data + "");
        db.execSQL("DROP TABLE IF EXISTS " + Config.call_log + "");
        // Create tables again
        onCreate(db);
    }

    public void insertdata(String name, String city) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("name", name); // Contact Phone Number
        values.put("city", city); // Contact Name
        db.insert(Config.user_data, null, values);
        db.close(); // Closing database connection
    }

    public void inserttimedata(String current_time) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("current_time", current_time);
        db.insert(Config.time_data, null, values);
        db.close();
    }

    public void insertCallLogdata(String number, String time, int type) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("log_number", number);
        values.put("log_time", time);
        values.put("log_type", type);
        db.insert(Config.call_log, null, values);
        System.out.println("Success Insert " + number.toString() + " this number");
        db.close();
    }


    public ArrayList<String> gettimedata() {
        ArrayList<String> al = null;

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Config.time_data + " ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            al = new ArrayList<String>();
            do {
                al.add(cursor.getInt(0) + " " + cursor.getString(1).toString());
            } while (cursor.moveToNext());
        }
        return al;

    }

    public ArrayList<String> getLogdata(int type) {
        ArrayList<String> al = null;

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Config.call_log + " WHERE log_type=" + type + " ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            al = new ArrayList<String>();
            do {
                al.add(cursor.getString(1) + " \n" + cursor.getString(2).toString());
            } while (cursor.moveToNext());
        }
        return al;

    }


    public ArrayList<String> getdata() {
        ArrayList<String> al = null;

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Config.user_data;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            al = new ArrayList<String>();
            do {
                al.add(cursor.getInt(0) + " " + cursor.getString(1).toString() + " " + cursor.getString(2).toString());
            }
            while (cursor.moveToNext());
        }
        return al;

    }
}
