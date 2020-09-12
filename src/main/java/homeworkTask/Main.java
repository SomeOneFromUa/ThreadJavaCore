package homeworkTask;

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
    public static void main(String[] args) throws InterruptedException {
        Field field = new Field();
        Thread thread = new Thread(new Builder(field), "builder 1");
        Thread thread2 = new Thread(new Builder(field), "builder 2");
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(field.getStringBuilder().toString());
        System.out.println("----------------------------");
        Thread thread3 = new Thread(new Buffer(field), "buffer 1");
        Thread thread4 = new Thread(new Buffer(field), "buffer 2");
        thread3.start();
        thread4.start();
        thread3.join();
        thread4.join();
        System.out.println(field.getStringBuffer().toString());
    }
}
