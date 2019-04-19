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

class Main {

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		int caseNumber = 1;
		while(!input.equals("*")) {
			
			if(input.equals("Hajj")) {
				System.out.println("Case " + caseNumber + ": Hajj-e-Akbar");
			}
			else {
				System.out.println("Case " + caseNumber + ": Hajj-e-Asghar");
			}
			caseNumber++;
			input = reader.nextLine();
		}
	}
}