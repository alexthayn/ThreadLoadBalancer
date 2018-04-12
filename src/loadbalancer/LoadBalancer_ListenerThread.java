package loadbalancer;

import java.util.LinkedList;
import java.util.Queue;

public class LoadBalancer_ListenerThread implements Runnable{
	Queue<WorkRequest> queue1 = new LinkedList<>();
	Queue<WorkRequest> queue2 = new LinkedList<>();
	Queue<WorkRequest> incomingRequests = new LinkedList<>();
	
	 
	
	
	public void run() {
		while(true) {
			if(!incomingRequests.isEmpty())
			{
				
			}
				
		}
	}
	
	public void newRequest(WorkRequest request) {
		incomingRequests.add(request);
	}
	
	private void handleRequest() {
		
	}
}
