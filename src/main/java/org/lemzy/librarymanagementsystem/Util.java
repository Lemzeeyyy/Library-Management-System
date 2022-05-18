package org.lemzy.librarymanagementsystem;

import java.util.ArrayList;

public class Util {
    private static ArrayList<Book> showAll;
    private static ArrayList<Book> alreadyRead;
    private static ArrayList<Book> wantToRead;
    private static ArrayList<Book> currentlyReading;
    private static int id = 0 ;

    public Util() {
        if (showAll == null) {
            showAll = new ArrayList<>();
            initAllBooks();
        }
        if (alreadyRead == null)
            alreadyRead = new ArrayList<>();
        if (null == wantToRead)
            wantToRead = new ArrayList<>();
        if (null == currentlyReading)
            currentlyReading = new ArrayList<>();
    }


    public static ArrayList<Book> getShowAll() {
        return showAll;
    }

    public static ArrayList<Book> getAlreadyRead() {
        return alreadyRead;
    }

    public static ArrayList<Book> getWantToRead() {
        return wantToRead;
    }

    public static ArrayList<Book> getCurrentlyReadingBook() {
        return currentlyReading;
    }
    public boolean  addCurrentlyReadingBook(Book book){
        return currentlyReading.add(book);
    }
    public boolean  addWantToReadBook(Book book){
        return wantToRead.add(book);
    }
    public boolean  addAlreadyReadBook(Book book){
        return alreadyRead.add(book);
    }
    public boolean removeCurrentlyReadingBook(Book book){
        return currentlyReading.remove(book);
    }
    public boolean removeWantToReadBook(Book book){
        return wantToRead.remove(book);
    }
    public boolean removeAlreadyReadBook(Book book){
        return alreadyRead.remove(book);
    }
    public static void initAllBooks(){
        //TODO initialize all books
        String name, author,imageURL,description;
        int pages;

        id++;
        name= " Tottenham Fc";
        author = "Mourinho ";
        pages = 320;
        imageURL = "https://resources.premierleague.com/premierleague/badges/70/t6.png";
        description = "welcome to Tottenham Fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= "Arsenal Fc";
        author = "Arsene Winger";
        pages = 210;
        imageURL = "https://m.media-amazon.com/images/I/51C0eqMRcyL._AC_UL480_FMwebp_QL65_.jpg";
        description = "Welcome to arsenal fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= "Newcastle United fc";
        author = "NewCastle";
        pages = 120;
        imageURL = "https://m.media-amazon.com/images/I/71IQUwSNQGL._AC_UL480_FMwebp_QL65_.jpg";
        description = "Welcome to newcastle united fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= "Chelsea Fc";
        author = "Abrahamovic";
        pages =100;
        imageURL = "https://resources.premierleague.com/premierleague/badges/70/t8.png";
        description = "welcome to chelsea fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= " Manchester United";
        author = "The Glazers family";
        pages = 100;
        imageURL = "https://m.media-amazon.com/images/I/61aXy49KF5L._AC_UL480_FMwebp_QL65_.jpg";
        description = "Welcome to manchester united fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= " Leeds United";
        author = "Leeds";
        pages = 100;
        imageURL = "https://resources.premierleague.com/premierleague/badges/70/t2.pngg";
        description = "Welcome to leeds united fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= " Everton fc";
        author = "Carlo Ancelotti";
        pages = 100;
        imageURL = "https://resources.premierleague.com/premierleague/badges/70/t11.pngg";
        description = "Welcome to Everton fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= " Manchester City Fc";
        author = "Guardiola";
        pages = 100;
        imageURL = "https://m.media-amazon.com/images/I/61fLOY61C5L._AC_UL480_FMwebp_QL65_.jpg";
        description = "Welcome to manchester city fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= "Liverpool Fc";
        author = "Jorgen Klopp";
        pages = 100;
        imageURL = "https://m.media-amazon.com/images/I/61Lt+riTURL._AC_UL480_FMwebp_QL65_.jpg";
        description = "Welcome to Liverpool fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= "Brighton and hoves albion Fc";
        author = "Brighton";
        pages = 100;
        imageURL = "https://resources.premierleague.com/premierleague/badges/70/t36.png";
        description = "Welcome to Brighton and hoves albion Fc fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= "Wolves Fc";
        author = "Wolves";
        pages = 100;
        imageURL = "https://resources.premierleague.com/premierleague/badges/70/t39.png";
        description = "Welcome to wolves fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= "Burnley Fc";
        author = "Burnley";
        pages = 100;
        imageURL = "https://resources.premierleague.com/premierleague/badges/70/t90.png";
        description = "Welcome to burnley fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= " Swansea City Fc";
        author = "swansea";
        pages = 100;
        imageURL = "https://m.media-amazon.com/images/I/71IQUwSNQGL._AC_UL480_FMwebp_QL65_.jpg";
        description = "Welcome to swansea city fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name= " FUlham Fc";
        author = "fulham";
        pages = 100;
        imageURL = "https://resources.premierleague.com/premierleague/badges/70/t54.png";
        description = "Welcome to fulham fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
        id++;
        name=  "Westbrom Fc";
        author = "westbrom";
        pages = 100;
        imageURL = "https://resources.premierleague.com/premierleague/badges/70/t35.png";
        description = "Welcome to westbrom fc";
        showAll.add(new Book(id,name,author,imageURL,description,pages));
    }

}
