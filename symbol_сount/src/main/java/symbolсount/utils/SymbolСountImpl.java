package symbolсount.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import symbolсount.dto.CountResponce;
import symbolсount.service.SymbolСountService;

import java.util.TreeMap;

@Service
public class SymbolСountImpl implements SymbolСountService {

    @Autowired
    TextStorage textStorage;

    @Override
    public CountResponce countSymbols() {
        CountResponce countResponce = new CountResponce();
        TreeMap<Character, Integer> countData = new TreeMap<>();
        char[] textCharArray = textStorage.getText().toCharArray();
        for(char c : textCharArray){
            if(countData.containsKey(c)){
                countData.put(c, countData.get(c) + 1);
            } else {
                countData.put(c, 1);
            }
        }
        countResponce.setResult(true);
        countResponce.setCountData(countData);
        return countResponce;
    }

    @Override
    public String saveTextInStorage(String text) {
        textStorage.setText(text);
        return text;
    }
}
