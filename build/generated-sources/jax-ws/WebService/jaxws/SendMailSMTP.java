
package WebService.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnviarCorreoSMTP", namespace = "http://WebService/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnviarCorreoSMTP", namespace = "http://WebService/", propOrder = {
    "remitente",
    "clave",
    "para",
    "copia",
    "asunto",
    "mensaje",
    "servidor",
    "puerto"
})
public class SendMailSMTP {

    @XmlElement(name = "Remitente", namespace = "")
    private String remitente;
    @XmlElement(name = "Clave", namespace = "")
    private String clave;
    @XmlElement(name = "Para", namespace = "")
    private String para;
    @XmlElement(name = "Copia", namespace = "")
    private String copia;
    @XmlElement(name = "Asunto", namespace = "")
    private String asunto;
    @XmlElement(name = "Mensaje", namespace = "")
    private String mensaje;
    @XmlElement(name = "Servidor", namespace = "")
    private String servidor;
    @XmlElement(name = "Puerto", namespace = "")
    private int puerto;

    /**
     * 
     * @return
     *     returns String
     */
    public String getRemitente() {
        return this.remitente;
    }

    /**
     * 
     * @param remitente
     *     the value for the remitente property
     */
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getClave() {
        return this.clave;
    }

    /**
     * 
     * @param clave
     *     the value for the clave property
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPara() {
        return this.para;
    }

    /**
     * 
     * @param para
     *     the value for the para property
     */
    public void setPara(String para) {
        this.para = para;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCopia() {
        return this.copia;
    }

    /**
     * 
     * @param copia
     *     the value for the copia property
     */
    public void setCopia(String copia) {
        this.copia = copia;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getAsunto() {
        return this.asunto;
    }

    /**
     * 
     * @param asunto
     *     the value for the asunto property
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getMensaje() {
        return this.mensaje;
    }

    /**
     * 
     * @param mensaje
     *     the value for the mensaje property
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getServidor() {
        return this.servidor;
    }

    /**
     * 
     * @param servidor
     *     the value for the servidor property
     */
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getPuerto() {
        return this.puerto;
    }

    /**
     * 
     * @param puerto
     *     the value for the puerto property
     */
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

}
