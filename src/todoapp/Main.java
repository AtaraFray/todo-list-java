package todoapp;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskRepository repo = new TaskRepository();
		TaskService service = new TaskService(repo);
		Task t = service.findTaskByText("finish task");
		if (t != null) {
			t.toString();
		}
	}

}
