package todoapp;

enum Status{
	NEW, 
	IN_PROGRESS,
	DONE
}
public class Task {
	
	// Fields
	private int Id ;
	private String Title ; 
	private String Description ; 
	private Status status ;
	
	// c-tor
	public Task(int id, String title, String description, Status status) {
		Id = id;
		Title = title;
		Description = description;
		this.status = status;
	}
	
	// getters and setters
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	} 
		
		

	
	
	

}
