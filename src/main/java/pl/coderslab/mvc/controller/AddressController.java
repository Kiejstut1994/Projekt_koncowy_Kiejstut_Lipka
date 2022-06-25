package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.DAOclasses.AddressDAO;
import pl.coderslab.DAOclasses.PurchaseDAO;
import pl.coderslab.classes.Address;
import pl.coderslab.classes.Purchaser;

import javax.validation.Valid;

@Controller
public class AddressController {
    public final AddressDAO addressDAO;
    public final PurchaseDAO purchaseDAO;


    public AddressController(AddressDAO addressDAO, PurchaseDAO purchaseDAO) {
        this.addressDAO = addressDAO;
        this.purchaseDAO = purchaseDAO;
    }
    @RequestMapping(value = "/addressform", method = RequestMethod.GET)
    public String getFrom(Model model,@RequestParam int purchaser_id)  {
        model.addAttribute("address", new Address());
        model.addAttribute("purchaser_id",purchaser_id);
        return "addressform";
    }
    @RequestMapping(value = "/addressform/{id}", method = RequestMethod.POST)
    public String addaddress(@Valid Address address,@PathVariable("id") int id, BindingResult result2,Model model) {
        if (result2.hasErrors()) {
            model.addAttribute("purchaser_id",id);
            return "addressform";
        }
//        addressDAO.saveAddress(address);
        Purchaser purchaser=purchaseDAO.findById(id);
        purchaser.setAddress(address);
        purchaseDAO.update(purchaser);
        return "purchaseresult";
    }
}
