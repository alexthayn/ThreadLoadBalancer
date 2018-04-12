package loadbalancer;

import java.util.LinkedList;
import java.util.Queue;

public class LoadBalancer_WorkerThread implements Runnable{
	private Queue<WorkRequest> incomingRequests = new LinkedList<>();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
		}
	}
	
	public void handleRequest() {
		
	}

}
