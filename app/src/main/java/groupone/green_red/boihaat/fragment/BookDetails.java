package groupone.green_red.boihaat.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import groupone.green_red.boihaat.R;
import groupone.green_red.boihaat.app.AppConfig;
import groupone.green_red.boihaat.models.Book;
import groupone.green_red.boihaat.models.User;


public class BookDetails extends Fragment implements View.OnClickListener {
    private TextView tv_title, tv_author, tv_publisher, tv_pubDate, tv_price, tv_format, tv_total_copy, tv_rating, tv_uploader_id;
    private SharedPreferences pref;
    private AppCompatButton btn_details, btn_read, btn_exchange;
    private android.app.AlertDialog dialog;
    private ProgressBar progress;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        User user = new User();
        Book book = new Book();
        pref = getActivity().getPreferences(0);


        tv_name.setText("Welcome : " + pref.getString(AppConfig.NAME, ""));
        tv_email.setText("Email :  : " + pref.getString(AppConfig.EMAIL, ""));
        tv_age.setText("Age : " + pref.getInt(AppConfig.AGE, user.getAge()));


    }

    public void goToDetails() {
        Fragment bookDetailsComments = new BookComments();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, bookDetailsComments);
        ft.commit();

    }

    private void initViews(View view) {

        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_author = (TextView) view.findViewById(R.id.tv_author);
        tv_publisher = (TextView) view.findViewById(R.id.tv_publisher);
        tv_pubDate = (TextView) view.findViewById(R.id.tv_pub_date);
        tv_price = (TextView) view.findViewById(R.id.tv_price);
        tv_format = (TextView) view.findViewById(R.id.tv_format);
        tv_total_copy = (TextView) view.findViewById(R.id.tv_total_copy);
        tv_rating = (TextView) view.findViewById(R.id.tv_rating);
        tv_uploader_id = (TextView) view.findViewById(R.id.tv_uploader_id);
        btn_read = (AppCompatButton) view.findViewById(R.id.btn_read);
        btn_exchange = (AppCompatButton) view.findViewById(R.id.btn_exchange);
        btn_details = (AppCompatButton) view.findViewById(R.id.btn_details_comment);
        btn_read.setOnClickListener(this);
        btn_exchange.setOnClickListener(this);
        btn_details.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_details_comment:
                goToDetails();
                break;
            case R.id.btn_logout:
                logout();
                break;
        }
    }


}