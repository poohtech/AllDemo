package test.esp.com.alldemos.ScrollAndMoveImage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import test.esp.com.alldemos.MyUtils;
import test.esp.com.alldemos.R;

/**
 * Created by admin on 17/5/16.
 */
public class ScrollAndMoveActivity extends Activity implements View.OnClickListener {

    private ImageView imgMainImage;
    private ImageView imgMoveImage;
    private LinearLayout llColorLayer;

    private ImageView imag1;
    private ImageView imag2;

    private TextView txtGreen;
    private TextView txtBlue;
    private TextView txtRed;

    private Bitmap bitmapOrg1;
    private int width;
    private int height;
    private Bitmap bitmapOrg;
    private Bitmap croppedBmp;

    DrawingView dv ;
    private Paint mPaint;
    LinearLayout llDrawing;
    private Canvas mCanvas;
    private Display display;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dv = new DrawingView(this);
        setContentView(R.layout.activity_scroll_and_moveimage);

        imgMainImage = (ImageView) findViewById(R.id.imgMainImage);
        imgMoveImage = (ImageView) findViewById(R.id.imgMoveImage);
        llColorLayer = (LinearLayout) findViewById(R.id.llColorLayer);
        llDrawing = (LinearLayout) findViewById(R.id.llDrawing);

        imag1 = (ImageView) findViewById(R.id.imag1);
        imag2 = (ImageView) findViewById(R.id.imag2);

        setDefaultRoundImage(ScrollAndMoveActivity.this, imag1, R.drawable.image1);
        setDefaultRoundImage(ScrollAndMoveActivity.this, imag2, R.drawable.image2);

