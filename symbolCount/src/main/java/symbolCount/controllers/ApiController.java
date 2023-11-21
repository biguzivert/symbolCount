package symbolCount.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import symbolCount.dto.CountResponce;
import symbolCount.services.SymbolCountService;

@RestController
public class ApiController {

    private final SymbolCountService symbolCountService;
    public ApiController(SymbolCountService symbolCountService){
        this.symbolCountService = symbolCountService;
    }

    public ResponseEntity<CountResponce> countSymbols(String text){
        return ResponseEntity.ok(symbolCountService.countSymbols(text));
    }
}
