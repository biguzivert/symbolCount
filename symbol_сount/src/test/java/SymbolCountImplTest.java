import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import symbolсount.utils.SymbolСountImpl;
import symbolсount.utils.TextStorage;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.mockito.Mockito.when;
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
    private Map<Character, Integer> expectedResult5;
    private String scenario1;
    private String scenario2;
    private String scenario3;
    private String scenario4;
    private String scenario5;

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
        expectedResult3 = new LinkedHashMap<>();

        scenario4 = " fdf fd    dssscca";
        expectedResult4 = new LinkedHashMap<>();
        expectedResult4.put(' ', 6);
        expectedResult4.put('d', 3);
        expectedResult4.put('f', 3);
        expectedResult4.put('s', 3);
        expectedResult4.put('c', 2);
        expectedResult4.put('a', 1);

        scenario5 = "933,/!";
        expectedResult5 = new LinkedHashMap<>();
        expectedResult5.put('3', 2);
        expectedResult5.put('9', 1);
        expectedResult5.put(',', 1);
        expectedResult5.put('/', 1);
        expectedResult5.put('!', 1);
    }

    @Test
    void testCountSymbols_whenOrderNotAlphabetical(){
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

    @Test
    void testCountSymbols_whenInputIsNull_thenEmptyResultReturned(){
        when(textStorage.getText()).thenReturn(scenario3);
        Map<Character, Integer> actual = symbolСount.countSymbols();
        Assertions.assertEquals(expectedResult3, actual);
    }

    @Test
    void testCountSymbols_whenInputIncludeSpaces_thenNormalResultReturned(){
        when(textStorage.getText()).thenReturn(scenario4);
        Map<Character, Integer> actual = symbolСount.countSymbols();
        Assertions.assertEquals(expectedResult4, actual);
    }

    @Test
    void testCountSymbols_whenInputIncludeNumbersAndSymbols_theNormalResultReturned(){
        when(textStorage.getText()).thenReturn(scenario5);
        Map<Character, Integer> actual = symbolСount.countSymbols();
        Assertions.assertEquals(expectedResult5, actual);
    }
}
