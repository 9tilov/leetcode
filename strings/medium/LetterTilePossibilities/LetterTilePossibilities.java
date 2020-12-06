package strings.medium.LetterTilePossibilities;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {

    private Set<String> perms = new HashSet<>();
    private boolean[] visit;

    public int numTilePossibilities(String tiles) {
        if (tiles.isEmpty()) {
            return 0;
        }
        visit = new boolean[tiles.length()];
        backTrack(tiles, "");
        return perms.size();
    }

    private void backTrack(String input, String tmp) {
        if (tmp.length() > input.length()) {
            return;
        }
        if (tmp.length() > 0) {
            perms.add(tmp);
        }

        for (int i = 0; i < input.length(); ++i) {
            if (visit[i]) continue;
            visit[i] = true;
            backTrack(input, tmp + input.charAt(i));
            visit[i] = false;


        }
    }
}
