package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/caja")
public class ServletCaja extends HttpServlet
{
    public void acciones(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        this.acciones(request,response);
        System.out.println("Ingreso al metodo post");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        this.acciones(request, response);
    }
}
