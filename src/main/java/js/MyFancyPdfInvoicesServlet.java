package js;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFancyPdfInvoicesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("path: " + request.getRequestURI());

        String path = request.getRequestURI();
        switch (path) {
            case "/":
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().print("<html>\n" + "<body>\n" + "<h1>Hello World</h1>\n" + "<p>This is my very first, embedded Tomcat, HTML Page!</p>\n" + "</body>\n" + "</html>");
                break;
            case "/invoices":
                Invoice invoice = new Invoice();
                invoice.setId("ok");
                System.out.println(invoice.getId());

                response.setContentType("application/json; charset=UTF-8");
                response.getWriter().print("[]");
                break;

            default:
                System.out.println("no configure yet");

        }

    }
}
