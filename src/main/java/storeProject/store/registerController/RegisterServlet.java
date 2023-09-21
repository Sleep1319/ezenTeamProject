package storeProject.store.registerController;

import storeProject.store.user.UserDAO;
import storeProject.store.user.UserDTO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");//한글 꺠짐 방지
		
		HttpSession session = request.getSession();//servlet에서 세션값 쓰려면 선언해야함
		
		String userID = null;//로그인 회원가입을 위해 v에서 넘어온 값을 받기위한 변수들
		String userEmail = null;
		String userPassword = null;
		String userName = null;
		String userPhone = null;
		String userPost = null;
		String userAddr = null;	
		String addr_detail = null;
//		Date userBirth = null;

		if(session.getAttribute("userID") != null) {//세션에 아이디값이 있으면(로그인 되어있으면)
			userID = (String) session.getAttribute("userID");//유저 아이디 변수에 값 대입
		}
		
		if(userID != null) {//위에서 실행이 이뤄지면 로그인완료 상태이니 다시 되돌리는 구문
			PrintWriter script = response.getWriter();//걍 입출력 선언
			script.println("<script>");//스크립트 구문이라 스크립트 태그 사용
			script.println("alert('로그인이 된 상태입니다.');");
			script.println("location.href = 'main.html';");
			script.println("</script>");
			script.close();
			return;
		}
		if(request.getParameter("userID") != null) {//VIEW의 name="userID"의 값이 있으면
			userID = (String) request.getParameter("userID");//위에 선언한 변수에 대입
		}
		
		if(request.getParameter("userEmail") != null) {//이하 동일
			userEmail = (String) request.getParameter("userEmail");
		}
		
		if(request.getParameter("userPassword") != null) {
			userPassword = (String) request.getParameter("userPassword");
		}
		
		if(request.getParameter("userName") != null) {
			userName = (String) request.getParameter("userName");
		}
		
		if (request.getParameter("userPhone") != null) {
		    userPhone = (String) request.getParameter("userPhone");
		}
		
		if(request.getParameter("userPost") != null) {
			userPost = (String) request.getParameter("userPost");
		}
		
		if(request.getParameter("userAddr") != null) {
			userAddr = (String) request.getParameter("userAddr");
		}
		
		if(request.getParameter("Addrdetail") != null) {
			addr_detail = (String) request.getParameter("Addrdetail");
		}
		
		
		//입력값 조건 지정 추가
		//공백 체크 값이 안넘어오면 VIEW에서 안쓴거니 필수값은 이리 체크
		if (userID == null || userEmail == null || userPassword == null || userName == null || userPhone == null || userID.equals("") || userEmail.equals("") || userPassword.equals("") || userName.equals("") || userPhone.equals("")) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다.');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
			return;
		}

		UserDAO userDAO = new UserDAO();//MODEL부분인 DAO사용을 위해 선언
		
		int result = userDAO.join(new UserDTO(0, userID, userEmail, userPassword, userName, userPhone, userPost, userAddr, addr_detail));
		//result = DAO의 join메소드실행 리턴값 받아옴
		// userDAO.join(클래스형 파라미터) => join(new UserDTO(선언된 생성자 파라미터 값 입력);
		// DTO에는 생성자 파라미터에 각 변수값들이 들어가 DTO코드 흐름에 따라 멤버변수들 값 지정
			
		if (result == -1) {//join에서 리턴값이 -1나올시
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 존재하는 아이디입니다 중복체크 오류.');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
			return;
		} 
		
		else if (result == -2) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류 발생');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
		}
		
		else {//리턴값이 -1 -2가 아닌상태 즉 실행되었을때 
//			session.setAttribute("userID", userID);
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('회원가입 성공')");
			script.println("location.href = 'userLogin.html';");
			script.println("</script>");
			script.close();
			return;
		}
	}

}
