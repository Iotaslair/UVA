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

// https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=229&page=show_problem&problem=3146
class ICanGuessTheDataStructure11995 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Deque<Integer> stack = new LinkedList<Integer>();
        Deque<Integer> queue = new LinkedList<Integer>();
        PriorityQueue<Integer> pekeq = new PriorityQueue<Integer>();
        //int commands = reader.nextInt();
        while (reader.hasNext()) {
            int commands = reader.nextInt();
            boolean canS = true;
            boolean canQ = true;
            boolean canP = true;
            for (int i = 0; i < commands; i++) {
                int type = reader.nextInt();
                int val = reader.nextInt();

                if (type == 1) {
                    stack.addFirst(val);
                    queue.addLast(val);
                    pekeq.add(-val);
                } else {
                    int so = stack.removeFirst();
                    int qo = queue.removeFirst();
                    int po = -pekeq.poll();

                    if (val != so)
                        canS = false;
                    if (val != qo)
                        canQ = false;
                    if (val != po)
                        canP = false;
                }
            }

//			System.out.println("Stack: " + canS);
//			System.out.println("Queue: " + canQ);
//			System.out.println("PriorityQueue: " + canP);


            if ((canS && canQ) || (canQ && canP) || (canS && canP)) {
                System.out.println("not sure");
            } else if (canS) {
                System.out.println("stack");
            } else if (canQ) {
                System.out.println("queue");
            } else if (canP) {
                System.out.println("priority queue");
            } else {
                System.out.println("impossible");
            }
            stack.clear();
            queue.clear();
            pekeq.clear();
        }
    }
}


//static class CommandComparator implements Comparator<Command> {
//	public int compare(Command c1, Command c2) {
//		int out = c1.time-c2.time;
//		
//		if (out == 0) {
//			out = c1.out-c2.out;
//		}
//		
//		return out;
//	}
//}
//
//static class Command {
//	int out;
//	int period;
//	int time;
//	
//	public Command(int out, int period, int time) {
//		this.out = out;
//		this.period = period;
//		this.time = time;
//	}
//}






