package symbolCount.utils;

import symbolCount.dto.CountResponce;
import symbolCount.services.SymbolCountService;

import java.util.HashMap;

public class SymbolCountImpl implements SymbolCountService {

    @Override
    public CountResponce countSymbols(String text) {
        CountResponce countResponce = new CountResponce();
        HashMap<String, Integer> countData = new HashMap<>();

        return countResponce;
    }
}
