package storeProject.store.boardServlet;

import storeProject.store.board.BoardDAO;
import storeProject.store.board.BoardDTO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		int inherenceID = 0;
		String userName = null;
		String boardName = null;
		String boardYear = null;
		String boardMonth = null;
		String boardDay = null;
		String boardDivide = null;
		String boardContentuser = null;
		
		inherenceID = Integer.parseInt((String) session.getAttribute("inherenceID"));
		userName = (String) session.getAttribute("userName");
		boardName = request.getParameter("boardName");
		boardYear = request.getParameter("boardYear");
		boardMonth = request.getParameter("boardMonth");
		boardDay = request.getParameter("boardDay");
		boardDivide = request.getParameter("boardDivide");
		
		if(inherenceID == 0 || userName == null || boardName == null || boardYear ==null || boardMonth == null || boardDay == null || boardDivide == null || boardContentuser == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비어있는 값이 있습니다');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
		}
		BoardDAO boardDAO = new BoardDAO();
		int result = boardDAO.write(new BoardDTO(0, inherenceID, userName, boardName, boardYear, boardMonth, boardDay, boardDivide, boardContentuser));
		if (result == -2) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스오류');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
		} else {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('등록성공');");
			script.println("location.href = 'board.jsp';");
			script.println("</script>");
			script.close();
		}
	}

}
