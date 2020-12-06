package strings.medium.WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    private boolean isPossible = false;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        Set<String> tmpDict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int fast = 0; fast <= s.length(); ++fast) {
            for (int low = 0; low < fast; ++low) {
                String tmp = s.substring(low, fast);
                if (dp[low] && tmpDict.contains(tmp)) {
                    dp[fast] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        Set<String> tmpDict = new HashSet<>(wordDict);
        traverse(s, 0, 0, tmpDict);
        return isPossible;
    }

    private void traverse(String s, int low, int fast, Set<String> dict) {
        if (low >= s.length()) {
            isPossible = true;
        }
        if (fast > s.length()) {
            return;
        }
        String tmp = s.substring(low, fast);
        if (dict.contains(tmp)) {
            traverse(s, fast, fast + 1, dict);
        }
        traverse(s, low, fast + 1, dict);
    }

}
