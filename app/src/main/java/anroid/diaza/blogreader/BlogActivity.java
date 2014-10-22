package anroid.diaza.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.net.URI;


public class BlogActivity extends Activity {

    // making an instance of the type of variable and naming them
    protected ProgressBar progressBar;
    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        // connecting to the ids in the activity
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        listView = (ListView)findViewById(R.id.listView);

        // If listView is Empty it sets the view to empty
        listView.setEmptyView(progressBar);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("BlogActivity", "Title: " + BlogPostParser.get().posts.get(position).title);

                Intent intent = new Intent(getApplicationContext(), BlogWebActivity.class);
                Uri blogUri = Uri.parse(BlogPostParser.get().posts.get(position).url);
                intent.setData(blogUri);

                startActivity(intent);
            }
        });

        new BlogPostTask().execute(this);
    }

}
