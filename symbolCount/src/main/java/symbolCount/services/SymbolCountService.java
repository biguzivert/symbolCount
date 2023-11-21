package symbolCount.services;

import symbolCount.dto.CountData;
import symbolCount.dto.CountResponce;

import java.util.HashMap;

public interface SymbolCountService {

    CountResponce countSymbols(String text);
}
