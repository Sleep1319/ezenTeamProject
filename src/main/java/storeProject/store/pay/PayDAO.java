package storeProject.store.pay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import storeProject.store.util.DatabaseUtil;

public class PayDAO {
 public int payUp (PayDTO pay) {
	 Connection conn = null;
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 String sql = "INSERT INTO PAYINTO VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
	 
	 try {
		conn = DatabaseUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pay.getInherenceID());
		pstmt.setString(2, pay.getMerchantID());
		pstmt.setString(3, pay.getImpID());
		pstmt.setInt(4, pay.getItemID());
		pstmt.setString(5, pay.getItemName());
		pstmt.setInt(6, pay.getBuyCount());
		pstmt.setInt(7, pay.getTotalAmount());
		pstmt.setString(8, pay.getItemType());
		pstmt.setString(9, pay.getBuyerEmail());
		pstmt.setString(10, pay.getBuyerName());
		pstmt.setString(11, pay.getBuyerTel());
		pstmt.setString(12, pay.getBuyerAddr());
		pstmt.setString(13, pay.getBuyerPost());
		return pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
    	try { if(conn != null) conn.close(); }
		catch (Exception e) { e.printStackTrace(); }
		try { if(pstmt != null) pstmt.close(); }
		catch (Exception e) { e.printStackTrace(); }
		try { if(rs != null) rs.close(); }
		catch (Exception e) { e.printStackTrace(); }
    } 
	 return -2;
 }
}
