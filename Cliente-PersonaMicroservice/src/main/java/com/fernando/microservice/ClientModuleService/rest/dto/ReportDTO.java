package com.fernando.microservice.ClientModuleService.rest.dto;

public class ReportDTO {
    private Long id;
    private String report;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReport() {
        return this.report;
    }

    public void setReport(String report) {
        this.report = report;
    }

}
