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
import java.util.BitSet;
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

// https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=441&page=show_problem&problem=3960
class MoviePolice12515 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<BitSet> movies = new ArrayList<BitSet>();
        ArrayList<BitSet> clips = new ArrayList<BitSet>();
        String stuff = reader.nextLine();
        String[] things = stuff.split(" ");
        int moviesToHold = Integer.parseInt(things[0]);
        int clipsToHold = Integer.parseInt(things[1]);

        for (int i = 0; i < moviesToHold; i++) {
            String movie = reader.nextLine();
            //System.out.println(movie);
            BitSet temp = new BitSet();
            for (int j = 0; j < movie.length(); j++) {
                if (movie.substring(j, j + 1).equals("1"))
                    temp.set(j, true);
                else
                    temp.set(j, false);
            }
            temp.set(movie.length(), true);
            movies.add(temp);
        }

//		for(int i = 0; i < movies.size(); i++) {
//			System.out.println(i + "     " + movies.get(i));
//		}

        for (int i = 0; i < clipsToHold; i++) {
            String clip = reader.nextLine();
            BitSet temp = new BitSet();
            for (int j = 0; j < clip.length(); j++) {
                if (clip.substring(j, j + 1).equals("1"))
                    temp.set(j, true);
                else
                    temp.set(j, false);
            }
            temp.set(clip.length(), true);
            clips.add(temp);
        }

        for (BitSet clip : clips) {
            int minHam = clip.length();
            int winner = 1;
            int place = 1;
            for (BitSet movie : movies) {
//				System.out.println("Movie " + place + " length " + movie.length());
//				System.out.println("Clip length " + clip.length());
                if (movie.length() < clip.length()) {

//					System.out.println("Movie " + place + " skipped");
                    place++;
                    continue;
                } else {
                    int diff = movie.length() - clip.length();
                    for (int i = 0; i <= diff; i++) {
                        BitSet submovie = movie.get(i, movie.length() - ((diff + 1) - i));
                        submovie.set(clip.length() - 1, true);
                        //System.out.println("Submovie " + submovie.toString());
                        int dist = hammingDistance(submovie, clip);
//						System.out.println("Movie: " + place + " Distance: " + dist);
                        if (dist < minHam) {
                            minHam = dist;
                            winner = place;
                        }
                    }
                    place++;
                }
            }
            System.out.println(winner);
        }


    }


    public static int hammingDistance(BitSet first, BitSet second) {
        if (first.length() != second.length()) {
            System.out.println("first length " + first.length());
            System.out.println("second length " + second.length());
            throw new IllegalStateException();
        }
        BitSet clone = (BitSet) first.clone();
        clone.xor(second);
        return clone.cardinality();
    }

}

