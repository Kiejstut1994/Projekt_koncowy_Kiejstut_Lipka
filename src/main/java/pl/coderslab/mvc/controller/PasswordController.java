package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.DAOclasses.PasswordDAO;
import pl.coderslab.DAOclasses.PurchaseDAO;
import pl.coderslab.classes.Address;
import pl.coderslab.classes.Password;
import pl.coderslab.classes.Purchaser;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class PasswordController {
    public final PasswordDAO passwordDAO;
    public final PurchaseDAO purchaseDAO;
    public PasswordController(PasswordDAO passwordDAO, PurchaseDAO purchaseDAO) {
        this.passwordDAO = passwordDAO;
        this.purchaseDAO = purchaseDAO;
    }


    @RequestMapping(value = "/passwordform", method = RequestMethod.GET)
    public String getFrom(Model model) {
        model.addAttribute("password", new Password());
        return "passwordform";
    }
    @RequestMapping(value = "/passwordform", method = RequestMethod.POST)
    public String addpassword(Model model, @Valid Password password, BindingResult result, HttpSession ses) {
        if (result.hasErrors()) {
            return "passwordform";
        }
        password.setPassword(BCrypt.hashpw(password.getPassword(), BCrypt.gensalt()));
        ses.setAttribute("newpassword",password);
        return "redirect:/addressform";
    }
    @RequestMapping(value = "/changepasswordpurchaser", method = RequestMethod.GET)
    public String changegetFrom(Model model) {
        model.addAttribute("password", new Password());
        return "changepasswordpurchaser";
    }
    @RequestMapping(value = "/changepasswordpurchaser", method = RequestMethod.POST)
    public String changeaddpassword(Model model, @Valid Password password, BindingResult result, HttpSession ses) {
        if (result.hasErrors()) {
            return "changepasswordpurchaser";
        }
        password.setPassword(BCrypt.hashpw(password.getPassword(), BCrypt.gensalt()));
        Purchaser purchaser=purchaseDAO.findById((int)ses.getAttribute("zalogowany"));
        Password password1=purchaser.getPassword();
        password1.setPassword(password.getPassword());
        passwordDAO.update(password1);
        return "redirect:/changedata";
    }
}
