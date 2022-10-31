package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DAOclasses.OrdersDAO;
import pl.coderslab.DAOclasses.WeaponsDAO;
import pl.coderslab.classes.Orders;
import pl.coderslab.classes.Weapons;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Controller
public class WeaponController {
    private final WeaponsDAO weaponsDAO;
    private final OrdersDAO ordersDAO;
    @ModelAttribute("typewepon")
    public Collection<String> typesofwepon() {
        List<String> types = new ArrayList<String>();
        types.add("długa");
        types.add("krótka");
        types.add("kolekcjonerska");
        types.add("do paintballa");
        return types;
    }

    public WeaponController(WeaponsDAO weaponsDAO, OrdersDAO ordersDAO) {
        this.weaponsDAO = weaponsDAO;
        this.ordersDAO = ordersDAO;
    }
    @RequestMapping(value = "/findbyweaponname", method = RequestMethod.GET)
    public String findname(Model model) {
        List<Weapons> weapons=weaponsDAO.findall();
        model.addAttribute("weapons",weapons);
        model.addAttribute("maxwep",weaponsDAO.maxwep());
        return "findbyweaponname";
    }
    @RequestMapping(value = "/findbyweaponname", method = RequestMethod.POST)
    public String findnamepost(@RequestParam int id) {
        Weapons weapons=weaponsDAO.findById(id);
        if (weapons==null) {
            return "redirect:findbyweaponname";
        }else {

            return "redirect:changeweapondata/" + id;
        }

    }
@RequestMapping(value = "/addweapon/{id}",method = RequestMethod.GET)
public String addweapon(@PathVariable("id") int id, HttpSession ses){
    Weapons weapons=weaponsDAO.findById(id);
    List<Weapons> weaponsList=(List<Weapons>) ses.getAttribute("weaponslist");
        int zalogowany=(int) ses.getAttribute("zalogowany");
        if(weaponsList==null)
        {
            ses.setAttribute("noord",1);
            List<Weapons> bron=new ArrayList<>();
            bron.add(weapons);
            ses.setAttribute("weaponslist",bron);
            }else {
            int noord=(int) ses.getAttribute("noord");
            noord++;
            ses.setAttribute("noord",noord);
            weaponsList.add(weapons);
            ses.setAttribute("weaponslist",weaponsList);
        }

        return "redirect:/shoppingcart";
        }
    @RequestMapping(value = "/changeweapondata/{id}", method = RequestMethod.GET)
    public String updateweaponget(@PathVariable("id") int id,Model model,@ModelAttribute("typewepon") List<String> typewepon,HttpSession session) {
        Weapons weapons=weaponsDAO.findById(id);
        model.addAttribute("wepid",id);
        model.addAttribute("weapontochange",weapons);
        model.addAttribute("perswepon",new Weapons());
        model.addAttribute("typewepon",typewepon);
        return "changeweapondata";
    }
    @RequestMapping(value = "/changeweapondata/{id}", method = RequestMethod.POST)
    public String updateweaponpost(@PathVariable("id") int id,@Valid Weapons weapons, BindingResult result,Model model,@ModelAttribute("typewepon") List<String> typewepon,HttpSession session) {

        if(result.hasErrors())
        {
            Weapons weapons1=weaponsDAO.findById(id);
            session.setAttribute("wepid",id);
            session.setAttribute("weapontochange",weapons1);
            session.setAttribute("typewepon",typewepon);
            return "changeweapondata";
        }
        Weapons weaponsold=weaponsDAO.findById(id);
        weaponsold.setName(weapons.getName());
        weaponsold.setWeight(weapons.getWeight());
        weaponsold.setProducent(weapons.getProducent());
        weaponsold.setPrice(weapons.getPrice());
        weaponsold.setCaliber(weapons.getCaliber());
        weaponsold.setRating(weapons.getRating());
        weaponsold.setType(weapons.getType());
        weaponsold.setPhoto(weapons.getPhoto());
        session.setAttribute("wepid",0);
        session.setAttribute("weapontochange",null);
        weaponsDAO.update(weaponsold);
        return "changedata";
    }
    @RequestMapping(value = "/changedata", method = RequestMethod.GET)
    public String changedatae() {
        return "changedata";
    }
    @RequestMapping(value = "/deleteweaponbyname", method = RequestMethod.GET)
    public String findtodeletename(Model model) {
        List<Weapons> weapons=weaponsDAO.findall();
        model.addAttribute("weapons",weapons);
        model.addAttribute("maxwep",weaponsDAO.maxwep());
        return "deleteweaponbyname";
    }
    @RequestMapping(value = "/deleteweaponbyname", method = RequestMethod.POST)
    public String findtodeletenamepost(@RequestParam int id) {
        Weapons weapons=weaponsDAO.findById(id);
        if (weapons==null) {
            return "redirect:deleteweaponbyname";
        }else {
            weaponsDAO.delete(weapons);
            return "redirect:/mainview/true";
        }
    }
    @RequestMapping(value = "/weaponsform", method = RequestMethod.GET)
    public String addweapon(Model model,@ModelAttribute("typewepon") List<String> typewepon) {
        model.addAttribute("typewepon",typewepon);
        model.addAttribute("weapons", new Weapons());
        return "weaponsform";
    }
    @RequestMapping(value = "/weaponsform", method = RequestMethod.POST)
    public String saveeapon(@Valid Weapons weapons, BindingResult result) {
        if(result.hasErrors()){
            return "weaponsform";
        }
        weaponsDAO.saveWeapons(weapons);
        return "mainview";
    }

    @RequestMapping(value = "/deleteweaponfromlist/{id}",method = RequestMethod.GET)
    public String deleteweaponfromlist(@PathVariable("id") int id, HttpSession ses){
        Weapons weapons=weaponsDAO.findById(id);
        List<Weapons> weaponsList=(List<Weapons>) ses.getAttribute("weaponslist");
        weaponsList.remove(weapons);
        ses.setAttribute("weaponslist",weaponsList);
            return "redirect:/shoppingcart";
    }
}
