package loadbalancer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LoadBalancer implements Runnable {
	//private LoadBalancer_ListenerThread LB_ListenerThread = new LoadBalancer_ListenerThread();
	private ArrayList<Thread> workers = new ArrayList<>();
	private ArrayList<WorkerThread> workerThreads= new ArrayList<>(); 
	private Queue<WorkRequest> incomingRequests = new LinkedList<>();
	private int nextWorker;
	
	public LoadBalancer(int numOfWorkers) {
		nextWorker = 0;
		for(int i = 0; i<numOfWorkers; i++) {
			workerThreads.add(new WorkerThread(i));
			workers.add(new Thread(workerThreads.get(i)));
		}
	}
	
	//Add incoming requests to the queue
	public void makeRequest(WorkRequest request) {
		incomingRequests.add(request);
	}

	//this function handles all the requests and sends them to the worker threads
	private void handleRequests() {
		while(true) {
			while(!incomingRequests.isEmpty())
			{
				if(workers.get(nextWorker).isAlive()) {
					try {
						workers.get(nextWorker).join();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setupThread(nextWorker);
				
				workerThreads.get(nextWorker).addRequest(incomingRequests.poll());
				workers.get(nextWorker).start();
	
				incrementNextWorker();
			}
			if(incomingRequests.isEmpty())
				break;
		}
	}

	public void run() {
		handleRequests();
	}
	
	private void setupThread(int i) {
			workers.set(i, new Thread(workerThreads.get(i)));	
	}
	
	private void incrementNextWorker() {
		int numOfWorkers = workers.size();
		if(nextWorker == (numOfWorkers-1))
			nextWorker = 0;
		else
			nextWorker++;
	}

}
