package groupone.green_red.boihaat.app;

import groupone.green_red.boihaat.models.Book;
import groupone.green_red.boihaat.models.User;

/**
 * Created by kh3la on 10/15/2017.
 */

public class ServerRequest {
    private String operation;
    private User user;
    private Book book;

    public void setBook(Book book) {
        this.book = book;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(User user) {
        this.user = user;
    }
}