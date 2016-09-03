package test.esp.com.alldemos.ScrollviewInnerListview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import test.esp.com.alldemos.R;

/**
 * Created by admin on 18/1/16.
 */
public class ScrollviewInnerListviewActivity extends Activity {
    ListView lvFirst,lvsecond;
    ArrayList<String> listFirst;
    ArrayList<String> listsecond;
    ArrayAdapter<String> adFirst;
    ArrayAdapter<String> adLast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_inner_listview);

        lvFirst=(ListView)findViewById(R.id.lvFirst);
        lvsecond=(ListView)findViewById(R.id.lvsecond);

        listFirst=new ArrayList<String>();
        listFirst.add("Hello");
        listFirst.add("sdf");
        listFirst.add("Hsdfsello");
        listFirst.add("Hsdfello");
        listFirst.add("Hsdfello");
        listFirst.add("ssfddf");
        listFirst.add("Hsdfssdfello");
        listFirst.add("Hsdfsdfello");
        listFirst.add("Hsdfsdfsdfello");




        adFirst=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listFirst);
        lvFirst.setAdapter(adFirst);
        setListViewHeightBasedOnChildren(lvFirst);



        listsecond=new ArrayList<String>();
        listsecond.add("Helsdfsdflo");
        listsecond.add("sdfsdfsdfsdf");
        listsecond.add("Hsdfsdfssdfsello");
        listsecond.add("Hsdsdfsdffello");
        listsecond.add("Hsdfello");
        listsecond.add("ssfsdfsdfddf");
        listsecond.add("Hsdsdfsffssdfello");
        listsecond.add("Hsdfsdfello");
        listsecond.add("Hsdfsdsdfsdffsdfello");

        adLast=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listsecond);
        lvsecond.setAdapter(adLast);
        setListViewHeightBasedOnChildren(lvsecond);

    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, LinearLayout.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
