package test.esp.com.alldemos.ListViewWithSelected;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import test.esp.com.alldemos.R;

/**
 * Created by hardikjani on 7/4/16.
 */
public class MyAdapter extends ArrayAdapter<UserBean> {


    private ArrayList<UserBean> userBeanArrayList;

    public MyAdapter(Context context, int resource, ArrayList<UserBean> userBeanArrayList) {
        super(context, resource, userBeanArrayList);

        this.userBeanArrayList = userBeanArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_listuser, null);
            viewHolder = new ViewHolder();
            viewHolder.llMain = (LinearLayout) convertView.findViewById(R.id.llMain);
            viewHolder.txtid = (TextView) convertView.findViewById(R.id.txtid);
            viewHolder.txtname = (TextView) convertView.findViewById(R.id.txtname);
            viewHolder.txtcity = (TextView) convertView.findViewById(R.id.txtcity);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtid.setText(userBeanArrayList.get(position).id + "");
        viewHolder.txtname.setText(userBeanArrayList.get(position).name);
        viewHolder.txtcity.setText(userBeanArrayList.get(position).city);

        return convertView;

    }

    public class ViewHolder {
        private LinearLayout llMain;
        TextView txtid;
        TextView txtname;
        TextView txtcity;
    }
}
