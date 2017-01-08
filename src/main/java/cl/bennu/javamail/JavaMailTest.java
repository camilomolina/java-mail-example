package cl.bennu.javamail;

import cl.bennu.javamail.helper.JavaMailHelper;

public class JavaMailTest {

    public static void main(String[] args) throws Exception {
        String host = "smtp.gmail.com";
        int port = 465;
        String user = "djmac.j@gmail.com";
        String pass = "*******";
        String from = "support@bennu.cl";
        String to = "camilo@bennu.cl";
        String subject = "Soporte Bennu";
        String doby = "Soporte Bennu nuevo 2";
        boolean ssl = true;

        JavaMailHelper.sendMail(host, port, ssl, from, to, subject, doby, user, pass);
    }


}
