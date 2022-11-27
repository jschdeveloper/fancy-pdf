package js.service;

import js.model.Invoice;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvoiceService {

    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        //create invoice
        Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");

        //add to list
        invoices.add(invoice);

        //return new invoice
        return invoice;
    }
}
