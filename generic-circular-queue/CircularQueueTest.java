import java.util.LinkedList;

/**
 * Test class for the CircularQueue.java, which implements the circular queue abstract 
 * data type with a generic array.
 * 
 * @author Thomas Lonowski
 *
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class CircularQueueTest {
	/**
	 * Private utility method for printing a queue
	 * 
	 * @param queue	-	a queue of generic objects
	 */
	@SuppressWarnings("unused")
	private static <T> void printQueue(CircularQueue<T>[] queue) {
		System.out.format("[%d ", queue[0]);
		for(int i=0; i<queue.length-1; i++) System.out.format("%d, ", queue[i]);
		System.out.format("%d]", queue[queue.length-1]);
	}

	private static void printTestResults(String test, boolean result) {
		System.out.format("Test: %s\n", test);
		if(result) System.out.format("Result: %s\n\n", "pass");
		else 	   System.out.format("Result: %s\n\n", "fail");
	}
	
	/**
	 * Initial: empty queue
	 * Change: none
	 * Result: isEmpty returns true
	 */
	private static boolean createEmptyQueue_QueueIsEmpty() {
		CircularQueue<Integer> q = new CircularQueue();
		return q.isEmpty();
	}

	
	/**
	 * Initial: new queue with values already in it
	 * Change: none
	 * Result: dequeued numbers are expected values
	 */
	private static boolean createNewQueueWithElements_ExpectedElementsArePresent() {
		boolean retVal = false;
		LinkedList<Integer> list = new LinkedList<>();
		list.add(-1);
		list.add(0);
		list.add(1);
		CircularQueue<Integer> q = new CircularQueue(list,0,2);		// Create new queue via parameterized constructor
		
		Integer n1 = q.dequeue();
		Integer n2 = q.dequeue();
		Integer n3 = q.dequeue();
		
		if(n1==-1 && n2==0 && n3==1) retVal = true;
		return retVal;
	}
	
	/**
	 * Initial: empty queue
	 * Change: enqueue one element
	 * Result: element is in the queue
	 */
	private static boolean newQueue_Enqueue1_ExpectedValue() {
		boolean retVal = false;
		CircularQueue<Integer> q = new CircularQueue();	
		
		q.enqueue(0);
		
		if(q.dequeue() == 0) retVal = true;
		return retVal;
	}
	
	/**
	 * Initial: empty queue
	 * Change: enqueue two elements
	 * Result: elements are in the queue
	 */
	private static boolean newQueue_Enqueue2_ExpectedValues() {
		boolean retVal = false;
		CircularQueue<Integer> q = new CircularQueue();	
		
		q.enqueue(1);
		q.enqueue(-1);
		
		if(q.dequeue()==1 && q.dequeue()==-1) retVal = true;
		return retVal;
	}
	
	/**
	 * Initial: one-element queue
	 * Change: dequeue one element
	 * Result: queue is empty
	 */
	private static boolean oneElementQueue_Dequeue1_QueueIsEmpty() {
		boolean retVal = false;
		CircularQueue<Integer> q = new CircularQueue();
		q.enqueue(100);
		
		q.dequeue();
		
		if(q.isEmpty()) retVal = true;
		return retVal;
	}
	
	/**
	 * Initial: one-element queue
	 * Change: dequeue one element
	 * Result: dequeued element is the expected one
	 * @return
	 */
	private static boolean oneElementQueue_Dequeue1_ExpectedValue() {
		boolean retVal = false;
		CircularQueue<Integer> q = new CircularQueue();
		q.enqueue(-1);
		
		if(q.dequeue()==-1) retVal = true;
		return retVal;
	}
	
	/**
	 * Initial: two-element queue
	 * Change: dequeue twice
	 * Result: queue is empty
	 */
	private static boolean twoElementQueue_Dequeue2_QueueIsEmpty() {
		boolean retVal = false;
		CircularQueue<Integer> q = new CircularQueue();	
		q.enqueue(1);
		q.enqueue(5);
		
		q.dequeue();
		q.dequeue();
		
		if(q.isEmpty()) retVal = true;
		return retVal;
	}
	
	/**
	 * Initial: two-element queue
	 * Change: dequeue twice
	 * Result: dequeued elements are the expected ones
	 * @return
	 */
	private static boolean twoElementQueue_Dequeue2_ExpectedValues() {
		boolean retVal = false;
		CircularQueue<Integer> q = new CircularQueue();
		q.enqueue(-1);
		q.enqueue(0);
		
		int n1 = q.dequeue();
		int n2 = q.dequeue();
		
		if(n1==-1 && n2==0) retVal = true;
		return retVal;
	}
	
	public static void main(String[] args) {
		System.out.println("*".repeat(50));

		// Test 1
		if(createEmptyQueue_QueueIsEmpty()) printTestResults("createEmptyQueue_QueueIsEmpty", true);
		else printTestResults("createEmptyQueue_QueueIsEmpty", false);
		
		// Test 2
		if(createNewQueueWithElements_ExpectedElementsArePresent()) printTestResults("createNewQueueWithElements_ExpectedElementsArePresent", true);
		else printTestResults("createNewQueueWithElements_ExpectedElementsArePresent", false);
		
		// Test 3
		if(newQueue_Enqueue1_ExpectedValue()) printTestResults("newQueue_Enqueue1_ExpectedValue", true);
		else printTestResults("newQueue_Enqueue1_ExpectedValue", false);
		
		// Test 4
		if(newQueue_Enqueue2_ExpectedValues()) printTestResults("newQueue_Enqueue2_ExpectedValues", true);
		else printTestResults("newQueue_Enqueue2_ExpectedValues", false);
		
		// Test 5
		if(oneElementQueue_Dequeue1_QueueIsEmpty()) printTestResults("oneElementQueue_Dequeue1_QueueIsEmpty", true);
		else printTestResults("oneElementQueue_Dequeue1_QueueIsEmpty", false);
		
		// Test 6
		if(oneElementQueue_Dequeue1_ExpectedValue()) printTestResults("oneElementQueue_Dequeue1_ExpectedValue", true);
		else printTestResults("oneElementQueue_Dequeue1_ExpectedValue", false);
		
		// Test 7
		if(twoElementQueue_Dequeue2_QueueIsEmpty()) printTestResults("twoElementQueue_Dequeue2_QueueIsEmpty", true);
		else printTestResults("twoElementQueue_Dequeue2_QueueIsEmpty", false);
		
		// Test 8
		if(twoElementQueue_Dequeue2_ExpectedValues()) printTestResults("twoElementQueue_Dequeue2_ExpectedValues", true);
		else printTestResults("twoElementQueue_Dequeue2_ExpectedValues", false);
		
		System.out.println("*".repeat(50));
	}
}
