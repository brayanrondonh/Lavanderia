package servlet;

import dao.ClienteDAO;
import dto.ClienteDTO;
import jdbc.jdbc_cliente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/clientes")
public class ServletCliente extends HttpServlet
{
    private void accion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingresaste en accion");
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

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en agregar");
        String dniTemp = request.getParameter("dni");
        String nombreTemp = request.getParameter("nombre");
        String apellidoTemp = request.getParameter("apellido");
        String correoTemp = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(nombreTemp);
        clienteDTO.setApellido(apellidoTemp);
        clienteDTO.setDni(dniTemp);
        clienteDTO.setCorreo(correoTemp);
        clienteDTO.setTelefono(dniTemp);

        ClienteDAO clienteDAO = new jdbc_cliente();

        try
        {
            boolean test = clienteDAO.agregar(clienteDTO);
            if (test)
            {
                this.listar(request, response);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al agregar cliente en el servlet");
            System.out.println(s.getMessage());
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en listar");
        ClienteDAO clienteDAO = new jdbc_cliente();
        try
        {
            List<ClienteDTO> cliente = clienteDAO.listar();
            if (cliente != null)
            {
                request.setAttribute("cliente",cliente);
                request.getRequestDispatcher("/cliente/listado_cliente.jsp").forward(request,response);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al listar clientes en servlet");
            System.out.println(s.getMessage());
        }
    }

    private void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en consultar");
        String idString = request.getParameter("idCliente");
        int id = Integer.parseInt(idString);
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId_cliente(id);
        ClienteDAO clienteDAO = new jdbc_cliente();
        try
        {
            ClienteDTO clienteDTO1 = clienteDAO.consultar(clienteDTO);
            if (clienteDTO1!=null)
            {
                request.setAttribute("cliente",clienteDTO1);
                request.getRequestDispatcher("/cliente/actualizar_cliente.jsp").forward(request,response);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al consultar cliente en el servlet");
            System.out.println(s.getMessage());
        }
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Ingreso en actualizar");
        String idString = request.getParameter("id_cliente");
        int id = Integer.parseInt(idString);
        String modificar = request.getParameter("modificar");
        String eliminar = request.getParameter("eliminar");
        if (modificar != null && modificar.equals("modificar"))
        {
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("telefono");
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNombre(nombre);
            clienteDTO.setApellido(apellido);
            clienteDTO.setDni(dni);
            clienteDTO.setCorreo(correo);
            clienteDTO.setTelefono(telefono);
            clienteDTO.setId_cliente(id);

            ClienteDAO clienteDAO = new jdbc_cliente();
            try
            {
                boolean test = clienteDAO.modificar(clienteDTO);
            }
            catch (SQLException s)
            {
                System.out.println("Error al actualizar cliente en servlet");
                System.out.println(s.getMessage());
            }
        }
        else if (eliminar != null && eliminar.equals("eliminar"))
        {
            System.out.println("Boton en eliminar");
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setId_cliente(id);
            ClienteDAO clienteDAO = new jdbc_cliente();
            try
            {
                boolean test = clienteDAO.eliminar(clienteDTO);
            }
            catch (SQLException s)
            {
                System.out.println("Error al eliminar cliente en servlet");
                System.out.println(s.getMessage());
            }
        }
        this.listar(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.accion(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.accion(request, response);
    }
}
