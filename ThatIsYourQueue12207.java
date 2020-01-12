import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=244&page=show_problem&problem=3359
class ThatIsYourQueue12207 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int people = reader.nextInt();
        int commands = reader.nextInt();
        int caseCounter = 1;
        while (people != 0 && commands != 0) {
            System.out.println("Case " + caseCounter + ":");
            ArrayDeque<Integer> line = new ArrayDeque<Integer>();
            for (int i = 0; i < Math.min(people, 1000); i++) {
                line.add(i);
            }

            for (int i = 0; i < commands; i++) {
                String command = reader.next();
                if (command.contains("N")) {
                    int temp = line.pop();
                    System.out.println(temp + 1);
                    line.add(temp);
                } else {
                    //Expedite
                    int number = Integer.parseInt(reader.next()) - 1;
                    line.remove(number);
                    line.addFirst(number);
                }
            }

            people = reader.nextInt();
            commands = reader.nextInt();
            caseCounter++;
        }


    }
}
