package groupone.green_red.boihaat.app;

import groupone.green_red.boihaat.models.Book;
import groupone.green_red.boihaat.models.Comment;
import groupone.green_red.boihaat.models.User;

/**
 * Created by kh3la on 10/15/2017.
 */

public class ServerResponse {
    private String result;
    private String message;
    private User user;
    private Book book;
    private Comment comment;

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