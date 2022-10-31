package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DAOclasses.AmmunitionDAO;
import pl.coderslab.classes.Ammunition;
import pl.coderslab.classes.Weapons;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Controller
public class AmmunitionController {
    private final AmmunitionDAO ammunitionDAO;

    public AmmunitionController(AmmunitionDAO ammunitionDAO) {
        this.ammunitionDAO = ammunitionDAO;
    }
    @ModelAttribute("types")
    public Collection<String> types() {
        List<String> types = new ArrayList<String>();
        types.add("do pistoletu");
        types.add("do karabinu");
        types.add("do paintballa");
        types.add("treningowa");
        return types;
    }

    @RequestMapping(value = "/ammunitionsform", method = RequestMethod.GET)
    public String addammunition(Model model, @ModelAttribute("types") List<String> types) {
        model.addAttribute("ammunition", new Ammunition());
        model.addAttribute("types",types);
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
    @RequestMapping(value = "/deleteammunitions",method = RequestMethod.GET)
    public String deleteammunition(Model model){
        List<Ammunition> ammunitions=ammunitionDAO.findall();
        model.addAttribute("ammunitions",ammunitions);
        model.addAttribute("maxamm",ammunitionDAO.maxid());
        return "deleteammunitions";
    }
    @RequestMapping(value = "/deleteammunitions", method = RequestMethod.POST)
    public String findtodeletenameammpost(@RequestParam int id) {
        Ammunition ammunition=ammunitionDAO.findById(id);
        if (ammunitionDAO.findById(id)==null){
            return "redirect:deleteammunitions";
        }
        else {
            ammunitionDAO.delete(ammunition);
            return "redirect:/mainview/true";
        }
    }
    @RequestMapping(value = "/findbyammoname", method = RequestMethod.GET)
    public String findname(Model model) {
        List<Ammunition> ammunitions=ammunitionDAO.findall();
        model.addAttribute("ammunitions",ammunitions);
        model.addAttribute("maxamm",ammunitionDAO.maxid());
        return "findbyammoname";
    }
    @RequestMapping(value = "/findbyammoname", method = RequestMethod.POST)
    public String findnamepost(@RequestParam int id) {
            if (ammunitionDAO.findById(id)==null){
                return "findbyammoname";
            }
            else {
                return "redirect:changeammunitiondata/" + id;
            }
    }
    @RequestMapping(value = "/changeammunitiondata/{id}", method = RequestMethod.GET)
    public String updateammget(@PathVariable("id") int id, Model model) {
        Ammunition ammunition=ammunitionDAO.findById(id);
        model.addAttribute("ammtochange",ammunition);
        model.addAttribute("persamm",new Ammunition());

        return "changeammunitiondata";
    }
    @RequestMapping(value = "/changeammunitiondata/{id}", method = RequestMethod.POST)
    public String updateammpost(@PathVariable("id") int id,@Valid Ammunition ammunition, BindingResult result) {
        if(result.hasErrors())
        {
            return "changeammunitiondata/"+id;
        }
        Ammunition ammunitionold=ammunitionDAO.findById(id);
        ammunitionold.setName(ammunition.getName());
        ammunitionold.setWeight(ammunition.getWeight());
        ammunitionold.setCaliber(ammunition.getCaliber());
        ammunitionold.setType(ammunition.getType());
        ammunitionold.setPrice(ammunition.getPrice());
        ammunitionold.setNumberinpack(ammunition.getNumberinpack());
        ammunitionold.setPhoto(ammunition.getPhoto());
        ammunitionDAO.update(ammunitionold);
        return "changedata";
    }
    @RequestMapping(value = "/addammunition/{id}",method = RequestMethod.GET)
    public String addammo(@PathVariable("id") int id, HttpSession ses){
        Ammunition ammunition=ammunitionDAO.findById(id);
        List<Ammunition> ammunitionList=(List<Ammunition>) ses.getAttribute("ammunitionlist");
        int zalogowany=(int) ses.getAttribute("zalogowany");
        if(ammunitionList==null)
        {
            ses.setAttribute("noord",1);
            List<Ammunition> amunicja=new ArrayList<>();
            amunicja.add(ammunition);
            ses.setAttribute("ammunitionlist",amunicja);
        }else {
            int noord=(int) ses.getAttribute("noord");
            noord++;
            ses.setAttribute("noord",noord);
            ammunitionList.add(ammunition);
            ses.setAttribute("ammunitionlist",ammunitionList);
        }

        return "redirect:/shoppingcart";
    }
    @RequestMapping(value = "/deleteammunitionfromlist/{id}",method = RequestMethod.GET)
    public String deletefromlistammo(@PathVariable("id") int id, HttpSession ses){
        Ammunition ammunition=ammunitionDAO.findById(id);
        List<Ammunition> ammunitionList=(List<Ammunition>) ses.getAttribute("ammunitionlist");
        ammunitionList.remove(ammunition);
        ses.setAttribute("ammunitionlist",ammunitionList);
            return "redirect:/shoppingcart";
    }

}
