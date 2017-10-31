package groupone.green_red.boihaat.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import groupone.green_red.boihaat.R;


public class BookDetailsFragment extends Fragment {
    private TextView tv_title, tv_author, tv_publisher, tv_pub_date, tv_price, tv_format, tv_total, tv_summary;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_details, container, false);

        initView(view);
        String tile = getArguments().getString("Book Title");
        String author = getArguments().getString("Book Author");

        tv_title.setText(tile);
        tv_author.setText(author);
        return view;

    }

    public void initView(View view) {
        tv_title = view.findViewById(R.id.tv_title_details);
        tv_author = view.findViewById(R.id.tv_author_details);
        tv_publisher = view.findViewById(R.id.tv_publisher_details);
        tv_pub_date = view.findViewById(R.id.tv_pub_date_details);
        tv_price = view.findViewById(R.id.tv_price_details_details);
        tv_format = view.findViewById(R.id.tv_format_details);
        tv_total = view.findViewById(R.id.tv_total_copy_details);
        tv_summary = view.findViewById(R.id.tv_summary_details);

    }
}