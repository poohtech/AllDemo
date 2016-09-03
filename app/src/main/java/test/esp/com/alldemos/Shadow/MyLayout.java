package test.esp.com.alldemos.Shadow;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;

import test.esp.com.alldemos.R;

/**
 * Created by admin on 27/4/16.
 */
public class MyLayout extends LinearLayout {

    private static final Xfermode PORTER_DUFF_CLEAR = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    private int mShadowRadius;
    private int mShadowXOffset;
    private int mShadowYOffset;
    private int mShadowColor;
    private Drawable mBackgroundDrawable;
    private boolean mShowShadow = true;
    private int mRawWidth;
    private int mRawHeight;
    private int mCornerRadius = 0;
    private Context context;

    public MyLayout(Context context) {
        super(context);
        this.context=context;
        mShadowColor = Color.GRAY;
        mShadowRadius = 0;
        mShadowXOffset = 10;
        mShadowYOffset = 10;
        mShowShadow = true;
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        mShadowColor = Color.GRAY;
        mShadowRadius = 0;
        mShadowXOffset = 10;
        mShadowYOffset = 10;
        mShowShadow = true;
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        mShadowColor = Color.GRAY;
        mShadowRadius = 0;
        mShadowXOffset = 10;
        mShadowYOffset = 10;
        mShowShadow = true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(calculateMeasuredWidth(), calculateMeasuredHeight());
    }

    private int calculateMeasuredWidth() {
        if (mRawWidth == 0) {
            mRawWidth = getMeasuredWidth();
        }
        return getMeasuredWidth() + calculateShadowWidth();
    }

    private int calculateMeasuredHeight() {
        if (mRawHeight == 0) {
            mRawHeight = getMeasuredHeight();
        }
        return getMeasuredHeight() + calculateShadowHeight();
    }

    int calculateShadowWidth() {
        return mShowShadow ? (mShadowRadius + Math.abs(mShadowXOffset)) : 0;
    }

    int calculateShadowHeight() {
        return mShowShadow ? (mShadowRadius + Math.abs(mShadowYOffset)) : 0;
    }

    void updateBackground() {
        LayerDrawable layerDrawable;
        if (mShowShadow) {
            layerDrawable = new LayerDrawable(new Drawable[]{
                    new Shadow(),
                    createFillDrawable()
            });

            int leftInset = mShadowRadius + Math.abs(mShadowXOffset);
            int topInset = mShadowRadius + Math.abs(mShadowYOffset);
            int rightInset = (mShadowRadius + Math.abs(mShadowXOffset));
            int bottomInset = (mShadowRadius + Math.abs(mShadowYOffset));

            layerDrawable.setLayerInset(
                    1,
                    leftInset,
                    topInset,
                    rightInset,
                    bottomInset
            );
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{
                    createFillDrawable()
            });
        }

        setBackgroundCompat(layerDrawable);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private Drawable createFillDrawable() {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_pressed}, context.getResources().getDrawable(R.drawable.shap_drawable));
        drawable.addState(new int[]{},context.getResources().getDrawable(R.drawable.shap_drawable));

        if (hasLollipop()) {
            RippleDrawable ripple = new RippleDrawable(new ColorStateList(new int[][]{{}},
                    new int[]{Color.parseColor("#ff9900")}), drawable, null);
            setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            });
            setClipToOutline(true);
            mBackgroundDrawable = ripple;
            return ripple;
        }

        mBackgroundDrawable = drawable;
        return drawable;
    }

    @SuppressWarnings("deprecation")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setBackgroundCompat(Drawable drawable) {
        if (hasJellyBean()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }


    private class Shadow extends Drawable {

        private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        private Paint mErase = new Paint(Paint.ANTI_ALIAS_FLAG);

        private Shadow() {
            this.init();
        }

        private void init() {
            setLayerType(LAYER_TYPE_SOFTWARE, null);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.parseColor("#ff9900"));

            mErase.setXfermode(PORTER_DUFF_CLEAR);

            if (!isInEditMode()) {
                mPaint.setShadowLayer(mShadowRadius, mShadowXOffset, mShadowYOffset, mShadowColor);
            }
        }

        @Override
        public void draw(Canvas canvas) {
            RectF shadowRect = new RectF(
                    mShadowRadius + Math.abs(mShadowXOffset),
                    mShadowRadius + Math.abs(mShadowYOffset),
                    mRawWidth,
                    mRawHeight
            );

            canvas.drawRoundRect(shadowRect, mCornerRadius, mCornerRadius, mPaint);
            canvas.drawRoundRect(shadowRect, mCornerRadius, mCornerRadius, mErase);
        }

        @Override
        public void setAlpha(int alpha) {

        }

        @Override
        public void setColorFilter(ColorFilter cf) {

        }

        @Override
        public int getOpacity() {
            return 0;
        }
    }

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    public static int dpToPx(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return Math.round(dp * scale);
    }
}
