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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

class Main {

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		TreeMap<String, Integer> treeThing = new TreeMap<String,Integer>();
		int times = reader.nextInt();
		reader.nextLine();
		reader.nextLine();
		for(int i = 0; i < times; i++) {
			String tree = reader.nextLine();
			int treeCount = 0;
			while(!tree.isEmpty()) {
				treeThing.put(tree, treeThing.getOrDefault(tree, 0) + 1);
				treeCount++;
				if (reader.hasNextLine())
					tree = reader.nextLine();
				else
					break;
			}
			
			NavigableMap<String, Integer> huntIsBroken = treeThing;
			while(!huntIsBroken.isEmpty()) {
				Map.Entry<String, Integer> value = huntIsBroken.pollFirstEntry();
				System.out.printf("%s %.4f\n", value.getKey(), ((float)value.getValue()/treeCount * 100));
			}
			if (i<times-1)
				System.out.println();
			treeThing.clear();
		}
		
	}
}
