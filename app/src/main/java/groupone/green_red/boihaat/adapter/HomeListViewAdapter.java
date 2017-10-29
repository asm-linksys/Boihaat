package groupone.green_red.boihaat.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by kh3la on 10/24/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public class HomeListViewAdapter extends BaseAdapter {
    private int[] image;
    String[] bookName;
    private int[] rating;
    Context context;

    HomeListViewAdapter(Context context, String[] bookName, int[] image, int[] rating) {
        this.context = context;
        this.bookName = bookName;
        this.image = image;
        this.rating = rating;


    }




    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
