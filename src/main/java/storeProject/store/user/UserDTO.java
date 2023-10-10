package storeProject.store.user;

import java.util.Date;


// 뭐요 뭐 요건 그냥 값들 받아서 DAO setStrin()이나 뭐 암튼 pstmt에 쓰려고 있는겨
public class UserDTO {
	private int inherenceIDuuID;
	private String userID;
	private String userEmail;
	private String userPassword;
	private String userName;
	private String userBirth;
	private String userPhone;
	private String userPost;
	private String userAddr;
	private String addr_detail;
//	private Date userBirth;
	
	public int getInherenceIDuuID() {
		return inherenceIDuuID;
	}
	public void setInherenceIDuuID(int inherenceIDuuID) {
		this.inherenceIDuuID = inherenceIDuuID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserPost() {
		return userPost;
	}
	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getAddr_detail() {
		return addr_detail;
	}
	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}
//	public Date getUserBirth() {
//		return userBirth;
//	}
//	public void setUserBirth(Date userBirth) {
//		this.userBirth = userBirth;
//	}
	
	public UserDTO(int inherenceIDuuID, String userID, String userEmail, String userPassword, String userName,
			String userPhone, String userBirth, String userPost,String userAddr, String addr_detail) {
		super();
		this.inherenceIDuuID = inherenceIDuuID;
		this.userID = userID;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userBirth = userBirth;
		this.userPost = userPost;
		this.userAddr = userAddr;
		this.addr_detail = addr_detail;
//		this.userBirth = userBirth;
	}
	
}
