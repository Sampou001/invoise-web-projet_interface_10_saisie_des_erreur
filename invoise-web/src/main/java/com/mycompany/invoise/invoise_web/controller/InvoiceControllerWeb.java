package com.mycompany.invoise.invoise_web.controller;


import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb implements InvoiceControllerInterface {
    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }


    @Override
    public String createInvoice(Invoice invoice) {
        return "";
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }


    public void createInvoice(){

        String customerName="Tesla";
        Invoice invoice=new Invoice();
        invoice.setCustomerName(customerName);

        invoiceService.createInvoice(invoice);
    }

    //Première méthode
    /*@RequestMapping("/home")
    public ModelAndView displayHome(){
        System.out.println("La méthode displayHome a été invoquée");
        ModelAndView mv=new ModelAndView("invoice-home");
        mv.addObject("invoices", invoiceService.getInvoiceList());

        return mv;
    }


    @RequestMapping("/{id}")
    public ModelAndView   displayInvoice(@PathVariable("id") String number){
        System.out.println("La méthode displayInvoice a été invoquée");
        ModelAndView mv=new ModelAndView("invoice-details");
        mv.addObject("invoice", invoiceService.getInvoiceByNumber(number));
        //List<Invoice> invoices=invoiceService.getInvoiceList();

        return mv;
    }*/

    //Deuxième méthode
    @RequestMapping("/home")
    public String displayHome(Model model){
        System.out.println("La méthode displayHome a été invoquée");
        model.addAttribute("invoices", invoiceService.getInvoiceList());

        return "invoice-home";
    }


    @RequestMapping("/{id}")
    public String   displayInvoice(@PathVariable("id") String number, Model model){
        System.out.println("La méthode displayInvoice a été invoquée");

        model.addAttribute("invoice", invoiceService.getInvoiceByNumber(number));
        return "invoice-details";
    }


}
