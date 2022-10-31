package pl.coderslab.mvc.controller;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DAOclasses.OrdersDAO;
import pl.coderslab.DAOclasses.PurchaseDAO;
import pl.coderslab.DAOclasses.UserDAO;
import pl.coderslab.DAOclasses.UserPaswordDAO;
import pl.coderslab.classes.Orders;
import pl.coderslab.classes.Purchaser;
import pl.coderslab.classes.User;
import pl.coderslab.classes.UserPassword;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    public final PurchaseDAO purchasedao;
    public final UserDAO userDAO;
    public final UserPaswordDAO userPaswordDAO;
    public final OrdersDAO ordersDAO;

    public UserController(PurchaseDAO purchasedao, UserDAO userDAO, UserPaswordDAO userPaswordDAO, OrdersDAO ordersDAO) {
        this.purchasedao = purchasedao;
        this.userDAO = userDAO;
        this.userPaswordDAO = userPaswordDAO;
        this.ordersDAO = ordersDAO;
    }

    @RequestMapping(value = "/findbyPESEL", method = RequestMethod.GET)
    public String veryficationbypesel() {
        return "findbyPESEL";
    }
    @RequestMapping(value = "/findbyPESEL", method = RequestMethod.POST)
    public String veryfication(@RequestParam String PESEL, HttpServletRequest request) {

        try {
            Purchaser purchaser = purchasedao.findByPesel(PESEL);
            request.setAttribute("purchaser", purchaser);
            return "emailandlisenceveryfication";
        } catch (IndexOutOfBoundsException ex){
            return "findbyPESEL";
        }

    }

    @RequestMapping(value = "/emailandlisenceveryfication/{id}", method = RequestMethod.POST)

    public String emailch(@PathVariable("id") int id,@RequestParam String[] weryf) {
        Purchaser purchaser =purchasedao.findById(id);
        if (weryf.length==2) {
            purchaser.setEmailveryfication(true);
            purchaser.setFirearmslicensce(true);
            purchasedao.update(purchaser);
        }
        if(weryf[0].equals("tak"))
        {
            purchaser.setEmailveryfication(true);
            purchasedao.update(purchaser);
        }
        if(weryf[0].equals("okej"))
        {
            purchaser.setFirearmslicensce(true);
            purchasedao.update(purchaser);
        }

        return "redirect:/veryficated";


    }
    @RequestMapping(value = "/veryficated", method = RequestMethod.GET)
    public String veryficated() {
        return "veryficated";
    }


    @RequestMapping(value = "/loginformuser", method = RequestMethod.GET)
    public String loginuserform(HttpSession session) {
        session.setAttribute("userzalogowany",1);
        return "/loginformuser";
    }
    @RequestMapping(value = "/loginformuser", method = RequestMethod.POST)
    public String loginuser(@RequestParam String name,@RequestParam String surname,@RequestParam String password,HttpSession session) {

        User user = userDAO.findByNameandSurname(name, surname);
        UserPassword userPassword=user.getUserPassword();

        if (BCrypt.checkpw(password,userPassword.getUserpassword())){
            session.setAttribute("userzalogowany",-user.getId());
            session.setAttribute("usernamesurname",user.getName()+" "+user.getSurname());
            session.setAttribute("existnotpaidacticver",ordersDAO.existsnotpaidnotactive());
            session.setAttribute("ordersnotactvenotpaid",ordersDAO.allunpaidandnotactive());
            return "userlogresult";
        }else {
            return "loginformuser";
        }

    }

    @RequestMapping(value = "/userform", method = RequestMethod.GET)
    public String getFrom(Model model) {
        model.addAttribute("user", new User());
        return "userform";
    }
    @RequestMapping(value = "/userform", method = RequestMethod.POST)
    public String addpurchase(@Valid User user, BindingResult result1, Model model, HttpSession session) {
        if (result1.hasErrors()) {
            return "userform";
        }
        session.setAttribute("newuser",user);
        return "redirect:/userpasswordform";
    }
    @RequestMapping(value = "/userpasswordform", method = RequestMethod.GET)
    public String getpaswordFrom(Model model) {
        model.addAttribute("userpassword", new UserPassword());
        return "userpasswordform";
    }
    @RequestMapping(value = "/userpasswordform", method = RequestMethod.POST)
    public String addpassword(@Valid UserPassword userPassword, BindingResult result2,HttpSession session) {
        System.out.println(userPassword.getUserpassword());
        if (result2.hasErrors()) {
            return "userpasswordform";
        }
        userPassword.setUserpassword(BCrypt.hashpw(userPassword.getUserpassword(), BCrypt.gensalt()));
        User user=(User) session.getAttribute("newuser");
        user.setUserPassword(userPassword);
        userDAO.saveUser(user);
        return "redirect:/userresult";
    }
    @RequestMapping(value = "/userresult", method = RequestMethod.GET)
    public String result() {
        return "userresult";
    }
    @RequestMapping(value = "/changeuserpassword", method = RequestMethod.GET)
    public String getchangepaswordFrom(Model model) {
        model.addAttribute("userpassword", new UserPassword());
        return "changeuserpassword";
    }

    @RequestMapping(value = "/changeuserpassword", method = RequestMethod.POST)
    public String addnewpassword(@Valid UserPassword userPassword, BindingResult result,Model model,HttpSession session) {
        if (result.hasErrors()) {
            return "userpasswordform";
        }
        int userid=(int) session.getAttribute("userzalogowany");
        User user=userDAO.findById(-userid);
        UserPassword userPasswordold=user.getUserPassword();
        userPassword.setUserpassword(BCrypt.hashpw(userPassword.getUserpassword(), BCrypt.gensalt()));
        userPasswordold.setUserpassword(userPassword.getUserpassword());
        return "redirect:/changedata";
    }
    @RequestMapping(value = "/userlogresult", method = RequestMethod.GET)
    public String usresult(HttpSession session) {
        session.setAttribute("existnotpaidacticver",ordersDAO.existsnotpaidnotactive());
        session.setAttribute("ordersnotactvenotpaid",ordersDAO.allunpaidandnotactive());
        return "userlogresult";
    }
    @RequestMapping(value = "/veryfpaid/{id}", method = RequestMethod.GET)
    public String veryfpaid(@PathVariable("id") int id) {
    Orders orders=ordersDAO.findById(id);
    orders.setPaid(true);
    ordersDAO.updateorders(orders);
        return "redirect:/userlogresult";
    }
    @RequestMapping(value = "/veryfactive/{id}", method = RequestMethod.GET)
    public String veryfactive(@PathVariable("id") int id) {
        Orders orders=ordersDAO.findById(id);
        orders.setActive(true);
        ordersDAO.updateorders(orders);
        return "redirect:/userlogresult";
    }





}

