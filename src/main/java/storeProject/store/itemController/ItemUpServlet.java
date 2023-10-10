//ackage storeProject.store.itemServlet;
//
//import storeProject.store.item.ItemDAO;
//import storeProject.store.item.ItemDTO;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import java.io.PrintWriter;
//
//
///**
// * Servlet implementation class ItemUpServlet
// */
//@WebServlet("/ItemUp")
//public class ItemUpServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public ItemUpServlet() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//
//		HttpSession session = request.getSession();
//		//관리자 계정 추가후 구분 필요
//		int itemID = 0;
//		String itemName = null;
//		int itemAmount = 0;;
//		String itemType = null;
//		int itemCount = 0;
//		String itemImg = null;
//
//		if(request.getParameter("itemName") != null) {
//			itemName = (String) request.getParameter("itemName");
//		}
//
//		if(request.getParameter("itemAmount") != null) {
//			itemAmount = Integer.parseInt(request.getParameter("itemAmount"));
//		}
//
//		if(request.getParameter("itemType") != null) {
//			itemType = (String) request.getParameter("itemType");
//		}
//
//		if(request.getParameter("itemCount") != null) {
//			itemCount = Integer.parseInt(request.getParameter("itemCount"));
//		}
//
//		ItemDAO itemDAO = new ItemDAO();
//
//		int result = itemDAO.itemUp(new ItemDTO(itemID, itemName, itemAmount, itemType, itemCount, itemImg));
//
//		if (result == -2) {
//			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('데이터베이스 오류 발생');");
//			script.println("history.back();");
//			script.println("</script>");
//			script.close();
//		} else {
//			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('상품등록 완료');");
//			script.println("history.back();");
//			script.println("</script>");
//			script.close();
//		}
//	}
//
//}
