package servlet;

import dao.LavadoDAO;
import dao.TipoLavadoDAO;
import dto.LavadoDTO;
import dto.TipoLavadoDTO;
import jdbc.jbdc_lavado;
import jdbc.jdbc_tipoLavado;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/lavados")
public class ServletLavado extends HttpServlet
{
    public void accion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String accion = request.getParameter("accion");
        if (accion!=null && accion.equals("agregar"))
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
        else if (accion != null && accion.equals("registrar"))
        {
            this.registrar(request, response);
        }
        else
        {
            this.listar(request, response);
        }
    }

    public void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        TipoLavadoDAO tipoLavadoDAO = new jdbc_tipoLavado();
        try
        {
            List<TipoLavadoDTO> tipoLavadoDTO = tipoLavadoDAO.listar();
            System.out.println(tipoLavadoDTO);
            request.setAttribute("tipo", tipoLavadoDTO);
            request.getRequestDispatcher("/lavado/agregar_lavado2.jsp").forward(request,response);
        }
        catch (SQLException s)
        {
            System.out.println("Error al listar tipos de lavado en el servlet Lavado");
            System.out.println(s.getMessage());
        }
    }

    public void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String pesoString = request.getParameter("peso");
        double peso = Double.parseDouble(pesoString);
        String importeString = request.getParameter("importe");
        double importe = Double.parseDouble(importeString);
        String totalString = request.getParameter("total");
        double total = Double.parseDouble(totalString);
        String igvString = request.getParameter("igv");
        double igv = Double.parseDouble(igvString);
        String canceladoTemp = request.getParameter("cancelado");
        boolean cancelado = Boolean.parseBoolean(canceladoTemp);


        LavadoDTO lavadoDTO = new LavadoDTO();
        lavadoDTO.setPeso(peso);
        lavadoDTO.setImporte(importe);
        lavadoDTO.setTotal(total);
        lavadoDTO.setIgv(igv);
        lavadoDTO.setCancelado(cancelado);
        LavadoDAO lavadoDAO = new jbdc_lavado();
        try
        {
            int row = lavadoDAO.agregar_lavado(lavadoDTO);
        }
        catch (SQLException s)
        {
            System.out.println("Error al agregar lavado en el servlet");
            System.out.println(s.getMessage());
        }
        this.listar(request,response);
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LavadoDAO lavadoDAO = new jbdc_lavado();
        try
        {
            List<LavadoDTO> lavadoDTOS = lavadoDAO.listar_lavado();
            if (lavadoDTOS!=null)
            {
                request.setAttribute("lavado",lavadoDTOS);
                request.getRequestDispatcher("/lavado/listado_lavado.jsp").forward(request,response);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al listar lavado en el servlet");
            System.out.println(s.getMessage());
        }
    }

    public void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        LavadoDTO lavadoDTO = new LavadoDTO();
        lavadoDTO.setId_lavado(id);
        LavadoDAO lavadoDAO = new jbdc_lavado();
        try
        {
            LavadoDTO lavadoDTO1 = lavadoDAO.consultar_lavado(lavadoDTO);
            if (lavadoDTO1 != null)
            {
                System.out.println(lavadoDTO1);
                request.setAttribute("lavado",lavadoDTO1);
                request.getRequestDispatcher("/lavado/actualizar_lavado.jsp").forward(request,response);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al consultar jdbc");
            System.out.println(s.getMessage());
        }
    }

    public void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en actualizar");
        String eliminar = request.getParameter("eliminar");
        String modificar = request.getParameter("modificar");
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        if (modificar != null && modificar.equals("modificar"))
        {
            System.out.println("Ingreso en modificar");
            String pesoString = request.getParameter("peso");
            String importeString = request.getParameter("importe");
            String totalString = request.getParameter("total");
            String igvString = request.getParameter("igv");
            String canceladoString = request.getParameter("cancelado");
            String clienteString = request.getParameter("cliente");
            String tipoString = request.getParameter("tipo");
            String cajeroString = request.getParameter("cajero");

            double peso = Double.parseDouble(pesoString);
            double importe = Double.parseDouble(importeString);
            double total = Double.parseDouble(totalString);
            double igv = Double.parseDouble(igvString);
            boolean cancelado = Boolean.parseBoolean(canceladoString);
            int cliente = Integer.parseInt(clienteString);
            int cajero = Integer.parseInt(cajeroString);
            int tipo = Integer.parseInt(tipoString);

            LavadoDTO lavadoDTO = new LavadoDTO();
            lavadoDTO.setId_lavado(id);
            lavadoDTO.setPeso(peso);
            lavadoDTO.setImporte(importe);
            lavadoDTO.setTotal(total);
            lavadoDTO.setIgv(igv);
            lavadoDTO.setCancelado(cancelado);
            lavadoDTO.setId_cliente(cliente);
            lavadoDTO.setId_cajero(cajero);
            lavadoDTO.setId_tipoLavado(tipo);

            LavadoDAO lavadoDAO = new jbdc_lavado();
            try
            {
                int row = lavadoDAO.actualizar_lavado(lavadoDTO);
            }
            catch (SQLException s)
            {
                System.out.println("Error al actualizar lavado servlet");
                System.out.println(s.getMessage());
            }
        }
        else if(eliminar != null && eliminar.equals("eliminar"))
        {
            System.out.println("ingreso en eliminar");
            LavadoDTO lavadoDTO = new LavadoDTO();
            lavadoDTO.setId_lavado(id);

            LavadoDAO lavadoDAO = new jbdc_lavado();
            try
            {
                int row = lavadoDAO.eliminar_lavado(lavadoDTO);
            }
            catch (SQLException s)
            {
                System.out.println("Error al eimnar lavado en el servlet");
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
