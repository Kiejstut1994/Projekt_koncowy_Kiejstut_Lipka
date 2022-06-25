package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.DAOclasses.WeaponsDAO;
import pl.coderslab.classes.Weapons;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;

@Controller
public class WeaponController {
    private final WeaponsDAO weaponsDAO;

    public WeaponController(WeaponsDAO weaponsDAO) {
        this.weaponsDAO = weaponsDAO;
    }
    @RequestMapping(value = "/findbyweaponname", method = RequestMethod.GET)
    public String findname(Model model) {
        List<Weapons> weapons=weaponsDAO.findall();
        model.addAttribute("weapons",weapons);
        return "findbyweaponname";
    }
    @RequestMapping(value = "/findbyweaponname", method = RequestMethod.POST)
    public String findnamepost(@RequestParam String name) {
        List<String> names=weaponsDAO.findallname();
        Iterator<String> iterator= names.iterator();
        boolean zawiera=false;
        while (iterator.hasNext()) {
            String next=iterator.next();
            if(next.equals(name))
            {
                zawiera=true;
            }
        }
        if (zawiera) {
            return "redirect:changeweapondata/" + name;
        }else {
            return "redirect:findbyweaponname";
        }
    }
    @RequestMapping(value = "/changeweapondata/{name}", method = RequestMethod.GET)
    public String updateweaponget(@PathVariable("name") String name,Model model) {
        model.addAttribute("name",name);
        return "changeweapondata";
    }
    @RequestMapping(value = "/changeweapondata/{name}", method = RequestMethod.POST)
    public String updateweaponpost(@PathVariable("name") String name,@RequestParam int price,@RequestParam int rating,@RequestParam String photo) {
        int licznik=0;//jak nic nie zmienieamy ma się nic nie wykonywać

        Weapons weapons=weaponsDAO.findbyname(name);

        if (price>0)
        {
            weapons.setPrice(price);
            licznik++;
        }
        if (rating>0)
        {
            weapons.setRating(rating);
            licznik++;
        }
        if (photo.length()>0)
        {
            weapons.setPhoto(photo);
            licznik++;
        }
        if (licznik>0)
        {
            weaponsDAO.update(weapons);
        }
        return "mainview";
    }
    @RequestMapping(value = "/deleteweaponbyname", method = RequestMethod.GET)
    public String findtodeletename(Model model) {
        List<Weapons> weapons=weaponsDAO.findall();
        model.addAttribute("weapons",weapons);
        return "deleteweaponbyname";
    }
    @RequestMapping(value = "/deleteweaponbyname", method = RequestMethod.POST)
    public String findtodeletenamepost(@RequestParam String name) {
        List<String> names=weaponsDAO.findallname();
        Iterator<String> iterator= names.iterator();
        boolean zawiera=false;
        while (iterator.hasNext()) {
            String next=iterator.next();
            if(next.equals(name))
            {
                zawiera=true;
            }
        }
        if (zawiera) {
            Weapons weapons=weaponsDAO.findbyname(name);
            weaponsDAO.delete(weapons);
            return "redirect:mainview/true";

        }else {
            return "redirect:deleteweaponbyname";
        }
    }
}
