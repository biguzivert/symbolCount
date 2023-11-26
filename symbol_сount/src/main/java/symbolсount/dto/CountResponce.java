package symbolсount.dto;

import lombok.Data;

import java.util.TreeMap;

@Data
public class CountResponce {
    private boolean result;

    private TreeMap<Character, Integer> countData;

}
