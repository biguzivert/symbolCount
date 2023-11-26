package symbolсount.service;

import org.springframework.stereotype.Service;
import symbolсount.dto.CountResponce;

public interface SymbolСountService {

    CountResponce countSymbols();

    String saveTextInStorage(String text);
}
