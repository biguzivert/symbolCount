package symbolCount.utils;

import symbolCount.dto.CountResponce;
import symbolCount.services.SymbolCountService;

import java.util.HashMap;
import java.util.TreeMap;

public class SymbolCountImpl implements SymbolCountService {

    @Override
    public CountResponce countSymbols(String text) {
        CountResponce countResponce = new CountResponce();
        TreeMap<Character, Integer> countData = new TreeMap<>();
        char[] textCharArray = text.toCharArray();
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
}
