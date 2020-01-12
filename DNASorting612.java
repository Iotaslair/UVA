import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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

class DNASorting612 {
	static class EntropyComp implements Comparator<String> {
		public EntropyComp() {}
		
		public int compare(String o1, String o2) {
			int entropy1 = calcValue(o1);
			int entropy2 = calcValue(o2);
			
			return entropy1-entropy2;
		}
		
		public static int calcValue(String s) {
			char[] c = s.toCharArray();
			
			int entropy = 0;
			
			for(int i = 0; i< c.length - 1; i++) {
				for(int j = i; j < c.length - 1; j++) {
					if(c[i] > c[j + 1]) entropy++;
				}
			}
			
			return entropy;
		}
	}
	
	public static void main(String[] args)
	{	
		Scanner reader = new Scanner(System.in);
		
		int datasets = reader.nextInt();
		
		for(int i = 0; i < datasets; i++) {
			int length = reader.nextInt();
			int numStrings = reader.nextInt();
			
			ArrayList<String> al = new ArrayList<String>();
			for(int j = 0; j < numStrings; j++) {
				al.add(reader.next());
			}
			
			Collections.sort(al, new DNASorting612.EntropyComp());
			
			for (int s=0; s<al.size(); s++) {
				System.out.println(al.get(s));
			}
			
			if (i<datasets-1) System.out.println();
		}
	}
}






