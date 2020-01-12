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
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Conformity11286 {

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		HashMap<HashSet, Integer> list = new HashMap<HashSet, Integer>();
				
		int times = reader.nextInt();
		while(times != 0) {
			int highestCount = 0;
			int peopleInHighest = 0;
			
			for (int j=0; j<times; j++) {
				HashSet<Integer> temp = new HashSet<Integer>();
				for(int i = 0; i < 5; i++) {
					temp.add(reader.nextInt());
				}
				int hashCode = temp.hashCode();
				int newAmount = 1+list.getOrDefault(temp, 0);
				list.put(temp, newAmount);
				if (newAmount > highestCount) {
					highestCount = newAmount;
					peopleInHighest = newAmount;
				} else if (newAmount == highestCount) {
					peopleInHighest += newAmount;
				}
			}
			System.out.println(peopleInHighest);
			times = reader.nextInt();
			list.clear();
		}
	}
}
