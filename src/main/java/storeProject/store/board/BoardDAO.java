package storeProject.store.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import storeProject.store.util.DatabaseUtil;

public class BoardDAO {
	
	public int write(BoardDTO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO BOARD VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";	
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getInherenceID());
			pstmt.setString(2, board.getUserName());
			pstmt.setString(3, board.getBoardName());
			pstmt.setString(4, board.getBoardYear());
			pstmt.setString(5, board.getBoardMonth());
			pstmt.setString(6, board.getBoardDay());
			pstmt.setString(7, board.getBoardDivide());
			pstmt.setString(8, board.getBoardContentuser());
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
