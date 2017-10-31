package groupone.green_red.boihaat.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import groupone.green_red.boihaat.R;
import groupone.green_red.boihaat.adapter.ListViewAdapter;
import groupone.green_red.boihaat.app.ListViewController;
import groupone.green_red.boihaat.app.URLs;
import groupone.green_red.boihaat.models.BookList;
public class HomeFragment extends Fragment {
    // Log tag
    private static final String TAG = HomeFragment.class.getSimpleName();

    private ProgressDialog pDialog;
    private List<BookList> bookLists = new ArrayList<BookList>();
    private ListView listView;
    private ListViewAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listView = view.findViewById(R.id.list_view_home);

        adapter = new ListViewAdapter(getActivity(), bookLists);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color
//        getActivity().getActionBar().setBackgroundDrawable(
//                new ColorDrawable(Color.parseColor("#1b1b1b")));

        // Creating volley request obj
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URLs.URL_BOOK_DETAILS, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                final String [] book_title=new String[response.length()];
//                final String [] book_author=new String[response.length()];
                hidePDialog();
                try {
                    JSONArray jsonArray = response.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject object = jsonArray.getJSONObject(i);
                        // Storeing data for book Details
//                        book_title[i]=object.getString("Title");
//                        book_author[i]=object.getString("Author");


                        BookList bookList = new BookList();
                        bookList.setUnique_id(object.getString("unique_id"));
                        bookList.setTitle(object.getString("title"));
                        bookList.setAuthors(object.getString("authors"));
                        bookList.setPublisher(object.getString("publishers"));
                        bookList.setPub_date(object.getString("pub_date"));
                        bookList.setPrice(object.getString("price"));
                        bookList.setFormat(object.getString("format"));
                        bookList.setTotal_copy(object.getString("total_copy"));
                        bookList.setSummary(object.getString("summary"));
                        bookList.setImage_url(object.getString("image"));
                        bookLists.add(bookList);
                    }
                } catch (JSONException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                }
                adapter.notifyDataSetChanged();
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Fragment bookDetailsFragment=new BookDetailsFragment();
//                      //  FragmentTransaction ft=getFragmentManager().beginTransaction();
//                        Bundle b=new Bundle();
//                        b.putStringArray("Book Title",book_title);
//                        b.putStringArray("Book Author",book_author);
//                        bookDetailsFragment.setArguments(b);
//                        getFragmentManager().beginTransaction().add(R.id.frame,bookDetailsFragment).commit();
//                    }
//                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hidePDialog();

            }
        });
        ListViewController.getInstance().addToRequestQueue(jsonObjectRequest, TAG);

        return view;
    }


    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }



}