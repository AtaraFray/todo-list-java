package todoapp;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskRepository repo = new TaskRepository();
		TaskService service = new TaskService(repo);
//		service.markTaskDone(3);
		service.markTaskDone(5);

	}

}
