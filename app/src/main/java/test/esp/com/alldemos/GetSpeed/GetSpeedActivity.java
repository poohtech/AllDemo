package test.esp.com.alldemos.GetSpeed;

import android.app.Activity;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;

import java.math.BigDecimal;
import java.math.RoundingMode;

import test.esp.com.alldemos.R;

public class GetSpeedActivity extends Activity implements GPSCallback {

//    TextView txtspeed;
    private GPSManager gpsManager = null;
    private SpeedometerView speedometer;

    public static final int HOUR_MULTIPLIER = 3600;
    public static final double UNIT_MULTIPLIERS = 0.001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getspeed);

        speedometer = (SpeedometerView) findViewById(R.id.sp1);
        speedometer.setMaxSpeed(140);
        speedometer.setMajorTickStep(20);
        speedometer.setMinorTicks(1);
        speedometer.addColoredRange(0, 50, Color.GREEN);
        speedometer.addColoredRange(50, 100, Color.YELLOW);
        speedometer.addColoredRange(100, 140, Color.RED);

        // Add label converter
        speedometer.setLabelConverter(new SpeedometerView.LabelConverter() {
            @Override
            public String getLabelFor(double progress, double maxProgress) {
                return String.valueOf((int) Math.round(progress));
            }
        });

        gpsManager = new GPSManager();

        gpsManager.startListening(getApplicationContext());
        gpsManager.setGPSCallback(this);

    }

    @Override
    public void onGPSUpdate(Location location) {

        location.getLatitude();
        location.getLongitude();

        String speedString = String.valueOf(roundDecimal(convertSpeed(location.getSpeed()), 2));
        String unitString = "km/h";

//        txtspeed.setText(speedString + " " + unitString);

        speedometer.setSpeed(roundDecimal(convertSpeed(location.getSpeed()), 2));
    }

    private double roundDecimal(double value, final int decimalPlace) {
        BigDecimal bd = new BigDecimal(value);

        bd = bd.setScale(decimalPlace, RoundingMode.HALF_UP);
        value = bd.doubleValue();

        return value;
    }

    private double convertSpeed(double speed) {
        return ((speed * HOUR_MULTIPLIER) * UNIT_MULTIPLIERS);
    }
}
