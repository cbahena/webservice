package WebService;

/**
 * @author carlos
 */

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/**
 * Clase para la autenticación
 * @author carlos
 * @version 1.0
 */
public class SMTPAuthenticator extends Authenticator{

    private String SMTP_AUTH_USER = "";
    private String SMTP_AUTH_PWD = "";
/**
 * Constructir
 * @author carlos
 */
public SMTPAuthenticator() {}
/**
 * Constructor
 * @author carlos
 * @param user Usuario de la cuenta de correo
 * @param pass Clave de la cuenta de correo
 */
public SMTPAuthenticator(String user , String pass) {
    this.SMTP_AUTH_USER = user;
    this.SMTP_AUTH_PWD = pass;
}
/**
 * @author carlos
 */
 @Override
public PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(this.SMTP_AUTH_USER, this.SMTP_AUTH_PWD);
}
}


