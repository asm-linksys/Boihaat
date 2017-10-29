//package groupone.green_red.boihaat.fragment;
//
//import android.app.Fragment;
//import android.os.Bundle;
//import android.support.design.widget.Snackbar;
//import android.support.v7.widget.AppCompatButton;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//
//import groupone.green_red.boihaat.R;
//import groupone.green_red.boihaat.app.AppConfig;
//import groupone.green_red.boihaat.models.Book;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class AddBookFragment extends Fragment implements View.OnClickListener {
//    private AppCompatButton btn_add;
//    private EditText et_unique_id, et_title, et_author, et_publisher, et_pubdate, et_price, et_format, et_total_copy, et_summary;
//    private ProgressBar progress;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.fragment_add_book, container, false);
//        initViews(view);
//        return view;
//    }
//
//    private void initViews(View view) {
//
//        btn_add = view.findViewById(R.id.btn_add);
//        et_unique_id = view.findViewById(R.id.et_unique_id);
//        et_title = view.findViewById(R.id.et_title);
//        et_author = view.findViewById(R.id.et_author);
//        et_publisher = view.findViewById(R.id.et_publisher);
//        et_pubdate = view.findViewById(R.id.et_pubdate);
//        et_price = view.findViewById(R.id.et_price);
//        et_format = view.findViewById(R.id.et_format);
//        et_total_copy = view.findViewById(R.id.et_total_copy);
//        et_summary = view.findViewById(R.id.et_summary);
//
//        progress = view.findViewById(R.id.progress);
//
//        btn_add.setOnClickListener(this);
//
//    }
//
//
//    @Override
//    public void onClick(View v) {
//
//        switch (v.getId()) {
//
//            case R.id.btn_add:
//                String uniqueId = et_unique_id.getText().toString();
//                String title = et_title.getText().toString();
//                String author = et_author.getText().toString();
//                String publisher = et_publisher.getText().toString();
//                String pubDate = et_pubdate.getText().toString();
//                String price = et_price.getText().toString();
//                String format = et_format.getText().toString();
//                String total_copy = et_total_copy.getText().toString();
//                String summary = et_summary.getText().toString();
//
//
//                if (!uniqueId.isEmpty() && !title.isEmpty() && !author.isEmpty() && !publisher.isEmpty() && !pubDate.isEmpty() && !price.isEmpty() && !format.isEmpty() && !total_copy.isEmpty() && !summary.isEmpty()) {
//
//                    progress.setVisibility(View.VISIBLE);
//                    bookAddProcess(uniqueId, title, author, publisher, pubDate, price, format, total_copy, summary);
//
//                } else {
//
//                    Snackbar.make(getView(), "Fields are empty !", Snackbar.LENGTH_LONG).show();
//                }
//                break;
//
//        }
//
//    }
//
//    private void bookAddProcess(String uniqueId, String title, String author, String publisher, String pubDate, String price, String format, String totalCopy, String summary) {
//        //  int finalTotalCopy = Integer.parseInt(totalCopy);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(AppConfig.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
//        //  int finalPrice = Integer.parseInt(price);
//        Book book = new Book();
//        book.setUniqueId(uniqueId);
//        book.setTitle(title);
//        book.setAuthorId(author);
//        book.setPublisherId(publisher);
//        book.setPubDate(pubDate);
//        book.setPrice(price);
//        book.setFormat(format);
//        book.setTotalCopy(totalCopy);
//        book.setSummary(summary);
//        ServerRequest request = new ServerRequest();
//        request.setOperation(AppConfig.ADD_BOOK_OPERATION);
//        request.setBook(book);
//        Call<ServerResponse> response = requestInterface.operation(request);
//
//        response.enqueue(new Callback<ServerResponse>() {
//            @Override
//            public void onResponse(Call<ServerResponse> call, retrofit2.Response<ServerResponse> response) {
//
//                ServerResponse resp = response.body();
//                Snackbar.make(getView(), resp.getMessage(), Snackbar.LENGTH_LONG).show();
//                progress.setVisibility(View.INVISIBLE);
//            }
//
//            @Override
//            public void onFailure(Call<ServerResponse> call, Throwable t) {
//
//                progress.setVisibility(View.INVISIBLE);
//                Log.d(AppConfig.TAG, "failed");
//                Snackbar.make(getView(), t.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
//
//
//            }
//        });
//    }
//
////    private void goToLibrary() {
////
////        Fragment library = new LibraryFragment();
////        FragmentTransaction ft = getFragmentManager().beginTransaction();
////        ft.replace(R.id.fragment_frame, library);
////        ft.commit();
////    }
//}
