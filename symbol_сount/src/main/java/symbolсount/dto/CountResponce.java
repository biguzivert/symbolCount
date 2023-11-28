package symbolсount.dto;

import lombok.Data;

import java.util.Map;
import java.util.TreeMap;

@Data
public class CountResponce {
    private boolean result;

    private Map<Character, Integer> countData;

}
