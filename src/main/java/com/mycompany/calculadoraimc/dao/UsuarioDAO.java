package com.mycompany.calculadoraimc.dao;
import com.mycompany.calculadoraimc.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    // Registrar un usuario
    public boolean registrar(Usuario usuario) {

        String sql = "INSERT INTO Usuario "
                + "(Nombre, Usuario, Contraseña, Edad, Sexo, Estatura) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getContraseña());
            ps.setInt(4, usuario.getEdad());
            ps.setString(5, usuario.getSexo());
            ps.setDouble(6, usuario.getEstatura());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.getMessage());
            return false;
        }
    }

    // Validar inicio de sesión
    public Usuario iniciarSesion(String nombreUsuario, String contraseña) {

        String sql = "SELECT * FROM Usuario "
                + "WHERE Usuario = ? AND Contraseña = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nombreUsuario);
            ps.setString(2, contraseña);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Usuario usuario = new Usuario();

                    usuario.setIdUsuario(rs.getInt("IdUsuario"));
                    usuario.setNombre(rs.getString("Nombre"));
                    usuario.setUsuario(rs.getString("Usuario"));
                    usuario.setContraseña(rs.getString("Contraseña"));
                    usuario.setEdad(rs.getInt("Edad"));
                    usuario.setSexo(rs.getString("Sexo"));
                    usuario.setEstatura(rs.getDouble("Estatura"));

                    return usuario;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }

        return null;
    }
}