//package groupone.green_red.boihaat.fragment;
//
//import android.annotation.SuppressLint;
//import android.app.Fragment;
//import android.app.FragmentTransaction;
//import android.content.DialogInterface;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.support.design.widget.Snackbar;
//import android.support.v7.widget.AppCompatButton;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import groupone.green_red.boihaat.R;
//import groupone.green_red.boihaat.app.AppConfig;
//import groupone.green_red.boihaat.models.User;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//
//public class ProfileFragment extends Fragment implements View.OnClickListener {
//
//    private TextView tv_name, tv_email, tv_message, tv_age;
//    private SharedPreferences pref;
//    private EditText et_old_password, et_new_password;
//    private android.app.AlertDialog dialog;
//    private ProgressBar progress;
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.fragment_profile, container, false);
//        initViews(view);
//        return view;
//    }
//
//    @SuppressLint("SetTextI18n")
//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        //User user = new User();
//        pref = getActivity().getPreferences(0);
//        tv_name.setText("Welcome : " + pref.getString(AppConfig.NAME, ""));
//        tv_email.setText("Email :  : " + pref.getString(AppConfig.EMAIL, ""));
//        tv_age.setText("Age : " + pref.getString(AppConfig.AGE, ""));
//
//
//    }
//
//    private void initViews(View view) {
//
//        tv_name = view.findViewById(R.id.tv_name);
//        tv_email = view.findViewById(R.id.tv_email);
//        tv_age = view.findViewById(R.id.tv_age);
//        AppCompatButton btn_change_password = view.findViewById(R.id.btn_chg_password);
//        AppCompatButton btn_logout = view.findViewById(R.id.btn_logout);
//        btn_change_password.setOnClickListener(this);
//        btn_logout.setOnClickListener(this);
//
//    }
//
//    private void showDialog() {
//
//        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.dialog_change_password, null);
//        et_old_password = view.findViewById(R.id.et_old_password);
//        et_new_password = view.findViewById(R.id.et_new_password);
//        tv_message = view.findViewById(R.id.tv_message);
//        progress = view.findViewById(R.id.progress);
//        builder.setView(view);
//        builder.setTitle("Change Password");
//        builder.setPositiveButton("Change Password", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        dialog = builder.create();
//        dialog.show();
//        dialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onClick(View v) {
//                String old_password = et_old_password.getText().toString();
//                String new_password = et_new_password.getText().toString();
//                if (!old_password.isEmpty() && !new_password.isEmpty()) {
//
//                    progress.setVisibility(View.VISIBLE);
//                    changePasswordProcess(pref.getString(AppConfig.EMAIL, ""), old_password, new_password);
//
//                } else {
//
//                    tv_message.setVisibility(View.VISIBLE);
//                    tv_message.setText("Fields are empty");
//                }
//            }
//        });
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//
//            case R.id.btn_chg_password:
//                showDialog();
//                break;
//            case R.id.btn_logout:
//                logout();
//                break;
//        }
//    }
//
//    private void logout() {
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putBoolean(AppConfig.IS_LOGGED_IN, false);
//        editor.putString(AppConfig.EMAIL, "");
//        editor.putString(AppConfig.NAME, "");
//        editor.putString(AppConfig.UNIQUE_ID, "");
//        editor.apply();
//        goToLogin();
//    }
//
//    private void goToLogin() {
//
//        Fragment login = new LoginFragment();
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.replace(R.id.frame, login);
//        ft.commit();
//    }
//
//    private void changePasswordProcess(String email, String old_password, String new_password) {
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(AppConfig.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
//
//        User user = new User();
//        user.setEmail(email);
//        user.setOld_password(old_password);
//        user.setNew_password(new_password);
//        ServerRequest request = new ServerRequest();
//        request.setOperation(AppConfig.CHANGE_PASSWORD_OPERATION);
//        request.setUser(user);
//        Call<ServerResponse> response = requestInterface.operation(request);
//
//        response.enqueue(new Callback<ServerResponse>() {
//            @Override
//            public void onResponse(Call<ServerResponse> call, retrofit2.Response<ServerResponse> response) {
//
//                ServerResponse resp = response.body();
//                if (resp.getResult().equals(AppConfig.SUCCESS)) {
//                    progress.setVisibility(View.GONE);
//                    tv_message.setVisibility(View.GONE);
//                    dialog.dismiss();
//                    //noinspection ConstantConditions
//                    Snackbar.make(getView(), resp.getMessage(), Snackbar.LENGTH_LONG).show();
//
//                } else {
//                    progress.setVisibility(View.GONE);
//                    tv_message.setVisibility(View.VISIBLE);
//                    tv_message.setText(resp.getMessage());
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ServerResponse> call, Throwable t) {
//
//                Log.d(AppConfig.TAG, "failed");
//                progress.setVisibility(View.GONE);
//                tv_message.setVisibility(View.VISIBLE);
//                tv_message.setText(t.getLocalizedMessage());
//
//
//            }
//        });
//    }
//}
