package jdbc;

import dao.ClienteDAO;
import dto.ClienteDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class jdbc_cliente implements ClienteDAO
{
    private Connection userConn = null;

    private final String sql_agregar = "insert into cliente (nombre,apellido,dni,telefono,correo) value (?,?,?,?,?)";

    private final String sql_modificar = "update cliente set nombre = ?, apellido = ?, dni = ?, telefono = ?, correo = ? where id_cliente = ?";

    private final String sql_eliminar = "delete from cliente where id_cliente = ?";

    private final String sql_listar = "Select * from cliente";

    private final String sql_consultar = "select * from cliente where id_cliente = ?";

    public jdbc_cliente() {}

    public jdbc_cliente(Connection conn)
    {
        this.userConn = conn;
    }

    public boolean agregar(ClienteDTO clienteDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        boolean exito = false;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_agregar);
            int index = 1;
            pstmt.setString(index++,clienteDTO.getNombre());
            pstmt.setString(index++,clienteDTO.getApellido());
            pstmt.setString(index++,clienteDTO.getDni());
            pstmt.setString(index++,clienteDTO.getTelefono());
            pstmt.setString(index,clienteDTO.getCorreo());
            row = pstmt.executeUpdate();
            System.out.println("Filas afectadas: "+row);
            exito = true;
        }
        catch (SQLException s)
        {
            System.out.println("Error en el agregar cliente");
            System.out.println(s.getMessage());
        }
        finally
        {
            Conexion.close(pstmt);
            if(userConn == null)
            {
                Conexion.close(conn);
            }
        }
        return exito;
    }

    public boolean modificar(ClienteDTO clienteDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        boolean exito = false;
        try
        {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_modificar);
            int index = 1;
            pstmt.setString(index++,clienteDTO.getNombre());
            pstmt.setString(index++,clienteDTO.getApellido());
            pstmt.setString(index++,clienteDTO.getDni());
            pstmt.setString(index++,clienteDTO.getTelefono());
            pstmt.setString(index++,clienteDTO.getCorreo());
            pstmt.setInt(index,clienteDTO.getId_cliente());
            row = pstmt.executeUpdate();
            System.out.println("Filas afectadas: "+row);
            exito = true;
        }
        catch (SQLException s)
        {
            System.out.println("Error en el modificar cliente");
            System.out.println(s.getMessage());
        }
        finally
        {
            Conexion.close(pstmt);
            if(userConn==null)
            {
                Conexion.close(conn);
            }
        }
        return exito;
    }

    public boolean eliminar(ClienteDTO clienteDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        boolean exito = false;
        try
        {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_eliminar);
            pstmt.setInt(1,clienteDTO.getId_cliente());
            row = pstmt.executeUpdate();
            System.out.println("Filas afectadas: "+row);
            exito = true;
        }
        catch (SQLException s)
        {
            System.out.println("Error al eliminar cliente");
            System.out.println(s.getMessage());
        }
        return exito;
    }

    @Override
    public List<ClienteDTO> listar()
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ClienteDTO clienteDTO = null;
        List<ClienteDTO> clientes = new ArrayList<>();
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_listar);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                int idTemp = rs.getInt(1);
                String nombreTemp = rs.getString(2);
                String apellidoTemp = rs.getString(3);
                String dniTemp = rs.getString(4);
                String telefonoTemp = rs.getString(5);
                String correoTemp = rs.getString(6);
                clienteDTO = new ClienteDTO();
                clienteDTO.setId_cliente(idTemp);
                clienteDTO.setNombre(nombreTemp);
                clienteDTO.setApellido(apellidoTemp);
                clienteDTO.setDni(dniTemp);
                clienteDTO.setTelefono(telefonoTemp);
                clienteDTO.setCorreo(correoTemp);
                clientes.add(clienteDTO);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al listar cliente");
            System.out.println(s.getMessage());
        }
        finally
        {
            Conexion.close(rs);
            Conexion.close(pstmt);
            if(userConn==null)
            {
                Conexion.close(conn);
            }
        }
        return clientes;
    }

    public ClienteDTO consultar(ClienteDTO clienteDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ClienteDTO clienteDTO1 = null;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_consultar);
            pstmt.setInt(1,clienteDTO.getId_cliente());
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                clienteDTO1 = new ClienteDTO();
                clienteDTO1.setId_cliente(rs.getInt(1));
                clienteDTO1.setNombre(rs.getString(2));
                clienteDTO1.setApellido(rs.getString(3));
                clienteDTO1.setDni(rs.getString(4));
                clienteDTO1.setCorreo(rs.getString(6));
                clienteDTO1.setTelefono(rs.getString(5));
            }
        }
        catch (SQLException s)
        {
            System.out.println("Fallo al consultar cliente jdbc");
            System.out.println(s.getMessage());
        }
        return clienteDTO1;
    }
}