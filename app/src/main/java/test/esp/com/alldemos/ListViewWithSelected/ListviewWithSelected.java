package test.esp.com.alldemos.ListViewWithSelected;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import test.esp.com.alldemos.R;

/**
 * Created by hardikjani on 7/4/16.
 */
public class ListviewWithSelected extends Activity {

    private ListView lvData;
    private TextView txtSelect;
    private ArrayList<UserBean> userBeenList;
    private UserBean userBean;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listview_with_selected);
        lvData = (ListView) findViewById(R.id.lvData);
        txtSelect = (TextView) findViewById(R.id.txtSelect);

        userBeenList = new ArrayList<UserBean>();

        userBean = new UserBean();
        userBean.id = 1;
        userBean.name = "aaaaaa";
        userBean.city = "asdasd";
        userBeenList.add(userBean);

        userBean = new UserBean();
        userBean.id = 1;
        userBean.name = "bbbbbb";
        userBean.city = "asdasd";
        userBeenList.add(userBean);

        userBean = new UserBean();
        userBean.id = 1;
        userBean.name = "ccccccc";
        userBean.city = "asdasd";
        userBeenList.add(userBean);

        userBean = new UserBean();
        userBean.id = 1;
        userBean.name = "dddddddd";
        userBean.city = "asdasd";
        userBeenList.add(userBean);

        userBean = new UserBean();
        userBean.id = 1;
        userBean.name = "eeeeee";
        userBean.city = "asdasd";
        userBeenList.add(userBean);

        userBean = new UserBean();
        userBean.id = 1;
        userBean.name = "fffffff";
        userBean.city = "asdasd";
        userBeenList.add(userBean);

        userBean = new UserBean();
        userBean.id = 1;
        userBean.name = "gggggggg";
        userBean.city = "asdasd";
        userBeenList.add(userBean);

        userBean = new UserBean();
        userBean.id = 1;
        userBean.name = "hhhhhhhhh";
        userBean.city = "asdasd";
        userBeenList.add(userBean);


        userBean = new UserBean();
        userBean.id = 1;
        userBean.name = "iiiiiii";
        userBean.city = "asdasd";
        userBeenList.add(userBean);

        userBean = new UserBean();
        userBean.id = 1;
        userBean.name = "jjjjjjjjjj";
        userBean.city = "asdasd";
        userBeenList.add(userBean);

        userBean = new UserBean();
        userBean.id = 1;
        userBean.name = "kkkkkkkkkkk";
        userBean.city = "asdasd";
        userBeenList.add(userBean);

        myAdapter = new MyAdapter(ListviewWithSelected.this, R.layout.row_listuser, userBeenList);
        lvData.setAdapter(myAdapter);


        setRowColor(true, 0);

        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("=====position====" + position);
//                setRowColor(false, pre_view);
//                setRowColor(true, view);
//                pre_view = view;
            }
        });


    }

    void setRowColor(boolean isSelect, int pos) {
        if (isSelect == true) {
            lvData.getAdapter().getView(pos, null, lvData).setBackgroundColor(getResources().getColor(R.color.colortext));
        } else {
            lvData.getAdapter().getView(pos, null, lvData).setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
    }
}
