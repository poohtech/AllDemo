package test.esp.com.alldemos.NavigationDrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.esp.com.alldemos.R;

/**
 * Created by admin on 20/1/16.
 */
public class ThreeFragment extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_three,null);
        return view;
    }
}
