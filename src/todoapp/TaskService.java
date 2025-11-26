package todoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		} else {
			throw new RuntimeException("Task not found");
		}
	}

	// find task by text from user
	public Task findTaskByText(String text) {
		if (text == null || text.isEmpty()) {
			return null;
		}
		String changText = text.toLowerCase();
		return repository.listAll().values().stream()
				.filter(t -> (t.getTitle() != null && t.getTitle().toLowerCase().contains(changText))
						|| t.getDescription() != null && t.getDescription().toLowerCase().contains(changText))
				.findFirst().orElse(null);

	}

	// sort all tasks by status when new first ...
	public List<Task> sortTaskByStatus() {
		TaskRepository repository = new TaskRepository();
		Map<Integer, Task> tasks = repository.listAll();
		List<Task> sortList = new ArrayList<>();
		for (Task task : tasks.values()) {
			sortList.add(task);
		}
		sortList.sort((t1, t2) -> t1.getStatus().compareTo(t2.getStatus()));
		return sortList;
	}

}
