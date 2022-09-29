package org.training.etiya.microservice.msnotification;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
            exchange = @Exchange(name = "notfication-exchange",
                                        autoDelete = "false",
                                        durable = "true", type = ExchangeTypes.DIRECT),
            key = "sms-notification"))
    @SendTo("notfication-response-exchange/response-notification")
    public NotificationObj handleSMS(NotificationObj msg) {
        System.out.println("SMS : " + msg);
        msg.setMsg("SMS atıldı");
        return msg;
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "mail-queue",
            durable = "true",
            autoDelete = "false"),
            exchange = @Exchange(name = "notfication-exchange",
                    autoDelete = "false",
                    durable = "true", type = ExchangeTypes.DIRECT),
            key = "mail-notification"))
    @SendTo("notfication-response-exchange/response-notification")
    public NotificationObj handleMail(NotificationObj msg) {
        System.out.println("Mail : " + msg);
        msg.setMsg("MAIL atıldı");
        return msg;
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-topic-queue",
            durable = "true",
            autoDelete = "false"),
            exchange = @Exchange(name = "notfication-topic-exchange",
                    autoDelete = "false",
                    durable = "true", type = ExchangeTypes.TOPIC),
            key = "msg.sms.turkey.#"))
    public void handleTurkeySMS(NotificationObj msg) {
        System.out.println("SMS : " + msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "mail-topic-queue",
            durable = "true",
            autoDelete = "false"),
            exchange = @Exchange(name = "notfication-topic-exchange",
                    autoDelete = "false",
                    durable = "true", type = ExchangeTypes.TOPIC),
            key = "msg.mail.turkey.#"))
    public void handleTurkeyMAIL(NotificationObj msg) {
        System.out.println("MAIL : " + msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "all-msg-topic-queue",
            durable = "true",
            autoDelete = "false"),
            exchange = @Exchange(name = "notfication-topic-exchange",
                    autoDelete = "false",
                    durable = "true", type = ExchangeTypes.TOPIC),
            key = "msg.#"))
    public void handleAllMessages(NotificationObj msg) {
        System.out.println("ALL : " + msg);
    }

}
