package servlet;

import dao.TipoLavadoDAO;
import dto.TipoLavadoDTO;
import jdbc.jdbc_tipoLavado;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/tipoLavados")
public class servletTipoLavado extends HttpServlet
{
    public void accion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String accion = request.getParameter("accion");
        if(accion != null && accion.equals("agregar"))
        {
            this.agregar(request,response);
        }
        else if(accion != null && accion.equals("consultar"))
        {
            this.consultar(request,response);
        }
        else if (accion != null && accion.equals("actualizar"))
        {
            this.actualizar(request, response);
        }
        else
        {
            this.lista(request, response);
        }
    }

    public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en listar ");
        TipoLavadoDAO tipoLavadoDAO = new jdbc_tipoLavado();
        try
        {
            List<TipoLavadoDTO> tipoLavados = tipoLavadoDAO.listar();
            if(tipoLavados!=null)
            {
                request.setAttribute("tipoLavados",tipoLavados);
                request.getRequestDispatcher("/tipolavado/listado_tipoLavado.jsp").forward(request,response);
            }
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
        System.out.println(tipoLavado);
        String precio = request.getParameter("precio");
        double precioDouble = Double.parseDouble(precio);
        TipoLavadoDTO tipoLavadoDTO = new TipoLavadoDTO();
        tipoLavadoDTO.setTipoLavado(tipoLavado);
        tipoLavadoDTO.setPrecioxkg(precioDouble);

        TipoLavadoDAO tipoLavadoDAO = new jdbc_tipoLavado();
        try
        {
            boolean test = tipoLavadoDAO.agregar(tipoLavadoDTO);
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
        this.lista(request, response);
    }

    public void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en consultar");
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        TipoLavadoDTO tipoLavadoDTO = new TipoLavadoDTO();
        tipoLavadoDTO.setId_tipoLavado(id);
        TipoLavadoDAO tipoLavadoDAO = new jdbc_tipoLavado();
        try
        {
            TipoLavadoDTO tipoLavadoDTO1 = tipoLavadoDAO.consultar(tipoLavadoDTO);
            if (tipoLavadoDTO1 != null)
            {
                request.setAttribute("tipo",tipoLavadoDTO1);
                request.getRequestDispatcher("/tipolavado/actualizar_tipoLavado.jsp").forward(request,response);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error en consultar tipo de lavado en servlet");
            System.out.println(s.getMessage());
        }
    }

    public void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en actualizar");
        String modificar = request.getParameter("modificar");
        String eliminar = request.getParameter("eliminar");

        if(modificar != null && modificar.equals("modificar"))
        {
            String idString = request.getParameter("id");
            String tipoString = request.getParameter("tipo");
            String precioString = request.getParameter("precio");
            int id = Integer.parseInt(idString);
            double precio = Double.parseDouble(precioString);

            TipoLavadoDTO tipoLavadoDTO = new TipoLavadoDTO();
            tipoLavadoDTO.setTipoLavado(tipoString);
            tipoLavadoDTO.setPrecioxkg(precio);
            tipoLavadoDTO.setId_tipoLavado(id);

            TipoLavadoDAO tipoLavadoDAO = new jdbc_tipoLavado();
            try
            {
                boolean test = tipoLavadoDAO.modificar(tipoLavadoDTO);
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
        else if(eliminar != null && eliminar.equals("eliminar"))
        {
            String idString = request.getParameter("id");
            int id = Integer.parseInt(idString);

            TipoLavadoDTO tipoLavadoDTO = new TipoLavadoDTO();
            tipoLavadoDTO.setId_tipoLavado(id);

            TipoLavadoDAO tipoLavadoDAO = new jdbc_tipoLavado();
            try
            {
                boolean test = tipoLavadoDAO.eliminar(tipoLavadoDTO);
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
        this.lista(request, response);
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
