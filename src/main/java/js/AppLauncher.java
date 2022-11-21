package js;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class AppLauncher {
    public static void main(String[] args) throws LifecycleException {
        System.out.println("init server....");

        Tomcat tomcat = new Tomcat();

        //configure port of the server
        tomcat.setPort(8080);

        //this line is required because run the engine of tomcat
        tomcat.getConnector();


        //contextPath: if you have more than 1 application in the same server, you can configure in diff contexts example
        // localhost/app1 and localhost/app2
        //docBase: path where you can add statics files
        Context ctx = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(ctx, "myFirstServlet", new MyFirstServlet());
        servlet.setLoadOnStartup(1);

        //You are telling Tomcat that your Servlet should react to any request that starts with "/", i.e.
        servlet.addMapping("/*");

        tomcat.start();
    }
}
