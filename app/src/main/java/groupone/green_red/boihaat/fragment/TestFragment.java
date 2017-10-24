package groupone.green_red.boihaat.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import groupone.green_red.boihaat.R;

public class TestFragment extends Fragment implements View.OnClickListener {

    private AppCompatButton profile, bookDetails, addBook, exchange, home, library;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        profile = view.findViewById(R.id.btn_profile_fragment);
        bookDetails = view.findViewById(R.id.btn_book_details_fragment);
        addBook = view.findViewById(R.id.btn_add_book_fragment);
        exchange = view.findViewById(R.id.btn_book_exchange_fragment);
        home = view.findViewById(R.id.btn_book_home_fragment);
        library = view.findViewById(R.id.btn_book_library_fragment);
        profile.setOnClickListener(this);
        bookDetails.setOnClickListener(this);
        addBook.setOnClickListener(this);
        exchange.setOnClickListener(this);
        home.setOnClickListener(this);
        library.setOnClickListener(this);


    }


    public void gotoProfile() {
        Fragment profile = new ProfileFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame, profile);
        ft.commit();
    }

    public void gotoAddBook() {
        Fragment addBook = new AddBookFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame, addBook);
        ft.commit();
    }

    public void gotoBookDetails() {
        Fragment bookDetails = new BookDetailsFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame, bookDetails);

    }

    public void gotoExchange() {
        Fragment exchange = new ExchangeFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame, exchange);
        ft.commit();
    }

    public void gotoHome() {
        Fragment home = new HomeFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame, home);
        ft.commit();

    }

    public void gotoLibrary() {
        Fragment library = new LibraryFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame, library);
        ft.commit();
    }

    @Override
    public void onClick(View v) {


    }
}