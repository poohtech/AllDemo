package test.esp.com.alldemos;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import test.esp.com.alldemos.Animation.MyAnimation;
import test.esp.com.alldemos.CamaraWithCrop.CamaraWithCropActivity;
import test.esp.com.alldemos.CurrentLatLong.MyLocation;
import test.esp.com.alldemos.Drowing.DrowingActivity;
import test.esp.com.alldemos.FacebookList.FacebookFriendListActivity;
import test.esp.com.alldemos.GetSpeed.GetSpeedActivity;
import test.esp.com.alldemos.ListViewWithSelected.ListviewWithSelected;
import test.esp.com.alldemos.NavigationDrawer.NavigationDrawerMainActivity;
import test.esp.com.alldemos.ReceiverExample.BrodcastReceiverActivity;
import test.esp.com.alldemos.ScrollAndMoveImage.ScrollAndMoveActivity;
import test.esp.com.alldemos.ScrollviewInnerListview.ScrollviewInnerListviewActivity;
import test.esp.com.alldemos.ServiceBase.StartStopService;
import test.esp.com.alldemos.Shadow.ShadowActivity;
import test.esp.com.alldemos.StikkyList.StikkyListviewActivity;
import test.esp.com.alldemos.TickTock.TickTockRoundActivity;
import test.esp.com.alldemos.database.DatabaseActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    //    Keyhase :- W9HvTtSFn4d/ZVDbsIUony2aL7I=
//    App Id :- 1100143733350917
//    App Secert :- d00eb78e88dde75d10c10eef6bec0767
    TextView databaseDemo, UploadImageWithCrop, scrollviewWithList, ticktock, drowingImage, NavigationDrawer, CurrentLatLong, StikkyListview, Animation, FacebookFriendList, ShadowExample, ServiceStartStop, BrodcastReceiver;
    TextView GetSpeed, ScrollAndMoveImage, WEbViewSWFFile, RetrofitParsing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseDemo = (TextView) findViewById(R.id.databasedemo);
        UploadImageWithCrop = (TextView) findViewById(R.id.UploadImageWithCrop);
        scrollviewWithList = (TextView) findViewById(R.id.scrollListview);
        ticktock = (TextView) findViewById(R.id.ticktock);
        drowingImage = (TextView) findViewById(R.id.drowingImage);
        NavigationDrawer = (TextView) findViewById(R.id.NavigationDrawer);
        CurrentLatLong = (TextView) findViewById(R.id.CurrentLatLong);
        StikkyListview = (TextView) findViewById(R.id.StikkyListview);
        Animation = (TextView) findViewById(R.id.Animation);
        FacebookFriendList = (TextView) findViewById(R.id.FacebookFriendList);
        ShadowExample = (TextView) findViewById(R.id.ShadowExample);
        ServiceStartStop = (TextView) findViewById(R.id.ServiceStartStop);
        BrodcastReceiver = (TextView) findViewById(R.id.BrodcastReceiver);
        GetSpeed = (TextView) findViewById(R.id.GetSpeed);
        ScrollAndMoveImage = (TextView) findViewById(R.id.ScrollAndMoveImage);
        WEbViewSWFFile = (TextView) findViewById(R.id.WEbViewSWFFile);
        RetrofitParsing = (TextView) findViewById(R.id.RetrofitParsing);


        databaseDemo.setOnClickListener(this);
        UploadImageWithCrop.setOnClickListener(this);
        scrollviewWithList.setOnClickListener(this);
        ticktock.setOnClickListener(this);
        drowingImage.setOnClickListener(this);
        NavigationDrawer.setOnClickListener(this);
        CurrentLatLong.setOnClickListener(this);
        StikkyListview.setOnClickListener(this);
        Animation.setOnClickListener(this);
        FacebookFriendList.setOnClickListener(this);
        ShadowExample.setOnClickListener(this);
        ServiceStartStop.setOnClickListener(this);
        BrodcastReceiver.setOnClickListener(this);
        GetSpeed.setOnClickListener(this);
        ScrollAndMoveImage.setOnClickListener(this);
        WEbViewSWFFile.setOnClickListener(this);
        RetrofitParsing.setOnClickListener(this);


        try {
            PackageInfo info = getPackageManager().getPackageInfo("test.esp.com.alldemos", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                System.out.println("KeyHash:" + Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {

            case R.id.databasedemo:
                i = new Intent(this, DatabaseActivity.class);
                startActivity(i);
                break;

            case R.id.UploadImageWithCrop:
                i = new Intent(this, CamaraWithCropActivity.class);
                startActivity(i);
                break;

            case R.id.scrollListview:
                i = new Intent(this, ScrollviewInnerListviewActivity.class);
                startActivity(i);
                break;

            case R.id.ticktock:
                i = new Intent(this, TickTockRoundActivity.class);
                startActivity(i);
                break;

            case R.id.drowingImage:
                i = new Intent(this, DrowingActivity.class);
                startActivity(i);
                break;

            case R.id.NavigationDrawer:
                i = new Intent(this, NavigationDrawerMainActivity.class);
                startActivity(i);
                break;

            case R.id.CurrentLatLong:
                i = new Intent(this, MyLocation.class);
                startActivity(i);
                break;

            case R.id.StikkyListview:
                i = new Intent(this, StikkyListviewActivity.class);
                startActivity(i);
                break;

            case R.id.Animation:
                i = new Intent(this, MyAnimation.class);
                startActivity(i);
                break;

            case R.id.FacebookFriendList:
                i = new Intent(this, FacebookFriendListActivity.class);
                startActivity(i);
                break;

            case R.id.ShadowExample:
                i = new Intent(this, ShadowActivity.class);
                startActivity(i);
                break;


            case R.id.ServiceStartStop:
                i = new Intent(this, StartStopService.class);
                startActivity(i);
                break;

            case R.id.BrodcastReceiver:
                i = new Intent(this, BrodcastReceiverActivity.class);
                startActivity(i);
                break;

            case R.id.GetSpeed:
                i = new Intent(this, GetSpeedActivity.class);
                startActivity(i);
                break;

            case R.id.ScrollAndMoveImage:
                i = new Intent(this, ScrollAndMoveActivity.class);
                startActivity(i);
                break;

            case R.id.WEbViewSWFFile:
                i = new Intent(this, ScrollAndMoveActivity.class);
                startActivity(i);
                break;

            case R.id.RetrofitParsing:
                i = new Intent(this, ListviewWithSelected.class);
                startActivity(i);
                break;


        }
    }
}
