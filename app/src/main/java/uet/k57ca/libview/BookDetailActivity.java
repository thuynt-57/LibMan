package uet.k57ca.libview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;

import static uet.k57ca.libview.R.menu.menu_main;

/**
 * Created by Nguyen Thuy on 9/18/2015.
 */
public class BookDetailActivity extends AppCompatActivity {
    TextView title, id, publisher, description, author;
    ImageView image;
    private Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("book view", "on create");
        Context context = getApplicationContext();
        Intent intent = this.getIntent();
        final Book curBook = (Book)intent.getSerializableExtra("CurBook");

        setContentView(R.layout.book_view);

        mToolbar = (Toolbar) findViewById(R.id.toolbarbookview);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);

        image = (ImageView) findViewById(R.id.imageViewBookView);
        title = (TextView) findViewById(R.id.book_name);
        id = (TextView) findViewById(R.id.book_id);
        publisher = (TextView) findViewById(R.id.book_publisher);
        description = (TextView) findViewById(R.id.book_description);
        author = (TextView) findViewById(R.id.book_author);
        Toast.makeText(this, "book " + curBook.getTittle(), Toast.LENGTH_LONG);

        if (curBook.getCoverImage() == null) {
            image.setImageResource(R.drawable.ic_launcher);
        }
        else{
            Ion.with(getBaseContext())
                    .load(curBook.getCoverImage())
                    .intoImageView(image);
        }
        title.setText(curBook.getTittle());
        id.setText("Category: " + curBook.getCategory());
        publisher.setText("Publisher: " + curBook.getPublisher());
        description.setText(curBook.getDescription());
        author.setText("Author: " + curBook.getAuthor());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        // Configure the search info and add any event listeners
        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
