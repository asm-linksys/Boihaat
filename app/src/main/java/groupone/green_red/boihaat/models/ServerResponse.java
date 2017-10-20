package groupone.green_red.boihaat.models;

/**
 * Created by kh3la on 10/15/2017.
 */

public class ServerResponse {
    private String result;
    private String message;
    private User user;
    private Book book;

    public Book getBook() {
        return book;
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

}