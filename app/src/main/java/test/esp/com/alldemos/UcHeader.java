package test.esp.com.alldemos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by admin on 20/1/16.
 */
public class UcHeader extends RelativeLayout{

    public Context context;
    public ImageView imgLogo;
    public TextView txtTitle;

    public UcHeader(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public UcHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }


    public void init()
    {
        View view = LayoutInflater.from(context).inflate(R.layout.uc_header, this, true);
        imgLogo=(ImageView)view.findViewById(R.id.imgLogo);
        txtTitle=(TextView)view.findViewById(R.id.txtHeaderTitle);
    }
}
