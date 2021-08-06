package WebService;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Implementación del servicio web
 * @version 1.0
 * @author carlos
 */
@WebService(serviceName = "MailWebService")
public class MailWebService {

    private Pattern pattern;
    private Matcher matcher;
 
    private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
    /**
     * @version  1.0
     * Método para enviar correos SMTP
     * @param From Remitente del correo
     * @param Password Clave del correo
     * @param To Destinatarios del correo separados por coma
     * @param Cc Copia a destinatarios del correo separados por coma
     * @param Subject Asunto  del correo
     * @param Message Mensaje del correo
     * @param Server Servidor de correo
     * @param Port Puerto del servidor de correo
     * @autor carlos
     * @return Retorna si (true) envió o no(false) exitosamente el correo
     */
    @WebMethod(operationName = "EnviarCorreoSMTP")
    public boolean  SendMailSMTP(
    @WebParam(name = "Remitente")String From, 
    @WebParam(name = "Clave")String Password, 
    @WebParam(name = "Para")String To, 
    @WebParam(name = "Copia")String Cc,
    @WebParam(name = "Asunto") String Subject, 
    @WebParam(name = "Mensaje")String Message,
    @WebParam(name = "Servidor") String Server, 
    @WebParam(name = "Puerto")int Port) {
        try
        {
            Mail mail = new Mail();
            
            mail.setFrom(From);
            mail.setPassword(Password);        
            mail.setTo(To);
            mail.setCc(Cc);
            mail.setSubject(Subject);
            mail.setMessage(Message);
            mail.setServer(Server);
            mail.setPort(Port);

            return mail.SEND();
        } catch (Exception ex) {
                System.out.println(ex);
        }
        return false;
    }

    /**
     * @version  1.0
     * @autor carlos
     * Validación de correo electrónico
     * @param email Dirección de correo electrónico
     */
    @WebMethod(operationName = "validEmail")
    public boolean validEmail(@WebParam(name = "email") String email) {
        
        try
        {  
            if (email == null) return false;
                    
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(email.trim());
            
            return matcher.matches();

        } catch (Exception ex) {
                System.out.println(ex);
         }
        return false;
    }
    /**
     * @version  1.0
     * @autor carlos
     * Validación de correo electrónico
     * @param email Dirección de correo electrónico
     */
    @WebMethod(operationName = "validEmails")
    public boolean validEmails(@WebParam(name = "emails") String emails) {
        
        if (emails == null) return false;
        
        pattern = Pattern.compile(EMAIL_PATTERN);
        
        String[] tmp = emails.split(",");
                
        for (int i = 0; i < tmp.length; i++) {
            try {
                matcher = pattern.matcher(tmp[i].trim());
                if (!matcher.matches())
                    return false;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }        
        return true;
    }
}
