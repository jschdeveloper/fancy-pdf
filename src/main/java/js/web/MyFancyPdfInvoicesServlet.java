package js.web;


import js.context.Application;
import js.model.Invoice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MyFancyPdfInvoicesServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("get path: " + request.getRequestURI());

        String path = request.getRequestURI();
        if ("/".equalsIgnoreCase(path)) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("<html>\n" + "<body>\n" + "<h1>Hello World</h1>\n" + "<p>Health : OK </p>\n" + "</body>\n" + "</html>");

        } else if ("/invoices".equalsIgnoreCase(path)) {
            //configure return type
            response.setContentType("application/json; charset=UTF-8");

            //get all invoices
            List<Invoice> invoices = Application.invoiceService.findAll();

            //convert invoices to json
            String json = Application.objectMapper.writeValueAsString(invoices);

            //return json with invoices
            response.getWriter().print(json);

        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post path: " + request.getRequestURI());
        String path = request.getRequestURI();

        //test with cUrl
        //curl -d "user_id=jesus&amount=10" -X POST http://localhost:8080/invoices/

        if ("/invoices".equalsIgnoreCase(path)) {

            //get parameters of url
            String userId = request.getParameter("user_id");
            Integer amount = Integer.parseInt(request.getParameter("amount"));

            //configure return type
            response.setContentType("application/json; charset=UTF-8");

            //create new invoice
            Invoice invoice = Application.invoiceService.create(userId, amount);

            //convert invoice to json
            String json = Application.objectMapper.writeValueAsString(invoice);

            //return json
            response.getWriter().print(json);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
