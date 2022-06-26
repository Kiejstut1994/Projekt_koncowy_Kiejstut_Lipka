package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;
import pl.coderslab.DAOclasses.PasswordDAO;
import pl.coderslab.DAOclasses.PurchaseDAO;

import pl.coderslab.classes.Password;
import pl.coderslab.classes.Purchaser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class PurchaseController {
    public final PurchaseDAO purchasedao;
    public final PasswordDAO passwordDAO;
    public PurchaseController(PurchaseDAO purchasedao, PasswordDAO passwordDAO){
        this.purchasedao=purchasedao;
        this.passwordDAO = passwordDAO;
    }




    @RequestMapping(value = "/purchaserform", method = RequestMethod.GET)
    public String getFrom(Model model) {
        model.addAttribute("purchaser", new Purchaser());

        return "purchaserform";
    }
    @RequestMapping(value = "/purchaserform", method = RequestMethod.POST)
    public String addpurchase(@Valid Purchaser purchaser, BindingResult result,Model model) {


        if (result.hasErrors()) {
            return "purchaserform";
        }

        purchasedao.savePurchaser(purchaser);
        model.addAttribute("purchaser_id",purchaser.getId());

        return "redirect:/passwordform";
    }




    @RequestMapping(value = "/purchaseresult", method = RequestMethod.GET)
    public String getresult() {
        return "purchaseresult";
    }
    @RequestMapping(value = "/loginform", method = RequestMethod.GET)
    public String loginpurchasform() {
        return "loginform";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        Cookie c = WebUtils.getCookie(request, "zalogowany");
        c.setMaxAge(0);
        response.addCookie(c);
        return "mainview";
    }
    @RequestMapping(value = "/loginform", method = RequestMethod.POST)
    public String loginpurchase(@RequestParam String PESEL, @RequestParam String password, HttpServletResponse response) {
        Purchaser purchaser=purchasedao.findByPesel(PESEL);
        Password passwordobj= purchaser.getPassword();

//komm

        if(BCrypt.checkpw(password,passwordobj.getPassword())) {
            Cookie cookie1 = new Cookie("zalogowany", String.valueOf(purchaser.getId()));
            cookie1.setPath("/");
            cookie1.setMaxAge(10*3600);
            response.addCookie(cookie1);
            return "redirect:purchaserloged";
        }else {
            return "redirect:loginform";
        }



    }
    @RequestMapping(value = "/purchaserloged", method = RequestMethod.GET)
    public String purchaserloged() {

        return "purchaserloged";
    }


}