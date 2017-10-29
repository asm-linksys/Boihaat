package groupone.green_red.boihaat.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import groupone.green_red.boihaat.R;
import groupone.green_red.boihaat.app.SharedPrefManager;
import groupone.green_red.boihaat.fragment.ExchangeFragment;
import groupone.green_red.boihaat.fragment.HomeFragment;
import groupone.green_red.boihaat.fragment.LibraryFragment;
import groupone.green_red.boihaat.models.User;


public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView tv_user_name, tv_user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //noinspection deprecation
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tv_user_name = findViewById(R.id.user_nav_name);
        tv_user_email = findViewById(R.id.user_nav_email);
        User user = SharedPrefManager.getInstance(this).getUser();
        Bundle b = getIntent().getExtras();
        tv_user_name = navigationView.getHeaderView(0).findViewById(R.id.user_nav_name);
        tv_user_email = navigationView.getHeaderView(0).findViewById(R.id.user_nav_email);
        tv_user_email.setText(user.getEmail());
        tv_user_name.setText(String.valueOf(user.getName()));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {

            return true;
        } else if (id == R.id.action_about_us) {
            return true;
        } else if (id == R.id.action_logout) {
            finish();
            SharedPrefManager.getInstance(getApplicationContext()).logout();

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        displayView(item.getItemId());

        return true;
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.home_fragment) {
//            // Handle the camera action
//        } else if (id == R.id.profile_fragment) {
//
//        } else if (id == R.id.library_fragment) {
//
//        } else if (id == R.id.add_book_fragment) {
//
//        } else if (id == R.id.exchange_book) {
//
//        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);

    }

    //    private void logout() {
//
//          SharedPreferences.Editor editor=preferences.edit();
//          editor.remove(AppConfig.EMAIL);
//          editor.commit();
////        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(AppConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE);
////        SharedPreferences.Editor editor = sharedPreferences.edit();
////        editor.clear();
////        editor.apply();
////        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
//    }
    private void displayView(int viewID) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (viewID) {
            case R.id.home_fragment:
                fragment = new HomeFragment();
                title = "Home";
                break;
            case R.id.library_fragment:
                fragment = new LibraryFragment();
                title = "Library";
                break;

            case R.id.exchange_book_fragment:
                fragment = new ExchangeFragment();
                title = "Exchange";
        }
        if (fragment != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment);
            ft.commit();
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


}
