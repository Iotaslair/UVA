import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

import javax.xml.ws.spi.http.HttpExchange;

// https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=21&page=show_problem&problem=1876
class ThrowingCardsAway10935 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int card = reader.nextInt();
        while (card != 0) {
            ArrayList<Integer> discard = new ArrayList<Integer>();
            Deque<Integer> cards = new ArrayDeque<Integer>();
            for (int i = 1; i < card + 1; i++) {
                cards.add(i);
            }
            while (cards.size() != 1) {
                discard.add(cards.poll());
                cards.addLast(cards.poll());
            }

            if (!discard.isEmpty()) {
                System.out.print("Discarded cards: ");
                String out = "";
                for (Integer x : discard) {
                    out = out + x + ", ";
                }
                out = out.substring(0, out.length() - 2);
                System.out.println(out);
            } else {
                System.out.println("Discarded cards:");
            }
            System.out.println("Remaining card: " + cards.poll());


            card = reader.nextInt();
        }

    }
}