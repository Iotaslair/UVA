import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=278&page=show_problem&problem=3778
class ArmyBuddies12356 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int s = reader.nextInt();
        int b = reader.nextInt();
        while (s != 0 && b != 0) {
//			System.out.println("* *");
            int[] left = new int[s];
            int[] right = new int[s];

            left[0] = -1;
            right[right.length - 1] = -1;

            //Setting up the left array
            for (int i = 1; i < s; i++) {
                left[i] = i - 1;
            }
//			printArray(left);
            //Setting up the right array
            for (int i = 0; i < s - 1; i++) {
                right[i] = i + 1;
            }

//			printArray(right);

            for (int report = 0; report < b; report++) {
                int l = reader.nextInt() - 1;
                int r = reader.nextInt() - 1;

                int lOfKin = left[l];
                int rOfKin = right[r];

                if (lOfKin >= 0 && r >= 0)
                    right[lOfKin] = right[r];

                if (rOfKin >= 0 && l >= 0)
                    left[rOfKin] = left[l];

//				printArray(left);
//				printArray(right);
                printBuddies(lOfKin, rOfKin);
            }

            System.out.println("-");

            //Don't remove, grabs s and b for next round (Also used to check when to end the program)
            s = reader.nextInt();
            b = reader.nextInt();
        }
    }

    public static void printArray(int[] hi) {
        String output = "[";
        for (int i : hi) {
            output += i + ", ";
        }
        output += "]";
        System.out.println(output);
    }

    public static void printBuddies(int l, int r) {
        String charl = String.valueOf(l + 1);
        if (l == -1)
            charl = "*";

        String charr = String.valueOf(r + 1);
        if (r == -1)
            charr = "*";

        System.out.println(charl + " " + charr);
    }
}
