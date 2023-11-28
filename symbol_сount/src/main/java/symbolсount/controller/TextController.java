package symbolсount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import symbolсount.dto.CountResponce;
import symbolсount.service.SymbolСountService;

@RestController
public class TextController {

    @Autowired
    SymbolСountService symbolCountService;

    @GetMapping(value = "/text", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountResponce> countSymbols(){
        return ResponseEntity.ok(symbolCountService.countSymbols());
    }

    @PostMapping("/text")
    public String add(String text){
        return symbolCountService.saveTextInStorage(text);
    }
}
