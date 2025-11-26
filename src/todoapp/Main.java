package todoapp;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void ShowAllTasks(TaskService service) {
		for (Task task : service.sortTaskByStatus()) {
			System.out.println(task.toString());
		}
	}

	public static void addNewTask(Task newTask, TaskRepository taskRepository) {
		taskRepository.addNewTask(newTask);
	}

	public static void updateTask(Task updateTask, TaskRepository taskRepository) {
		taskRepository.updateTask(updateTask.getId(), updateTask);
	}

	public static void deleteTask(int taskId ,TaskRepository taskRepository ) {
		taskRepository.delete(taskId);
	}
	
	public static Task searchTask(String text , TaskService service) {
		return service.findTaskByText(text);
	}
	public static void main(String[] args) {

		// ------------------------------------
		// Basic UI
		// ------------------------------------
		System.out.println("                  ******************");
		System.out.println("                  My Tasks Management");
		System.out.println("                  ******************");

		// Show all tasks
		TaskRepository taskRepository = new TaskRepository();
		TaskService service = new TaskService(taskRepository);
		ShowAllTasks(service);

		// Add new task form
		Scanner scanner = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.println("              Add task form             ");
		System.out.println("enter taskId");
		int taskId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("enter task title");
		String title = scanner.next();
		System.out.println("enter description ");
		scanner.nextLine();
		String description = scanner.nextLine();

		System.out.println("---------------------------------------");
		Task newTask = new Task(taskId, title, description);
		addNewTask(newTask, taskRepository);

		// edit task form
		System.out.println("---------------------------------------");
		System.out.println("              Update task form             ");
		System.out.println("enter taskId");
		int taskIdToEdit = scanner.nextInt();
		scanner.nextLine();
		System.out.println("enter task title");
		String titleToEdit = scanner.next();
		System.out.println("enter description ");
		scanner.nextLine();
		String descriptionToEdit = scanner.nextLine();

		System.out.println("---------------------------------------");
		Task UpdateTask = new Task(taskIdToEdit, titleToEdit, descriptionToEdit);
		addNewTask(newTask, taskRepository);
		// delete task
		System.out.println("enter task to delete");
		int taskIdToDelete = scanner.nextInt();
		deleteTask(taskIdToDelete , taskRepository);
		
	    // search task 
		System.out.println("enter description or title");
		String textToSearch = scanner.nextLine();
		searchTask(textToSearch,service);
		
		
		
	}
 

}
