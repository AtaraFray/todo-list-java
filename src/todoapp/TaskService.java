package todoapp;

import java.security.PublicKey;

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
		public Task findTaskByText (String text) {
			if (text == null || text == "") {
				return  null ;
			}
			String changText = text.toLowerCase();
			    return
				repository.listAll().values().stream()
	            .filter(t -> (t.getTitle() != null && t.getTitle().toLowerCase().contains(changText)) ||
	            		t.getDescription() != null && t.getDescription().toLowerCase().contains(changText))
	            .findFirst()
	            .orElse(null);
			
			
		}
	
	}


