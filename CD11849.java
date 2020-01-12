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
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class CD11849 {

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int m = reader.nextInt();
		while(n != 0 && m != 0) {
			//Comment out for extra credit
			ArrayList<Integer> jack = new ArrayList<Integer>();
			ArrayList<Integer> jill = new ArrayList<Integer>();
			
			//Extra Credit
//			int[] jack = new int[n];
//			int[] jill = new int[m];
			int rtn = 0;
			
			//Comment out for extra credit
			for (int i = 0; i < n; i++) {
				jack.add(reader.nextInt());
			}
			for (int i = 0; i < m; i++) {
				jill.add(reader.nextInt());
			}
			
			
//			Extra Credit
//			for (int i = 0; i < n; i++) {
//				jack[i] = reader.nextInt();
//			}
//			for (int i = 0; i < m; i++) {
//				jill[i] = reader.nextInt();
//			}
			
			
			//comment out for extra credit
			for(int i = 0; i < jack.size(); i++) {
				if(jill.contains(jack.get(i))) {
					rtn++;
				}
			}
			
			//Extra credit
//			int j = 0;
//			for(int i = 0; i < n; i++) {
//				for (; j < m; j++) {
//					if (jill[j] >= jack[i]) break;
//				}
//				if (j >= m) break;
//				if (jill[j] == jack[i]) rtn++;
//			}
			
			
			n = reader.nextInt();
			m = reader.nextInt();
			System.out.println(rtn);
		}
	}
}






