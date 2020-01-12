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

class Main {

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		PriorityQueue<String> queue = new PriorityQueue<String>();
		HashSet<String> set = new HashSet<String>();
		while(reader.hasNext()) {
			String line = reader.nextLine();
			if(line.equals("0"))
				break;
			line = line.replaceAll("[^a-zA-Z ]", " ");
			line = line.toLowerCase();
			String[] words = line.split(" +");
			for(String word : words) {
				if(set.contains(word)) {
					
				}
				else
				{
					set.add(word);
					queue.add(word);
				}
			}
			
		}
		while(!queue.isEmpty()) {
			String s = queue.poll();
			if (s.length() > 0)
				System.out.println(s);
		}
		
		
	}
}