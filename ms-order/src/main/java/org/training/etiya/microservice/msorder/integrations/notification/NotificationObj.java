package org.training.etiya.microservice.msorder.integrations.notification;

public class NotificationObj {
    private String dest;
    private String msg;

    public NotificationObj() {
    }

    public NotificationObj(String dest,
                           String msg) {
        this.dest = dest;
        this.msg = msg;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "NotificationObj{" +
                "dest='" + dest + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
