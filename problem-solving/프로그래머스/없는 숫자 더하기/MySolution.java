import java.util.*;
import java.util.stream.*;

class Solution {

    public int solution(int[] numbers) {
        return (9*10/2) - Arrays.stream(numbers).sum();
    }
}