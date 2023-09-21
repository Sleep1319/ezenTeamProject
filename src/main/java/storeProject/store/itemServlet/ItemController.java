package storeProject.store.itemServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import storeProject.store.item.ItemDAO;
import storeProject.store.item.ItemDTO;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ItemServlet
 */
@Controller
public class ItemController {

	@PostMapping("/item")
	public String item(Model model, HttpSession session){
		ItemDAO itemDAO = new ItemDAO();
			ArrayList<ItemDTO> itemList = itemDAO.itemAllList();
			if (!itemList.isEmpty()) {
				model.addAttribute("itemAllList", itemList);
			} else {
				model.addAttribute("message", "저장된 정보가 없습니다");
		}
    return "store";
	}

}
