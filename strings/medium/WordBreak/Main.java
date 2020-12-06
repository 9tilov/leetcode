package strings.medium.WordBreak;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        WordBreak solution = new WordBreak();
        System.out.println(solution.wordBreak("aaaaaaa", new ArrayList<>() {{
            add("aaaa");
            add("aaa");
        }}));
    }
}
