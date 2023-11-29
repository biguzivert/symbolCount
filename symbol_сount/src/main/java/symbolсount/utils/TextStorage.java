package symbolсount.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TextStorage {
    private ArrayList<String> textStorage;

    public TextStorage(ArrayList<String> textStorage){
        this.textStorage = textStorage;
    }

    public String addText(String text){
        textStorage.clear();
        textStorage.add(text);
        return text;
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
