package com.mycompany.calculadoraimc.controlador;

import com.mycompany.calculadoraimc.dao.MedicionDAO;
import com.mycompany.calculadoraimc.modelo.MedicionIMC;
import com.mycompany.calculadoraimc.modelo.Usuario;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CalculoServlet", urlPatterns = {"/CalculoServlet"})
public class CalculoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Usuario usuario = (session == null) ? null
                : (Usuario) session.getAttribute("usuario");

        // Sin sesión no se puede calcular
        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        double peso;
        try {
            peso = Double.parseDouble(request.getParameter("peso"));
        } catch (NumberFormatException | NullPointerException e) {
            response.sendRedirect("imc.jsp?error=peso");
            return;
        }

        // No se aceptan 0 ni negativos
        if (peso <= 0) {
            response.sendRedirect("imc.jsp?error=peso");
            return;
        }

        MedicionIMC medicion = new MedicionIMC(0, usuario.getIdUsuario(),
                usuario.getEstatura(), peso, 0, new Date());

        boolean ok = new MedicionDAO().guardar(medicion);

        response.sendRedirect(ok ? "imc.jsp" : "imc.jsp?error=guardar");
    }
}