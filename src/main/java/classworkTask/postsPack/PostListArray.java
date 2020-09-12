package classworkTask.postsPack;

import classworkTask.UserPack.User;
import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class PostListArray implements Runnable {
    private ArrayList<Post> posts;

    public PostListArray() {
        this.posts = new ArrayList<Post>();
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    @Override
    public void run() {
        try {
            URLConnection urlConnection = new URL("https://jsonplaceholder.typicode.com/posts").openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder stringBuilder = new StringBuilder();
            int i;
            while ((i = inputStream.read()) != -1){
                stringBuilder.append((char) i);
            }
            JSONArray objects = new JSONArray(stringBuilder.toString());
            for (int j = 0; j < objects.length(); j++) {
                int userId = objects.getJSONObject(j).getInt("userId");
                int id = objects.getJSONObject(j).getInt("id");
                String title = objects.getJSONObject(j).getString("title");
                String body = objects.getJSONObject(j).getString("body");

                Post post = new Post(userId, id, title, body);
                this.posts.add(post);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
