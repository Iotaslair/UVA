import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class TheLonesomeCargoDistributor10172 {

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		int set = reader.nextInt();
		for(int i = 0; i < set; i++) {
			int timer = 0;
			int n = reader.nextInt();
			int s = reader.nextInt();
			int q = reader.nextInt();
			int numberOfBoxes = 0;
			Queue<Integer>[] world = new LinkedList[n];
			//Setting up the world
			for(int j = 0; j < n; j++) {
				world[j] = new LinkedList<Integer>();
				int containers = reader.nextInt();
				for(int k = 0; k < containers; k++) {
					world[j].add(reader.nextInt());
					numberOfBoxes++;
				}
			}
			
			//Used as a stack
			Deque<Integer> cart = new ArrayDeque<Integer>();
			int currentPlatform = 0;
			while (numberOfBoxes > 0) {
				
				// Offload step
				while (cart.size() > 0) {
					
					int destination = cart.pop();
					if (destination-1 == currentPlatform) {
						numberOfBoxes--;
					}
					else if (world[currentPlatform].size() < q) {
						world[currentPlatform].add(destination);
					}
					else {
						cart.push(destination);
						break;
					}
					
					timer++;
				}
				
				// Load step
				while (world[currentPlatform].size() > 0 && cart.size() < s) {
					cart.push(world[currentPlatform].remove());
					timer++;
				}
				
				if (numberOfBoxes > 0)
					timer += 2;
				currentPlatform = (currentPlatform+1) % world.length;
			}
			
			
			System.out.println(timer);
		}
	}
}
