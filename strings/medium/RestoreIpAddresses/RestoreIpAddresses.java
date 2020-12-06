package strings.medium.RestoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    private List<String> resultIps = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }

        backTrack(s, "", 0, 0);
        return resultIps;
    }

    private void backTrack(String s, String sub, int dotCount, int bigIndex) {
        if (dotCount == 4 && bigIndex == s.length()) {
            resultIps.add(sub.substring(0, sub.length() - 1));
            return;
        } else if (dotCount == 4 && bigIndex < s.length()) {
            return;
        } else {
            for (int i = 1; i < 4 && bigIndex + i <= s.length(); ++i) {
                String tmp = s.substring(bigIndex, bigIndex + i);
                int num = Integer.valueOf(tmp);
                if (num > 255 || tmp.length() > 1 && tmp.startsWith("0")) {
                    break;
                }
                backTrack(s, sub + num + ".", dotCount + 1, bigIndex + i);
            }

        }
    }
}
