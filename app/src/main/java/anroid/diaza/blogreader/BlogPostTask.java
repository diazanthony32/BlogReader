package anroid.diaza.blogreader;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BlogPostTask extends AsyncTask <Activity, Void, JSONObject>{
    private Activity activity;

    @Override
    protected JSONObject doInBackground(Activity... activities) {
        activity = activities[0];
        JSONObject jsonObject = null;

        //tries to connect to the url provided and sends errors if something is wrong
        try {
            URL blogFeedUrl = new URL("http://blog.teamtreehouse.com/api/get_recent_summary/?count=20");

            HttpURLConnection connection = (HttpURLConnection)blogFeedUrl.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                Log.i("BlogPostTask", "Successful Connection " + responseCode);
                jsonObject = BlogPostParser.get().parse(connection.getInputStream());
            }
        }
        catch (MalformedURLException error){
            Log.e("BlogPostTag", "Malformed URL: " + error);
        }
        catch (IOException error){
            Log.e("BlogPostTask", "IO Exception: " + error);
        }
        return jsonObject;
    }

    //sets the listview adapter
    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
        BlogPostParser.get().readFeed(jsonObject);
        ListView listView = (ListView)activity.findViewById(R.id.listView);

        BlogPostAdapter adapter = new BlogPostAdapter(activity, BlogPostParser.get().posts);
        listView.setAdapter(adapter);
    }
}
