package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DAOclasses.EarandeyesrecoverAccesoriesDAO;
import pl.coderslab.classes.Ammunition;
import pl.coderslab.classes.EarandeyesrecoverAccesories;
import pl.coderslab.classes.Guncovers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Controller
public class EarandeyesrecoverAccesoriesController {
    private final EarandeyesrecoverAccesoriesDAO earandeyesrecoverAccesoriesDAO;

    public EarandeyesrecoverAccesoriesController(EarandeyesrecoverAccesoriesDAO earandeyesrecoverAccesoriesDAO) {
        this.earandeyesrecoverAccesoriesDAO = earandeyesrecoverAccesoriesDAO;
    }

    @ModelAttribute("typers")
    public Collection<String> types() {
        List<String> types = new ArrayList<String>();
        types.add("wzrok");
        types.add("słuch");
        return types;
    }
    @RequestMapping(value = "/earandeyesrecoverAccesoriesform", method = RequestMethod.GET)
    public String addearandeyesrecoverAccesories(Model model, @ModelAttribute("typers") List<String> typers) {
        model.addAttribute("earandeyesrecoverAccesories", new EarandeyesrecoverAccesories());
        model.addAttribute("typers",typers);
        return "earandeyesrecoverAccesoriesform";
    }
    @RequestMapping(value = "/earandeyesrecoverAccesoriesform", method = RequestMethod.POST)
    public String saveearandeyesrecoverAccesories(@Valid EarandeyesrecoverAccesories earandeyesrecoverAccesories, BindingResult result) {
        if(result.hasErrors()){
            return "earandeyesrecoverAccesoriesform";
        }
        earandeyesrecoverAccesoriesDAO.saveEarandeyesrecoverAccesories(earandeyesrecoverAccesories);
        return "mainview";
    }
    @RequestMapping(value = "/findbyearandeyesrecoverAccesoriesname", method = RequestMethod.GET)
    public String findbyearandeyesrecoverAccesoriesname(Model model) {
        List<EarandeyesrecoverAccesories> earandeyesrecoverAccesories = earandeyesrecoverAccesoriesDAO.findallearandeyesrecoverAccesories();
        model.addAttribute("earandeyesrecoverAccesories", earandeyesrecoverAccesories);
        model.addAttribute("maxeae",earandeyesrecoverAccesoriesDAO.maxideae());
        return "findbyearandeyesrecoverAccesoriesname";
    }

    @RequestMapping(value = "/findbyearandeyesrecoverAccesoriesname", method = RequestMethod.POST)
    public String findbyearandeyesrecoverAccesoriesnamepost(@RequestParam int id) {
        if (earandeyesrecoverAccesoriesDAO.findById(id)==null){
            return "findbyearandeyesrecoverAccesoriesname";
        }
        else {
            return "redirect:changeearandeyesrecoverAccesoriesdata/" + id;
        }
    }

    @RequestMapping(value = "/changeearandeyesrecoverAccesoriesdata/{id}", method = RequestMethod.GET)
    public String updateguncovsget(@PathVariable("id") int id, Model model) {
        EarandeyesrecoverAccesories earandeyesrecoverAccesories = earandeyesrecoverAccesoriesDAO.findById(id);
        model.addAttribute("changeearandeyesrecoverAccesories", earandeyesrecoverAccesories);
        model.addAttribute("perearandeyesrecoverAccesories", new EarandeyesrecoverAccesories());
        return "changeearandeyesrecoverAccesoriesdata";
    }

