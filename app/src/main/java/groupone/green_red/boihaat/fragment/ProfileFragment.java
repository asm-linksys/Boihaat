package groupone.green_red.boihaat.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import groupone.green_red.boihaat.R;
import groupone.green_red.boihaat.app.SharedPrefManager;
import groupone.green_red.boihaat.models.User;

public class ProfileFragment extends Fragment {
    private TextView tv_user_id, tv_name, tv_email, tv_age, tv_gender, tv_address;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //if the user is not logged in
        //starting the login activity

        tv_user_id = view.findViewById(R.id.tv_user_id_pro);
        tv_name = view.findViewById(R.id.tv_name_pro);
        tv_email = view.findViewById(R.id.tv_email_pro);
        tv_age = (TextView) view.findViewById(R.id.tv_email_pro);
        tv_gender = (TextView) view.findViewById(R.id.tv_gender_pro);
        tv_address = view.findViewById(R.id.tv_address_pro);


        //getting the current user
        User user = SharedPrefManager.getInstance(getActivity()).getUser();

        //setting the values to the textviews
        tv_user_id.setText("ID : " + String.valueOf(user.getId()));
        tv_name.setText("Name : " + user.getName());
        tv_email.setText(" Email : " + user.getEmail());
        tv_age.setText("Age : " + user.getAge());
        tv_gender.setText("Gender : " + user.getGender());
        tv_address.setText("Address : " + user.getAddress());

        //when the user presses logout button
        //calling the logout method



        return view;
    }

}