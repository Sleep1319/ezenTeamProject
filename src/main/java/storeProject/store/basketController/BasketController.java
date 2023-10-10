package storeProject.store.basketController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import storeProject.store.basket.BasketDAO;
import storeProject.store.basket.BasketDTO;
import storeProject.store.item.ItemDAO;
import storeProject.store.item.ItemDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Member;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class BasketServlet
 */
@Controller
public class BasketController {

	@PostMapping("/basket")
	public String basketUp (HttpSession session, Model model,
							@RequestParam("itemID") String itemID) {

		String userID = null;

		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
		String inherenceID = (String) session.getAttribute("inherenceID");


		BasketDAO basketDAO = new BasketDAO();
		ItemDAO itemDAO = new ItemDAO();
		int result = basketDAO.upbasket(inherenceID, itemID);

		if (result == -2) {
			model.addAttribute("message", "DB에러");
		} else if (result == -1) {
			model.addAttribute("message", "등록 실패");
		}
		return "redirect:/itemBasket.html";
	}
}
