package uet.k57ca.libview;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Ref;
import java.util.ArrayList;

/**
 * Created by Nguyen Thuy on 9/17/2015.
 */
public class LibRestClient {
    private static final String BASE_URL = "https://soalibman.herokuapp.com/books";

    private static AsyncHttpClient client = new AsyncHttpClient();



    public static RequestHandle get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        return client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static RequestHandle post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        return client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

    public static RequestHandle getAllBooks (final OnGetBookListener callBack) {
        return get("", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                ArrayList<Book> all_books = new ArrayList<Book>();
                for (int i = 0; i < response.length(); i++) {
                    JSONObject bookItem = response.optJSONObject(i);
                    String title = bookItem.optString("title");
                    String id = bookItem.optString("id");
                    String author = bookItem.optString("author");
                    String description = bookItem.optString("description");
                    String publisher = bookItem.optString("publisher");
                    String coverImageLink = bookItem.optString("cover");
                    String category = bookItem.optString("category");
                    Log.d("Cover", coverImageLink);

                    Book book = new Book();
                    book.setData(title, author, id, publisher, description, coverImageLink, category);

                    all_books.add(book);
                    System.out.println("Num of book after add: " + all_books.size() + title);
                }

                callBack.onSuccess(all_books);
            }

        });
    }

    public interface OnGetBookListener {
        public void onSuccess(ArrayList<Book> books);
    }
}


