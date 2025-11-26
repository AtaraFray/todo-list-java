package todoapp;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// בדיקת פונקציות curd
		TaskRepository taskes = new TaskRepository();
		Task task = new Task(5, "finish task", "finisn java task", Status.DONE);
		taskes.addNewTask(task);
		System.out.println(taskes.updateTask(5, task));
//		taskes.delete(5);
		taskes.saveTasksToFile();
		
	}

}
