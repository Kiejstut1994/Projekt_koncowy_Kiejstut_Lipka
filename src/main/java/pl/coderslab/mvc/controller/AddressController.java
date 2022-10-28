package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.DAOclasses.AddressDAO;
import pl.coderslab.DAOclasses.PasswordDAO;
import pl.coderslab.DAOclasses.PurchaseDAO;
import pl.coderslab.classes.Address;
import pl.coderslab.classes.Password;
import pl.coderslab.classes.Purchaser;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AddressController {
    public final AddressDAO addressDAO;
    public final PurchaseDAO purchaseDAO;
    public final PasswordDAO passwordDAO;


    public AddressController(AddressDAO addressDAO, PurchaseDAO purchaseDAO, PasswordDAO passwordDAO) {
        this.addressDAO = addressDAO;
        this.purchaseDAO = purchaseDAO;
        this.passwordDAO = passwordDAO;
    }
    @RequestMapping(value = "/addressform", method = RequestMethod.GET)
    public String getadresFrom(Model model)  {
        model.addAttribute("address", new Address());
        return "addressform";
    }
    @RequestMapping(value = "/addressform", method = RequestMethod.POST)
    public String addaddress(@Valid Address address, BindingResult result2, HttpSession session) {
        if (result2.hasErrors()) {
            return "addressform";
        }
        Purchaser purchaser=(Purchaser) session.getAttribute("newpurchaser");
        Password password=(Password) session.getAttribute("newpassword");
        purchaser.setPassword(password);
        purchaser.setAddress(address);
        purchaseDAO.savePurchaser(purchaser);
        session.setAttribute("newpurchaser",null);
        session.setAttribute("newpassword",null);
        return "redirect:/purchaseresult";
    }

    @RequestMapping(value = "/changeaddres", method = RequestMethod.GET)
    public String changegetadresFrom(Model model,HttpSession session)  {
        Purchaser purchaser=purchaseDAO.findById((int) session.getAttribute("zalogowany"));
        Address address1=purchaser.getAddress();
        model.addAttribute("oldadress",address1);
        model.addAttribute("address", new Address());
        return "changeaddres";
    }
    @RequestMapping(value = "/changeaddres", method = RequestMethod.POST)
    public String changeaddaddress(@Valid Address address, BindingResult result2, HttpSession session) {
        if (result2.hasErrors()) {
            return "changeaddres";
        }
        Purchaser purchaser=purchaseDAO.findById((int) session.getAttribute("zalogowany"));
        Address address1=purchaser.getAddress();
        address1.setStreet(address.getStreet());
        address1.setFlatnumber(address.getFlatnumber());
        address1.setHousenumber(address.getHousenumber());
        address1.setPostcode(address.getPostcode());
        addressDAO.update(address1);
        return "redirect:/changedata";
    }
}
























