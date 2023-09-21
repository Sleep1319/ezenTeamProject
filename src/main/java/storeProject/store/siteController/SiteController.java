package storeProject.store.siteController;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import storeProject.store.basket.BasketDAO;
import storeProject.store.basket.BasketDTO;
import storeProject.store.item.ItemDAO;
import storeProject.store.item.ItemDTO;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;

@Controller
public class SiteController {

    //메인 페이지
    @GetMapping("/")
    public String MainPage(Model model) {
        return "main";
    }

    //로그인 페이지
    @GetMapping("userLogin.html")
    public String loginPage(Model model , HttpSession session) {
        if(session.getAttribute("userID") != null) {
            return "main";
        }
        return "userLogin";
    }

    //회원가입 페이지
    @GetMapping("userRegister.html")
    public  String Register(Model model, HttpSession session) {
        if(session.getAttribute("userID") != null) {
        return "main";
        }
        return "userRegister";
    }

    //로그아웃 페이지
    @GetMapping("userLogout.html")
    public  String logOut(Model model, HttpSession session) {
        session.invalidate();
        return "userLogout";
    }

    //유저정보 페이지
    @GetMapping("userInfo.html")
    public String userInfo () {
        return "userInfo";
    }

    //상점 사이트 이동시 값일 미리 불러오기 위함
    @GetMapping("store.html")
    public String store(Model model) {
        ItemDAO itemDAO = new ItemDAO();
        ArrayList<ItemDTO> itemList = itemDAO.itemAllList();
        if (!itemList.isEmpty()) {
            model.addAttribute("itemAllList", itemList);
        } else {
            model.addAttribute("message", "저장된 정보가 없습니다");
        }
        return "store";
    }

    //장바구니 사이트 이동
    @GetMapping("itemBasket.html")
    public String itemBasket (Model model, HttpSession session) {
        if(session.getAttribute("userID") != null) {
            String userID = (String) session.getAttribute("userID");

            BasketDAO basketDAO = new BasketDAO();
            ItemDAO itemDAO = new ItemDAO();
            ArrayList<ItemDTO> itemList = new ArrayList<>();
            ArrayList<BasketDTO> basketList = basketDAO.basketAllList(userID);

            model.addAttribute("basketList", basketList);

            for(int i = 0; i < basketList.size(); i++) {
                BasketDTO basket =  basketList.get(i);
                itemList = itemDAO.iteminfoList(basket.getItemID());
            }
            model.addAttribute("basitemList", itemList);
            return "itemBasket";
        }
        return "main";
    }
}
