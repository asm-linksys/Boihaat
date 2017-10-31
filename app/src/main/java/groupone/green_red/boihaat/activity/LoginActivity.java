package groupone.green_red.boihaat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
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

public class LoginActivity extends AppCompatActivity {

    private EditText et_email;
    private EditText et_password;
    private AppCompatButton btn_login;
    private TextView tv_register;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, DrawerActivity.class));
        }
        btn_login = findViewById(R.id.btn_login);
        tv_register = findViewById(R.id.tv_register);
        progressBar = findViewById(R.id.progress_login);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);


        //if user presses on login
        //calling the method login
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

        //if user presses on not registered
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }

    private void userLogin() {
        //first getting the values
        final String email = et_email.getText().toString();
        final String password = et_password.getText().toString();

        //validating inputs
        if (TextUtils.isEmpty(email)) {
            et_email.setError("Please enter your username");
            et_email.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            et_password.setError("Please enter your password");
            et_password.requestFocus();
            return;
        }

        //if everything is fine
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);

                        try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);

                            //if no error in response
                            if (!obj.getBoolean("error")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                //getting the user from the response
                                JSONObject userJson = obj.getJSONObject("user");

                                //creating a new user object
                                User user = new User(
                                        userJson.getInt("user_id"),
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
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        VolleyController.getInstance(this).addToRequestQueue(stringRequest);
    }
}