package groupone.green_red.boihaat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import groupone.green_red.boihaat.R;
import groupone.green_red.boihaat.app.SharedPrefManager;
import groupone.green_red.boihaat.app.URLs;
import groupone.green_red.boihaat.app.VolleyController;
import groupone.green_red.boihaat.models.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_email;
    private EditText et_password;
    private EditText et_age;
    private EditText et_address;
    private RadioGroup radioGroupGender;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBar = findViewById(R.id.progress_register);

        //if the user is already logged in we will directly start the profile activity
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, DrawerActivity.class));
            return;
        }

        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_age = findViewById(R.id.et_age);
        radioGroupGender = findViewById(R.id.radioGender);
        et_address = findViewById(R.id.et_address);
        AppCompatButton btn_register = findViewById(R.id.btn_register);
        TextView tv_login = findViewById(R.id.tv_login);


        btn_register.setOnClickListener(view -> {
            //if user pressed on button register
            //here we will register the user to server
            registerUser();
        });

        tv_login.setOnClickListener(view -> {
            //if user pressed on login
            //we will open the login screen
            finish();
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });

    }

    private void registerUser() {
        final String name = et_name.getText().toString().trim();
        final String email = et_email.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        final String age = et_age.getText().toString().trim();
        final String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
        final String address = et_address.getText().toString().trim();

        //first we will do the validations

        if (TextUtils.isEmpty(name)) {
            et_name.setError("Please enter Your Name");
            et_name.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            et_email.setError("Please enter your email");
            et_email.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError("Enter a valid email");
            et_email.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            et_password.setError("Enter a password");
            et_password.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(age)) {
            et_age.setError(" Enter your Age");
            et_age.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(address)) {
            et_age.setError(" Enter your Address");
            et_age.requestFocus();
            return;
        }


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);

                        try {
                            //converting response to json object
//                            JSONArray jsonArray=new JSONArray(response);
//                            JSONObject obj=jsonArray.getJSONObject(0);
                            JSONObject obj = new JSONObject(response);

                            //if no error in response
                            if (!obj.getBoolean("error")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                //getting the user from the response
                                JSONObject userJson = obj.getJSONObject("user");

                                //creating a new user object
                                User user = new User(
                                        userJson.getInt("id"),
                                        userJson.getString("name"),
                                        userJson.getString("email"),
                                        userJson.getString("age"),
                                        userJson.getString("gender"),
                                        userJson.getString("address")
                                );

                                //storing the user in shared preferences
                                SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                                //starting the profile activity
                                finish();
                                startActivity(new Intent(getApplicationContext(), DrawerActivity.class));
                            } else {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("password", password);
                params.put("age", age);
                params.put("gender", gender);
                params.put("address", address);
                return params;
            }
        };

        VolleyController.getInstance(this).addToRequestQueue(stringRequest);

    }

}