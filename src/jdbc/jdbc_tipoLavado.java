package jdbc;

import dao.TipoLavadoDAO;
import domain.TipoLavado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class jdbc_tipoLavado implements TipoLavadoDAO
{
    private final String sql_agregarTipoLavado = "insert into tipolavado (tipoLavado,precio_kg) value (?,?)";

    private final String sql_listarTipoLavado = "select * from tipolavado";

    private final String sql_modificarTipoLavado = "update from tipolavado set tipoLavado = ?, precio_kg = ? where id_tipoLavado = ?";

    private final String sql_eliminarTipoLavado = "delete from tipolavado where id_tipoLavado = ?";

    public jdbc_tipoLavado(){}

    @Override
    public boolean agregarTipoLavado(String tipo, double precio)
    {
        System.out.println("Ingreso en agregar tipo de lavado jdbc");
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rows = 0;
        boolean exito = false;

        try
        {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_agregarTipoLavado);
            int index = 1;
            pstmt.setString(index++,tipo);
            pstmt.setDouble(index,precio);
            rows = pstmt.executeUpdate();
            if(rows>0)
            {
                System.out.println("Datos almacenados con exito");
                System.out.println("Filas afectadas: "+rows);
                exito = true;
            }
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
    public boolean modificarTipoLavado(String tipo, double precio, int id)
    {
        System.out.println("Ingreso en modificar tipo de lavado jdbc");
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        boolean exito = false;

        try
        {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_modificarTipoLavado);
            int index = 1;
            pstmt.setString(index++,tipo);
            pstmt.setDouble(index++,precio);
            pstmt.setInt(index,id);
            row = pstmt.executeUpdate();
            exito = true;
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
    public boolean eliminarTipoLavado(int id)
    {
        System.out.println("Ingreso en eliminarTipoLavado");
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        boolean exito = false;

        try
        {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_eliminarTipoLavado);
            pstmt.setInt(1,id);
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
    public List<TipoLavado> listar()
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TipoLavado tipoLavado = null;
        List<TipoLavado> tipoLavados = new ArrayList<>();
        try
        {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_listarTipoLavado);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                int idTemp = rs.getInt(1);
                String tipoTemp = rs.getString(2);
                double precioTemp = rs.getDouble(3);
                tipoLavado = new TipoLavado();
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
}