package com.example.EmployeeManagement.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


public class EmployeeManagementException extends RuntimeException {

    private static final long serialVersionUID = -3702430061803422881L;

    private String errorCode;
    private String errorMsg;

    private String userId;
 //   private String authToken;
    public EmployeeManagementException() {
        super();
    }

    public EmployeeManagementException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public EmployeeManagementException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
    }

    public EmployeeManagementException(String message, String userId,
                                   Throwable cause) {
        super(message, cause);
        this.userId = userId;
    }



    public EmployeeManagementException(String errorCode, String errorMsg, int httpErrorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
