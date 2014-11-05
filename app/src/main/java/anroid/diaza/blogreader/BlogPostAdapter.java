package anroid.diaza.blogreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BlogPostAdapter extends ArrayAdapter<BlogPost>{
    public BlogPostAdapter(Context context, ArrayList<BlogPost> posts) {
        super(context, 0, posts);
    }

    //sets the variables in the blog post to the data in the url

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BlogPost post = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.blog_item, parent, false);
        }

        //for the title
        TextView textView = (TextView)convertView.findViewById(R.id.title);
        textView.setText(post.title);

        //for the author
        TextView authorView = (TextView)convertView.findViewById(R.id.author);
        authorView.setText(post.author);

        //for the date
        TextView dateView = (TextView)convertView.findViewById(R.id.date);
        dateView.setText(post.date);

        return convertView;
    }
}
