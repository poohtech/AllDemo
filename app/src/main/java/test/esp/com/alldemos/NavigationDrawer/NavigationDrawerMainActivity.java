package test.esp.com.alldemos.NavigationDrawer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import test.esp.com.alldemos.R;
import test.esp.com.alldemos.UcHeader;

/**
 * Created by admin on 20/1/16.
 */
public class NavigationDrawerMainActivity extends FragmentActivity {
    private UcHeader header;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private String[] opcionesMenu;
    private String tituloSeccion;
    private LinearLayout llList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationdrawer_main);
        findviewbyid();

        drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcionesMenu));

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                setFragment(position);
            }
        });

        setFragment(0);

    }

    void setFragment(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragement();
                header.txtTitle.setText(opcionesMenu[position].toString());
                break;
            case 1:
                fragment = new PhotoFragement();
                header.txtTitle.setText(opcionesMenu[position].toString());
                break;
            case 2:
                fragment = new HomeFragement();
                header.txtTitle.setText(opcionesMenu[position].toString());
                break;
        }
        if (fragment != null)
        {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            drawerLayout.closeDrawer(llList);
        }
    }

    void findviewbyid() {
        llList = (LinearLayout) findViewById(R.id.llList);
        header = (UcHeader) findViewById(R.id.topHeader);
        header.txtTitle.setText("Home");
        opcionesMenu = new String[]{"Home", "Photos", "Video"};
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        header.imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (drawerLayout.isDrawerOpen(findViewById(R.id.llList))) {
                    drawerLayout.closeDrawer(findViewById(R.id.llList));
                } else {
                    drawerLayout.openDrawer(findViewById(R.id.llList));
                }
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
