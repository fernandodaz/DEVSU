package com.fernando.microservice.AccountModuleService.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "numero_cuenta_id")
    private Account cuenta;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "movimiento")
    private String Movimiento;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "saldo")
    private Double saldo;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Account cuenta) {
        this.cuenta = cuenta;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
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
        return this.Movimiento;
    }

    public void setMovimiento(String Movimiento) {
        this.Movimiento = Movimiento;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", cuenta='" + getCuenta() + "'" +
                ", fecha='" + getFecha() + "'" +
                ", tipo='" + getTipo() + "'" +
                ", Movimiento='" + getMovimiento() + "'" +
                ", valor='" + getValor() + "'" +
                ", saldo='" + getSaldo() + "'" +
                "}";
    }

}