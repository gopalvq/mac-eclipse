package mypackage;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<String> cars = new LinkedList<String>();
		// Adding
		cars.add("Land Rover");
		cars.add("BMW");
		cars.add("Tesla");
		cars.add("Audi");
		cars.add("Ferrari");
		
		// Size
		int size = cars.size();
		System.out.println("The size of the list is " + size);
		
		// Get
		System.out.println("The item on index 1 is: " + cars.get(1));
		
		// Iteration
		System.out.println("Iteration example");
		for(int i=0; i<size; i++){
			System.out.println("Item on index " + i + " is " +cars.get(i));
		}
		
		// One more way of for loop
		for (String car: cars){
			System.out.println("The item is: " + car);
		}
		
		// Remove
		cars.remove(size - 1);
		
		for (String car: cars){
			System.out.println("The item is: " + car);
		}

	}


}
