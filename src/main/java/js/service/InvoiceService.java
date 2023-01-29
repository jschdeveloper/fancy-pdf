package js.service;

import js.model.Invoice;
import js.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {
    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    private final UserService userService;

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

    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Template from S3...");
        // TODO download from s3 and save locally
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Deleting downloaded templates...");
        // TODO actual deletion of PDFs
    }

}
