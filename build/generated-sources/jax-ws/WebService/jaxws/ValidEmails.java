
package WebService.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "validEmails", namespace = "http://WebService/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validEmails", namespace = "http://WebService/")
public class ValidEmails {

    @XmlElement(name = "emails", namespace = "")
    private String emails;

    /**
     * 
     * @return
     *     returns String
     */
    public String getEmails() {
        return this.emails;
    }

    /**
     * 
     * @param emails
     *     the value for the emails property
     */
    public void setEmails(String emails) {
        this.emails = emails;
    }

}
