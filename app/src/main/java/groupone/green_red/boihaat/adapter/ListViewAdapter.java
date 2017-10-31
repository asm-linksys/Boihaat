package groupone.green_red.boihaat.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import groupone.green_red.boihaat.R;
import groupone.green_red.boihaat.app.ListViewController;
import groupone.green_red.boihaat.models.BookList;

public class ListViewAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<BookList> book_items;

    private ImageLoader imageLoader = ListViewController.getInstance().getImageLoader();

    public ListViewAdapter(Activity activity, List<BookList> book_items) {
        this.activity = activity;
        this.book_items = book_items;

    }

    @Override
    public int getCount() {
        return book_items.size();
    }

    @Override
    public Object getItem(int location) {
        return book_items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = ListViewController.getInstance().getImageLoader();
        NetworkImageView thumbNail = convertView
                .findViewById(R.id.thumbnail);
        TextView title = convertView.findViewById(R.id.title_book_list);
        //   TextView rating = convertView.findViewById(R.id.book_rating_list);
        TextView authors = convertView.findViewById(R.id.book_authors_list);
        TextView price = convertView.findViewById(R.id.book_price_list);

        // getting book data for the row
        BookList bookList = book_items.get(position);

        // thumbnail image
        //thumbNail.setImageUrl(bookList.getImage(), imageLoader);
        // imageLoader.get(bookList.getImage(),listener);

        // title
        title.setText(bookList.getTitle());

        authors.setText("Authors : " + bookList.getAuthors());

        // rating
        //rating.setText("Rating: " + String.valueOf(bookList.getRating()));

        // genre


        // release year
        price.setText(bookList.getPrice());

        return convertView;
    }

}