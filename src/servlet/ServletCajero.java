package servlet;

import dao.CajeroDAO;
import dto.CajeroDTO;
import jdbc.jdbc_cajero;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/cajeros")
public class ServletCajero extends HttpServlet
{
    private void accion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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
        else if(accion != null && accion.equals("actualizar"))
        {
            this.actualizar(request, response);
        }
        else
        {
            listar(request, response);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en listar");
        CajeroDAO cajeroDAO = new jdbc_cajero();
        try
        {
            List<CajeroDTO> cajeroDTO = cajeroDAO.listar();
            if(cajeroDTO!= null)
            {
                System.out.println(cajeroDTO);
                request.setAttribute("cajero",cajeroDTO);
                request.getRequestDispatcher("/cajero/listado_cajero.jsp").forward(request,response);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al listar cajero en servlet cajero");
            System.out.println(s.getMessage());
        }
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en agregar");
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");

        CajeroDTO cajero = new CajeroDTO();
        cajero.setDniCajero(dni);
        cajero.setNombreCajero(nombre);
        cajero.setApellidoCajero(apellido);

        CajeroDAO cajeroDAO = new jdbc_cajero();
        try
        {
            boolean test = cajeroDAO.agregar(cajero);
            if(test)
            {
                System.out.println("los datos fueron registrados con exito");
                this.listar(request, response);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Problema al intenter agregar datos en el servlet cajero");
            System.out.println(s.getMessage());
            this.listar(request, response);
        }
    }

    private void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String idString = request.getParameter("idCajero");
        int id = Integer.parseInt(idString);
        System.out.println("Valor parseado "+id);
        CajeroDAO cajeroDAO = new jdbc_cajero();
        CajeroDTO cajero = new CajeroDTO();
        cajero.setId_cajero(id);
        try
        {
            CajeroDTO cajeroDTO = cajeroDAO.consultar(cajero);
            if (cajeroDTO != null)
            {
                request.setAttribute("cajero",cajeroDTO);
                request.getRequestDispatcher("/cajero/actualizar_cajero.jsp").forward(request,response);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al consultar cajero en el servletCajero");
            System.out.println(s.getMessage());
        }
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en actualizar");
        String eliminar = request.getParameter("eliminar");
        String modificar = request.getParameter("modificar");
        String idTemp = request.getParameter("id_cajero");
        int id = Integer.parseInt(idTemp);

        if(modificar != null && modificar.equals("modificar"))
        {
            String dniTemp = request.getParameter("dni");
            String nombreTemp = request.getParameter("nombre");
            String apellidoTemp = request.getParameter("apellido");

            CajeroDTO cajeroDTO = new CajeroDTO();
            cajeroDTO.setId_cajero(id);
            cajeroDTO.setNombreCajero(nombreTemp);
            cajeroDTO.setApellidoCajero(apellidoTemp);
            cajeroDTO.setDniCajero(dniTemp);
            CajeroDAO cajeroDAO = new jdbc_cajero();
            try
            {
                boolean test = cajeroDAO.modificar(cajeroDTO);
                if (test)
                {
                    System.out.println("Se realizaron los cambios");
                }
            }
            catch (SQLException s)
            {
                System.out.println("Error al modificar datos en actualizar cajero servlet");
                System.out.println(s.getMessage());
            }
        }
        if (eliminar != null && eliminar.equals("eliminar"))
        {
            CajeroDTO cajeroDTO = new CajeroDTO();
            cajeroDTO.setId_cajero(id);
            CajeroDAO cajeroDAO = new jdbc_cajero();
            try
            {
                boolean test = cajeroDAO.eliminar(cajeroDTO);
                if (test)
                {
                    System.out.println("Los datos fueron eliminados correctamente");
                }
            }
            catch (SQLException s)
            {
                System.out.println("Error al eliminar cajero servlet");
                System.out.println(s.getMessage());
            }
        }
        this.listar(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.accion(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException
    {
        this.accion(request, response);
    }
}
