package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.DAOclasses.AddressDAO;
import pl.coderslab.DAOclasses.OrdersDAO;
import pl.coderslab.classes.Orders;


import javax.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {
    private final OrdersDAO ordersDAO;
    private final AddressDAO addressDAO;
    public ShoppingCartController(OrdersDAO ordersDAO, AddressDAO addressDAO) {
        this.ordersDAO = ordersDAO;
        this.addressDAO = addressDAO;
    }

    @RequestMapping(value = "/shoppingcart",method = RequestMethod.GET)
    public String showorders(Model model, HttpSession session){
        int ordnumber=(int) session.getAttribute("noord");
        int zalogowany=(int) session.getAttribute("zalogowany");
        model.addAttribute("purchaseraddres", addressDAO.findById(zalogowany));
        return "shoppingcart";
    }
}
