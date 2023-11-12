package com.fernando.microservice.AccountModuleService.rest.dto;

import java.util.Date;

public class MovementDTO {
    private Long id;
    private AccountDTO cuenta;
    private Date fecha;
    private String tipo;
    private String movimiento;
    private Double valor;
    private Double saldo;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountDTO getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(AccountDTO cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMovimiento() {
        return this.movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

}
