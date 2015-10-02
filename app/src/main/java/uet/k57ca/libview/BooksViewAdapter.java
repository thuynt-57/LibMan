package uet.k57ca.libview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Thuy on 9/18/2015.
 */
public class BooksViewAdapter extends ArrayAdapter<Book> {
    private ArrayList<Book> books;

    public BooksViewAdapter(Context context, ArrayList<Book> objects) {
        super(context, R.layout.list_item, objects);
        books = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        // set value into imageview
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewListItem);
        if (books.get(position).getCoverImage() == null) {
            imageView.setImageResource(R.drawable.ic_launcher);
        }
        else{
            Ion.with(getContext())
                    .load(books.get(position).getCoverImage())
                    .intoImageView(imageView);
        }

        // set value into title text view
        TextView textView = (TextView) convertView.findViewById(R.id.textViewTitleListItem);
        textView.setText(books.get(position).getTittle());

        // set value into author text view
        TextView textViewAuthor = (TextView) convertView.findViewById(R.id.textViewAuthorListItem);
        textViewAuthor.setText(books.get(position).getAuthor());

        return convertView;
    }

}
