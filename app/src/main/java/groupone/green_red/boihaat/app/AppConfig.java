package groupone.green_red.boihaat.app;


public class AppConfig {
    public static final String BASE_URL = "http://27.147.172.213:8050/";
    public static final String SHARED_PREF_NAME = "boihaat";
    public static final String REGISTER_OPERATION = "register";
    public static final String LOGIN_OPERATION = "login";
    public static final String CHANGE_PASSWORD_OPERATION = "chgPass";
    public static final String ADD_BOOK_OPERATION = "addBook";
    public static final String UPDATE_BOOK_DETAILS = "updateBook";
    public static final String RESET_PASSWORD_INITIATE = "resPassReq";
    public static final String RESET_PASSWORD_FINISH = "resPass";
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String IS_LOGGED_IN = "isLoggedIn";


    // User Table Information
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String UNIQUE_ID = "unique_id";
    public static final String GENDER = "gender";
    public static final String AGE = "age";
    public static final String ADDRESS = "address";

    //Book Table Information
    public static final String BOOKID = "book_id";
    public static final String UNIQUEID = "unique_id";
    public static final String TITLE = "title";
    public static final String AUTHOR = "authors";
    public static final String PUBLISHER = "publisher_id";
    public static final String PUBDATE = "pub_date";
    public static final String PRICE = "price";
    public static final String FORMAT = "format";
    public static final String TOTALCOPY = "total_copy";
    public static final String SUMMARY = "summary";
    public static final String RATING = "rating";

    //Comment Table Information

    public static final String COMMENT = "comment";

    //Author Table Information
    public static final String AUTHORNAME = "name";
    public static final String AUTHOREMAIL = "email";
    public static final String AUTHORDOB = "dob";
    public static final String AUTHORDETAILS = "details";


    //Image Table information

    public static final String IMAGEURL = "image_url";
    public static final String IMAGESIZE = "image_size";
    public static final String IMAGECAT = "image_cat";
    public static final String IMAGENAME = "image_name";

    //Publisher Table information
    public static final String PUBLISHERNAME = "name";
    public static final String PUBLISHERADDRESS = "address";
    public static final String PUBLISHERDETAIS = "details";

    //Ratings table information
    public static final String RATINGS = "rating";

    public static final String TAG = "Boihaat";

}