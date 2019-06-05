package servlet;

import dao.FacturaDAO;
import dto.FacturaDTO;
import jdbc.jdbc_factura;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/facturas")
public class ServletFactura extends HttpServlet
{
    public void accion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("agregar"))
        {
            this.agregar(request, response);
        }
        else if (accion != null && accion.equals("consultar"))
        {
            this.consultar(request, response);
        }
        else if (accion != null && accion.equals("actualizar"))
        {
            this.actualizar(request, response);
        }
        else
        {
            this.listar(request, response);
        }
    }

    public void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String nombreEmpresa = request.getParameter("nombreEmpresa");
        String nombreComecial = request.getParameter("nombreComercial");
        String ruc = request.getParameter("ruc");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String numeroOperacionString = request.getParameter("numeroOperacion");
        String numeroBoletaString = request.getParameter("boleta");
        int numeroOperacion = Integer.parseInt(numeroOperacionString);
        int numeroBoleta = Integer.parseInt(numeroBoletaString);

        FacturaDTO facturaDTO = new FacturaDTO();
        facturaDTO.setNombreEmpresa(nombreEmpresa);
        facturaDTO.setNombreComercial(nombreComecial);
        facturaDTO.setRuc(ruc);
        facturaDTO.setDireccion(direccion);
        facturaDTO.setTelefono(telefono);
        facturaDTO.setNum_operacion(numeroOperacion);
        facturaDTO.setNum_boleta(numeroBoleta);

        FacturaDAO facturaDAO = new jdbc_factura();
        try
        {
            int row = facturaDAO.agregar_factura(facturaDTO);
        }
        catch (SQLException s)
        {
            System.out.println("Error al agregar factura");
            System.out.println(s.getMessage());
        }
        this.listar(request, response);
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        FacturaDAO facturaDAO = new jdbc_factura();
        try
        {
            List<FacturaDTO> facturaDTOS = facturaDAO.listar_factura();
            request.setAttribute("facturas", facturaDTOS);
            request.getRequestDispatcher("factura/listar_factura.jsp").forward(request,response);
        }
        catch (SQLException s)
        {
            System.out.println("Error al listar factura en el servlet");
            System.out.println(s.getMessage());
        }

    }

    public void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);

        FacturaDTO facturaDTO = new FacturaDTO();
        facturaDTO.setId_factura(id);

        FacturaDAO facturaDAO = new jdbc_factura();
        try
        {
            FacturaDTO facturaDTO1 = facturaDAO.consultar_factura(facturaDTO);
            request.setAttribute("factura", facturaDTO1);
            request.getRequestDispatcher("/factura/actualizar_factura.jsp").forward(request, response);
        }
        catch (SQLException s)
        {
            System.out.println("Error al consultar factura jdbc");
            System.out.println(s.getMessage());
        }
    }

    public void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("ingreso en actualizar");
        String modificar = request.getParameter("modificar");
        String eliminar = request.getParameter("eliminar");
        String idString = request.getParameter("id_factura");
        int id = Integer.parseInt(idString);

        if(modificar != null && modificar.equals("modificar"))
        {
            String nombreEmpresa = request.getParameter("nombreEmpresa");
            String nombreComercial = request.getParameter("nombreComercial");
            String ruc = request.getParameter("ruc");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String numeroOperacion = request.getParameter("numeroOperacion");
            String numeroBoleta = request.getParameter("numeroBoleta");
            int operacion = Integer.parseInt(numeroOperacion);
            int boleta = Integer.parseInt(numeroBoleta);

            FacturaDTO facturaDTO = new FacturaDTO();
            facturaDTO.setId_factura(id);
            facturaDTO.setNombreEmpresa(nombreEmpresa);
            facturaDTO.setNombreComercial(nombreComercial);
            facturaDTO.setRuc(ruc);
            facturaDTO.setDireccion(direccion);
            facturaDTO.setTelefono(telefono);
            facturaDTO.setNum_operacion(operacion);
            facturaDTO.setNum_boleta(boleta);

            FacturaDAO facturaDAO = new jdbc_factura();
            try
            {
                int row = facturaDAO.actualizar_factura(facturaDTO);
            }
            catch (SQLException s)
            {
                System.out.println("Error al actualizar factura servelt");
                System.out.println(s.getMessage());
            }
        }
        else if (eliminar != null && eliminar.equals("eliminar"))
        {
            FacturaDTO facturaDTO = new FacturaDTO();
            facturaDTO.setId_factura(id);

            FacturaDAO facturaDAO = new jdbc_factura();
            try
            {
                int row = facturaDAO.eliminar_factura(facturaDTO);
            }
            catch (SQLException s)
            {
                System.out.println("Error al eliminar factura");
                System.out.println(s.getMessage());
            }
        }
        this.listar(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.accion(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.accion(request, response);
    }
}
