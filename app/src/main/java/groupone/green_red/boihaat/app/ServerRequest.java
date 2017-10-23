package groupone.green_red.boihaat.app;

import groupone.green_red.boihaat.models.Author;
import groupone.green_red.boihaat.models.Book;
import groupone.green_red.boihaat.models.Comment;
import groupone.green_red.boihaat.models.Image;
import groupone.green_red.boihaat.models.Publisher;
import groupone.green_red.boihaat.models.Rating;
import groupone.green_red.boihaat.models.User;

/**
 * Created by kh3la on 10/15/2017.
 */

public class ServerRequest {
    private String operation;
    private User user;
    private Book book;
    private Comment comment;
    private Author author;
    private Publisher publisher;
    private Rating rating;
    private Image image;

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setImage(Image image) {
        this.image = image;
    }

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