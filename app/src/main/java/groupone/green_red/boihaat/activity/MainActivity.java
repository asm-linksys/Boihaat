package groupone.green_red.boihaat.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import groupone.green_red.boihaat.R;
import groupone.green_red.boihaat.app.AppConfig;
import groupone.green_red.boihaat.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getPreferences(0);
        initFragment();
    }

    private void initFragment() {
        Fragment fragment;
        if (pref.getBoolean(AppConfig.IS_LOGGED_IN, false)) {
            Intent intent = new Intent(MainActivity.this, DrawerActivity.class);
            // fragment = new TestFragment();
        } else {
            fragment = new LoginFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_frame, fragment);
            ft.commit();
        }

    }

}
