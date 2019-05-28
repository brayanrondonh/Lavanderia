package jdbc;

import dao.CajeroDAO;
import dto.CajeroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class jdbc_cajero implements CajeroDAO
{
    private Connection userConn = null;

    private final String sql_agregarCajero = "insert into cajero (nombre,apellido,dni_cajero) value (?,?,?)";

    private final String sql_modificarCajero = "update cajero set nombre = ?, apellido = ?, dni_cajero = ? where id_cajero = ?";

    private final String sql_eliminarCajero = "delete from cajero where id_cajero = ?";

    private final String sql_listarCajeros = "select * from cajero";

    private final String sql_conultarCajero = "select * from cajero where id_cajero = ?";

    public jdbc_cajero(){}

    public jdbc_cajero(Connection conn)
    {
        this.userConn = conn;
    }

    public boolean agregar(CajeroDTO cajeroDTO)
    {
        long t1 = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean exito = false;
        int row = 1;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_agregarCajero);
            int index = 1;
            pstmt.setString(index++,cajeroDTO.getNombreCajero());
            pstmt.setString(index++,cajeroDTO.getApellidoCajero());
            pstmt.setString(index,cajeroDTO.getDniCajero());
            row = pstmt.executeUpdate();
            exito = true;
            long t2 = System.currentTimeMillis();
            System.out.println( row + " rows affected (" + (t2-t1) + " ms)" );
        }
        catch (SQLException s)
        {
            System.out.println("Error en el insert cajero");
            System.out.println(s.getMessage());
        }
        finally
        {
            Conexion.close(pstmt);
            if (userConn!=null)
            {
                Conexion.close(conn);
            }
        }
        return exito;
    }

    public boolean modificar(CajeroDTO cajeroDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        boolean exito = false;
        try
        {
            conn = (this.userConn!=null) ? userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_modificarCajero);
            int index = 1;
            pstmt.setString(index++,cajeroDTO.getNombreCajero());
            pstmt.setString(index++,cajeroDTO.getApellidoCajero());
            pstmt.setString(index++, cajeroDTO.getDniCajero());
            pstmt.setInt(index,cajeroDTO.getId_cajero());
            row = pstmt.executeUpdate();
            System.out.println("Filas afectadas: "+row);
            exito = true;
        }
        catch (SQLException s)
        {
            System.out.println("Error al actualizar cajero");
            System.out.println(s.getMessage());
        }
        finally
        {
            Conexion.close(pstmt);
            if(userConn!=null)
            {
                Conexion.close(conn);
            }
        }
        return exito;
    }

    public boolean eliminar(CajeroDTO cajeroDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        boolean exito = false;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_eliminarCajero);
            pstmt.setInt(1,cajeroDTO.getId_cajero());
            row = pstmt.executeUpdate();
            exito = true;
            System.out.println("Filas afectadas: "+row);
        }
        catch (SQLException s)
        {
            System.out.println("Error al eliminar al cajero");
            System.out.println(s.getMessage());
        }
        finally
        {
            Conexion.close(pstmt);
            if (userConn==null)
            {
                Conexion.close(conn);
            }
        }
        return exito;
    }

    public List<CajeroDTO> listar()
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        CajeroDTO cajero = null;
        List<CajeroDTO> cajeros = new ArrayList<>();
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_listarCajeros);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                int idTemp = rs.getInt(1);
                String nombreTemp = rs.getString(2);
                String apellidoTemp = rs.getString(3);
                String dniTemp = rs.getString(4);
                cajero = new CajeroDTO();
                cajero.setId_cajero(idTemp);
                cajero.setNombreCajero(nombreTemp);
                cajero.setApellidoCajero(apellidoTemp);
                cajero.setDniCajero(dniTemp);
                cajeros.add(cajero);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al eliminar el cajero");
            System.out.println(s.getMessage());
        }
        finally
        {
            Conexion.close(rs);
            Conexion.close(pstmt);
            if (userConn==null)
            {
                Conexion.close(conn);
            }
        }
        return cajeros;
    }

    public CajeroDTO consultar(CajeroDTO cajeroDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        CajeroDTO cajeroDTO1 = null;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_conultarCajero);
            pstmt.setInt(1,cajeroDTO.getId_cajero());
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                cajeroDTO1 = new CajeroDTO();
                cajeroDTO1.setId_cajero(rs.getInt(1));
                cajeroDTO1.setNombreCajero(rs.getString(2));
                cajeroDTO1.setApellidoCajero(rs.getString(3));
                cajeroDTO1.setDniCajero(rs.getString(4));
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al consultar el cajero en jdbc_cajero");
            System.out.println(s.getMessage());
        }
        return cajeroDTO1;
    }
}