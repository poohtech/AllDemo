package test.esp.com.alldemos.Animation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import test.esp.com.alldemos.R;

/**
 * Created by admin on 2/4/16.
 */
public class MyAnimation extends Activity implements Animation.AnimationListener {

    int pos = 0;
    TextView btnNext;
    TextView btnPre;
    LinearLayout ll_first, ll_second, ll_third, ll_for;
    Animation animBounce;

    private int getDisplayHeight(boolean pos) {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        System.out.println("=======metrics.widthPixels=======" + metrics.widthPixels);
        return pos == true ? metrics.widthPixels : (metrics.widthPixels + metrics.widthPixels);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        animBounce = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce);

        animBounce.setAnimationListener(this);

        btnNext = (TextView) findViewById(R.id.btnNext);
        btnPre = (TextView) findViewById(R.id.btnPre);
        ll_first = (LinearLayout) findViewById(R.id.ll_first);
        ll_second = (LinearLayout) findViewById(R.id.ll_second);
        ll_third = (LinearLayout) findViewById(R.id.ll_third);
        ll_for = (LinearLayout) findViewById(R.id.ll_for);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("====pos=======>" + pos);
                if (pos == 2) {
                    btnNext.setTextColor(Color.parseColor("#80000000"));
                } else {
                    btnPre.setTextColor(Color.parseColor("#000000"));
                }
                ll_first = (LinearLayout) findViewById(R.id.ll_first);
                ll_second = (LinearLayout) findViewById(R.id.ll_second);
                ll_third = (LinearLayout) findViewById(R.id.ll_third);
                ll_for = (LinearLayout) findViewById(R.id.ll_for);

                TranslateAnimation translation = new TranslateAnimation(getDisplayHeight(true), 0F, 0f, 0);
                translation.setStartOffset(100);
                translation.setDuration(1000);
                translation.setFillAfter(true);
                translation.setInterpolator(new BounceInterpolator());

                if (pos == 0) {
                    ll_first.setVisibility(View.GONE);
                    pos++;
                    ll_second.clearAnimation();
                    ll_second.startAnimation(translation);
                    ll_second.setVisibility(View.VISIBLE);
                } else if (pos == 1) {
                    ll_second.setVisibility(View.GONE);
                    pos++;
                    ll_third.clearAnimation();
                    ll_third.startAnimation(translation);
                    ll_third.setVisibility(View.VISIBLE);

                } else if (pos == 2) {
                    ll_third.setVisibility(View.GONE);
                    pos++;

                    ll_for.clearAnimation();
                    ll_for.startAnimation(translation);
                    ll_for.setVisibility(View.VISIBLE);

                }
            }
        });

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("====pos=======>" + pos);

                if (pos == 1) {
                    btnPre.setTextColor(Color.parseColor("#80000000"));

                } else {
                    btnNext.setTextColor(Color.parseColor("#000000"));
                }

                ll_first = (LinearLayout) findViewById(R.id.ll_first);
                ll_second = (LinearLayout) findViewById(R.id.ll_second);
                ll_third = (LinearLayout) findViewById(R.id.ll_third);
                ll_for = (LinearLayout) findViewById(R.id.ll_for);

                TranslateAnimation translation = new TranslateAnimation(getDisplayHeight(false), 0f, 0f, 0);
                translation.setStartOffset(100);
                translation.setDuration(1000);
                translation.setFillAfter(true);
                translation.setInterpolator(new BounceInterpolator());

                if (pos == 3) {
                    ll_for.setVisibility(View.GONE);
                    pos--;
                    ll_third.clearAnimation();
                    ll_third.startAnimation(translation);
                    ll_third.setVisibility(View.VISIBLE);
                } else if (pos == 2) {
                    ll_third.setVisibility(View.GONE);
                    pos--;
                    ll_second.clearAnimation();
                    ll_second.startAnimation(translation);
                    ll_second.setVisibility(View.VISIBLE);

                } else if (pos == 1) {

                    ll_second.setVisibility(View.GONE);
                    pos--;

                    ll_first.clearAnimation();
                    ll_first.startAnimation(translation);
                    ll_first.setVisibility(View.VISIBLE);

                }
            }
        });


    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
