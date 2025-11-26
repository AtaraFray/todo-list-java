package todoapp;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskRepository repo = new TaskRepository();
		TaskService service = new TaskService(repo);
		Map<Integer, Task> t = TaskRepository.loadTasksFromFile();
         List<Task> sort = service.sortTaskByStatus();
		for (Task task : sort) {
			task.toString();
		}
	}

}
