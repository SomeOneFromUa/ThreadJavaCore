package classworkTask.UserPack;

import classworkTask.postsPack.Post;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersListArray implements Runnable {
    private ArrayList<User> userList;

    public UsersListArray() {
        this.userList = new ArrayList<User>();
    }

    public void getPostsForAllUsers(ArrayList<Post> allPosts){
        for (User user : userList) {
            List<Post> collect = allPosts.stream().filter(post -> post.getUserId() == user.getId()).collect(Collectors.toList());
            user.setPosts((ArrayList<Post>) collect);
        }
    }


    public void printUserWithPosts(){
        for (User user : userList) {
            System.out.println(user.getId() + " " +user.getUsername()+ ":");
            for (Post post : user.getPosts()) {
                System.out.println(post.getId() + " userID " + post.getUserId());
                System.out.println(post.getTitle());
                System.out.println(post.getBody());

                System.out.println("/=============================/");
            }
        }
    }
    public void printUserWithPosts(int id) {
        User user1 = this.userList.stream().filter(user -> user.getId() == id).findFirst().get();
        System.out.println(user1.getId() + " " + user1.getUsername() + ":");
        for (Post post : user1.getPosts()) {
            System.out.println(post.getId() + " userID " + post.getUserId());
            System.out.println(post.getTitle());
            System.out.println(post.getBody());

            System.out.println("/=============================/");
        }
    }
    public ArrayList<User> getUserList() {
        return userList;
    }

    @Override
    public void run() {
        try {
            URLConnection urlConnection = new URL("https://jsonplaceholder.typicode.com/users").openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder stringBuilder = new StringBuilder();
            int i;
            while ((i = inputStream.read()) != -1) {
                stringBuilder.append((char) i);
            }
            JSONArray objects = new JSONArray(stringBuilder.toString());
            for (int j = 0; j < objects.length(); j++) {
                int id = objects.getJSONObject(j).getInt("id");
                String name = objects.getJSONObject(j).getString("name");
                String username = objects.getJSONObject(j).getString("username");
                String email = objects.getJSONObject(j).getString("email");
                String phone = objects.getJSONObject(j).getString("phone");
                String website = objects.getJSONObject(j).getString("website");

                JSONObject address = objects.getJSONObject(j).getJSONObject("address");
                String street = address.getString("street");
                String suite = address.getString("suite");
                String city = address.getString("city");
                String zipcode = address.getString("zipcode");

                JSONObject geo = address.getJSONObject("geo");
                String lat = geo.getString("lat");
                String lng = geo.getString("lng");

                JSONObject company = objects.getJSONObject(j).getJSONObject("company");
                String name1 = company.getString("name");
                String catchPhrase = company.getString("catchPhrase");
                String bs = company.getString("bs");
                User user = new User(
                        id,
                        name,
                        username,
                        email,
                        new Address(street, suite, city, zipcode, new Geo(lat, lng)),
                        phone,
                        website,
                        new Company(name1, catchPhrase, bs)
                );
                this.userList.add(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
