package cl.bennu.javamail;

import cl.bennu.javamail.builder.MailHelper;
import org.apache.commons.mail.HtmlEmail;

public class MailTest {

    public static void main(String[] args) throws Exception {
        String host = "smtp.gmail.com";
        int port = 465;
        String from = "support@bennu.cl";
        String fromAlias = "";
        String user = "djmac.j@gmail.com";
        String pass = "********";
        boolean ssl = true;
        boolean tls = false;

        HtmlEmail email = MailHelper.buildHtmlEmail(host, port, ssl, tls, from, fromAlias, user, pass);

        email.setSubject("Test 2");
        email.addTo("camilo@bennu.cl");
        //email.addTo("camilo.molina.orth@gmail.com");
        email.setHtmlMsg("<html><body>Test HTML Mail</body></html>");

        email.send();
    }


}
