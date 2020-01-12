import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

// https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=27&page=show_problem&problem=2619
class UniqueSnowflakes11572 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        int testCases = reader.nextInt();
        for (int j = 0; j < testCases; j++) {
            int best = 0;
            int snowflakes = reader.nextInt();
            LinkedList<Integer> flakes = new LinkedList<Integer>();
            for (int i = 0; i < snowflakes; i++) {
                int newVal = reader.nextInt();
                if (table.containsKey(newVal)) {
                    best = Math.max(best, flakes.size());
                    while (flakes.size() > 0) {
                        int val = flakes.remove(0);
                        table.remove(val);
                        if (val == newVal) break;
                    }
                }
                flakes.add(newVal);
                table.put(newVal, newVal);
            }
            best = Math.max(best, flakes.size());

            System.out.println(best);

            flakes.clear();
            table.clear();
        }


    }
}