    @RequestMapping(value = "/changeearandeyesrecoverAccesoriesdata/{id}", method = RequestMethod.POST)
    public String updateguncovspost(@PathVariable("id") int id, @Valid EarandeyesrecoverAccesories earandeyesrecoverAccesories, BindingResult result, Model model) {
        EarandeyesrecoverAccesories earandeyesrecoverAccesoriesold = earandeyesrecoverAccesoriesDAO.findById(id);
        if (result.hasErrors()) {
            return "/changeearandeyesrecoverAccesoriesdata/" + id;
        }
        earandeyesrecoverAccesoriesold.setName(earandeyesrecoverAccesories.getName());
        earandeyesrecoverAccesoriesold.setPrice(earandeyesrecoverAccesories.getPrice());
        earandeyesrecoverAccesoriesold.setDescription(earandeyesrecoverAccesories.getDescription());
        earandeyesrecoverAccesoriesold.setType(earandeyesrecoverAccesories.getType());
        earandeyesrecoverAccesoriesold.setPhoto(earandeyesrecoverAccesories.getPhoto());
        earandeyesrecoverAccesoriesDAO.update(earandeyesrecoverAccesoriesold);
        return "changedata";
    }
    @RequestMapping(value = "/addearandeyesrecoverAccesories/{id}",method = RequestMethod.GET)
    public String addammo(@PathVariable("id") int id, HttpSession ses){
        EarandeyesrecoverAccesories earandeyesrecoverAccesories=earandeyesrecoverAccesoriesDAO.findById(id);
        List<EarandeyesrecoverAccesories> earandeyesrecoverAccesorieslist=(List<EarandeyesrecoverAccesories>) ses.getAttribute("earandeyesrecoverAccesorieslist");
        int zalogowany=(int) ses.getAttribute("zalogowany");
        if(earandeyesrecoverAccesorieslist==null)
        {
            ses.setAttribute("noord",1);
            List<EarandeyesrecoverAccesories> ochronawzrokisluch=new ArrayList<>();
            ochronawzrokisluch.add(earandeyesrecoverAccesories);
            ses.setAttribute("earandeyesrecoverAccesorieslist",ochronawzrokisluch);
        }else {
            earandeyesrecoverAccesorieslist.add(earandeyesrecoverAccesories);
            ses.setAttribute("earandeyesrecoverAccesorieslist",earandeyesrecoverAccesorieslist);
        }

        return "redirect:/shoppingcart";
    }
    @RequestMapping(value = "/deleteearandeyesrecoverAccesories",method = RequestMethod.GET)
    public String deleteammunition(Model model){
        List<EarandeyesrecoverAccesories> earandeyesrecoverAccesories = earandeyesrecoverAccesoriesDAO.findallearandeyesrecoverAccesories();
        model.addAttribute("earandeyesrecoverAccesories", earandeyesrecoverAccesories);
        model.addAttribute("maxeae",earandeyesrecoverAccesoriesDAO.maxideae());
        return "deleteearandeyesrecoverAccesories";
    }
    @RequestMapping(value = "/deleteearandeyesrecoverAccesories", method = RequestMethod.POST)
    public String findtodeletenameammpost(@RequestParam int id) {
        EarandeyesrecoverAccesories earandeyesrecoverAccesories=earandeyesrecoverAccesoriesDAO.findById(id);
        if (earandeyesrecoverAccesoriesDAO.findById(id)==null){
            return "redirect:deleteearandeyesrecoverAccesories";
        }
        else {
            earandeyesrecoverAccesoriesDAO.delete(earandeyesrecoverAccesories);
            return "redirect:/mainview/true";
        }
    }
    @RequestMapping(value = "/deleteearandeyesrecoverAccesoriesfromlist/{id}",method = RequestMethod.GET)
    public String deleteear(@PathVariable("id") int id, HttpSession ses){
        EarandeyesrecoverAccesories earandeyesrecoverAccesories=earandeyesrecoverAccesoriesDAO.findById(id);
        List<EarandeyesrecoverAccesories> earandeyesrecoverAccesorieslist=(List<EarandeyesrecoverAccesories>) ses.getAttribute("earandeyesrecoverAccesorieslist");
                   earandeyesrecoverAccesorieslist.remove(earandeyesrecoverAccesories);
            ses.setAttribute("earandeyesrecoverAccesorieslist",earandeyesrecoverAccesorieslist);
            return "redirect:/shoppingcart";
    }

}
