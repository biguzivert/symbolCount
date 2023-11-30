package symbolсount.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import symbolсount.service.SymbolСountService;
import symbolсount.utils.TextStorage;

import java.util.Map;

@RestController
public class TextController {

    @Autowired
    SymbolСountService symbolCountService;
    @Autowired
    TextStorage textStorage;

/*    @Autowired
    public TextController(SymbolСountService symbolСountService, TextStorage textStorage){
        this.symbolCountService = symbolСountService;
        this.textStorage = textStorage;
    }*/
    @GetMapping(value = "/text", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Character, Integer>> countSymbols(){
        return ResponseEntity.ok(symbolCountService.countSymbols());
    }

    @PostMapping("/text")
    public ResponseEntity<String> add(String text){
        return ResponseEntity.ok(symbolCountService.saveTextInStorage(text));
    }
}
