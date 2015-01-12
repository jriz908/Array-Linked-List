package all;

class Item {
	String name;
	int next;
	public Item(String name, int next) {
		this.name = name;
		this.next = next;
	}
	public String toString() {
		return "(" + name + "," + next + ")";
	}
}

public class ArrayLL {

	private Item[] all;
	private int numItems;
	private int front;
	private int[] avail;
	private int numAvail;

	// Constructor, initializes all data fields, to represent 
	// an empty Item array linked list of length maxItems
	public ArrayLL(int maxItems) {

		all = new Item[maxItems];
		numItems = 0;
		front = -1;
		avail = new int[maxItems];
		numAvail=maxItems;
		
		for(int i=0; i<maxItems; i++){
			avail[i] = i;
		}
		

	}

	// Adds a name to the front of this array linked list, in worst case O(1) time,
	// and returns true.
	// Returns false if the array is full, in O(1) time
	public boolean addFront(String name){
		

		if(numAvail == 0)
			return false;
		
		int a = avail[numAvail-1];
		
		all[a] = new Item(name, front);
		avail[numAvail-1] = -1;
		numItems++;
		front = a;
		numAvail--;
		return true;
		
			
		// COMPLETE THIS METHOD
		
		// THE NEXT LINE IS ONLY A PLACEHOLDER TO MAKE THE PROGRAM COMPILE 
		// YOU WILL NEED TO CHANGE IT APPROPRIATELY IN YOUR IMPLEMENTATION

		

	}

	// Deletes the name that is at the front this array linked list, in worst case O(1) time,
	// and returns the deleted name
	// Returns null if the list is empty, in O(1) time
	public String deleteFront() {

		// COMPLETE THIS METHOD

		// THE NEXT LINE IS ONLY A PLACEHOLDER TO MAKE THE PROGRAM COMPILE 
		// YOU WILL NEED TO CHANGE IT APPROPRIATELY IN YOUR IMPLEMENTATION
		if(numItems == 0)
		return null;
		
		else{
			String a = all[front].name;
			int newFront = all[front].next;
			numItems--;
			numAvail++;
			avail[numAvail-1] = front;
			all[front].name = null;
			all[front].next = -1;
			front = newFront;
			return a;
			
			
		}
	}

	// Deletes the given name from this array linked list, and returns true.
	// Returns false if the name is not in the list.
	// Note: If there are n active items in the list, then this method must run in
	// worst case O(n) time, i.e. time must not depend on the length of the all array
	// (since the array might include available space not filled by active items)
	// Also, avail array should be accessed/updated in O(1) time
	public boolean delete(String name) {

		if(numItems == 0)
			return false;
		
		Item temp = all[front];
		
		
		
		if(temp.name.equals(name)){
			int newFront = all[front].next;
			numItems--;
			numAvail++;
			avail[numAvail-1] = front;
			all[front].name = null;
			all[front].next = -1;
			front = newFront;
			return true;
		}
		
		temp = all[all[front].next];
		Item prev = all[front];
		
		
		
		
			while(temp.next!=-1){
				if(temp.name.equals(name)){
					numItems--;
					numAvail++;
					avail[numAvail-1] = prev.next;
					prev.next = temp.next;
					return true;
				}
				prev = temp;
				temp = all[temp.next];
			}
			
			if(temp.name.equals(name)){
				numItems--;
				numAvail++;
				avail[numAvail-1] = prev.next;
				prev.next = -1;
				return true;
			}
		
				
		
		
		// COMPLETE THIS METHOD

		// THE NEXT LINE IS ONLY A PLACEHOLDER TO MAKE THE PROGRAM COMPILE
		// YOU WILL NEED TO CHANGE IT APPROPRIATELY IN YOUR IMPLEMENTATION

		return false;	
	}

	// Checks if the given name is in this array linked list
	// Note: If there are n items in the list, then this method must run in
	// worst case O(n) time, i.e. time does not depend on the length of the all array.
	public boolean contains(String name) {

		if(numItems == 0)
			return false;
		
		Item Temp = all[front];
		
		while(Temp.next!=-1){
			if(Temp.name.equals(name))
				return true;
			
			Temp = all[Temp.next];
		}
		
		if(Temp.name.equals(name))
			return true;
		
		return false;
		
		
		// COMPLETE THIS METHOD

		// THE NEXT LINE IS ONLY A PLACEHOLDER TO MAKE THE PROGRAM COMPILE
		// YOU WILL NEED TO CHANGE IT APPROPRIATELY IN YOUR IMPLEMENTATION

		
	}

	// Prints the items in this array linked list in sequence from first to last,
	// in worst case O(n) time where n is the number of items in the linked list
	// The list should be printed in a single line, separated by commas
	// Example: earth,mercury,venus
	// Make sure there aren't any extra commas in your output.
	// If the list is empty, you may print either nothing, or an empty string
	public void printList() {
		
		if(numItems==0)
			return;
		
		Item temp = all[front];
		
		while(temp.next!=-1){
			System.out.print(temp.name + ",");
			
			temp = all[temp.next];
		}
		
			System.out.print(temp.name);

		// COMPLETE THIS METHOD
	}

	// Prints all the entries in the main array (including unused spaces)
	// You may fill in this method and use it for debugging
	// This method WILL NOT be graded
	public void printArray() {

	}

	// Prints all the entries in the avail array that correspond to
	// available spaces in the main array
	// You may fill in this method and use it for debugging
	// This method WILL NOT be graded
	public void printAvailableSpots() {
	}
}
