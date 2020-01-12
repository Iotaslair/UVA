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

class Recycling154 {

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		ArrayList<HashMap<String, String>> cities = new ArrayList<HashMap<String, String>>();
		
		
		while(true) {
			cities.clear();
			String input = reader.nextLine();
			if(input.equals("#"))
				return;
			while(!input.substring(0, 1).equals("e")) {
				
				String[] chars = input.split(",");
				HashMap<String,String> temp = new HashMap<String,String>();
				for(String x : chars) {
					temp.put(x.substring(0, 1), x.substring(2,3));
				}
				cities.add(temp);
				input = reader.nextLine();
			}
			//System.out.println("Out of parsing");
			int bestScore = -1;
			int bestCity = -1;
			
			for (int city=0; city<cities.size(); city++) {
				int score = 5*cities.size();
				for (int otherCity=0; otherCity<cities.size(); otherCity++) {
					String[] keys = {"r", "o", "y", "g", "b"};
					for (String key : keys) {
						if (!cities.get(city).get(key).equals(cities.get(otherCity).get(key))) {
							score -= 1;
							/*
							System.out.println("City # " + city);
							System.out.println("Key " + key);
							System.out.println("Value " +  cities.get(city).get(key));
							
							
							System.out.println();
							System.out.println("City # " + otherCity);
							System.out.println("Key " + key);
							System.out.println("Value " +  cities.get(otherCity).get(key));
							System.out.println();
							System.out.println();
							*/
						}
							
					}
				}
				//System.out.println("Score for city # " + city + " " +  score);
				//System.out.println("Going to next city");
				if (score > bestScore) {
					bestScore = score;
					bestCity = city;
				}
			}
			
			System.out.println(bestCity + 1);
		}
	}
}