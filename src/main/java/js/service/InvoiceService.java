package js.service;

import js.model.Invoice;
import js.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

    private final UserService userService;
    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public InvoiceService(UserService userService) {
        this.userService = userService;
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);

        if (user == null) {
            throw new IllegalStateException();
        }
        //create invoice
        Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");

        //add to list
        invoices.add(invoice);

        //return new invoice
        return invoice;
    }
}
