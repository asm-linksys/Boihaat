package groupone.green_red.boihaat.models;


public class Book {
    private String uniqueId;
    private String title;
    private String authorId;
    private String publisherId;
    private String pubDate;
    private String price;
    private String format;
    private int totalCopy;
    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getTotalCopy() {
        return totalCopy;
    }

    public void setTotalCopy(String totalCopy) {
        this.totalCopy = totalCopy;
    }
}