package numbers.medium.LetterCombinationOfPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

    private Map<Integer, String> phoneMap = new HashMap<>() {{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        backTrack(result, digits.length(), digits, "");
        return result;
    }

    private void backTrack(List<String> result, int size, String digits, String tmp) {
        if (tmp.length() == size) {
            result.add(tmp);
            return;
        }
        if (digits.isEmpty()) {
            return;
        }
        String tmpDigit = String.valueOf(digits.charAt(0));
        for (int i = 0; i < phoneMap.get(Integer.valueOf(tmpDigit)).length(); ++i) {
            char numStr = phoneMap.get(Integer.valueOf(tmpDigit)).charAt(i);
            backTrack(result, size, digits.substring(1), tmp + numStr);
        }
    }
}
