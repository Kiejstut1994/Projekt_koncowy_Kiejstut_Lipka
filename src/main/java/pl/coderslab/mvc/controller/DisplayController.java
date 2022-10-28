package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;
import pl.coderslab.DAOclasses.*;
import pl.coderslab.classes.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DisplayController {
    public final WeaponsDAO weaponsDAO;
    public final AmmunitionDAO ammunitionDAO;
    public final OpticAccesoriesDAO opticAccesoriesDAO;
    public final GuncoversDAO guncoversDAO;
    private final EarandeyesrecoverAccesoriesDAO earandeyesrecoverAccesoriesDAO;

    public DisplayController(WeaponsDAO weaponsDAO, AmmunitionDAO ammunitionDAO, OpticAccesoriesDAO opticAccesoriesDAO, GuncoversDAO guncoversDAO, EarandeyesrecoverAccesoriesDAO earandeyesrecoverAccesoriesDAO) {
        this.weaponsDAO = weaponsDAO;
        this.ammunitionDAO = ammunitionDAO;
        this.opticAccesoriesDAO = opticAccesoriesDAO;
        this.guncoversDAO = guncoversDAO;
        this.earandeyesrecoverAccesoriesDAO = earandeyesrecoverAccesoriesDAO;
    }


    @RequestMapping(value = "/deletecookie", method = RequestMethod.GET)
    public String delFrom(HttpServletRequest request, HttpSession httpSession) {
        Cookie c = WebUtils.getCookie(request, "wiekok");

       c.setMaxAge(0);
        return "ageveryfication";
    }

    @RequestMapping(value = "/ageveryfication", method = RequestMethod.GET)
    public String getFrom(HttpServletRequest request, HttpSession httpSession) {
        httpSession.setAttribute("zalogowany",-1);
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

    @RequestMapping(value = "/weapondisplay/{type}", method = RequestMethod.GET)
    public String dispweapon(Model model, @PathVariable("type") String type,HttpSession ses) {
        int zalogowany = (int) ses.getAttribute("zalogowany");
        List<Weapons> weapons=weaponsDAO.findalltype(type);
        model.addAttribute("weaponsl", weapons);
        return "weapondisplay";
    }
    @RequestMapping(value = "/ammunitiondisplay/{type}", method = RequestMethod.GET)
    public String dispammunition(Model model, @PathVariable("type") String type) {
        List<Ammunition> ammunitions=ammunitionDAO.findalltype(type);
        model.addAttribute("ammunitions", ammunitions);
        return "ammunitiondisplay";
    }
    @RequestMapping(value = "/opticaccesoriesdisplay/{type}", method = RequestMethod.GET)
    public String dispoptics(Model model, @PathVariable("type") String type) {
        List<OpticAccesories> opticaccesories=opticAccesoriesDAO.findalltype(type);
        model.addAttribute("opticaccesories", opticaccesories);
        return "opticaccesoriesdisplay";
    }
    @RequestMapping(value = "/guncoversdisplay", method = RequestMethod.GET)
    public String disguns(Model model) {
        List<Guncovers> guncovers=guncoversDAO.findallguncovs();
        model.addAttribute("guncovers", guncovers);
        return "guncoversdisplay";
    }
    @RequestMapping(value = "/earandeyesrecoverAccesoriesdisplay/{type}", method = RequestMethod.GET)
    public String disears(Model model,@PathVariable("type") String type) {
        List<EarandeyesrecoverAccesories> earandeyesrecoverAccesories=earandeyesrecoverAccesoriesDAO.findallbytype(type);
        model.addAttribute("earandeyesrecoverAccesories", earandeyesrecoverAccesories);
        return "earandeyesrecoverAccesoriesdisplay";
    }

}
