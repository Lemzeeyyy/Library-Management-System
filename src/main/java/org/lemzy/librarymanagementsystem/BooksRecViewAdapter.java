package org.lemzy.librarymanagementsystem;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecViewAdapter extends RecyclerView.Adapter<BooksRecViewAdapter.ViewHolder>{
    private static final String TAG = "BooksRecViewAdapter";
    private ArrayList<Book> books = new ArrayList<>();
    private Context context;
    private String type = "";
    private Util utils;

    public BooksRecViewAdapter(Context context) {
        this.context = context;
        utils = new Util();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitems_book_rec_view, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.bookName.setText(books.get(position).getName());
        holder.BookCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,BookActivity.class);
                intent.putExtra("bookID",books.get(position).getId());
                context.startActivity(intent);

            }
        });
        holder.BookCardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Book book = books.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("deleting " +book.getName())
                        .setMessage("Are you sure you want to delete "+book.getName() +"?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                switch (type){
                    case "want to read":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(utils.removeWantToReadBook(books.get(position))){
                                    notifyDataSetChanged();
                                    Toast.makeText(context,book.getName() + "has been deleted successfully...",Toast.LENGTH_LONG).show();
                                }
                            }
                        }).create().show();

                        break;
                    case "already read":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(utils.removeAlreadyReadBook(books.get(position))){
                                    notifyDataSetChanged();
                                    Toast.makeText(context,book.getName() + "has been deleted successfully...",Toast.LENGTH_LONG).show();
                                }
                            }
                        }).create().show();

                        break;
                    case "currently reading":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(utils.removeCurrentlyReadingBook(books.get(position))){
                                    notifyDataSetChanged();
                                    Toast.makeText(context,book.getName() + "has been deleted successfully...",Toast.LENGTH_LONG).show();
                                }
                            }
                        }).create().show();

                        break;
                    default:
                        break;

                }
                return true;

            }
        });
        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.bookImageView);

    }

    @Override
    public int getItemCount() {

        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView bookImageView;
        private TextView bookName;
        private CardView BookCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookImageView = itemView.findViewById(R.id.bookImage);
            bookName = itemView.findViewById(R.id.bookName);
            BookCardView = itemView.findViewById(R.id.BookCardView);
        }
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public void setType(String type) {
        this.type = type;
    }
}
