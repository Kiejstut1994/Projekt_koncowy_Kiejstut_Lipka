package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DAOclasses.PurchaseDAO;
import pl.coderslab.DAOclasses.UserDAO;
import pl.coderslab.DAOclasses.UserPaswordDAO;
import pl.coderslab.classes.Purchaser;
import pl.coderslab.classes.User;
import pl.coderslab.classes.UserPassword;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserController {
    public final PurchaseDAO purchasedao;
    public final UserDAO userDAO;
    public final UserPaswordDAO userPaswordDAO;

    public UserController(PurchaseDAO purchasedao, UserDAO userDAO, UserPaswordDAO userPaswordDAO) {
        this.purchasedao = purchasedao;
        this.userDAO = userDAO;
        this.userPaswordDAO = userPaswordDAO;
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
    @ResponseBody
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


        return "<a href=\"http://localhost:8080/veryficated\">Sukces, przejdz dalej</a>";

    }
    @RequestMapping(value = "/veryficated", method = RequestMethod.GET)
    public String veryficated() {
        return "veryficated";
    }


    @RequestMapping(value = "/loginformuser", method = RequestMethod.GET)
    public String loginuserform() {


        return "/loginformuser";
    }




    @RequestMapping(value = "/loginformuser", method = RequestMethod.POST)
    public String loginuser(@RequestParam String name,@RequestParam String surname,@RequestParam String password) {

        User user = userDAO.findByNameandSurname(name, surname);
        UserPassword userPassword=user.getUserPassword();

        if (BCrypt.checkpw(password,userPassword.getPassword())){
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
    public String addpurchase(@Valid User user, BindingResult result1, Model model) {


        if (result1.hasErrors()) {
            return "userform";
        }

        userDAO.saveUser(user);
        model.addAttribute("user_id",user.getId());

        return "redirect:/userpasswordform";
    }
    @RequestMapping(value = "/userpasswordform", method = RequestMethod.GET)
    public String getFrom(Model model, @RequestParam int user_id) {

        model.addAttribute("userpassword", new UserPassword());
        model.addAttribute("user_id",user_id);



        return "userpasswordform";
    }
    @RequestMapping(value = "/userpasswordform/{id}", method = RequestMethod.POST)
    public String addpassword(@Valid UserPassword userPassword, BindingResult result,@PathVariable("id") int id,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userpassword", new UserPassword());
            model.addAttribute("user_id",id);
            return "userpasswordform";
        }

        User user=userDAO.findById(id);
        user.setUserPassword(userPassword);
        userDAO.update(user);
        userPassword.setPassword(BCrypt.hashpw(userPassword.getPassword(), BCrypt.gensalt()));
userPaswordDAO.update(userPassword);

        return "redirect:/userresult";
    }
    @RequestMapping(value = "/userresult", method = RequestMethod.GET)
    public String result() {

        return "userresult";
    }

    @RequestMapping(value = "/userlogresult", method = RequestMethod.GET)
    public String usresult() {

        return "userlogresult";
    }
}