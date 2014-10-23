package anroid.diaza.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

//once object is clicked it is sent to another page to show the url
public class BlogWebActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web);

        Intent intent = getIntent();
        Uri blogUri = intent.getData();

        WebView webView = (WebView)findViewById(R.id.webView);
        webView.loadUrl(blogUri.toString());
    }
}
