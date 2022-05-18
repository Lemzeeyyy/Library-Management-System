 package org.lemzy.librarymanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private static final String TAG = "BookActivity";
    private TextView bookName,author,desc,pageNum;
    private Button BtncurrentlyReading,BtnwantTo,BtnalreadyRead;
    private ImageView bookImage;
    private Book incomingBook;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initWidgets();
        Intent intent = getIntent();
        int id = intent.getIntExtra("bookID",0);
        util = new Util();
        ArrayList<Book> books = util.getShowAll();
        for(Book b : books){
            if(b.getId() == id) {
                incomingBook = b;
                bookName.setText(b.getName());
                author.setText(b.getAuthor());
                desc.setText(b.getDescription());
//                pageNum.setText(b.getNum_of_pages());
                Glide.with(this)
                        .asBitmap()
                        .load(b.getImageUrl())
                        .into(bookImage);
            }
        }

        BtncurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtncurrentlyReadingTapped();
            }
        });
        BtnalreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnalreadyReadTapped();
            }
        });
        BtnwantTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnWantToTapped();
            }
        });
    }

    private void BtnWantToTapped(){
        Log.d(TAG, "BtnWantToTapped: started");

        ArrayList<Book> wantToRead = util.getWantToRead();

        if(wantToRead.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added this book to your want to read book");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        } else{
            ArrayList<Book> alreadyRead = util.getAlreadyRead();
            if(alreadyRead.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("you already read this book");//You are already reading this book
            builder.setTitle("Error");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();
            }else{
                ArrayList<Book> currentlyReading = util.getCurrentlyReadingBook();
                if(currentlyReading.contains(incomingBook)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("You already read this book");
                    builder.setTitle("Error");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setCancelable(false);
                    builder.create().show();
                }else{
                    util.addWantToReadBook(incomingBook);
                    Toast.makeText(this,"The Book" +incomingBook.getName() +" added successfully to your want to read list",Toast.LENGTH_LONG).show();
                }
            }

        }
    }
    private void BtnalreadyReadTapped(){
        Log.d(TAG, "BtnalreadyReadTapped: started");

        ArrayList<Book> alreadyReadBook = util.getAlreadyRead();

        if(alreadyReadBook.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added this book to your already read book");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        } else{
            ArrayList<Book> currentlyReading = util.getCurrentlyReadingBook();
            if(currentlyReading.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("have you finished reading this book?");
                builder.setTitle("Error");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removeAlreadyReadBook(incomingBook);
                        util.addAlreadyReadBook(incomingBook);
                        Toast.makeText(BookActivity.this,"The Book" +incomingBook.getName() +" added successfully to your already read list",Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();

            }else{
                util.addAlreadyReadBook(incomingBook);
                Toast.makeText(this,"The Book" +incomingBook.getName() +" added successfully to your already read list",Toast.LENGTH_LONG).show();
            }

        }
    }
    private void BtncurrentlyReadingTapped(){

        Log.d(TAG, "BtncurrentlyReadingTapped: started");

        ArrayList<Book> currentlyReadingBook = util.getCurrentlyReadingBook();


        if(currentlyReadingBook.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added this book to your currently reading book");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        } else{
            ArrayList<Book> wantToRead = util.getWantToRead();
            if(wantToRead.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you going to start reading this book?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                          util.removeWantToReadBook(incomingBook);
                         util.addCurrentlyReadingBook(incomingBook);
                        Toast.makeText(BookActivity.this,"The Book" +incomingBook.getName() +" added successfully to your currently reading list",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();
            }else{
            ArrayList<Book> alreadyRead = util.getAlreadyRead();
            if(alreadyRead.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Do you want to read this book again?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        util.addCurrentlyReadingBook(incomingBook);
                        Toast.makeText(BookActivity.this,"The Book" +incomingBook.getName() +" added successfully to your currently reading list",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.create().show();
            }else {
                util.addCurrentlyReadingBook(incomingBook);
                Toast.makeText(this,"The Book" +incomingBook.getName() +" added successfully to your currently reading list",Toast.LENGTH_LONG).show();
            }
            }

        }
    }
    private void initWidgets(){
        bookName = findViewById(R.id.bookName);
        bookImage = findViewById(R.id.bookImage);
        desc = findViewById(R.id.description);
        author = findViewById(R.id.authorName);
        BtncurrentlyReading = findViewById(R.id.CurrentBtn);
        BtnwantTo = findViewById(R.id.WantToReadBtn);
        BtnalreadyRead = findViewById(R.id.AlreadyRead);
        pageNum = findViewById(R.id.pages);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: started");
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}