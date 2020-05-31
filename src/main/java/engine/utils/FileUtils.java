package engine.utils;

import sun.util.locale.provider.JRELocaleProviderAdapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    private FileUtils(){}


    public static String loadAsString(String filePath) {
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String buffer = "";
            while((buffer = reader.readLine()) != null){
                result.append(buffer + "\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
