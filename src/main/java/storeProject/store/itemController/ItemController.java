package storeProject.store.itemController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import storeProject.store.item.ItemDAO;
import storeProject.store.item.ItemDTO;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ItemServlet
 */
@Controller
public class ItemController {

//	@PostMapping("/item")
//	public String item(Model model, HttpSession session){
//		ItemDAO itemDAO = new ItemDAO();
//			ArrayList<ItemDTO> itemList = itemDAO.itemAllList();
//			if (!itemList.isEmpty()) {
//				model.addAttribute("itemAllList", itemList);
//			} else {
//				model.addAttribute("message", "저장된 정보가 없습니다");
//		}
//    return "store";
//	}
	@PostMapping("/itemNameSearch")
	public String itemName(Model model, @RequestParam("itemName") String itemName) {
		ItemDAO itemDAO = new ItemDAO();
		ArrayList<ItemDTO> itemList = itemDAO.itemNameSearch(itemName);
		if (!itemList.isEmpty()) {
			model.addAttribute("itemAllList", itemList);
		} else {
			model.addAttribute("itemAllList", itemList);
			model.addAttribute("message", "검색 정보가 없습니다");
		}
		return "sang";
	}

	@PostMapping("/itemInsert")
	public String itemInsert (Model model, HttpSession session,
						  @RequestParam("itemName") String itemName,
						  @RequestParam("itemAmount") int itemAmount,
						  @RequestParam("itemType") String itemType,
						  @RequestParam("itemCount") int itemCount,
						  @RequestParam("itemImg") String itemImg,
						  @RequestParam("itemInfoDetail") String itemInfoDetail) {
		ItemDAO itemDAO = new ItemDAO();
		int result = itemDAO.itemInsert(new ItemDTO(0, itemName, itemAmount, itemType, itemCount, itemImg, itemInfoDetail));

		if(result == -2){
			model.addAttribute("message", "수정 실패 디비오류");
			return "redirect:/management";
		} else {
			model.addAttribute("message", "수정 성공");
			return "redirect:/management";
		}
	}

	@PostMapping("/itemUpdate")
	public String itemUpdate (Model model, HttpSession session,
							  @RequestParam("itemID") int itemID,
							  @RequestParam("itemName") String itemName,
							  @RequestParam("itemAmount") int itemAmount,
							  @RequestParam("itemType") String itemType,
							  @RequestParam("itemCount") int itemCount,
							  @RequestParam("itemImg") String itemImg,
							  @RequestParam("itemInfoDetail") String itemInfoDetail) {

		ItemDAO itemDAO = new ItemDAO();
		int result = itemDAO.itemUpdate(new ItemDTO(itemID, itemName, itemAmount, itemType, itemCount, itemImg, itemInfoDetail));

		if(result == -2){
			model.addAttribute("message", "수정 실패 디비오류");
			return "redirect:/management";
		} else {
			model.addAttribute("message", "수정 성공");
			return "redirect:/management";
		}
	}

	@PostMapping("/itemDelete")
	public String itemDelete(Model model, HttpSession session,
							 @RequestParam("itemID") String itemID){
		ItemDAO itemDAO = new ItemDAO();
		int result = itemDAO.itemDelete(itemID);
		if(result == -2){
			model.addAttribute("message", "삭제 실패 디비오류");
			return "redirect:/managemen";
		} else {
			model.addAttribute("message", "삭제 실패 디비오류");
			return "redirect:/managemen";
		}

	}

}
