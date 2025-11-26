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
		this.tasksList = loadTasksFromFile();

	}
	// ------------------------------------
	// API methods - add , update and delete .
	// ------------------------------------

	public void addNewTask(Task task) {
		tasksList.put(task.getId(), task);
		saveTasksToFile();
	}

	public boolean updateTask(int taskId, Task updatedTask) {
		if (tasksList.containsKey(taskId)) {
			tasksList.put(taskId, updatedTask);
			saveTasksToFile();
			return true;
		}
		return false;
	}

	public void delete(int taskId) {
		Task task = getTaskById(taskId);
		if (task != null) {
			tasksList.remove(taskId);
			saveTasksToFile();
		}

	}

	public Task getTaskById(int taskId) {
		return tasksList.get(taskId);
	}

//--------------------------------------------------
// file handle method - load data ,
//--------------------------------------------------

//load tasks From File
	public static Map<Integer, Task> loadTasksFromFile() {

		Map<Integer, Task> data = new HashMap<>();

		File file = new File(dataFilePath);

		if (!file.exists())
			return null;

		try {

			String json = new String(Files.readAllBytes(file.toPath())).trim();
			json = json.substring(1, json.length() - 1).trim();

			if (json.isEmpty() || json.equals("[]")) {
				return data;
			}
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
				data.put(task.getId(), task);

			}

		} catch (Exception e) {
			System.err.println("Failed to load tasks: " + e.getMessage());

		}

		return data;
	}

	// save tasks to file
	private void saveTasksToFile() {
		try {
			StringBuilder json = new StringBuilder();
			json.append("[");
			// מעבר של כל אוביקט ושדותיו
			boolean firstObject = true;

			for (Task task : tasksList.values()) {
				if (!firstObject)
					json.append(",");

				firstObject = false;

				json.append("{").append("\"id\":").append(task.getId()).append(",").append("\"title\":\"")
						.append(task.getTitle()).append("\",").append("\"description\":\"")
						.append(task.getDescription()).append("\",").append("\"status\":\"").append(task.getStatus())
						.append("\"").append("}");

			}
			json.append("]");
			Files.write(new File(dataFilePath).toPath(), json.toString().getBytes());

		} catch (Exception e) {
			System.err.println("Failed to write tasks: " + e.getMessage());
		}

	}

}
