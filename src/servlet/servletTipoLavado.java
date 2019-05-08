package servlet;

import dao.TipoLavadoDAO;
import domain.TipoLavado;
import jdbc.jdbc_tipoLavado;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/tipolavado")
public class servletTipoLavado extends HttpServlet
{
    public void accion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String accion = request.getParameter("accion");
        if(accion != null && accion.equals("agregar"))
        {
            this.agregar(request,response);
        }
        else if(accion != null && accion.equals("listar"))
        {
            this.lista(request,response);
        }
    }

    public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en listar ");
        TipoLavadoDAO tipoLavadoDAO = new jdbc_tipoLavado();
        try
        {
            List<TipoLavado> tipoLavados = tipoLavadoDAO.listar();
            System.out.println(tipoLavados);
        }
        catch (SQLException s)
        {
            System.out.println("Error en listar tipoLavados");
            System.out.println(s.getMessage());
        }
    }

    public void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en agregar tipo de lavado");
        String tipoLavado = request.getParameter("tipo");
        String precio = request.getParameter("precio");
        double precioDouble = Double.parseDouble(precio);
        TipoLavadoDAO tipoLavadoDAO = new jdbc_tipoLavado();
        try
        {
            boolean test = tipoLavadoDAO.agregarTipoLavado(tipoLavado,precioDouble);
            if(test)
            {
                System.out.println("Todo salio bien");
            }
            else
            {
                System.out.println("Ni viseryon tubo tan mala suerte");
            }
        }
        catch (SQLException s)
        {
            System.out.println("Exploto el agregar tipo lavado en el servlet");
            System.out.println(s.getMessage());
        }

    }

    public void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    public void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String modificar = request.getParameter("actualizar");
        String eliminar = request.getParameter("eliminar");

        if(modificar != null && modificar.equals("Modificar"))
        {
            String idString = request.getParameter("id");
            String tipoString = request.getParameter("tipo");
            String precioString = request.getParameter("precio");
            int id = Integer.parseInt(idString);
            double precio = Double.parseDouble(precioString);

            TipoLavadoDAO tipoLavadoDAO = new jdbc_tipoLavado();
            try
            {
                boolean test = tipoLavadoDAO.modificarTipoLavado(tipoString,precio,id);
                if(test)
                {
                    System.out.println("Los datos fueron modificados");
                }
                else
                {
                    System.out.println("Tu codido como viseryon");
                }
            }
            catch (SQLException s)
            {
                System.out.println("Exploto el actualizar el tipoLavado en el servlet");
                System.out.println(s.getMessage());
            }

        }
        else if(eliminar != null && eliminar.equals("Eliminar"))
        {
            String idString = request.getParameter("id");
            int id = Integer.parseInt(idString);

            TipoLavadoDAO tipoLavadoDAO = new jdbc_tipoLavado();
            try
            {
                boolean test = tipoLavadoDAO.eliminarTipoLavado(id);
                if(test)
                {
                    System.out.println("Se elimino el tipo de lavado");
                }
                else
                {
                    System.out.println("Khal drogo esta mas vivo que tu codigo");
                }
            }
            catch (SQLException s)
            {
                System.out.println("Exploto el eliminar tipoLavado en el servlet");
                System.out.println(s.getMessage());
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.accion(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.accion(request,response);
    }
}
