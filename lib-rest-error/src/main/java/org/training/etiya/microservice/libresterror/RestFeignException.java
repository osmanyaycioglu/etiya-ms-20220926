package org.training.etiya.microservice.libresterror;

public class RestFeignException extends RuntimeException {

    private ErrorObj errorObj;
    private int      status;

    public RestFeignException() {
    }

    public RestFeignException(ErrorObj errorObj,
                              int status) {
        super(errorObj.getDesc());
        this.errorObj = errorObj;
        this.status = status;
    }

    public ErrorObj getErrorObj() {
        return errorObj;
    }

    public void setErrorObj(ErrorObj errorObj) {
        this.errorObj = errorObj;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
