package test.esp.com.alldemos.StikkyList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import test.esp.com.alldemos.R;
import test.esp.com.alldemos.StikkyList.libs.StickyListHeadersAdapter;
import test.esp.com.alldemos.StikkyList.libs.StickyListHeadersListView;

/**
 * Created by admin on 5/3/16.
 */
public class StikkyListviewActivity extends Activity {

    private StickyListHeadersListView lvstate;
    private StateAdapter stateAdapter;
    private ArrayList<StateBean> stateBeanArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_stikkilist);

        lvstate = (StickyListHeadersListView) findViewById(R.id.lvstate);

        stateBeanArrayList=new ArrayList<>();

        StateBean stateBean;

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Anand";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=2;
        stateBean.name="Anandasd";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=3;
        stateBean.name="Manish";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Suraj";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Taku";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Zal";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);


        stateBean =new StateBean();
        stateBean.id=2;
        stateBean.name="Anandasd";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=3;
        stateBean.name="Manish";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Suraj";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Taku";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Zal";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=2;
        stateBean.name="Anandasd";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=3;
        stateBean.name="Manish";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Suraj";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Ravi";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Taku";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Zal";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Jignesh";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Bhavesh";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Chachhu";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Hiren";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Naresh";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        stateBean =new StateBean();
        stateBean.id=1;
        stateBean.name="Komal";
        stateBean.nrLocations=5;
        stateBeanArrayList.add(stateBean);

        Collections.sort(stateBeanArrayList, new Comparator<StateBean>() {
            @Override
            public int compare(StateBean lhs, StateBean rhs) {
                return lhs.name.compareToIgnoreCase(rhs.name);
            }
        });

        if (stateBeanArrayList != null && stateBeanArrayList.size() > 0) {
            stateAdapter = new StateAdapter(StikkyListviewActivity.this, stateBeanArrayList);
            lvstate.setAdapter(stateAdapter);

        }

    }

    public class StateBean implements Serializable {
        private static final long serialVersionUID = -8693305614802498743L; //auto generated for best practice
        public int id;
        public String name;
        public String abbrev;
        public int nrLocations;

    }

    public class StateAdapter extends BaseAdapter implements StickyListHeadersAdapter {
        private Activity context;
        private ArrayList<StateBean> list;

        public StateAdapter(Activity context, ArrayList<StateBean> list) {
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.row_state, null);
                viewHolder = new ViewHolder();
                viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtname);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

                viewHolder.txtName.setText(list.get(position).name);

            return convertView;
        }

        @Override
        public View getHeaderView(int position, View convertView, ViewGroup parent) {
            HeaderViewHolder holder;
            LayoutInflater inflater = LayoutInflater.from(context);
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.row_headerstate, parent, false);
                holder = new HeaderViewHolder(convertView);
                convertView.setTag(holder);

            } else {
                holder = (HeaderViewHolder) convertView.getTag();
            }

            //set header text based on first letter
            String headerText = "" + list.get(position).name.toString().charAt(0);
            holder.header.setText(headerText);
            return convertView;
        }

        @Override
        public long getHeaderId(int position) {
            return list.get(position).name.toString().charAt(0);
        }

        private class ViewHolder {
            private TextView txtName;
        }

        private class HeaderViewHolder {
            private TextView header;

            public HeaderViewHolder(View v) {
                header = (TextView) v.findViewById(R.id.header_text);
            }
        }
    }
}
