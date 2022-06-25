package pl.coderslab.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.DAOclasses.PurchaseDAO;
import pl.coderslab.classes.Purchaser;

import java.math.BigInteger;

public class Purchaseconverter implements Converter<String, Purchaser> {
    @Autowired
    private PurchaseDAO purchaseDAO;

    @Override
    public Purchaser convert(String source) {
        return purchaseDAO.findById(Integer.valueOf(Integer.parseInt(source)));
    }
}
