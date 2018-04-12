package loadbalancer;

public class WorkRequest {
	private int id;
	
	public WorkRequest(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		return "Work Request " + id;
	}
}
