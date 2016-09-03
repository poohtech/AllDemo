package test.esp.com.alldemos.Shadow;

import android.app.Activity;
import android.os.Bundle;

import test.esp.com.alldemos.R;

/**
 * Created by admin on 27/4/16.
 */
public class ShadowActivity extends Activity {

    MyLayout mylayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow);

        mylayout=(MyLayout)findViewById(R.id.mylayout);
        mylayout.updateBackground();
    }

}
