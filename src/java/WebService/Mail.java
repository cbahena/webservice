package WebService;

/**
 *
 * @author carlos
 */
import javax.mail.Message;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;

/**
 * Clase para el envio de correos desde gmail
 * @author carlos
 * @version 1.0
 */
public class Mail {

    private String from = "";
    private String password = "";   
    private InternetAddress[] addressTo;
    private InternetAddress[] addressCc;
    private String Subject = "";
    private String MessageMail = "";
    private int Port = 587;
    private String Server = "";
/**
 *
 * @author carlos
 */
    public Mail(){}
/**
 * Método de envío de correos SMTP
 * @author carlos
 */
    public boolean SEND()
    {
        try {
        // setup the mail server properties
         Properties props = new Properties();
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.starttls.enable", "true");

         // Propiedades del mensaje
         Session session = Session.getInstance(props);
         Message message = new MimeMessage(session);

         // Destinatario
         message.setRecipients(Message.RecipientType.TO, this.addressTo);

         // Copia a destinatarios
         if(this.addressCc != null) message.setRecipients(Message.RecipientType.CC, this.addressCc); 
         
         message.setSubject(this.Subject);
         message.setContent(this.MessageMail, "text/plain");

         //Autenticacion
         Transport transport = session.getTransport("smtp");
         transport.connect(this.Server, this.Port, this.from, this.password);
         transport.sendMessage(message, message.getAllRecipients());
         return true;
         } catch (MessagingException ex) {
                 System.out.println(ex);
         }
     return false;
}
   
 /**
 * Setea el Remitente
 * @author carlos
 * @param mail Remitente
 */
    public void setFrom(String mail){ this.from = mail; }
 /**
 * Obtiene el remitente
 * @author carlos
 */
    public String getFrom(){ return this.from; }
 /**
 * Contraseña
 * @author carlos
 * @param value Contraseña
 */
    public void setPassword(String value){
        this.password = value;
    }
 /**
 * Obtiene la clave
 * @author carlos
 */
    public String getPassword(){ return this.password; }

 /**
 * Destinatarios
 * @author carlos
 * @param mails Destinatarios del correo
 */
    public void setTo(String mails){
        
        if (mails == null || "".equals(mails)) return;
                
        String[] tmp = mails.split(",");
        addressTo = new InternetAddress[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            try {
                addressTo[i] = new InternetAddress(tmp[i].trim());
            } catch (AddressException ex) {
                System.out.println(ex);
            }
        }
    }
 /**
 * Obtiene los destinatarios del correo
 * @author carlos
 */
    public InternetAddress[] getTo(){ return this.addressTo; }
/**
 * Copia de Destinatarios
 * @author carlos
 * @param mails Destinatarios del correo
 */
    public void setCc(String mails){
        
        if (mails == null || "".equals(mails)) return;
        
        String[] tmp = mails.split(",");
        addressCc = new InternetAddress[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            try {
                addressCc[i] = new InternetAddress(tmp[i].trim());
            } catch (AddressException ex) {
                System.out.println(ex);
            }
        }
    }
 /**
 * Obtiene los destinatarios para enviar copia del correo
 * @author carlos
 */
    public InternetAddress[] getCc(){ return this.addressCc; }
 /**
 * Asunto del correo
 * @author carlos
 * @param value Asunto del correo
 */
    public void setSubject(String value){ this.Subject = value; }
 
 /**
 *
 * @author carlos
 */
    public String getSubject(){ return this.Subject; }

 /**
 * Contenido del mensaje
 * @author carlos
 * @param value Mensaje del correo
 */
    public void setMessage(String value){ this.MessageMail = value; }
 
    /**
 * Obtiene el mensaje del correo
 * @author carlos
 */
    public String getMessage(){ return this.MessageMail; }
/**
 * Puerto del servidor de correo
 * @author carlos
 * @param value Puerto del servidor de correo
 */
    public void setPort(int value){ this.Port = value; }
 
    /**
 * Obtiene el puerto del correo
 * @author carlos
 */
    public int getPort(){ return this.Port; }
    
    /**
 * Servidor de correo smtp
 * @author carlos
 * @param value Servidor del correo smtp
 */
    public void setServer(String value){ this.Server = value; }
 
    /**
 * Obtiene el servidor del correo smtp
 * @author carlos
 */
    public String getServer(){ return this.Server; }
}
