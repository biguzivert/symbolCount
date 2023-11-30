package symbolсount.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import symbolсount.service.SymbolСountService;

import java.util.*;
import java.util.stream.Stream;

@Service
public class SymbolСountImpl implements SymbolСountService {

    @Autowired
    TextStorage textStorage;

    @Override
    public Map<Character, Integer> countSymbols() {
        TreeMap<Character, Integer> countData = new TreeMap<>();
        char[] textCharArray = textStorage.getText().toCharArray();
        for(char c : textCharArray){
            if(countData.containsKey(c)){
                countData.put(c, countData.get(c) + 1);
            } else {
                countData.put(c, 1);
            }
        }
        Map<Character, Integer> sortedData = new LinkedHashMap<>();
        Stream<Map.Entry<Character, Integer>> countDataStream = countData.entrySet().stream();
        countDataStream.sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(d -> sortedData.put(d.getKey(), d.getValue()));
        return sortedData;
    }

    @Override
    public String saveTextInStorage(String text) {
        textStorage.addText(text);
        return text;
    }
}
