package storeProject.store.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import storeProject.store.util.DatabaseUtil;


public class ItemDAO {

	public ArrayList<ItemDTO> iteminfoList(int itemID) {
		ArrayList<ItemDTO> iteminfo = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT itemID, itemName, itemAmount, itemType, itemCount FROM ITEM WHERE itemID = ?";
		//개수는 추후 외부 요인 참고로 값변동 으로 수정 필요
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, itemID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ItemDTO item = new ItemDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5)
						);
				iteminfo.add(item);
			}
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
		
		return iteminfo;
	}
	//아이템 전체 출력 코드
	public ArrayList<ItemDTO> itemAllList() {
		ArrayList<ItemDTO> iteminfo = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT itemID, itemName, itemAmount, itemType, itemCount FROM ITEM";
		//개수는 추후 외부 요인 참고로 값변동 으로 수정 필요
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ItemDTO item = new ItemDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5)
						);
				iteminfo.add(item);
			}
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
		return iteminfo;
	}
	//JS LEE 코드
	 public int itemUp(ItemDTO item) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String db = "INSERT INTO ITEM VALUES(NULL, ?, ?, ?, ?)";
	      
	      try {
	         conn = DatabaseUtil.getConnection();
	         pstmt = conn.prepareStatement(db);
	         pstmt.setString(1, item.getItemName());
	         pstmt.setInt(2, item.getItemAmount());
	         pstmt.setString(3, item.getItemType());
	         pstmt.setInt(4, item.getItemCount());
	         
	         return pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	          try { if(conn != null) conn.close(); }
	         catch (Exception e) { e.printStackTrace(); }
	         try { if(pstmt != null) pstmt.close(); }
	         catch (Exception e) { e.printStackTrace(); }
	         try { if(rs != null) rs.close(); }
	         catch (Exception e) { e.printStackTrace(); }
	       }
	      return -2;
	   }
	 //결제전 상품 유무 및 검증 코드
	 public int itemCheck (String itemID, String itemName, String itemAmount, String itemType, String buyCount, String totalAmount) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql = "SELECT itemAmount FROM ITEM WHERE itemID = ? AND itemName = ? AND itemAmount = ? AND itemType = ?";
		 int count = Integer.parseInt(buyCount);
		 int total = Integer.parseInt(totalAmount);
		 
		 
		 try {
			 conn = DatabaseUtil.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1 , itemID);
			 pstmt.setString(2 , itemName);
			 pstmt.setString(3 , itemAmount);
			 pstmt.setString(4 , itemType);
			 rs = pstmt.executeQuery();
			 if(rs.next()) {
				 if(rs.getInt(1) == total / count) {
					 return 1;
				 }
			 }
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
