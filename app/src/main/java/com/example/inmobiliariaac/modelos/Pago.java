package com.example.inmobiliariaac.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Pago {

    private int pagoId;
    private float monto;
    private Contrato contrato;
    private String fecha;
    private int contratoId;

    public Pago() {
    }

    public Pago(int pagoId, float monto, Contrato contrato, String  fecha, int contratoId) {
        this.pagoId = pagoId;
        this.monto = monto;
        this.contrato = contrato;
        this.fecha = fecha;
        this.contratoId = contratoId;
    }

    public int getPagoId() {
        return pagoId;
    }

    public void setPagoId(int pagoId) {
        this.pagoId = pagoId;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public String  getFecha() {
        return fecha;
    }

    public void setFecha(String  fecha) {
        this.fecha = fecha;
    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "pagoId=" + pagoId +
                ", monto=" + monto +
                ", contrato=" + contrato +
                ", fecha=" + fecha +
                ", contratoId=" + contratoId +
                '}';
    }
}
