package groupone.green_red.boihaat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import groupone.green_red.boihaat.activity.LoginActivity;
import groupone.green_red.boihaat.models.Book;
import groupone.green_red.boihaat.models.User;

public class SharedPrefManager {

    //the constants

    @SuppressLint("StaticFieldLeak")
    private static SharedPrefManager mInstance;
    @SuppressLint("StaticFieldLeak")
    private static Context mCtx;

    public SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences
    public void userLogin(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(AppConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(AppConfig.ID, user.getId());
        editor.putString(AppConfig.NAME, user.getName());
        editor.putString(AppConfig.EMAIL, user.getEmail());
        editor.putString(AppConfig.AGE, user.getAge());
        editor.putString(AppConfig.GENDER, user.getGender());
        editor.putString(AppConfig.ADDRESS, user.getAddress());
        editor.apply();
    }

    // Store Book Information
    public void addBook(Book book) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(AppConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(AppConfig.BOOKID, book.getBook_id());
        editor.putString(AppConfig.UNIQUEID, book.getUnique_id());
        editor.putString(AppConfig.TITLE, book.getTitle());
        editor.putString(AppConfig.AUTHOR, book.getAuthors());
        editor.putString(AppConfig.PUBLISHER, book.getPublishers());
        editor.putString(AppConfig.PUBDATE, book.getPub_date());
        editor.putString(AppConfig.PRICE, book.getPrice());
        editor.putString(AppConfig.FORMAT, book.getFormat());
        editor.putString(AppConfig.TOTALCOPY, book.getFormat());
        editor.putString(AppConfig.SUMMARY, book.getSummary());
        editor.apply();


    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(AppConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(AppConfig.EMAIL, null) != null;
    }

    //Get Book Information
    private Book getBook() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(AppConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Book(
                sharedPreferences.getInt(AppConfig.BOOKID, -1),
                sharedPreferences.getString(AppConfig.UNIQUEID, null),
                sharedPreferences.getString(AppConfig.TITLE, null),
                sharedPreferences.getString(AppConfig.AUTHOR, null),
                sharedPreferences.getString(AppConfig.PUBLISHER, null),
                sharedPreferences.getString(AppConfig.PUBDATE, null),
                sharedPreferences.getString(AppConfig.PRICE, null),
                sharedPreferences.getString(AppConfig.FORMAT, null),
                sharedPreferences.getString(AppConfig.TOTALCOPY, null),
                sharedPreferences.getString(AppConfig.SUMMARY, null)

        );
    }

    //this method will give the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(AppConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(AppConfig.ID, -1),
                sharedPreferences.getString(AppConfig.NAME, null),
                sharedPreferences.getString(AppConfig.EMAIL, null),
                sharedPreferences.getString(AppConfig.AGE, null),
                sharedPreferences.getString(AppConfig.GENDER, null),
                sharedPreferences.getString(AppConfig.ADDRESS, null)


        );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(AppConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
    }
}