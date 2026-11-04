package com.mycompany.calculadoraimc.modelo;

import java.util.Date;

public class MedicionIMC {

    private int idMedicion;
    private int idUsuario;
    private double estatura;
    private double peso;
    private double imc;
    private Date fechaMedicion;

    // Constructor vacío necesario para REST/JSON/XML
    public MedicionIMC() {
    }

    // Constructor completo
    public MedicionIMC(int idMedicion, int idUsuario, double estatura,
                      double peso, double imc, Date fechaMedicion) {
        this.idMedicion = idMedicion;
        this.idUsuario = idUsuario;
        this.estatura = estatura;
        this.peso = peso;
        this.imc = imc;
        this.fechaMedicion = fechaMedicion;
    }

    public int getIdMedicion() {
        return idMedicion;
    }

    public void setIdMedicion(int idMedicion) {
        this.idMedicion = idMedicion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public Date getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(Date fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
    }

    public double calcularIMC() {
        if (estatura <= 0 || peso <= 0) {
            return 0;
        }

        return peso / (estatura * estatura);
    }
}