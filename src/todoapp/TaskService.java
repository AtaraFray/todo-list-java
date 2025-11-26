package todoapp;

public class TaskService {

	private final TaskRepository repository;

	public TaskService(TaskRepository repository) {
		this.repository = repository;
	}

	// mark task status done
	public void markTaskDone(int taskId) {
		Task task = this.repository.getTaskById(taskId);
		if (task != null) {
			task.setStatus(Status.DONE);
			this.repository.updateTask(taskId, task);
		}
		else {
			throw new RuntimeException("Task not found");
		}
		
		

	}

}
