package com.fernando.microservice.ClientModuleService.utils;

import org.zalando.problem.AbstractThrowableProblem;

@SuppressWarnings("java:S110")
public class BadRequestAlertException extends AbstractThrowableProblem {

    private String message;

    public BadRequestAlertException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
