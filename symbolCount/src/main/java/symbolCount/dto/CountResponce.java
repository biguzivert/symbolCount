package symbolCount.dto;

import com.sun.source.tree.Tree;
import lombok.Data;

import java.util.TreeMap;

@Data
public class CountResponce {
    private boolean result;

    private TreeMap<Character, Integer> countData;

}
