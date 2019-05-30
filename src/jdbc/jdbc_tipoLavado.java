package jdbc;

import dao.TipoLavadoDAO;
import dto.TipoLavadoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class jdbc_tipoLavado implements TipoLavadoDAO
{
    private Connection userConn = null;

    private final String sql_agregarTipoLavado = "insert into tipolavado (tipoLavado,precio_kg) value (?,?)";

    private final String sql_listarTipoLavado = "select * from tipolavado";

    private final String sql_modificarTipoLavado = "update tipolavado set tipoLavado = ?, precio_kg = ? where id_tipoLavado = ?";

    private final String sql_eliminarTipoLavado = "delete from tipolavado where id_tipoLavado = ?";

    private final String sql_consultarTipoLavado = "select * from tipolavado where id_tipoLavado = ?";

    public jdbc_tipoLavado(){}

    @Override
    public boolean agregar(TipoLavadoDTO tipoLavadoDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        boolean exito = false;

        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_agregarTipoLavado);
            int index = 1;
            pstmt.setString(index++,tipoLavadoDTO.getTipoLavado());
            pstmt.setDouble(index,tipoLavadoDTO.getPrecioxkg());
            row = pstmt.executeUpdate();
            exito = true;
            System.out.println("Filas afectadas: "+row);
        }
        catch (SQLException s)
        {
            System.out.println("Exploto el agregarTipoLavado");
            System.out.println(s.getMessage());
        }
        finally
        {
            Conexion.close(pstmt);
            if(conn == null)
            {
                Conexion.close(conn);
            }
        }
        return exito;
    }

    @Override
    public boolean modificar(TipoLavadoDTO tipoLavadoDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        boolean exito = false;

        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_modificarTipoLavado);
            int index = 1;
            pstmt.setString(index++,tipoLavadoDTO.getTipoLavado());
            pstmt.setDouble(index++,tipoLavadoDTO.getPrecioxkg());
            pstmt.setInt(index,tipoLavadoDTO.getId_tipoLavado());
            row = pstmt.executeUpdate();
            exito = true;
            System.out.println("Filas afectadas: "+row);
        }
        catch (SQLException s)
        {
            System.out.println("Exploto el modificarTipoLavado");
            System.out.println(s.getMessage());
        }
        finally
        {
            Conexion.close(pstmt);
            if(conn == null)
            {
                Conexion.close(conn);
            }
        }
        return exito;
    }

    @Override
    public boolean eliminar(TipoLavadoDTO tipoLavadoDTO)
    {
        System.out.println("Ingreso en eliminarTipoLavado");
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        boolean exito = false;

        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_eliminarTipoLavado);
            pstmt.setInt(1,tipoLavadoDTO.getId_tipoLavado());
            row = pstmt.executeUpdate();
            exito = true;
        }
        catch (SQLException s)
        {
            System.out.println("Exploto el eliminarTipoLavado");
            System.out.println(s.getMessage());
        }
        finally
        {
            Conexion.close(pstmt);
            {
                if(conn == null)
                {
                    Conexion.close(conn);
                }
            }
        }
        return exito;
    }

    @Override
    public List<TipoLavadoDTO> listar()
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TipoLavadoDTO tipoLavado = null;
        List<TipoLavadoDTO> tipoLavados = new ArrayList<>();
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_listarTipoLavado);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                int idTemp = rs.getInt(1);
                String tipoTemp = rs.getString(2);
                double precioTemp = rs.getDouble(3);
                tipoLavado = new TipoLavadoDTO();
                tipoLavado.setId_tipoLavado(idTemp);
                tipoLavado.setTipoLavado(tipoTemp);
                tipoLavado.setPrecioxkg(precioTemp);
                tipoLavados.add(tipoLavado);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Exploto el listarTipoLavado");
            System.out.println(s.getMessage());
        }
        finally
        {
            Conexion.close(rs);
            Conexion.close(pstmt);
            if(conn == null)
            {
                Conexion.close(conn);
            }
        }
        return tipoLavados;
    }

    @Override
    public TipoLavadoDTO consultar(TipoLavadoDTO tipoLavadoDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TipoLavadoDTO tipoLavadoDTO1 = null;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_consultarTipoLavado);
            pstmt.setInt(1,tipoLavadoDTO.getId_tipoLavado());
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                tipoLavadoDTO1 = new TipoLavadoDTO();
                tipoLavadoDTO1.setId_tipoLavado(rs.getInt(1));
                tipoLavadoDTO1.setTipoLavado(rs.getString(2));
                tipoLavadoDTO1.setPrecioxkg(rs.getDouble(3));
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al consultar tipo de lavado en el jbdc");
            System.out.println(s.getMessage());
        }
        return tipoLavadoDTO1;
    }
}