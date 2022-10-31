package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DAOclasses.AddressDAO;
import pl.coderslab.DAOclasses.OrdersDAO;
import pl.coderslab.DAOclasses.PasswordDAO;
import pl.coderslab.DAOclasses.PurchaseDAO;

import pl.coderslab.classes.Address;
import pl.coderslab.classes.Password;
import pl.coderslab.classes.Purchaser;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;

@Controller

public class PurchaseController {
    public final PurchaseDAO purchasedao;
    public final PasswordDAO passwordDAO;
    public final AddressDAO addressDAO;
    public final OrdersDAO ordersDAO;
    public PurchaseController(PurchaseDAO purchasedao, PasswordDAO passwordDAO, AddressDAO addressDAO, OrdersDAO ordersDAO){
        this.purchasedao=purchasedao;
        this.passwordDAO = passwordDAO;
        this.addressDAO = addressDAO;
        this.ordersDAO = ordersDAO;
    }
    @RequestMapping(value = "/purchaserform", method = RequestMethod.GET)
    public String getFrom(Model model) {
        model.addAttribute("purchaser", new Purchaser());
        return "purchaserform";
    }
    @RequestMapping(value = "/purchaserform", method = RequestMethod.POST)
    public String addpurchase(@Valid Purchaser purchaser, BindingResult result,Model model,HttpSession ses) {
        List<String> pesele= purchasedao.findAllPesel();
        List<String> emaile= purchasedao.findAllEmail();
        boolean repeteornot=false;
        ses.setAttribute("repeatpesel",0);
        ses.setAttribute("repeatemail",0);
        Iterator<String> iterator= pesele.iterator();
        while (iterator.hasNext()){
            String now= iterator.next();
            if (now.equals(purchaser.getPESEL())){ repeteornot=true;
                ses.setAttribute("repeatpesel",1);}

        }
        Iterator<String> iterator2= emaile.iterator();
        while (iterator2.hasNext()){
            String now= iterator2.next();
            if (now.equals(purchaser.getEmail())){ repeteornot=true;
                ses.setAttribute("repeatemail",1);}
        }

        if(repeteornot){
            return "purchaserform";
        }
        ses.setAttribute("repeatpesel",0);
        ses.setAttribute("repeatemail",0);
        purchaser.setEmailveryfication(false);
        purchaser.setFirearmslicensce(false);
        if (result.hasErrors()) {
            return "purchaserform";
        }
        ses.setAttribute("newpurchaser",purchaser);
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
    public String logout(HttpSession ses) {
        ses.setAttribute("zalogowany",-1);
        ses.setAttribute("noord",0);
        ses.setAttribute("weaponslist",null);
        ses.setAttribute("ammunitionlist",null);
        ses.setAttribute("earandeyesrecoverAccesorieslist",null);
        ses.setAttribute("guncoverslist",null);
        ses.setAttribute("opticaccesorieslist",null);
        ses.setAttribute("namesurname",null);
        ses.setAttribute("purchasershow",null);
        ses.setAttribute("addressshow",null);
        ses.setAttribute("namesurname",null);
        ses.setAttribute("userzalogowany",1);
        ses.setAttribute("canbuy",0);
        ses.setAttribute("existnotpaidacticver",null);
        ses.setAttribute("ordersnotactvenotpaid",null);
        ses.setAttribute("myorders",null);
        ses.setAttribute("numbrermyorders",null);
        return "mainview";
    }
    @RequestMapping(value = "/loginform", method = RequestMethod.POST)
    public String loginpurchase(@RequestParam String PESEL, @RequestParam String password,HttpSession ses) {
        Purchaser purchaser=purchasedao.findByPesel(PESEL);
        Password passwordobj= purchaser.getPassword();
        if(BCrypt.checkpw(password,passwordobj.getPassword())) {
            ses.setAttribute("zalogowany",purchaser.getId());
            ses.setAttribute("noord",0);
            ses.setAttribute("namesurname",purchaser.getName()+" "+purchaser.getSurname());
            ses.setAttribute("myorders",ordersDAO.myordersactiveorpaid(purchaser.getId()));
            ses.setAttribute("numbrermyorders",ordersDAO.myexistsnotpaidnotactive(purchaser.getId()));
            if(purchaser.isEmailveryfication() && purchaser.isFirearmslicensce()){
                ses.setAttribute("canbuy",1);
            }else {
                ses.setAttribute("canbuy",0);
            }
            return "redirect:purchaserloged";
        }else {
            return "redirect:loginform";
        }
    }
    @RequestMapping(value = "/purchaserloged", method = RequestMethod.GET)
    public String purchaserloged(HttpSession ses) {
        ses.setAttribute("noord",0);
        ses.setAttribute("weaponslist",null);
        ses.setAttribute("ammunitionlist",null);
        ses.setAttribute("earandeyesrecoverAccesorieslist",null);
        ses.setAttribute("guncoverslist",null);

        return "purchaserloged";
    }

    @RequestMapping(value = "/myprofilepurchaser", method = RequestMethod.GET)
    public String myprofilepurchasser(HttpSession ses) {
        Purchaser purchaser=purchasedao.findById((int) ses.getAttribute("zalogowany"));
        Address address=purchaser.getAddress();
            ses.setAttribute("purchasershow",purchaser);
            ses.setAttribute("addressshow",address);
        return "myprofilepurchaser";
    }
}