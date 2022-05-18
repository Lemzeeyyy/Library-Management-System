package org.lemzy.librarymanagementsystem;

public class Book {
    private String name,author,imageUrl,description;
    private int num_of_pages,id;

    public Book(int id, String name, String author, String imageUrl, String description, int num_of_pages) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.imageUrl = imageUrl;
        this.description = description;
        this.num_of_pages = num_of_pages;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNum_of_pages() {
        return num_of_pages;
    }

    public void setNum_of_pages(int num_of_pages) {
        this.num_of_pages = num_of_pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", num_of_pages=" + num_of_pages +
                ", id=" + id +
                '}';
    }
}
