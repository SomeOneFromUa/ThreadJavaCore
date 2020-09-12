package homeworkTask;

import GsonParseTask.UserPack.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;

public class Builder implements Runnable {
    private Field field;

    public Builder() {
    }

    public Builder(Field field) {
        this.field = field;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.field.addToBuilder(i);
        }
    }
}
