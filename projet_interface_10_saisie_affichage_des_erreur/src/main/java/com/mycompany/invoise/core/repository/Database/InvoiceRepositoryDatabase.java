package com.mycompany.invoise.core.repository.Database;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {


    public void create(Invoice invoice){

        System.out.println("Database: Invoice add with number "+invoice.getNumber()+" for "+invoice.getCustomerName());
    }

    @Override
    public List<Invoice> list() {
        Invoice invoice1=new Invoice();
        invoice1.setNumber("NUM_1");
        invoice1.setCustomerName("EDF");

        Invoice invoice2=new Invoice();
        invoice2.setNumber("NUM_2");
        invoice2.setCustomerName("La poste");
        return List.of(invoice1,invoice2);
    }

     @Override
    public Invoice getById(String number) {
        Invoice invoice1=new Invoice();
        invoice1.setNumber(number);
        invoice1.setCustomerName("EDF");
        invoice1.setOrderNumber("ON_002");
        return invoice1;
    }
}
