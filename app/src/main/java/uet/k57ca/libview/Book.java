package uet.k57ca.libview;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Nguyen Thuy on 9/17/2015.
 */
public class Book implements Serializable{
    private String tittle;
    private String author;
    private String id;
    private String publisher;
    private String description;
    private String cover;
    private String category;

    public void setData(String _tittle, String _author, String _id, String _publisher, String _description, String _cover, String _category) {
        tittle = _tittle;
        author = _author;
        id = _id;
        publisher = _publisher;
        description = _description;
        cover = _cover;
        category = _category;
    }

    public String getTittle(){
        return tittle;
    }
    public String getAuthor() {
        return author;
    }
    public String getId() {
        return id;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }

    public String getCoverImage() {
        return cover;
    }
}
