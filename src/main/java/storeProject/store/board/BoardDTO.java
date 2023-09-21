package storeProject.store.board;

public class BoardDTO {
	private int boardID;
    private int inherenceID;
    private String userName;
    private String boardName;
    private String boardYear;
    private String boardMonth;
    private String boardDay;
    private String boardDivide;
    private String boardContentuser;
    
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
	public String getBoardYear() {
		return boardYear;
	}
	public void setBoardYear(String boardYear) {
		this.boardYear = boardYear;
	}
	public String getBoardMonth() {
		return boardMonth;
	}
	public void setBoardMonth(String boardMonth) {
		this.boardMonth = boardMonth;
	}
	public String getBoardDay() {
		return boardDay;
	}
	public void setBoardDay(String boardDay) {
		this.boardDay = boardDay;
	}
	public String getBoardDivide() {
		return boardDivide;
	}
	public void setBoardDivide(String boardDivide) {
		this.boardDivide = boardDivide;
	}
	public String getBoardContentuser() {
		return boardContentuser;
	}
	public void setBoardContentuser(String boardContentuser) {
		this.boardContentuser = boardContentuser;
	}
	public BoardDTO(int boardID, int inherenceID, String userName, String boardName,
			String boardYear, String boardMonth, String boardDay, String boardDivide,
			String boardContentuser) {
		super();
		this.boardID = boardID;
		this.inherenceID = inherenceID;
		this.userName = userName;
		this.boardName = boardName;
		this.boardYear = boardYear;
		this.boardMonth = boardMonth;
		this.boardDay = boardDay;
		this.boardDivide = boardDivide;
		this.boardContentuser = boardContentuser;
	}
    
}
