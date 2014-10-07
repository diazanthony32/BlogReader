package anroid.diaza.blogreader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;


public class BlogActivity extends Activity {

    // making an instance of the type of variable and naming them
    protected ProgressBar progressBar;
    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        String[] arrayStrings = new String[] {

                "Blog Post 1",
                "Blog Post 2",
                "Blog Post 3",
                "Blog Post 4"
        };

        // connecting to the ids in the activity
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        listView = (ListView)findViewById(R.id.listView);

        // If listView is Empty it sets the view to empty
        listView.setEmptyView(progressBar);

        // makes it so our array is able to be used in our listView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayStrings);
        listView.setAdapter(adapter);

        new BlogPostTask().execute();
    }

}
