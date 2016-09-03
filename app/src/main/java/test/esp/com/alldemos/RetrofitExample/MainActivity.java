package test.esp.com.alldemos.RetrofitExample;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit.RestAdapter;
import test.esp.com.alldemos.R;

/**
 * Created by hardikjani on 6/13/16.
 */
public class MainActivity extends Activity {

    private ListView lvData;

    private static final String API_URL = "http://freemusicarchive.org/api";
    private static final String API_KEY = "----";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_retrofitdata);
        lvData = (ListView) findViewById(R.id.lvdata);
        MyAsyntack myAsyntack = new MyAsyntack();
        myAsyntack.execute();

    }

    public class MyAsyntack extends AsyncTask<Void, Void, MyBean> {
        RestAdapter restAdapter;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        }

        @Override
        protected MyBean doInBackground(Void... params) {

            APIMethod apiMethod = restAdapter.create(APIMethod.class);
            MyBean myBean = apiMethod.getBean(API_KEY);

            return myBean;
        }

        @Override
        protected void onPostExecute(MyBean myBean) {
            super.onPostExecute(myBean);


            MyAdapter stringArrayAdapter = new MyAdapter(MainActivity.this, R.layout.row_textview, myBean.dataset);
            lvData.setAdapter(stringArrayAdapter);
        }
    }

    public class MyAdapter extends ArrayAdapter<MyDataList> {

        private Context context;
        private int res;
        private ArrayList<MyDataList> myBeanArrayList;

        public MyAdapter(Context context, int resource, ArrayList<MyDataList> Mylist) {
            super(context, resource, Mylist);

            this.context = context;
            this.res = resource;
            this.myBeanArrayList = Mylist;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            MyHolder myHolder = null;
            if (convertView == null) {

                myHolder = new MyHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.row_textview, null);
                myHolder.txtname = (TextView) convertView.findViewById(R.id.txtTitle);
                convertView.setTag(myHolder);

            } else {
                myHolder = (MyHolder) convertView.getTag();
            }

            myHolder.txtname.setText(myBeanArrayList.get(position).curator_title);
            return convertView;

        }

        public class MyHolder {
            TextView txtname;
        }
    }
}
