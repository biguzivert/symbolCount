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

    @GetMapping(value = "/text", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Character, Integer>> countSymbols(){
        if(symbolCountService.getTextFromStorage().isEmpty()){
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.ok(symbolCountService.countSymbols());
    }

    @PostMapping("/text")
    public ResponseEntity<String> add(String text){
        if(text.isEmpty()){
            return ResponseEntity.status(400).body("Input is empty");
        }
        return ResponseEntity.ok(symbolCountService.saveTextInStorage(text));
    }
}
