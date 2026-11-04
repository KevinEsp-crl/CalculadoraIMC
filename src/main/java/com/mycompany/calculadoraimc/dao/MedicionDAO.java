package com.mycompany.calculadoraimc.dao;

import com.mycompany.calculadoraimc.modelo.MedicionIMC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicionDAO {

    // Guardar una medición de IMC
    public boolean guardar(MedicionIMC medicion) {

        String sql = "INSERT INTO Medicion_IMC "
                + "(IdUsuario, Peso, IMC, FechaMedicion, Estatura) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, medicion.getIdUsuario());
            ps.setDouble(2, medicion.getPeso());
            ps.setDouble(3, medicion.calcularIMC());
            ps.setDate(4, new java.sql.Date(
                    medicion.getFechaMedicion().getTime()));
            ps.setDouble(5, medicion.getEstatura());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al guardar medición: " + e.getMessage());
            return false;
        }
    }

    // Consultar historial de mediciones
    public List<MedicionIMC> obtenerHistorial(int idUsuario) {

        List<MedicionIMC> historial = new ArrayList<>();

        String sql = "SELECT * FROM Medicion_IMC "
         + "WHERE IdUsuario = ? ORDER BY IdMedicion DESC";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    MedicionIMC medicion = new MedicionIMC(
                            rs.getInt("IdMedicion"),
                            rs.getInt("IdUsuario"),
                            rs.getDouble("Estatura"),
                            rs.getDouble("Peso"),
                            rs.getDouble("IMC"),
                            rs.getDate("FechaMedicion")
                    );

                    historial.add(medicion);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar historial: " + e.getMessage());
        }

        return historial;
    }
}