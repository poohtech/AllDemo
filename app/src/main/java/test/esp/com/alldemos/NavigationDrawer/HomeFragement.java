package test.esp.com.alldemos.NavigationDrawer;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.esp.com.alldemos.R;

/**
 * Created by admin on 20/1/16.
 */
public class HomeFragement extends Fragment {

    View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home,null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        tabLayout=(TabLayout)view.findViewById(R.id.tabs);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        MyAdapter adapter = new MyAdapter(getChildFragmentManager());
        adapter.addFrag(new OneFragment(), "Photo");
        adapter.addFrag(new TwoFragment(), "Video");
        adapter.addFrag(new ThreeFragment(), "Apk");
        adapter.addFrag(new OneFragment(), "Storage");
        adapter.addFrag(new TwoFragment(), "Document");
        adapter.addFrag(new TwoFragment(), "Music");
        adapter.addFrag(new TwoFragment(), "Files");
        viewPager.setAdapter(adapter);
    }

    public static class MyAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public MyAdapter(FragmentManager manager)
        {
            super(manager);
        }

        @Override
        public Fragment getItem(int position)
        {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return mFragmentTitleList.get(position);
        }
    }
}
