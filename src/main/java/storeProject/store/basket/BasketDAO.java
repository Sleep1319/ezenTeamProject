package storeProject.store.basket;

import storeProject.store.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class BasketDAO {
	public int upbasket (String userID, String itemID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String SQL = "INSERT INTO ITEMBASKET (inherenceID, itemID) SELECT u.inherenceID, i.itemID FROM USERINFO u JOIN ITEM i ON u.userID = ? AND i.itemID = ?";//에러 수정 필요
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, itemID);
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
	
	//일단  하나의 장바구니만 가져오는구문
	public ArrayList<String> basketInfo (String userID) {
		ArrayList<String> basInfo = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT b.basketID, b.inherenceID, b.itemID FROM ITEMBASKET b JOIN USERINFO u ON b.inherenceID = u.inherenceID WHERE u.userID = ?";
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				basInfo.add(rs.getString("basketID"));
				basInfo.add(rs.getString("inherenceID"));
				basInfo.add(rs.getString("itemID"));
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
		
		return basInfo;
	}
	
	public ArrayList<BasketDTO> basketAllList (String userID) {
		ArrayList<BasketDTO> basInfo = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT b.basketID, b.inherenceID, b.itemID FROM ITEMBASKET b JOIN USERINFO u ON b.inherenceID = u.inherenceID WHERE u.userID = ?";
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BasketDTO basket = new BasketDTO(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3)
						);
				basInfo.add(basket);
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
		
		return basInfo;
	}
}
