package todoapp;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository {

	private Map<Integer, Task> tasksList = new HashMap<>();
	private static String dataFilePath = "data/tasksList.json";

	public TaskRepository() {
//		this.tasksList = loadDataFromFile();

	}
	// ------------------------------------
	// API methods - add , update and delete .
	// ------------------------------------

	public void addNewTask(Task task) {
		tasksList.put(task.getId(), task);
	}
	

	public boolean updateTask(int taskId, Task updatedTask) {
		if (tasksList.containsKey(taskId)) {
			tasksList.put(taskId, updatedTask);
			return true;
		}
		return false;
	}

	
	public Task getTaskById(int taskId) {
		return  tasksList.get(taskId);
	}
}
