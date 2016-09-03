package test.esp.com.alldemos.CurrentLatLong;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by admin on 3/3/16.
 */
public class GetLocation extends AppCompatActivity implements LocationListener {

    private Context context;
    private Activity activity;
    private Location location;
    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;

    public GetLocation(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
        setLocation();
    }

    public Location getLoc()
    {
        return location;
    }

    public void setLocation()
    {
        System.out.println("getLocation()");
        try
        {
            LocationManager locationManager = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            {

                System.out.println("isGPSEnabled=="+isGPSEnabled);
                System.out.println("isNetworkEnabled=="+isNetworkEnabled);
                if (!isGPSEnabled && !isNetworkEnabled)
                {
//                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    if (locationManager != null)
                    {
                            this.location= locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    }
                }
                else
                {
                    System.out.println("Both are true");
//                  locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    if (locationManager != null)
                    {
                        System.out.println("locationManager");
                        this.location= locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    }
                    else
                    {
                        System.out.println("locationManager null");
                        this.location= null;
                    }
                }
            }
            else
            {
                System.out.println("checkLocationPermission false");
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 500);
            }
        }
        catch (Exception e)
        {

        }
    }


    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        System.out.println("requestCode==="+requestCode);
        switch (requestCode)
        {
            case 500:
                System.out.println("Case");
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    System.out.println("Support");
                    setLocation();

                }
                else
                {
                    System.out.println("Not Support");
                }
                break;
        }

    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("GPS is settings");
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }
    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
