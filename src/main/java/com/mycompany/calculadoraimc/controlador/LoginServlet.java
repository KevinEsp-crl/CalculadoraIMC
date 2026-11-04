package com.mycompany.calculadoraimc.controlador;

import com.mycompany.calculadoraimc.dao.UsuarioDAO;
import com.mycompany.calculadoraimc.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");

        UsuarioDAO dao = new UsuarioDAO();

        Usuario usuarioEncontrado = dao.iniciarSesion(usuario, contraseña);

        if (usuarioEncontrado != null) {

            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuarioEncontrado);

            response.sendRedirect("imc.jsp");

        } else {

            response.sendRedirect("login.jsp?error=credenciales");
        }
    }
}