package org.lemzy.librarymanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowAllActivity extends AppCompatActivity {
    private RecyclerView booksRecyclerView;

    private static final String TAG = "ShowAllActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d(TAG, "onCreate: started");
        booksRecyclerView = findViewById(R.id.showAllRecView);
        BooksRecViewAdapter adapter = new BooksRecViewAdapter(this);
        booksRecyclerView.setAdapter(adapter);

        booksRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        Util util = new Util();

        ArrayList<Book> books = new ArrayList<>();
        books = util.getShowAll();
//        books.add(new Book("Engineering Mathematics","K.A Stroud","https://images-na.ssl-images-amazon.com/images/I/61jVCbC0p2L._SX389_BO1,204,203,200_.jpg","Introduction To Engineering Mathematics",5000));
//        books.add(new Book("Thermodynamics","Rajput","https://images-na.ssl-images-amazon.com/images/I/51nOaHJ3ZCL._SX362_BO1,204,203,200_.jpg","Introduction to thermodynamics",2000));
//        books.add(new Book("Fluid Mechanics","Rajput","https://m.media-amazon.com/images/I/91WvmmuB9XL._AC_UY327_FMwebp_QL65_.jpg" ,"Introduction to fluid mechanics",2300));
//        books.add(new Book("Chemistry","Ababio","https://m.media-amazon.com/images/I/81oWeVQOfAL._AC_UY327_FMwebp_QL65_.jpg","Introduction to chemistry",1200));
          adapter.setBooks(books);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                super.onBackPressed();
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}