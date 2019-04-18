package com.javalesson.lambdas;

/*interface Executable {
    int execute(int x, int y);
}

class Runner {
    public void run(Executable e) {
        int execute = e.execute(10, 15);
        System.out.println(execute);
    }
}*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaOther {
    public static void main(String[] args) {
/*        Runner runner = new Runner();

        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) {
                return x + y;
            }
        });

        runner.run((x, y) -> x + 5 + y);
        */

        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Good");
        list.add("a");
        list.add("ab");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(list);

        list.sort((s1, s2) -> {
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() < s2.length()) {
                return -1;
            } else {
                return 0;
            }
        });
    }
}
