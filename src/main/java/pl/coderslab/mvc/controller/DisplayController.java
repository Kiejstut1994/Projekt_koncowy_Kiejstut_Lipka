package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;
import pl.coderslab.DAOclasses.AmmunitionDAO;
import pl.coderslab.DAOclasses.WeaponsDAO;
import pl.coderslab.classes.Ammunition;
import pl.coderslab.classes.Weapons;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class DisplayController {
    public final WeaponsDAO weaponsDAO;
    public final AmmunitionDAO ammunitionDAO;

    public DisplayController(WeaponsDAO weaponsDAO, AmmunitionDAO ammunitionDAO) {
        this.weaponsDAO = weaponsDAO;
        this.ammunitionDAO = ammunitionDAO;
    }

    @RequestMapping(value = "/ageveryfication", method = RequestMethod.GET)
    public String getFrom(HttpServletRequest request) {
        Cookie c = WebUtils.getCookie(request, "wiekok");
        if(c!=null){
            return "mainview";
        }else {
            return "ageveryfication";
        }
    }
    @RequestMapping(value = "/mainview/true", method = RequestMethod.GET)
    public String frontsideFrom(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie1 = new Cookie("wiekok", "wiekok");
        cookie1.setPath("/");
        cookie1.setMaxAge(120*3600);
        response.addCookie(cookie1);
        return "mainview";
    }
    @RequestMapping(value = "/rights", method = RequestMethod.GET)
    public String rights() {
        return "rights";
    }

    @RequestMapping(value = "/weaponsform", method = RequestMethod.GET)
    public String addweapon(Model model) {
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
    @RequestMapping(value = "/weapondisplay/{type}", method = RequestMethod.GET)
    public String dispweapon(Model model, @PathVariable("type") String type) {
        List<Weapons> weapons=weaponsDAO.findalltype(type);
        model.addAttribute("weapons", weapons);
        return "weapondisplay";
    }
    @RequestMapping(value = "/ammunitionsform", method = RequestMethod.GET)
    public String addammunition(Model model) {
        model.addAttribute("ammunition", new Ammunition());
        return "ammunitionsform";
    }
    @RequestMapping(value = "/ammunitionsform", method = RequestMethod.POST)
    public String saveammunition(@Valid Ammunition ammunition, BindingResult result) {
        if(result.hasErrors()){
            return "ammunitionsform";
        }
        ammunitionDAO.saveAmmunition(ammunition);
        return "mainview";
    }
    @RequestMapping(value = "/ammunitiondisplay/{type}", method = RequestMethod.GET)
    public String dispammunition(Model model, @PathVariable("type") String type) {
        List<Ammunition> ammunitions=ammunitionDAO.findalltype(type);
        model.addAttribute("ammunitions", ammunitions);
        return "/ammunitiondisplay";
    }

}
