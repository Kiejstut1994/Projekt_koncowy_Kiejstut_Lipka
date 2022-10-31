package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DAOclasses.GuncoversDAO;
import pl.coderslab.classes.Ammunition;
import pl.coderslab.classes.Guncovers;
import pl.coderslab.classes.OpticAccesories;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class GuncoversController {
    private final GuncoversDAO guncoversDAO;

    public GuncoversController(GuncoversDAO guncoversDAO) {
        this.guncoversDAO = guncoversDAO;
    }

    @RequestMapping(value = "/guncoversform", method = RequestMethod.GET)
    public String addoguncov(Model model) {
        model.addAttribute("guncovers", new Guncovers());
        return "guncoversform";
    }

    @RequestMapping(value = "/guncoversform", method = RequestMethod.POST)
    public String addoguncovpost(@Valid Guncovers guncovers, BindingResult result) {
        if (result.hasErrors()) {
            return "guncoversform";
        }
        guncoversDAO.saveGuncovers(guncovers);

        return "mainview";
    }

    @RequestMapping(value = "/deleteguncoversform", method = RequestMethod.GET)
    public String deleteguncoversform(Model model) {
        List<Guncovers> guncovers = guncoversDAO.findallguncovs();
        model.addAttribute("guncovers", guncovers);
        model.addAttribute("maxgcov", guncoversDAO.maxgcov());
        return "deleteguncoversform";
    }

    @RequestMapping(value = "/deleteguncoversform", method = RequestMethod.POST)
    public String deleteguncoversformpost(@RequestParam int id) {
        Guncovers guncovers=guncoversDAO.findById(id);
        if (guncoversDAO.findById(id)==null) {
            return "deleteguncoversform";
        } else {
            guncoversDAO.delete(guncovers);
            return "redirect:/mainview/true";
        }
    }

    @RequestMapping(value = "/findbyguncovername", method = RequestMethod.GET)
    public String findguncovsname(Model model) {
        List<Guncovers> guncovers = guncoversDAO.findallguncovs();
        model.addAttribute("guncovers", guncovers);
        model.addAttribute("maxgcov", guncoversDAO.maxgcov());
        return "findbyguncovername";
    }

    @RequestMapping(value = "/findbyguncovername", method = RequestMethod.POST)
    public String findopticsnamepost(@RequestParam int id) {
        if (guncoversDAO.findById(id)==null) {
            return "findbyguncovername";
        } else {
            return "redirect:changeguncoverdata/"+id;
        }
    }

    @RequestMapping(value = "/changeguncoverdata/{id}", method = RequestMethod.GET)
    public String updateguncovsget(@PathVariable("id") int id, Model model) {
        Guncovers guncovers = guncoversDAO.findById(id);
        model.addAttribute("changeguncovers", guncovers);
        model.addAttribute("perguncover", new Guncovers());
        return "changeguncoverdata";
    }

    @RequestMapping(value = "/changeguncoverdata/{id}", method = RequestMethod.POST)
    public String updateguncovspost(@PathVariable("id") int id, @Valid Guncovers guncovers, BindingResult result, Model model) {
        Guncovers guncoversold = guncoversDAO.findById(id);
        if (result.hasErrors()) {
            return "/changeguncoverdata/" + id;
        }
        guncoversold.setName(guncovers.getName());
        guncoversold.setPrice(guncovers.getPrice());
        guncoversold.setDescription(guncovers.getDescription());
        guncoversold.setPhoto(guncovers.getPhoto());
        guncoversDAO.update(guncoversold);
        return "changedata";
    }
    @RequestMapping(value = "/addguncover/{id}",method = RequestMethod.GET)
    public String addammo(@PathVariable("id") int id, HttpSession ses){
        Guncovers guncovers=guncoversDAO.findById(id);
        List<Guncovers> guncoversList=(List<Guncovers>) ses.getAttribute("guncoverslist");
        int zalogowany=(int) ses.getAttribute("zalogowany");
        if(guncoversList==null)
        {
            ses.setAttribute("noord",1);
            List<Guncovers> szafy=new ArrayList<>();
            szafy.add(guncovers);
            ses.setAttribute("guncoverslist",szafy);
        }else {
            int noord=(int) ses.getAttribute("noord");
            noord++;
            ses.setAttribute("noord",noord);
            guncoversList.add(guncovers);
            ses.setAttribute("guncoverslist",guncoversList);
        }

        return "redirect:/shoppingcart";
    }
    @RequestMapping(value = "/deleteguncoversfromlist/{id}",method = RequestMethod.GET)
    public String deleteguncovfromlist(@PathVariable("id") int id, HttpSession ses){
        Guncovers guncovers=guncoversDAO.findById(id);
        List<Guncovers> guncoversList=(List<Guncovers>) ses.getAttribute("guncoverslist");
            guncoversList.remove(guncovers);
            ses.setAttribute("guncoverslist",guncoversList);

            return "redirect:/shoppingcart";

    }
}
