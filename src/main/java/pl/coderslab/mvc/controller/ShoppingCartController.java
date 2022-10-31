package pl.coderslab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.DAOclasses.AddressDAO;
import pl.coderslab.DAOclasses.OrdersDAO;
import pl.coderslab.DAOclasses.PurchaseDAO;
import pl.coderslab.classes.*;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class ShoppingCartController {
    private final OrdersDAO ordersDAO;
    private final AddressDAO addressDAO;
    private final PurchaseDAO purchaseDAO;
    public ShoppingCartController(OrdersDAO ordersDAO, AddressDAO addressDAO, PurchaseDAO purchaseDAO) {
        this.ordersDAO = ordersDAO;
        this.addressDAO = addressDAO;
        this.purchaseDAO = purchaseDAO;
    }

    @RequestMapping(value = "/shoppingcart",method = RequestMethod.GET)
    public String showorders(Model model, HttpSession session){
        int ordnumber=(int) session.getAttribute("noord");
        int zalogowany=(int) session.getAttribute("zalogowany");
        model.addAttribute("purchaseraddres", addressDAO.findById(zalogowany));
        return "shoppingcart";
    }
    @RequestMapping(value = "/payform",method = RequestMethod.GET)
    public String pay(Model model, HttpSession session){
        int zalogowany=(int) session.getAttribute("zalogowany");
        List<Weapons> bronorder=(List<Weapons>) session.getAttribute("weaponslist");
        List<Ammunition> ammorder=(List<Ammunition>) session.getAttribute("ammunitionlist");
        List<EarandeyesrecoverAccesories> earandeyesrecoverAccesoriesord=(List<EarandeyesrecoverAccesories>) session.getAttribute("earandeyesrecoverAccesorieslist");
        List<Guncovers> guncoverord=(List<Guncovers>) session.getAttribute("guncoverslist");
        List<OpticAccesories> opticsord=(List<OpticAccesories>) session.getAttribute("opticaccesorieslist");
        Orders orders=new Orders();
        orders.setPuchaserid(zalogowany);
        orders.setWeapons(bronorder);
        orders.setAmmunitions(ammorder);
        orders.setEarandeyesrecoverAccesories(earandeyesrecoverAccesoriesord);
        orders.setGuncovers(guncoverord);
        orders.setOpticAccesories(opticsord);
        orders.setPaid(false);
        orders.setActive(false);
        Iterator<Weapons> iterator=bronorder.iterator();
        double payment=0;
        while (iterator.hasNext()){
            Weapons now=iterator.next();
            payment= payment+now.getPrice();
        }
        Iterator<Ammunition> iterator2=ammorder.iterator();
        while (iterator2.hasNext()){
            Ammunition now=iterator2.next();
            payment= payment+now.getPrice();
        }
        Iterator<EarandeyesrecoverAccesories> iterator3=earandeyesrecoverAccesoriesord.iterator();
        while (iterator3.hasNext()){
            EarandeyesrecoverAccesories now=iterator3.next();
            payment= payment+ now.getPrice();
        }
        Iterator<OpticAccesories> iterator4=opticsord.iterator();
        while (iterator4.hasNext()){
            OpticAccesories now=iterator4.next();
            payment= payment+now.getPrice();
        }
        Iterator<Guncovers> iterator5=guncoverord.iterator();
        while (iterator5.hasNext()){
            Guncovers now=iterator5.next();
            payment= payment+now.getPrice();
        }
        orders.setPrice(payment);

        session.setAttribute("payment",payment);
        ordersDAO.saveOrders(orders);
        session.setAttribute("numerzam",orders.getId());
        Purchaser purchaser=purchaseDAO.findById(orders.getPuchaserid());
        Address address=purchaser.getAddress();
        String namesurnamepurchaser=purchaser.getName()+" "+purchaser.getSurname();
        Path path1 = Paths.get("C:\\Users\\qwerty\\Desktop\\Projekt_koncowy_Kiejstut_Lipka\\src\\main\\webapp\\Zamówienie"+orders.getId()+".txt");
        List<String> outList = new ArrayList<>();
        outList.add("Zamówienie numer "+orders.getId());
        outList.add("Zamawiający: "+namesurnamepurchaser);
        outList.add("Pesel: "+purchaser.getPESEL());
        outList.add("Ulica "+address.getStreet()+" numer bloku/domu: "+address.getFlatnumber());
        if (address.getHousenumber()!=0){
            outList.add("Numer mieszkania: "+address.getHousenumber());
        }
        outList.add("Kod pocztowy: "+address.getPostcode());
        outList.add("Zamawiane rzeczy: ");
        if (bronorder.get(0)!=null){
            outList.add("Broń: ");
            Iterator<Weapons> iterator6=bronorder.iterator();
            while (iterator6.hasNext()){
                Weapons wepons=iterator6.next();
                outList.add("Nazwa: "+wepons.getName());
                outList.add("Masa: "+wepons.getWeight());
                outList.add("Producent: "+wepons.getProducent());
                outList.add("Cena: "+wepons.getPrice());
                outList.add("Kaliber: "+wepons.getCaliber());
                outList.add("Typ broni: "+wepons.getType());

            }
        }

        if (ammorder.get(0)!=null){
            outList.add("Amunicja: ");
            Iterator<Ammunition> iterator7=ammorder.iterator();
            while (iterator7.hasNext()){
                Ammunition ammunition=iterator7.next();
                outList.add("Nazwa: "+ammunition.getName());
                outList.add("Masa: "+ammunition.getWeight());
                outList.add("Kaliber: "+ammunition.getCaliber());
                outList.add("Typ amunicji: "+ammunition.getType());
                outList.add("Cena: "+ammunition.getPrice());
                outList.add("Liczba w paczce: "+ammunition.getNumberinpack());
            }
        }
        if (earandeyesrecoverAccesoriesord.get(0)!=null){
            outList.add("Ochrona wzroku i słuchu: ");
            Iterator<EarandeyesrecoverAccesories> iterator8=earandeyesrecoverAccesoriesord.iterator();
            while (iterator8.hasNext()){
                EarandeyesrecoverAccesories earandeyesrecoverAccesories=iterator8.next();
                outList.add("Nazwa: "+earandeyesrecoverAccesories.getName());
                outList.add("Cena: "+earandeyesrecoverAccesories.getPrice());
                outList.add("Opis: "+earandeyesrecoverAccesories.getDescription());
                outList.add("Typ ochrony: "+earandeyesrecoverAccesories.getType());
            }
        }
        if (opticsord.get(0)!=null){
            outList.add("Optyka: ");
            Iterator<OpticAccesories> iterator9=opticsord.iterator();
            while (iterator9.hasNext()){
                OpticAccesories opticAccesories=iterator9.next();
                outList.add("Nazwa: "+opticAccesories.getName());
                outList.add("Opis: "+opticAccesories.getDescription());
                outList.add("Cena: "+opticAccesories.getPrice());
                outList.add("Typ ochrony: "+opticAccesories.getType());
            }
        }
        if (guncoverord.get(0)!=null){
            outList.add("Optyka: ");
            Iterator<Guncovers> iterator10=guncoverord.iterator();
            while (iterator10.hasNext()){
                Guncovers guncovers=iterator10.next();
                outList.add("Nazwa: "+guncovers.getName());
                outList.add("Opis: "+guncovers.getDescription());
                outList.add("Cena: "+guncovers.getPrice());
            }
        }
        outList.add("Razem do zapłaty: "+orders.getPrice());
        try {
            Files.write(path1, outList);
        } catch (IOException ex) {
            System.out.println("Nie można zapisać pliku.");
        }
        return "payform";
    }

}
