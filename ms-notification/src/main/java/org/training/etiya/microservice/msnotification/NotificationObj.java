package org.training.etiya.microservice.msnotification;

public class NotificationObj {
    private String dest;
    private String msg;

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
