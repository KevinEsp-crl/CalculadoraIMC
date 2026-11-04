package com.mycompany.calculadoraimc.controlador;

import com.mycompany.calculadoraimc.dao.UsuarioDAO;
import com.mycompany.calculadoraimc.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("nombre");
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        String sexo = request.getParameter("sexo");

        int edad = Integer.parseInt(request.getParameter("edad"));
        double estatura = Double.parseDouble(request.getParameter("estatura"));

        if (nombre == null || nombre.trim().isEmpty()
                || usuario == null || usuario.trim().isEmpty()
                || contraseña == null || contraseña.trim().isEmpty()
                || edad < 15 || estatura < 1 || estatura > 2.5) {

            response.sendRedirect("registro.jsp?error=datos");
            return;
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setUsuario(usuario);
        nuevoUsuario.setContraseña(contraseña);
        nuevoUsuario.setEdad(edad);
        nuevoUsuario.setSexo(sexo);
        nuevoUsuario.setEstatura(estatura);

        UsuarioDAO dao = new UsuarioDAO();

        if (dao.registrar(nuevoUsuario)) {
            response.sendRedirect("login.jsp?registro=exitoso");
        } else {
            response.sendRedirect("registro.jsp?error=registro");
        }
    }
}