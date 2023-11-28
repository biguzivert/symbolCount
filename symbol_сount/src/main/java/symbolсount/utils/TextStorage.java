package symbolсount.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TextStorage {
    private ArrayList<String> textStorage;

    public TextStorage(ArrayList<String> textStorage){
        this.textStorage = textStorage;
    }

    public void addText(String text){
        textStorage.clear();
        textStorage.add(text);
    }

    public String getText(){
        if(textStorage.size() == 1) {
            return textStorage.get(0);
        }
        else {
            return "";
        }
    }
}
