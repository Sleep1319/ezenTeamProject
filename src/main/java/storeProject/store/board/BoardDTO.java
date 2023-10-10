package storeProject.store.board;

public class BoardDTO {
	private int boardID;
    private int inherenceID;
    private String userName;
    private String boardName;
    private String boardTime;
    private String boardDivide;
    private String boardContents;

	public int getBoardID() {
		return boardID;
	}

	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}

	public int getInherenceID() {
		return inherenceID;
	}

	public void setInherenceID(int inherenceID) {
		this.inherenceID = inherenceID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getBoardTime() {
		return boardTime;
	}

	public void setBoardTime(String boardTime) {
		this.boardTime = boardTime;
	}

	public String getBoardDivide() {
		return boardDivide;
	}

	public void setBoardDivide(String boardDivide) {
		this.boardDivide = boardDivide;
	}

	public String getBoardContents() {
		return boardContents;
	}

	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}

	public BoardDTO(int boardID, int inherenceID, String userName, String boardName, String boardTime, String boardDivide, String boardContents) {
		this.boardID = boardID;
		this.inherenceID = inherenceID;
		this.userName = userName;
		this.boardName = boardName;
		this.boardTime = boardTime;
		this.boardDivide = boardDivide;
		this.boardContents = boardContents;
	}
}
