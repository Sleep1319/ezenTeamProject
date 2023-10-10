package storeProject.store.boardController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import storeProject.store.board.BoardDAO;
import storeProject.store.board.BoardDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

@Controller
public class boardController {

    @PostMapping("/boardInsert")
    public String boardInsert (@RequestParam("boardName") String boardName,
                               @RequestParam("boardDivide") String boardDivide,
                               @RequestParam("boardContents") String boardContents,
                               Model model, HttpSession session) {
        int inherenceID = 0;
        String userName = null;
        inherenceID = Integer.parseInt((String) session.getAttribute("inherenceID"));
        userName = (String) session.getAttribute("userName");

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
        String boardTime = dateTime.format(formatter);


        BoardDAO boardDAO = new BoardDAO();

        int result = boardDAO.write(new BoardDTO(0, inherenceID, userName, boardName, boardTime, boardDivide, boardContents));
        if(result == -2) {
            model.addAttribute("message", "등록 실패");
        } else {
            model.addAttribute("message", "등록 성공");
        }

        return "redirect:service_center";
    }

    @PostMapping("/boardUpdate")
    public String boardUpdate (@RequestParam("boardID") String boardID,
                               @RequestParam("boardDivide") String boardDivide,
                               @RequestParam("boardName") String boardName,
                               @RequestParam("boardContents") String boardContents,
                               Model model, HttpSession session) {


        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
        String boardTime = dateTime.format(formatter);

        BoardDAO boardDAO = new BoardDAO();

        int result = boardDAO.boardUpdate(boardID, boardDivide, boardName, boardContents, boardTime);
        if(result == -2) {
            model.addAttribute("message", "DB에러 발생");
        } else {
            int inherenceID = Integer.parseInt((String) session.getAttribute("inherenceID"));
            model.addAttribute("inherenceID", inherenceID);
            
            BoardDTO selectBoard = boardDAO.selectBoard(boardID);
                model.addAttribute("selectBoard", selectBoard);
        }

        return "board";
    }

    @PostMapping("/boardDeleteCheck")
    public String boardDelete (@RequestParam("boardID") String boardID,
                               @RequestParam("userPassword") String userPassword,
                               Model model, HttpSession session) {
        String inherenceID = null;
        inherenceID = (String) session.getAttribute("inherenceID");

        BoardDAO boardDAO = new BoardDAO();

        int result = boardDAO.boardDelete(inherenceID, userPassword, boardID);
        if(result == -2) {
            model.addAttribute("message", "DB에러 발생");
            BoardDTO selectBoard = boardDAO.selectBoard(boardID);
            model.addAttribute("selectBoard", selectBoard);
            return "board";
        } else if (result == -1) {
            model.addAttribute("message", "비밀번호 불일치");
            BoardDTO selectBoard = boardDAO.selectBoard(boardID);
            model.addAttribute("selectBoard", selectBoard);
            return "board";
        } else {
            model.addAttribute("message", "삭제 성공");
            return "redirect:/service_center";
        }
    }
}
