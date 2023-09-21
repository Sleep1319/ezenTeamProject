package storeProject.store.basketDownServlet;
//package basketServlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet implementation class BasketDownServlet
// */
//@WebServlet("/BasketDownServ")
//public class BasketDownServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public BasketDownServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		
//		HttpSession session = request.getSession();
//		PrintWriter script = response.getWriter();
//		
//		String userID = null;
//		String basketID = null;
//		String inherencID = null;
//		String itemID = null;
//		
//		String dummyData = null;
//		dummyData = (String) request.getParameter("dummyData");
//		
//		script.println("<script>");
//		script.println("alert('넘어왔다');");
//		script.println("history.back();");
//		script.println("</script>");
//		script.close();
//		
//		if(session.getAttribute("userID") != null) {
//	  		userID = (String) session.getAttribute("userID");
//	  	} else {
////	  		PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('세션 정보가 없습니다');");
//			script.println("history.back();");
//			script.println("</script>");
//			script.close();
//	  	}
//		
//		BasketDAO basketDAO = new BasketDAO();
//		ArrayList<String> selectList = basketDAO.basketInfo(userID);
//		basketID = selectList.get(0);
//		inherencID = selectList.get(1);
//		itemID = selectList.get(2);
//		if (basketID != null) {
//			session.setAttribute("basketID", basketID);
//			session.setAttribute("inherencID", inherencID);//값 전송 필요 없으면 삭제 필요
//			session.setAttribute("itemID", itemID);
////			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('불러오기 성공');");
//			script.println("location.href = 'itemBasket.html';");
//			script.println("</script>");
//			script.close();
//		} else {
//			session.setAttribute("basketID", -2);
////			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('상품 정보가 없습니다');");
//			script.println("location.href = 'itemBasket.html';");
//			script.println("</script>");
//			script.close();
//		}
//	}
//
//}
