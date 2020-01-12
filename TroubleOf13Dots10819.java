import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

/*
	Doesn't work
	https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=20&page=show_problem&problem=1760
 */
class TroubleOf13Dots10819 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (true) {
            int budget = reader.nextInt();
            int items = reader.nextInt();
            int spent = 0;
            int favor = 0;
            //input
            ArrayList<ArrayList<Double>> clothes = new ArrayList<ArrayList<Double>>();
            ArrayList<ArrayList<Double>> clothes2 = new ArrayList<ArrayList<Double>>();
            for (int i = 0; i < items; i++) {
                ArrayList<Double> temp = new ArrayList<Double>();
                temp.add(1.0 * reader.nextInt()); //price
                temp.add(1.0 * reader.nextInt()); //favor
                temp.add((1.0 * temp.get(0) / temp.get(1))); //ratio
                clothes.add(temp);
                clothes2.add(temp);
            }

            if (budget < 1800) {
                System.out.println("Went < 1800");
                ArrayList<Integer> results = value(clothes, budget, spent, favor);
                System.out.println(results.get(2).intValue());
            } else {
                ArrayList<Integer> results = value(clothes, budget + 200, spent, favor);

                System.out.println("result checking between 1800 and 2000: " + results.get(1));
                if (results.get(1) > 2000) {
                    System.out.println("Greater than 2000");
                    System.out.println(results.get(2).intValue());
                } else {
                    System.out.println("Less than 2000");
                    results = value(clothes2, budget, spent, favor);
                    System.out.println(results.get(2).intValue());
                }
            }
            //System.out.println("done");
        }
    }


    public static int bestItem(ArrayList<ArrayList<Double>> in, int leftOver) {
        double highest = 99999.0;
        int position = -1;
        System.out.println("Leftover in bestItem " + leftOver);
        for (int i = 0; i < in.size(); i++) {
            if (in.get(i).get(2) < highest && in.get(i).get(0) < leftOver) {
                highest = in.get(i).get(2);
                position = i;
            }
        }

        return position;
    }

    public static ArrayList<Integer> value(ArrayList<ArrayList<Double>> in, int budget, int spent, int favor) {
        int size = in.size();
        for (int i = 0; i < size; i++) {
            System.out.println("\nloops through " + i);
            int best = bestItem(in, budget - spent);
            if (best != -1) {
                ArrayList<Double> cloth = in.remove(best);
                System.out.println("Best price " + cloth.get(0));
                System.out.println("Best favor " + cloth.get(1));
                System.out.println("Best ratio " + cloth.get(2));
                //add item if valid
                if (spent + cloth.get(0) < budget) {
                    spent = (int) (spent + cloth.get(0));
                    System.out.println("total spent " + spent);
                    favor = (int) (favor + cloth.get(1));
                    System.out.println("total favor " + favor);
                    if (spent > 2000)
                        budget += 200;
                    System.out.println("clothes size " + in.size());
                } else {
                    //System.out.println("returning " + favor);
                    //System.out.println(favor);
                    break;
                }
            } else
                break;
        }
        ArrayList<Integer> rtn = new ArrayList<Integer>();
        rtn.add(budget);
        rtn.add(spent);
        rtn.add(favor);

        return rtn;
    }
}

