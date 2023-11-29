import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import symbolсount.controller.TextController;
import symbolсount.service.SymbolСountService;
import symbolсount.utils.TextStorage;

import java.util.LinkedHashMap;
import java.util.Map;

//@ExtendWith(MockitoExtension.class)
@WebMvcTest
public class TextControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @Mock
    SymbolСountService symbolСountService;


    TextStorage textStorage;

    TextController textController;

    @Test
    void testCountSymbols_whenOrderNotAlphabetical(){
        Map<Character, Integer> expectedResult1 = new LinkedHashMap<>();
        expectedResult1.put('n', 3);
        expectedResult1.put('d', 2);
        expectedResult1.put('x', 2);
        expectedResult1.put('a', 1);
        expectedResult1.put('c', 1);
        expectedResult1.put('o', 1);
        String scenario1 = "xxddcaonnn";
        String scenario2 = "";
        String scenario3 = null;
        String scenario4 = " fdf fd dssscca";

        Map<Character, Integer> expectedResult2;

        textController.add(scenario1);
        var response1 = textController.countSymbols();

        Assertions.assertEquals(HttpStatus.OK, response1.getStatusCode());
        Assertions.assertEquals(expectedResult1, response1.getBody());

    }

    void testCountSymbols_whenInputIsEmpty(){

    }

    void testCountSymbols_whenInputIsNull(){}

    void testCountSymbols_whenInputIncludeSpaces(){}
}
