package controller;

public enum ActionCommand {

	COMMAND_CONVERT("COMMAND_CONVERT", "Convertir");
	
	private String command;
	private String title;
	
	private ActionCommand(String command, String title) {
		this.command = command;
		this.title = title;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getTitle() {
		return title;
	}
}