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

public class Field {
    private StringBuilder stringBuilder;
    private StringBuffer stringBuffer;

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    public void setStringBuffer(StringBuffer stringBuffer) {
        this.stringBuffer = stringBuffer;
    }

    public Field() {
        this.stringBuilder = new StringBuilder();
        this.stringBuffer = new StringBuffer();
    }
    public void addToBuilder(int num){

                this.stringBuilder
                        .append(Thread.currentThread().getName())
                        .append(" : ")
                        .append(" num - ")
                        .append(num)
                        .append("\n");

    }

    public void addToBuffer(int num){
                this.stringBuffer
                        .append(Thread.currentThread().getName())
                        .append(" : ")
                        .append(" num - ")
                        .append(num)
                        .append("\n");

    }
}
