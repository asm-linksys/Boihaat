package groupone.green_red.boihaat.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
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
import groupone.green_red.boihaat.activity.DrawerActivity;
import groupone.green_red.boihaat.app.AppController;
import groupone.green_red.boihaat.app.SharedPrefManager;
import groupone.green_red.boihaat.app.URLs;
import groupone.green_red.boihaat.models.Book;


public class AddBookFragment extends Fragment implements View.OnClickListener {
    AppCompatButton btn_add;
    private EditText et_unique_id, et_title, et_author, et_publisher, et_pubdate, et_price, et_format, et_total_copy, et_summary;
    private ProgressBar progress_add_book;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_book, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        et_unique_id = view.findViewById(R.id.et_unique_id_isbn_book);
        et_title = view.findViewById(R.id.et_title_book);
        et_author = view.findViewById(R.id.et_author_book);
        et_publisher = view.findViewById(R.id.et_publisher_book);
        et_pubdate = view.findViewById(R.id.et_pubdate_book);
        et_price = view.findViewById(R.id.et_price_book);
        et_format = view.findViewById(R.id.et_format_book);
        et_total_copy = view.findViewById(R.id.et_total_copy_book);
        et_summary = view.findViewById(R.id.et_summary_book);
        progress_add_book = view.findViewById(R.id.progress_book);
        btn_add = view.findViewById(R.id.btn_add_book);
        btn_add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_add_book:
                addBook();
                break;
        }
    }

    private void addBook() {
        final String unique_id = et_unique_id.getText().toString().trim();
        final String title = et_title.getText().toString().trim();
        final String author = et_author.getText().toString().trim();
        final String publisher = et_publisher.getText().toString().trim();
        final String pub_date = et_pubdate.getText().toString().trim();
        final String price = et_price.getText().toString().trim();
        final String format = et_format.getText().toString().trim();
        final String total_copy = et_total_copy.getText().toString().trim();
        final String summary = et_summary.getText().toString().trim();
        //first we will do the validations

        if (TextUtils.isEmpty(unique_id)) {
            et_unique_id.setError("Please Enter ISBN No , If not available Publisher ID ");
            et_unique_id.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(title)) {
            et_title.setError("Please enter Book Title");
            et_title.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(author)) {
            et_author.setError("Enter Author Name");
            et_author.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(publisher)) {
            et_publisher.setError(" Enter Publisher Name");
            et_publisher.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(pub_date)) {
            et_pubdate.setError(" Enter Publication Date");
            et_pubdate.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(price)) {
            et_price.setError(" Enter Your selling price");
            et_price.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(format)) {
            et_format.setError(" Enter your Address");
            et_format.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(total_copy)) {
            et_total_copy.setError(" Enter Book Format");
            et_total_copy.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(summary)) {
            et_summary.setError(" Enter Some Details ");
            et_summary.requestFocus();
            return;
        }


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_ADDBOOK,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progress_add_book.setVisibility(View.GONE);

                        try {
                            //converting response to json object
//                            JSONArray jsonArray=new JSONArray(response);
//                            JSONObject obj=jsonArray.getJSONObject(0);
                            JSONObject obj = new JSONObject(response);

                            //if no error in response
                            if (!obj.getBoolean("error")) {
                                Toast.makeText(getActivity().getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                //getting the user from the response
                                JSONObject bookJson = obj.getJSONObject("book");

                                //creating a new book object
                                Book book = new Book(
                                        bookJson.getInt("book_id"),
                                        bookJson.getString("unique_id"),
                                        bookJson.getString("title"),
                                        bookJson.getString("authors"),
                                        bookJson.getString("publishers"),
                                        bookJson.getString("pub_date"),
                                        bookJson.getString("price"),
                                        bookJson.getString("format"),
                                        bookJson.getString("total_copy"),
                                        bookJson.getString("summary")
                                );

                                //storing the user in shared preferences
                                SharedPrefManager.getInstance(getActivity().getApplicationContext()).addBook(book);

                                //starting the profile activity
                                getActivity().finish();
                                startActivity(new Intent(getActivity().getApplicationContext(), DrawerActivity.class));
                            } else {
                                Toast.makeText(getActivity().getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("unique_id", unique_id);
                params.put("title", title);
                params.put("authors", author);
                params.put("publishers", publisher);
                params.put("pub_date", pub_date);
                params.put("price", price);
                params.put("format", format);
                params.put("total_copy", total_copy);
                params.put("summary", summary);

                return params;
            }
        };

        AppController.getInstance(getActivity()).addToRequestQueue(stringRequest);

    }


}
