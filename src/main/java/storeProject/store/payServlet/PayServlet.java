package storeProject.store.payServlet;

import com.fasterxml.jackson.databind.util.JSONPObject;
import storeProject.store.pay.PayDAO;
import storeProject.store.pay.PayDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public PayServlet() {
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
//		response.setContentType("application/json;");
//		HttpSession session = request.getSession();
//
//		//json을 받기위한 구문 어렵다...
//		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
//        StringBuilder jsonPayload = new StringBuilder(); //받아온 값을 이 변수에 저장
//        String line;
//        while ((line = reader.readLine()) != null) {
//            jsonPayload.append(line);
//        }
//        JSONPObjectt json = new JSONObject(jsonPayload.toString());
//		int inherenceID = Integer.parseInt((String) session.getAttribute("inherenceID"));
//		String merchant_uid = json.getString("merchant_uid");
//		String imp_uid = json.getString("imp_uid");
//	    int item_id = json.getInt("item_id");
//	    String itemName = json.getString("name");
//	    int buyCount = json.getInt("count");
//	    int totalAmount = json.getInt("amount");
//	    String itemType = json.getString("item_type");
//	    String buyer_email = json.getString("buyer_email");
//	    String buyer_name = json.getString("buyer_name");;
//	    String buyer_tel = json.getString("buyer_tel");
//	    String buyer_addr = json.getString("buyer_addr");
//	    String buyer_postcode = json.getString("buyer_postcode");
//
////	    inherenceID = Integer.parseInt((String) session.getAttribute("inherenceID"));
////	    merchant_uid = request.getParameter("merchant_uid");
////		imp_uid = request.getParameter("imp_uid");
////		item_id = Integer.parseInt(request.getParameter("item_id"));
////		itemName = request.getParameter("name");
////		buyCount = Integer.parseInt(request.getParameter("count"));
////		totalAmount = Integer.parseInt(request.getParameter("amount"));
////		itemType = request.getParameter("item_type");
////		buyer_email = request.getParameter("buyer_email");
////		buyer_name = request.getParameter("buyer_name");
////		buyer_tel = request.getParameter("buyer_tel");
////		buyer_addr = request.getParameter("buyer_addr");
////		buyer_postcode = request.getParameter("buyer_postcode");
//
//		if(merchant_uid == null) {
//			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('값전송 에러');");
//			script.println("history.back();");
//			script.println("</script>");
//			script.close();
//		} else {
//			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('값 들어왔다');");
//			script.println("</script>");
//			script.close();
//		}
//
//		PayDAO payDAO = new PayDAO();
//		int result = payDAO.payUp(new PayDTO(0, inherenceID, merchant_uid, imp_uid, item_id, itemName, buyCount, totalAmount, itemType, buyer_email, buyer_name, buyer_tel, buyer_addr, buyer_postcode));
//
//		if(result == -2) {
//			PrintWriter out = response.getWriter();
//		    JSONPObject jsonResponse = new JSONObject();
//		    jsonResponse.put("success", false);
//		    jsonResponse.put("error", "값 등록 에러");
//		    out.print(jsonResponse.toString());
//		    out.flush();
//		} else {
//			PrintWriter out = response.getWriter();
//		    JSONObject jsonResponse = new JSONObject();
//		    jsonResponse.put("success", true);
//		    out.print(jsonResponse.toString());
//		    out.flush();
//		}
//	}

}
