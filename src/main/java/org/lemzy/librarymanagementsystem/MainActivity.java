package org.lemzy.librarymanagementsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button BtnShowAll,BtnCurrent,BtnWantTo,BtnAlready,BtnAbout;
    private TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setOnClickListeners();
    }
    private void setOnClickListeners(){
        BtnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowAllActivity.class);
                startActivity(intent);
            }
        });
        BtnAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadActivity.class);
                startActivity(intent);
            }
        });
        BtnWantTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WantToActivity.class);
                        startActivity(intent);
            }
        });
        BtnCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });
        BtnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutTapped();
            }
        });
    }
    private void initWidgets(){
        BtnShowAll = findViewById(R.id.AllBooksBtn);
        BtnCurrent = findViewById(R.id.CurrentBtn);
        BtnWantTo = findViewById(R.id.WantToReadBtn);
        BtnAlready = findViewById(R.id.AlreadyRead);
        BtnAbout = findViewById(R.id.AboutBtn);
    }
    private void aboutTapped(){
        Log.d(TAG, "aboutTapped: started");
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("ABout my Library App")
                .setMessage("Built and published by Lemzy \n" +
                        "\n phone Number : 08106811525 \n" +
                "www.goal.com")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, MyWebViewActivity.class);
                        intent.putExtra("url","goal.com");
                        startActivity(intent);

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create().show();

    }

}