        llColorLayer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });

        llDrawing.addView(dv);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(12);


        txtGreen = (TextView) findViewById(R.id.txtGreen);
        txtBlue = (TextView) findViewById(R.id.txtBlue);
        txtRed = (TextView) findViewById(R.id.txtRed);


        txtGreen.setTextColor(getResources().getColor(R.color.color_red));
        txtBlue.setTextColor(getResources().getColor(R.color.color_white));
        txtRed.setTextColor(getResources().getColor(R.color.color_white));

        llColorLayer.setBackgroundColor(getResources().getColor(R.color.color_green_trans));

        txtGreen.setOnClickListener(this);
        txtBlue.setOnClickListener(this);
        txtRed.setOnClickListener(this);

        imag1.setOnClickListener(this);
        imag2.setOnClickListener(this);

        imgMainImage.setImageResource(R.drawable.image1);


        bitmapOrg1 = BitmapFactory.decodeResource(getResources(), R.drawable.imageblur1);
        width = MyUtils.getDeviceWidth(ScrollAndMoveActivity.this);
        height = MyUtils.getDeviceHeight(ScrollAndMoveActivity.this);
        bitmapOrg = Bitmap.createScaledBitmap(bitmapOrg1, width, height, true);

        croppedBmp = Bitmap.createBitmap(bitmapOrg, 0, 0, bitmapOrg.getWidth() / 2, bitmapOrg.getHeight());
        imgMoveImage.setImageBitmap(addWhiteBorder(croppedBmp, 10));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_MOVE: {
                croppedBmp = Bitmap.createBitmap(bitmapOrg, 0, 0, (int) event.getX(), bitmapOrg.getHeight());
                imgMoveImage.setImageBitmap(addWhiteBorder(croppedBmp, 10));
            }
        }

        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtGreen:
                txtGreen.setTextColor(getResources().getColor(R.color.color_red));
                txtBlue.setTextColor(getResources().getColor(R.color.color_white));
                txtRed.setTextColor(getResources().getColor(R.color.color_white));

                llColorLayer.setBackgroundColor(getResources().getColor(R.color.color_green_trans));
                break;

            case R.id.txtBlue:
                txtGreen.setTextColor(getResources().getColor(R.color.color_white));
                txtBlue.setTextColor(getResources().getColor(R.color.color_red));
                txtRed.setTextColor(getResources().getColor(R.color.color_white));

                llColorLayer.setBackgroundColor(getResources().getColor(R.color.color_blue_trans));
                break;

            case R.id.txtRed:
                txtGreen.setTextColor(getResources().getColor(R.color.color_white));
                txtBlue.setTextColor(getResources().getColor(R.color.color_white));
                txtRed.setTextColor(getResources().getColor(R.color.color_red));

                llColorLayer.setBackgroundColor(getResources().getColor(R.color.color_red_trans));
                break;

            case R.id.imag1:
                imgMainImage.setImageResource(R.drawable.image1);
                bitmapOrg1 = BitmapFactory.decodeResource(getResources(), R.drawable.imageblur1);
                width = MyUtils.getDeviceWidth(ScrollAndMoveActivity.this);
                height = MyUtils.getDeviceHeight(ScrollAndMoveActivity.this);
                bitmapOrg = Bitmap.createScaledBitmap(bitmapOrg1, width, height, true);

                croppedBmp = Bitmap.createBitmap(bitmapOrg, 0, 0, bitmapOrg.getWidth() / 2, bitmapOrg.getHeight());
                imgMoveImage.setImageBitmap(addWhiteBorder(croppedBmp, 10));
                break;

            case R.id.imag2:
                imgMainImage.setImageResource(R.drawable.image2);

                bitmapOrg1 = BitmapFactory.decodeResource(getResources(), R.drawable.imageblur2);
                width = MyUtils.getDeviceWidth(ScrollAndMoveActivity.this);
                height = MyUtils.getDeviceHeight(ScrollAndMoveActivity.this);
                bitmapOrg = Bitmap.createScaledBitmap(bitmapOrg1, width, height, true);

                croppedBmp = Bitmap.createBitmap(bitmapOrg, 0, 0, bitmapOrg.getWidth() / 2, bitmapOrg.getHeight());
                imgMoveImage.setImageBitmap(addWhiteBorder(croppedBmp, 10));
                break;
        }
    }

    public static void setDefaultRoundImage(Context context, ImageView imageView, int image) {
        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), BitmapFactory.decodeResource(context.getResources(), image));
        circularBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(circularBitmapDrawable);

    }

    private Bitmap addWhiteBorder(Bitmap bmp, int borderSize) {
        Bitmap bmpWithBorder = Bitmap.createBitmap(bmp.getWidth() + borderSize * 2, bmp.getHeight() + borderSize * 1, bmp.getConfig());
        Canvas canvas = new Canvas(bmpWithBorder);
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(bmp, borderSize, 0, null);
        return bmpWithBorder;
    }

    public class DrawingView extends View {

        public int width;
        public  int height;


        private Path mPath;
        private Paint   mBitmapPaint;
        Context context;
        private Paint circlePaint;
        private Path circlePath;

        public DrawingView(Context c) {
            super(c);
            context=c;
            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);
            circlePaint = new Paint();
            circlePath = new Path();
            circlePaint.setAntiAlias(true);
            circlePaint.setColor(Color.BLUE);
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setStrokeJoin(Paint.Join.MITER);
            circlePaint.setStrokeWidth(4f);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);

            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
            canvas.drawPath(mPath, mPaint);
            canvas.drawPath(circlePath, circlePaint);
        }

        private float mX, mY;
        private static final float TOUCH_TOLERANCE = 4;

        private void touch_start(float x, float y) {
            mPath.reset();
            mPath.moveTo(x, y);
            mX = x;
            mY = y;
        }

        private void touch_move(float x, float y) {
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);
            if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
                mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
                mX = x;
                mY = y;

                circlePath.reset();
                circlePath.addCircle(mX, mY, 30, Path.Direction.CW);
            }
        }

        private void touch_up() {
            mPath.lineTo(mX, mY);
            circlePath.reset();
            // commit the path to our offscreen
            mCanvas.drawPath(mPath,  mPaint);
            // kill this so we don't double draw
            mPath.reset();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touch_start(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    touch_move(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    touch_up();
                    invalidate();
                    break;
            }
            return true;
        }
    }

}