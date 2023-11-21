package symbolCount.services;

import symbolCount.dto.CountResponce;

public interface SymbolCountService {

    CountResponce countSymbols(String text);
}
