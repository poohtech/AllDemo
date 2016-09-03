package test.esp.com.alldemos.CurrentLatLong;

import android.Manifest;
import android.app.AlertDialog;
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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import test.esp.com.alldemos.R;

/**
 * Created by admin on 3/3/16.
 */
public class MyLocation extends AppCompatActivity implements LocationListener, View.OnClickListener {

    Button btnGetLatLong;
    TextView txtlat, txtlong;
    GetLocation getLoc;

    private Location location;
    private LocationManager locationManager;
    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currentlatlong);

        txtlat = (TextView) findViewById(R.id.txtlat);
        txtlong = (TextView) findViewById(R.id.txtlong);
        btnGetLatLong = (Button) findViewById(R.id.btnGetLatLong);
        btnGetLatLong.setOnClickListener(this);
    }

    public void setLocation() {
        System.out.println("getLocation()");
        try {
            locationManager = (LocationManager) this.getSystemService(this.LOCATION_SERVICE);
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                if (isGPSEnabled || isNetworkEnabled) {
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        btnGetLatLong.performClick();
                    } else {
                        System.out.println("locationManager null");
                        this.location = null;
                    }
                } else {
                    showSettingsAlert();
                }
            } else {
                System.out.println("checkLocationPermission false");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 99);
            }
        } catch (Exception e) {
            System.out.println("eeeeeee========" + e.toString());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
        btnGetLatLong.performClick();
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        System.out.println("requestCode===" + requestCode);
        switch (requestCode) {
            case 99:
                System.out.println("Case");
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    System.out.println("Support");
                    if (location == null) {
                        setLocation();
                    } else {
                        btnGetLatLong.performClick();
                    }
                } else {
                    System.out.println("Not Support");
                }
                break;
        }

    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("GPS is settings");
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
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
        this.location = location;
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetLatLong:

                if (location != null) {
                    System.out.println("Location in");
                    txtlat.setText(location.getLatitude() + "");
                    txtlong.setText(location.getLongitude() + "");
                } else {
                    setLocation();
                }
                break;
        }
    }
}
