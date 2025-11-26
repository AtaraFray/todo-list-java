package todoapp;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// בדיקת פונקציות curd
		TaskRepository taskes = new TaskRepository();
		Task task = new Task(5, "finish task", "finisn java task", Status.IN_PROGRESS);
		taskes.addNewTask(task);
	}

}
