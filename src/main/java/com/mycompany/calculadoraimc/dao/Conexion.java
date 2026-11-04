package com.mycompany.calculadoraimc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
"jdbc:sqlserver://localhost:1433;databaseName=CalculadoraIMC;encrypt=false;trustServerCertificate=true";
    
    private static final String USUARIO = "imc_app";

    private static final String CONTRASENA = "0504p01";

    public static Connection conectar() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection conexion = DriverManager.getConnection(
                URL, USUARIO, CONTRASENA
            );

            System.out.println("Conexion exitosa con SQL Server");

            return conexion;

        } catch (ClassNotFoundException e) {

            System.out.println("Driver no encontrado: " + e.getMessage());

            return null;

        } catch (SQLException e) {

            System.out.println("Error de conexion: " + e.getMessage());

            return null;
        }
    }

    public static void main(String[] args) {
        Connection prueba = conectar();

        if (prueba != null) {
            System.out.println("PRUEBA COMPLETADA: conexión correcta.");
            try {
                prueba.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo conectar.");
        }
    }
}