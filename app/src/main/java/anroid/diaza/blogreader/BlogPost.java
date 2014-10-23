package anroid.diaza.blogreader;

public class BlogPost {

    public final String title;
    public final String url;
    public final String date;
    public final String author;
    public final String image;

    //sets the variables of BlogPost
    public BlogPost(String title, String url, String date, String author, String image) {
        this.title = title;
        this.url = url;
        this.date = date;
        this.author = author;
        this.image = image;
    }

}
