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
import pl.coderslab.classes.Password;
import pl.coderslab.classes.Purchaser;

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
    public String getFrom(Model model, @RequestParam int purchaser_id) {

        model.addAttribute("password", new Password());
        model.addAttribute("purchaser_id",purchaser_id);


        return "passwordform";
    }
    @RequestMapping(value = "/passwordform/{id}", method = RequestMethod.POST)
    public String addpassword(Model model, @Valid Password password, BindingResult result,@PathVariable("id") int id) {
        if (result.hasErrors()) {
            model.addAttribute("purchaser_id",id);
            return "passwordform";
        }

        Purchaser purchaser=purchaseDAO.findById(id);
        purchaser.setPassword(password);
        purchaseDAO.update(purchaser);
        password.setPassword(BCrypt.hashpw(password.getPassword(), BCrypt.gensalt()));
        passwordDAO.update(password);
        model.addAttribute("purchaser_id",purchaser.getId());
//        passwordDAO.savePassword(password);
        return "redirect:/addressform";
    }
}