/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package bean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author maitr
 */
@MessageDriven(mappedName = "jms/queue1", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NewMessageBean implements MessageListener {
    
    String msg;
    
    public NewMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage) {
            try {
                msg = ((TextMessage) message).getText();
                System.out.println(msg + "");
            } catch (JMSException ex) {
                Logger.getLogger(NewMessageBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
