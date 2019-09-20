import java.util.ArrayDeque;
import java.util.Scanner;

public class MinQueue<T extends Comparable> {
	ArrayDeque<T> backing;
	ArrayDeque<T> minDeque;

	public MinQueue() {
		backing = new ArrayDeque<T>();
		minDeque = new ArrayDeque<T>();
	}
	
	public int size() {
		return backing.size();
	}

	public boolean isEmpty() {
		return backing.isEmpty();
	}

	public void add(T e) {
		int s = minDeque.size();
		for (int i=0; i<s; i++) {
			if (e.compareTo(minDeque.peekFirst()) >= 0) {
				break;
			}
			minDeque.removeFirst();
		}
		minDeque.addFirst(e);
		
		//if (minDeque.size() == 0) minDeque.addFirst(e);
		
		backing.addFirst(e);
	}
	
	public T remove() {
		if (backing.peekLast().compareTo(minDeque.peekLast()) == 0) minDeque.removeLast();
		
		return backing.removeLast();
	}
	
	public T min() {
		return minDeque.getLast();
	}
	
	public T peke() {
		return backing.peekLast();
	}
	
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		int testCases = reader.nextInt();
		
		for(int i = 0; i < testCases; i++) {
			int printJobs = reader.nextInt();
			int myPos = reader.nextInt();
			
			MinQueue<Integer> queue = new MinQueue<Integer>();
			for(int j = 0; j < printJobs; j++) {
				queue.add(-1 * reader.nextInt());
			}
						
			int timer = 0;
			
			while(true) {
				int temp = queue.peke();
				myPos--;
				if(queue.size() == 0 || queue.min() == temp) {
					queue.remove();
					timer++;
					if (myPos < 0)
						break;
				} else {
					if(myPos < 0) {
						myPos = queue.size()-1;
					}
					queue.remove();
					queue.add(temp);
				}
			}
			
			
			System.out.println(timer);
			
		}
	}
}
