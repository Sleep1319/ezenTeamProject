package storeProject.store.siteController;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import storeProject.store.basket.BasketDAO;
import storeProject.store.basket.BasketDTO;
import storeProject.store.board.BoardDAO;
import storeProject.store.board.BoardDTO;
import storeProject.store.item.ItemDAO;
import storeProject.store.item.ItemDTO;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.util.ArrayList;

@Controller
public class SiteController {

    //메인 페이지
    @GetMapping("/")
    public String MainPage(Model model) {
        return "main";
    }

    //로그인 페이지
    @GetMapping("login.html")
    public String loginPage(Model model , HttpSession session) {
        if(session.getAttribute("userID") != null) {
            return "main";
        }
        return "login";
    }

    //회원가입 페이지
    @GetMapping("register.html")
    public  String Register(Model model, HttpSession session) {
        if(session.getAttribute("userID") != null) {
        return "main";
        }
        return "register";
    }

    //로그아웃 페이지
    @GetMapping("userLogout.html")
    public  String logOut(Model model, HttpSession session) {
        session.invalidate();
        return "main";
    }

    //아이디 찾기 페이지 view 요청값(href="find_id.html")
    @GetMapping("find_id.html")
    public String findID () { return "find_id"; }

    //비밀번호 찾기 페이지 view 요청값(href="find_pwd.html")
    @GetMapping("find_pwd.html")
    public String findPW () { return "find_pwd"; }

    //유저정보 페이지
    @GetMapping("mypage.html")
    public String userInfo () {
        return "mypage";
    }

    //상점 사이트 이동시 값일 미리 불러오기 위함
    @GetMapping("sang.html")
    public String store(Model model, HttpSession session) {
        if(session.getAttribute("userID") == null) {
            model.addAttribute("message", "로그인 후 이용해 주세요");
            return "login";
        }
        ItemDAO itemDAO = new ItemDAO();
        ArrayList<ItemDTO> itemList = itemDAO.itemAllList();
        if (!itemList.isEmpty()) {
            model.addAttribute("itemAllList", itemList);
        } else {
            model.addAttribute("itemAllList", itemList);
            model.addAttribute("message", "저장된 정보가 없습니다");
        }
        return "sang";
    }

    //장바구니 사이트 이동
    @GetMapping("itemBasket.html")
    public String itemBasket (Model model, HttpSession session) {
        if(session.getAttribute("userID") != null) {
            String inherenceID = (String) session.getAttribute("inherenceID");

            BasketDAO basketDAO = new BasketDAO();
            ItemDAO itemDAO = new ItemDAO();
            ArrayList<ItemDTO> itemList = new ArrayList<>();
            ArrayList<BasketDTO> basketList = basketDAO.basketAllList(inherenceID);
            model.addAttribute("basketList", basketList);
            for (BasketDTO basket : basketList) {
                ItemDTO items = itemDAO.iteminfoList(basket.getItemID());
                itemList.add(items);
            }
            model.addAttribute("basitemList", itemList);
            return "itemBasket";
        }
        return "main";
    }
    
    //상품관리 사이트 이동
    @GetMapping("management")
    public String itemManagement (Model model) {
        ItemDAO itemDAO = new ItemDAO();
        ArrayList<ItemDTO> itemList = itemDAO.itemAllList();
        if (!itemList.isEmpty()) {
            model.addAttribute("itemAllList", itemList);
        } else {
            model.addAttribute("itemAllList", itemList);
            model.addAttribute("message", "아이템 값 불러오기 실패");
        }
        return "itemManagement";
    }

    //고객센터 사이트 이동 메소드 내부에 보드리스트 불러오는 구문 필요
    @GetMapping("service_center")
    public String serviceCenter (Model model) {
        BoardDAO boardDAO = new BoardDAO();
        ArrayList<BoardDTO> boardList = boardDAO.boardAllList();
        model.addAttribute("boardList", boardList);
        return "serviceCenter";
    }
    
    //글쓰기 페이지 이동
    @GetMapping("boardWrite")
    public String boardWrite () { return "boardWrite"; }

    //선택 게시글 board페이지 이동
    @GetMapping("selectBoard")
    public String selectBoard (Model model, HttpSession session,@RequestParam("boardID") String boardID) {
        BoardDAO boardDAO = new BoardDAO();
        BoardDTO selectBoard = boardDAO.selectBoard(boardID);
        if(selectBoard != null) {
            int inherenceID = Integer.parseInt((String) session.getAttribute("inherenceID"));
            model.addAttribute("inherenceID", inherenceID);//세션 고유 아이디를 셀렉 보더 고유 아이디랑 타입 맞추기 위한 작업
            model.addAttribute("selectBoard", selectBoard);
            return "board";
        } else {
            model.addAttribute("message", "불러오기 실패");
            return "serviceCenter";
        }
    }

    @GetMapping("boardDelete")
    public String boardDelete(Model model, @RequestParam("boardID") String boardID, @RequestParam("boardName") String boardName) {
        model.addAttribute("boardID", boardID);
        model.addAttribute("boardName", boardName);
        return "boardDelete";
    }
}

