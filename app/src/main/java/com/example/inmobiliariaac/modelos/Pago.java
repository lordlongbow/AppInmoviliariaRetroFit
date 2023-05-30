package com.example.inmobiliariaac.modelos;

import java.util.Date;

public class Pago {

    private int PagoId;
    private float Monto;
    private Contrato Contrato;
    private Date Fecha;
    private int ContratoId;

    public Pago() {
    }

    public Pago(int pagoId, float monto, com.example.inmobiliariaac.modelos.Contrato contrato, Date fecha, int contratoId) {
        PagoId = pagoId;
        Monto = monto;
        Contrato = contrato;
        Fecha = fecha;
        ContratoId = contratoId;
    }


    public int getPagoId() {
        return PagoId;
    }

    public void setPagoId(int pagoId) {
        PagoId = pagoId;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float monto) {
        Monto = monto;
    }

    public com.example.inmobiliariaac.modelos.Contrato getContrato() {
        return Contrato;
    }

    public void setContrato(com.example.inmobiliariaac.modelos.Contrato contrato) {
        Contrato = contrato;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public int getContratoId() {
        return ContratoId;
    }

    public void setContratoId(int contratoId) {
        ContratoId = contratoId;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "PagoId=" + PagoId +
                ", Monto=" + Monto +
                ", Contrato=" + Contrato +
                ", Fecha=" + Fecha +
                ", ContratoId=" + ContratoId +
                '}';
    }
}
