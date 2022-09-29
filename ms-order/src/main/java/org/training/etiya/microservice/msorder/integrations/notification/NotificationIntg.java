package org.training.etiya.microservice.msorder.integrations.notification;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationIntg {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendSMS(NotificationObj notificationObj) {
        rabbitTemplate.convertAndSend("notfication-exchange",
                                      "sms-notification",
                                      notificationObj);
    }

    public void sendMail(NotificationObj notificationObj) {
        rabbitTemplate.convertAndSend("notfication-exchange",
                                      "mail-notification",
                                      notificationObj);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "response-queue",
            durable = "true",
            autoDelete = "false"),
            exchange = @Exchange(name = "notfication-response-exchange",
                    autoDelete = "false",
                    durable = "true", type = ExchangeTypes.DIRECT),
            key = "response-notification"))
    public void handleResponse(NotificationObj msg) {
        System.out.println("Response from notificaiton : " + msg);
    }


}
