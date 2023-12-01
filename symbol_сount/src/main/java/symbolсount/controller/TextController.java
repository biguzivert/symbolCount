package symbolсount.controller;

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

    @GetMapping(value = "/text", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Character, Integer>> countSymbols(){
        Map<Character, Integer> result = symbolCountService.countSymbols();
        if(result.isEmpty()){
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/text")
    public ResponseEntity<String> add(String text){
        if(text.isEmpty()){
            return ResponseEntity.status(400).body("Input is empty");
        }
        return ResponseEntity.ok(symbolCountService.saveTextInStorage(text));
    }
}
