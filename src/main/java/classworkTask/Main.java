package classworkTask;

import classworkTask.UserPack.UsersListArray;
import classworkTask.postsPack.Post;
import classworkTask.postsPack.PostListArray;
import org.json.JSONArray;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        UsersListArray usersListArray = new UsersListArray();
        PostListArray postListArray = new PostListArray();
        Thread threadPosts = new Thread(postListArray);
        Thread threadUsers = new Thread(usersListArray);
        threadUsers.start();
        threadPosts.start();
        threadPosts.join();
        threadUsers.join();
        usersListArray.getPostsForAllUsers(postListArray.getPosts());
//        usersListArray.printUserWithPosts();
        usersListArray.printUserWithPosts(2);


    }
}
