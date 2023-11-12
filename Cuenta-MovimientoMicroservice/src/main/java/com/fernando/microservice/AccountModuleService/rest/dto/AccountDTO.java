package com.fernando.microservice.AccountModuleService.rest.dto;

import java.util.Objects;

public class AccountDTO {

    private Long id;
    private ClientDTO client;
    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return this.tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldoInicial() {
        return this.saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Boolean isEstado() {
        return this.estado;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public ClientDTO getClient() {
        return this.client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AccountDTO that = (AccountDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(numeroCuenta, that.numeroCuenta) &&
                Objects.equals(tipoCuenta, that.tipoCuenta) &&
                Objects.equals(saldoInicial, that.saldoInicial) &&
                Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroCuenta, tipoCuenta, saldoInicial, estado);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", numeroCuenta='" + getNumeroCuenta() + "'" +
                ", tipoCuenta='" + getTipoCuenta() + "'" +
                ", saldoInicial='" + getSaldoInicial() + "'" +
                ", estado='" + isEstado() + "'" +
                "}";
    }

}
