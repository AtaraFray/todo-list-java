package todoapp;

import java.io.Console;
import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class TaskRepository {

	private Map<Integer, Task> tasksList = new HashMap<>();
	private static String dataFilePath = "data/tasksList.json";

	public TaskRepository() {
		this.tasksList = loaTtasksFromFile();

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

	public void delete(int taskId) {
		tasksList.remove(taskId);
	}

	public Task getTaskById(int taskId) {
		return tasksList.get(taskId);
	}



//--------------------------------------------------
// file handle method - load data ,
//--------------------------------------------------

//load tasks From File
	public static Map<Integer, Task> loaTtasksFromFile() {

		Map<Integer, Task> data = new HashMap<>();

		File file = new File(dataFilePath);
		
         // בדיקה
		System.out.println(file.getPath());

		if (!file.exists())
			return null;

		try {

			String json = new String(Files.readAllBytes(file.toPath())).trim();
			json = json.substring(1, json.length() - 1).trim();
			String[] jsonObjects = json.split("},");

			for (String object : jsonObjects) {
				
				object = object.replace("{", "").replace("}", "").trim();

				int id = 0;
				String title = "";
				String description = "";
				Status status = null;

				String[] fields = object.split(",");

				for (String field : fields) {

					String[] eachfield = field.split(":", 2);
					String key = eachfield[0].trim().replace("\"", "");
					String value = eachfield[1].trim().replace("\"", "");

					switch (key) {
					case "id":
						id = Integer.parseInt(value);
						break;

					case "title":
						title = value;
						break;

					case "description":
						description = value;
						break;
					case "status":
						status = Status.valueOf(value);
						break;
					}

				}
                
				Task task = new Task(id, title, description, status);
				// בדיקה 
				System.out.println(task.toString());
				data.put(task.getId(), task);
				// בדיקה בקונסול

			}

		} catch (Exception e) {
			System.err.println("Failed to load tasks: " + e.getMessage());

		}

		return data;
	}

}
