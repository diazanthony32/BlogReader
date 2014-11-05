package anroid.diaza.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;


public class BlogActivity extends Activity {

    // making an instance of the type of variable and naming them
    protected ProgressBar progressBar;
    protected GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        // connecting to the ids in the activity
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        gridView = (GridView)findViewById(R.id.gridView);

        // If gridView is Empty it sets the view to empty
        gridView.setEmptyView(progressBar);

        //waits for item on the list to be clicked
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
