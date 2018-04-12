package loadbalancer;

import java.util.Random;

public class WorkerThread implements Runnable{
	private WorkRequest currentWorkRequest = null;
	private Random r = new Random();
	private int id;
	
	public WorkerThread(int id) {
		this.id = id;
	}
	
	
	@Override
	public void run() {
		handleRequest();		
	}
	
	public void handleRequest() {
		
		if(currentWorkRequest != null) {	
			System.out.println("Hi! I am " + this.toString()+ " and I am starting the work!");
				while(r.nextInt(10000)!= 9) {
					//do work
				}
				System.out.println(currentWorkRequest.toString() + " finished up!");
				currentWorkRequest = null;
		}
	}
	
	public boolean isAvailable() {
		return currentWorkRequest == null;
	}
	
	public String toString() {
		return "Worker Thread "	+ id;
	}
	
	public void addRequest(WorkRequest wr) {
		currentWorkRequest = wr;
	}

}
