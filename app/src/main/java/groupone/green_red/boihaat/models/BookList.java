package groupone.green_red.boihaat.models;


public class BookList {
    String unique_id, title, authors, publisher, pub_date, price, format, total_copy, summary, image;

//
//    public BookList() {
//        this.unique_id = unique_id;
//        this.title = title;
//        this.authors = authors;
//        this.publisher = publisher;
//        this.pub_date = pub_date;
//        this.price = price;
//        this.format = format;
//        this.total_copy = total_copy;
//        this.summary = summary;
//        this.image = image;
//
//
//    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTotal_copy() {
        return total_copy;
    }

    public void setTotal_copy(String total_copy) {
        this.total_copy = total_copy;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImage() {
        return image;
    }

    public void setImage_url(String image) {
        this.image = image;
    }


    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}