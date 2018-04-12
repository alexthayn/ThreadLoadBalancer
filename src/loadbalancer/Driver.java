package loadbalancer;


public class Driver {
		
	public static void main(String[] args) {
		LoadBalancer loadBalancerThread = new LoadBalancer(500000);
		Thread loadBalancer = new Thread(loadBalancerThread);
		
		
		
		//Create the requests
		for(int i = 0; i < 1000000; i++) {
			loadBalancerThread.makeRequest(new WorkRequest(i));
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			System.out.println("sleep failed");
		}
		loadBalancer.start();
		//LB_ListenerThread.doWork(requests.indexOf(i));
		
		//Test WorkerThread it works!
		/*Thread worker = new Thread(new WorkerThread());
		worker.start();*/
		try {
			loadBalancer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
