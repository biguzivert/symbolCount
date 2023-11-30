import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import symbolсount.controller.TextController;
import symbolсount.service.SymbolСountService;
import symbolсount.utils.SymbolСountImpl;
import symbolсount.utils.TextStorage;

import java.util.LinkedHashMap;
import java.util.Map;

import static javax.swing.UIManager.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(MockitoExtension.class)

@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class SymbolCountImplTest{

    @Mock
    TextStorage textStorage;

    @InjectMocks
    private SymbolСountImpl symbolСount;

    private Map<Character, Integer> expectedResult1;
    private Map<Character, Integer> expectedResult2;
    private Map<Character, Integer> expectedResult3;
    private Map<Character, Integer> expectedResult4;
    private String scenario1;
    private String scenario2;
    private String scenario3;
    private String scenario4;

    @BeforeEach
    void setUp() {
        scenario1 = "xxddcaonnn";

        expectedResult1 = new LinkedHashMap<>();
        expectedResult1.put('n', 3);
        expectedResult1.put('d', 2);
        expectedResult1.put('x', 2);
        expectedResult1.put('a', 1);
        expectedResult1.put('c', 1);
        expectedResult1.put('o', 1);

        scenario2 = "";

        expectedResult2 = new LinkedHashMap<>();

        scenario3 = null;
        scenario4 = " fdf fd dssscca";
        Map<Character, Integer> expectedResult2;
    }

    @Test
    void testCountSymbols_whenOrderNotAlphabetical() throws Exception{
        when(textStorage.getText()).thenReturn(scenario1);
        Map<Character, Integer> actual = symbolСount.countSymbols();
        Assertions.assertEquals(expectedResult1, actual);
    }

    @Test
    void testCountSymbols_whenInputIsEmpty_thenEmptyResultReturned(){
        when(textStorage.getText()).thenReturn(scenario2);
        Map<Character, Integer> actual = symbolСount.countSymbols();
        Assertions.assertEquals(expectedResult2, actual);
    }

    void testCountSymbols_whenInputIsNull(){}

    void testCountSymbols_whenInputIncludeSpaces(){}
}
