package groupone.green_red.boihaat.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import groupone.green_red.boihaat.R;
import groupone.green_red.boihaat.fragment.AddBookFragment;
import groupone.green_red.boihaat.fragment.ExchangeFragment;
import groupone.green_red.boihaat.fragment.HomeFragment;
import groupone.green_red.boihaat.fragment.LibraryFragment;
import groupone.green_red.boihaat.fragment.ProfileFragment;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //noinspection deprecation
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
            case R.id.profile_fragment:
                fragment = new ProfileFragment();
                title = "Profile";
                break;
            case R.id.add_book_fragment:
                fragment = new AddBookFragment();
                title = "Add Book";
                break;
            case R.id.exchange_book_fragment:
                fragment = new ExchangeFragment();
                title = "Exchange";
        }
        if (fragment != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_frame, fragment);
            ft.commit();
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


}
