package GsonParseTask;

import GsonParseTask.UserPack.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            Gson gson = new Gson();
            InputStream inputStream = url.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            Type type = new TypeToken<ArrayList<User>>(){}.getType();
            ArrayList<User> users = gson.fromJson(inputStreamReader, type);
            System.out.println(type);
            for (User user : users) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
