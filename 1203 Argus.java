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
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

class Main {
	static class CommandComparator implements Comparator<Command> {
		public int compare(Command c1, Command c2) {
			int out = c1.time-c2.time;
			
			if (out == 0) {
				out = c1.out-c2.out;
			}
			
			return out;
		}
	}
	
	static class Command {
		int out;
		int period;
		int time;
		
		public Command(int out, int period, int time) {
			this.out = out;
			this.period = period;
			this.time = time;
		}
	}
	
	public static void main(String[] args)
	{	
		Scanner reader = new Scanner(System.in);
		PriorityQueue<Command> queue = new PriorityQueue<Command>(1000, new CommandComparator()); 
		String in = reader.next();
		while(!in.equals("#")) {
			int out = reader.nextInt();
			int period = reader.nextInt();
			Command temp = new Command(out, period, period);
			queue.add(temp);
			
			in = reader.next();
		}
		int times = reader.nextInt();
		for(int i = 0; i < times; i++) {
			Command temp = queue.poll();
			System.out.println(temp.out);
			temp.time = temp.time + temp.period;
			queue.add(temp);
		}
		
		
	}
}






