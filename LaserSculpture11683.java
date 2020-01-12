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

class LaserSculpture11683 {

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		
		int input = reader.nextInt();
		while(input != 0) {
			ArrayList<Integer> block = new ArrayList<Integer>();
			int height = input;
			int width = reader.nextInt();
			
			int answer = 0;
			int higgy = height;
			for (int i = 0; i < width; i++) {
				int hig = reader.nextInt();
				if (hig < higgy) answer = answer + (higgy - hig);
				higgy = hig;
			}
			
//			for(int i = 0; i < height; i++) {
//				block.add(1);
//			}
//			
//			int gaps = 0;
//			for(int index = 0; index < width; index++) {
//				int tower = reader.nextInt();
//				for(int i = 0; i < height; i++) {
//					if (i < tower) {
//						block.set(i, 1);
//					} else {
//						if (block.get(i) == 1) gaps++;
//						block.set(i, 0);
//					}
//				}
//			}
			
//			for(ArrayList<Integer> row : block) {
//				for(int i : row) {
//					System.out.print(i + " ");
//				}
//				System.out.println();
//			}
//			
//			int gaps = 0;
//			for(ArrayList<Integer> row : block) {
//				int last = 1;
//				for(int space : row) {
//					if(last == 1 && space == 0) gaps++;
//					last = space;
//				}
//			}
			System.out.println(answer);
			input = reader.nextInt();
		}
		
	}
}