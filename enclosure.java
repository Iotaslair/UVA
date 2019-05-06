//doesn't work

import java.util.*;

public class enclosure{
	public static void main (String[] args){
		Scanner reader = new Scanner(System.in);
		int trees = reader.nextInt();
		int control = reader.nextInt();
		ArrayList<ArrayList<Integer>> myPoints = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> allPoints = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> notOwn = new ArrayList<ArrrayList<Integer>>();
		//input
		for(int i = 0; i < control; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(reader.nextInt());
			temp.add(reader.nextInt());
			myPoints.add(temp);
			allPoints.add(temp);
		}
		for(int i = 0; i < trees-control; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(reader.nextInt());
			temp.add(reader.nextInt());
			allPoints.add(temp);
			notOwn.add(temp);
		}

		//Get middle
		int midX = 0;
		int midY = 0;
		for(ArrayList<Integer> x : myPoints){
			midX += x.get(0);
			midY += x.get(1);
		}
		midX = midX / myPoints;
		midY = midY / myPoints;
		ArrayList<Integer> middlePoint = new ArrayList<Integer>();
		middlePoint.add(midX);
		middlePoint.add(midY);

		//Make Triangles
		ArrayList<ArrayList<ArrayList<Integer>>> triangles = new ArrayList<ArrayList<ArrayList<Integer>>>();
		//Loops through points
		for(int i = 0; i < myPoints.length(); i++){
			ArrayList<ArrayList<Integer>> tri = new ArrayList<ArrayList<Integer>>();
			tri.add(middlePoint);
			tri.add(i);
			try{
				tri.add(i+1);
			} catch(Exception e){
				//if at the end then grab the last point
				tri.add(0);
			}
			triangles.add(tri);
		}
		//If point is inside

		//Loop through notOwn
		newPoint:
		for(int i = 0; i < notOwn.length(); i++){
			//Loop through triangles
			for(int j = 0; j < triangles.length(); j++){
				//if point is in triangle then skip that point
				if(insideTriangle(triangles.get(j), notOwn.get(i)) == false)
					break newPoint;
				//Insert between two points
				int currentIndex = 0;
				ArrayList<Integer> currentPoint = myPoints.get(currentIndex);
				int oppositeIndex = Math.floor(currentIndex + (myPoints.length())) % myPoints.length()
				ArrayList<Integer> oppositePoint = myPoints.get(oppositeIndex);
				ArrayList<Integer> validIndices = new ArrayList<Integer>();
				//filling up validIndicies
				for(int i = 0; i < myPoints.size(); i++){
					validIndicies.add(i);
				}
				//find out slope 
				float slope = (currentPoint.get(0) - oppositePoint.get(0)) / (currentPoint.get(1) - oppositePoint.get(1));
				//make equation
				int b = currentPoint.get(1) - slope * currentPoint.get(0);
				//yOnLine
				int y = slope * notOwn.get(0) + b;
				//find out if above or below
				//if below
				if(y < notOwn.get(1)){
					//drop higher
					for(int k = oppositePoint + 1; k < myPoints.size(); k++){
						validIndices.remove(k);
					}
				}
				else //if higher
				{
					//drop lower
					for(int k = currentIndex + 1; k < oppositeIndex; k++){
						validIndices.remove(k);
					}
				}


			}
		}




	}

	boolean insideTriangle(ArrayList<ArrayList<Integer>> triangle, ArrayList<Integer> point) {
		ArrayList<Integer> center = getMiddle(triangle);

		float slope;
		int b;

		ArrayList<Integer> point1;
		ArrayList<Integer> point2;

		int yOnLine;

		// Line 1
		point1 = triangle.get(0);
		point2 = triangle.get(1);

		if (point1.get(0) != point2.get(0)) {
			slope = (point1.get(0)-point2.get(0))/(point1.get(1)-point2.get(1));
			b = point1.get(1)-slope*point1.get(0);

			yOnLine = slope*point.get(0)+b;


			if (yOnLine > center.get(1)) {
				if (point.get(1) > yOnLine)
					return False;
			} else {
				if (point.get(1) < yOnLine)
					return False;
			}
		} else {
			if (point1.get(0) > center.get(0)) {
				if (point.get(0) > point1.get(0))
					return False;
			} else {
				if (point.get(0) < point1.get(0))
					return False;
			}
		}

		// Line 2
		point1 = triangle.get(1);
		point2 = triangle.get(2);

		if (point1.get(0) != point2.get(0)) {
			slope = (point1.get(0)-point2.get(0))/(point1.get(1)-point2.get(1));
			b = point1.get(1)-slope*point1.get(0);

			yOnLine = slope*point.get(0)+b;

			if (yOnLine > center.get(1)) {
				if (point.get(1) > yOnLine)
					return False;
			} else {
				if (point.get(1) < yOnLine)
					return False;
			}
		} else {
			if (point1.get(0) > center.get(0)) {
				if (point.get(0) > point1.get(0))
					return False;
			} else {
				if (point.get(0) < point1.get(0))
					return False;
			}
		}

		// Line 3
		point1 = triangle.get(2);
		point2 = triangle.get(0);

		if (point1.get(0) != point2.get(0)) {
			slope = (point1.get(0)-point2.get(0))/(point1.get(1)-point2.get(1));
			b = point1.get(1)-slope*point1.get(0);

			yOnLine = slope*point.get(0)+b;

			if (yOnLine > center.get(1)) {
				if (point.get(1) > yOnLine)
					return False;
			} else {
				if (point.get(1) < yOnLine)
					return False;
			}
		} else {
			if (point1.get(0) > center.get(0)) {
				if (point.get(0) > point1.get(0))
					return False;
			} else {
				if (point.get(0) < point1.get(0))
					return False;
			}
		}

		return true;
	}

	ArrayList<Integer> getMiddle(ArrayList<ArrayList<Integer>> shape) {
		int xs = 0;
		int ys = 0;

		for (int point=0; point<shape.length(); point++) {
			xs += shape.get(point).get(0);
			ys += shape.get(point).get(1);
		}

		xs /= shape.length();
		ys /= shape.length();

		return new ArrayList<Integer>([xs, ys]);
	}
}



