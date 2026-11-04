<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.mycompany.calculadoraimc.dao.MedicionDAO,
 com.mycompany.calculadoraimc.modelo.*"%>
<%
    Usuario u = (Usuario) session.getAttribute("usuario");
    if (u == null) { response.sendRedirect("login.jsp"); return; }
    List<MedicionIMC> historial = new MedicionDAO().obtenerHistorial(u.getIdUsuario());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculadora IMC</title>
</head>
<body>
<h1>Hola, <%= u.getNombre() %></h1>
<p>Estatura registrada: <%= u.getEstatura() %> m</p>

<% if ("peso".equals(request.getParameter("error"))) { %>
  <p style="color:red">El peso debe ser mayor a 0.</p>
<% } %>
<% if ("guardar".equals(request.getParameter("error"))) { %>
  <p style="color:red">No se pudo guardar la medición.</p>
<% } %>

<form action="CalculoServlet" method="post">
  Peso (kg): <input type="number" name="peso" step="0.1" min="0.1" required>
  <button type="submit">Calcular IMC</button>
</form>

<% if (!historial.isEmpty()) {
     MedicionIMC actual = historial.get(0); %>
  <h2>IMC actual: <%= String.format("%.2f", actual.getImc()) %></h2>
<% } %>

<h3>Histórico</h3>
<table border="1" cellpadding="5">
  <tr><th>Fecha</th><th>Peso (kg)</th><th>Estatura (m)</th><th>IMC</th></tr>
  <% for (MedicionIMC m : historial) { %>
  <tr>
    <td><%= m.getFechaMedicion() %></td>
    <td><%= m.getPeso() %></td>
    <td><%= m.getEstatura() %></td>
    <td><%= String.format("%.2f", m.getImc()) %></td>
  </tr>
  <% } %>
</table>
</body>
</html>