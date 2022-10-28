package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DAOclasses.OpticAccesoriesDAO;
import pl.coderslab.classes.Guncovers;
import pl.coderslab.classes.OpticAccesories;
import pl.coderslab.classes.Weapons;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Controller
public class OpticAccesoriesController {
    private final OpticAccesoriesDAO opticAccesoriesDAO;

    public OpticAccesoriesController(OpticAccesoriesDAO opticAccesoriesDAO) {
        this.opticAccesoriesDAO = opticAccesoriesDAO;
    }
    @ModelAttribute("typesofopticacessories")
    public Collection<String> typesofopticacessories() {
        List<String> types = new ArrayList<String>();
        types.add("lornetki");
        types.add("celowniki");
        types.add("lunety");
        types.add("pozostałe");
        return types;
    }

    @RequestMapping(value = "/opticaccesoriesform", method = RequestMethod.GET)
    public String addopticaccesory(Model model, @ModelAttribute("typesofopticacessories") List<String> typesofopticacessories) {
        model.addAttribute("opticaccesories", new OpticAccesories());
        model.addAttribute("typesofopticacessories",typesofopticacessories);
        return "opticaccesoriesform";
    }

    @RequestMapping(value = "/opticaccesoriesform", method = RequestMethod.POST)
    public String saveeapon(@Valid OpticAccesories opticAccesories, BindingResult result10,Model model,@ModelAttribute("typesofopticacessories") List<String> typesofopticacessories) {
        if(result10.hasErrors()){
            model.addAttribute("typesofopticacessories",typesofopticacessories);
            return "opticaccesoriesform";
        }
        opticAccesoriesDAO.saveOpticAccesories(opticAccesories);
        return "mainview";
    }
    @RequestMapping(value = "/deleteopticaccesoriesform",method = RequestMethod.GET)
    public String deleteopticaccesoriesform(Model model){
        List<OpticAccesories> opticAccesories=opticAccesoriesDAO.findalloptics();
        model.addAttribute("opticAccesories",opticAccesories);
        model.addAttribute("maxopt",opticAccesoriesDAO.maxopt());
        return "deleteopticaccesoriesform";
    }
    @RequestMapping(value = "/deleteopticaccesoriesform", method = RequestMethod.POST)
    public String deleteopticaccesoriesformpost(@RequestParam int id) {
        OpticAccesories opticAccesories=opticAccesoriesDAO.findById(id);
        if (opticAccesories==null) {
            return "deleteopticaccesoriesform";
        }else {
            opticAccesoriesDAO.delete(opticAccesories);
            return "redirect:/mainview/true";
        }
    }
    @RequestMapping(value = "/findbyopticsname", method = RequestMethod.GET)
    public String findopticsname(Model model) {
        List<OpticAccesories> opticAccesories=opticAccesoriesDAO.findalloptics();
        model.addAttribute("opticAccesories",opticAccesories);
        model.addAttribute("maxopt",opticAccesoriesDAO.maxopt());
        return "findbyopticsname";
    }
    @RequestMapping(value = "/findbyopticsname", method = RequestMethod.POST)
    public String findopticsnamepost(@RequestParam int id) {
        OpticAccesories opticAccesories=opticAccesoriesDAO.findById(id);
        if (opticAccesories==null) {
            return "findbyopticsname";
        }else {
            return "redirect:/changeopticsdata/"+id;
        }
    }
    @RequestMapping(value = "/changeopticsdata/{id}", method = RequestMethod.GET)
    public String updateweaponget(@PathVariable("id") int id,Model model) {
        OpticAccesories opticAccesories=opticAccesoriesDAO.findById(id);
        model.addAttribute("opticAccesories",opticAccesories);
        model.addAttribute("peropticAccesories",new OpticAccesories());
        return "changeopticsdata";
    }
    @RequestMapping(value = "/changeopticsdata/{id}", method = RequestMethod.POST)
    public String updateweaponpost(@PathVariable("id") int id,@Valid OpticAccesories opticAccesories, BindingResult result,@ModelAttribute("typesofopticacessories") List<String> typesofopticacessories,Model model) {
        if(result.hasErrors())
        {
            model.addAttribute("typesofopticacessories",typesofopticacessories);
            return "changeopticsdata/"+id;
        }
        OpticAccesories opticAccesoriesold=opticAccesoriesDAO.findById(id);
        opticAccesoriesold.setName(opticAccesories.getName());
        opticAccesoriesold.setDescription(opticAccesories.getDescription());
        opticAccesoriesold.setPrice(opticAccesories.getPrice());
        opticAccesoriesold.setRating(opticAccesories.getRating());
        opticAccesoriesold.setType(opticAccesories.getType());
        opticAccesoriesold.setPhoto(opticAccesories.getPhoto());

        opticAccesoriesDAO.update(opticAccesoriesold);
        return "changedata";
    }
    @RequestMapping(value = "/addopticaccesorie/{id}",method = RequestMethod.GET)
    public String addoptics(@PathVariable("id") int id, HttpSession ses){
        OpticAccesories opticAccesories=opticAccesoriesDAO.findById(id);
        List<OpticAccesories> opticaccesorieslist=(List<OpticAccesories>) ses.getAttribute("opticaccesorieslist");
        int zalogowany=(int) ses.getAttribute("zalogowany");
        if(opticaccesorieslist==null)
        {
            ses.setAttribute("noord",1);
            List<OpticAccesories> optyka=new ArrayList<>();
            optyka.add(opticAccesories);
            ses.setAttribute("opticaccesorieslist",optyka);
        }else {
            opticaccesorieslist.add(opticAccesories);
            ses.setAttribute("opticaccesorieslist",opticaccesorieslist);
        }

        return "redirect:/shoppingcart";
    }
    @RequestMapping(value = "/deleteopticaccesoriesfromlist/{id}",method = RequestMethod.GET)
    public String deleteoptics(@PathVariable("id") int id, HttpSession ses){
        OpticAccesories opticAccesories=opticAccesoriesDAO.findById(id);
        List<OpticAccesories> opticaccesorieslist=(List<OpticAccesories>) ses.getAttribute("opticaccesorieslist");
            opticaccesorieslist.add(opticAccesories);
            ses.setAttribute("opticaccesorieslist",opticaccesorieslist);
        return "redirect:/shoppingcart";
    }
}
