package groupone.green_red.boihaat.app;

import groupone.green_red.boihaat.models.Author;
import groupone.green_red.boihaat.models.Book;
import groupone.green_red.boihaat.models.Comment;
import groupone.green_red.boihaat.models.Image;
import groupone.green_red.boihaat.models.Publisher;
import groupone.green_red.boihaat.models.Rating;
import groupone.green_red.boihaat.models.User;


public class ServerResponse {
    private String result;
    private String message;
    private User user;
    private Book book;
    private Comment comment;
    private Author author;
    private Publisher publisher;
    private Rating rating;
    private Image image;

    public Image getImage() {
        return image;
    }

    public Comment getComment() {
        return comment;
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Rating getRating() {
        return rating;
    }

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