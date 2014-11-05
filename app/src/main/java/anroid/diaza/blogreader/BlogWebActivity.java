package anroid.diaza.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


//once object is clicked it is sent to another page
public class BlogWebActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web);

        Intent intent= getIntent();
        Uri blogUri= intent.getData();

        final ProgressBar progressBarWeb = (ProgressBar)findViewById(R.id.progressBarWeb);

        WebView webView= (WebView)findViewById(R.id.webView);
        webView.loadUrl(blogUri.toString());

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView webview, String url) {

                progressBarWeb.setVisibility(View.GONE);
            }
        });
    }
}