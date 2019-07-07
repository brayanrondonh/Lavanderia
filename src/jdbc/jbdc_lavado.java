package jdbc;

import dao.LavadoDAO;
import dto.ClienteDTO;
import dto.LavadoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class jbdc_lavado implements LavadoDAO
{
    private Connection userConn = null;

    private final String sql_agregar = "insert into lavado (importe, total, igv, cancelado, id_cliente, id_cajero) value (?,?,?,?,?,?)";

    private final String sql_agregar_items = "insert into tbl_lavado_tipolavado (id_lavado, id_tipoLavado, piezas) value (?,?,?)";

    private final String sql_actualizar = "update lavado set peso = ?, importe = ?, total = ?, igv = ?, cancelado = ?, id_cliente = ?, id_tipolavado = ?, id_cajero = ? where id_lavado = ?";

    private final String sql_borrar = "delete from lavado where id_lavado = ?";

    private final String sql_consultar = "select lavado.id_lavado, lavado.total, lavado.importe, lavado.igv, lavado.fecha_hora, lavado.cancelado, tipolavado.tipoLavado, tipolavado.precio_kg, tbl_lavado_tipolavado.piezas, tbl_lavado_tipolavado.id_tipoLavado, cliente.nombre, cliente.apellido, cajero.nombre, cajero.apellido, cliente.id_cliente, cajero.id_cajero from lavado inner JOIN tbl_lavado_tipolavado on lavado.id_lavado = tbl_lavado_tipolavado.id_lavado inner join tipolavado on tipolavado.id_tipoLavado = tbl_lavado_tipolavado.id_tipoLavado inner join cliente on cliente.id_cliente = lavado.id_cliente inner join cajero on cajero.id_cajero = lavado.id_cajero where lavado.id_lavado = ?";

    private final String sql_listar = "select lavado.id_lavado, lavado.total, lavado.importe, lavado.igv, lavado.fecha_hora, lavado.cancelado, cliente.nombre, cliente.apellido, cajero.nombre, cajero.apellido from lavado inner join cliente on cliente.id_cliente = lavado.id_cliente inner join cajero on cajero.id_cajero = lavado.id_cajero";

    public jbdc_lavado() {}

    public jbdc_lavado(Connection conn)
    {
        this.userConn = conn;
    }

    @Override
    public int agregar_lavado(LavadoDTO lavadoDTO) throws SQLException
    {
        Connection conn =  null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int row = 0;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_agregar,pstmt.RETURN_GENERATED_KEYS);
            int index = 1;
            pstmt.setDouble(index++,lavadoDTO.getImporte());
            pstmt.setDouble(index++,lavadoDTO.getTotal());
            pstmt.setDouble(index++,lavadoDTO.getIgv());
            pstmt.setBoolean(index++,lavadoDTO.isCancelado());
            pstmt.setInt(index++,1);
            pstmt.setInt(index++,1);
            row = pstmt.executeUpdate();
            if (row == 1)
            System.out.println("Filas afectadas: "+row);

            rs = pstmt.getGeneratedKeys();
            if (rs.next())
            {
                row = rs.getInt(1);
            }
            System.out.println("El id generado es: "+row);
        }
        //Se Comentaron estas lineas ya que se necesita propagar el error del JBDC al servlet y evaluar si se hace commit o no
        /*catch (SQLException s)
        {
            System.out.println("Error en el insert de lavado jdbc");
            System.out.println(s.getMessage());
        }*/
        finally
        {
            Conexion.close(pstmt);
            if (this.userConn==null)
            {
                Conexion.close(conn);
            }
        }
        return row;
    }

    @Override
    public int agregar_items_lavado(int id_lavado, double id_tipoLavado, double piezas) throws SQLException
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        try
        {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_agregar_items);
            int index = 1;
            pstmt.setInt(index++,id_lavado);
            pstmt.setDouble(index++,id_tipoLavado);
            pstmt.setDouble(index,piezas);
            row = pstmt.executeUpdate();
        }
        //Se Comentaron estas lineas ya que se necesita propagar el error del JBDC al servlet y evaluar si se hace commit o no
        /*catch (SQLException s)
        {
            System.out.println("Error al agregar items de lavado en el jdbc");
            System.out.println(s.getMessage());
        }*/
        finally
        {
            Conexion.close(pstmt);
            if (this.userConn==null)
            {
                Conexion.close(conn);
            }
        }
        return row;
    }

    @Override
    public int actualizar_lavado(LavadoDTO lavadoDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_actualizar);
            int index = 1;
            pstmt.setDouble(index++,lavadoDTO.getImporte());
            pstmt.setDouble(index++,lavadoDTO.getTotal());
            pstmt.setDouble(index++,lavadoDTO.getIgv());
            pstmt.setBoolean(index++,lavadoDTO.isCancelado());
            pstmt.setInt(index++,lavadoDTO.getId_cliente());
            pstmt.setInt(index++,lavadoDTO.getId_tipoLavado());
            pstmt.setInt(index++,lavadoDTO.getId_cajero());
            pstmt.setInt(index,lavadoDTO.getId_lavado());
            row = pstmt.executeUpdate();
            System.out.println("Filas afectadas: "+row);
        }
        catch (SQLException s)
        {
            System.out.println("Error en el actualizar lavado jbdc");
            System.out.println(s.getMessage());
        }
        return row;
    }

    @Override
    public int eliminar_lavado(LavadoDTO lavadoDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 1;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_borrar);
            pstmt.setInt(1, lavadoDTO.getId_lavado());
            row = pstmt.executeUpdate();
            System.out.println("Filas afectadas: "+row);
        }
        catch (SQLException s)
        {
            System.out.println("Error en el eliminar jbdc");
            System.out.println(s.getMessage());
        }
        return row;
    }

    @Override
    public List<LavadoDTO> consultar_lavado(LavadoDTO lavadoDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LavadoDTO lavadoDTO1 = null;
        List<LavadoDTO> lavadoDTO2 = new ArrayList<>();
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_consultar);
            pstmt.setInt(1,lavadoDTO.getId_lavado());
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                lavadoDTO1 = new LavadoDTO();
                lavadoDTO1.setId_lavado(rs.getInt(1));
                lavadoDTO1.setTotal(rs.getDouble(2));
                lavadoDTO1.setImporte(rs.getDouble(3));
                lavadoDTO1.setIgv(rs.getDouble(4));
                lavadoDTO1.setTiempo(rs.getTimestamp(5));
                lavadoDTO1.setCancelado(rs.getBoolean(6));
                lavadoDTO1.setTipoLavado(rs.getString(7));
                lavadoDTO1.setTipoLavadoPrecioKg(rs.getDouble(8));
                lavadoDTO1.setPiezas(rs.getInt(9));
                lavadoDTO1.setId_tipoLavado(rs.getInt(10));
                lavadoDTO1.setClienteNombre(rs.getString(11));
                lavadoDTO1.setClienteApellido(rs.getString(12));
                lavadoDTO1.setCajeroNombre(rs.getString(13));
                lavadoDTO1.setCajeroApellido(rs.getString(14));
                lavadoDTO2.add(lavadoDTO1);
            }
        }catch (SQLException s)
        {
            System.out.println("Error en consultar lavado jbdc");
            System.out.println(s.getMessage());
        }
        return lavadoDTO2;
    }

    @Override
    public List<LavadoDTO> listar_lavado()
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LavadoDTO lavadoDTO = null;
        List<LavadoDTO> lavadoDTOS = new ArrayList<>();
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_listar);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                int lavadoId_lavadoTemp = rs.getInt(1);
                double lavadoTotalTemp = rs.getDouble(2);
                double lavadoImporteTemp = rs.getDouble(3);
                double lavadoIgvTemp = rs.getDouble(4);
                Timestamp timeTemp = rs.getTimestamp(5);
                boolean lavadoCanceladoTemp = rs.getBoolean(6);
                String ClienteNombreTemp = rs.getString(7);
                String ClienteApellidoTemp = rs.getString(8);
                String CajeroNombreTemp = rs.getString(9);
                String CajeroApellidoTemp = rs.getString(10);


                lavadoDTO = new LavadoDTO();
                lavadoDTO.setId_lavado(lavadoId_lavadoTemp);
                lavadoDTO.setTotal(lavadoTotalTemp);
                lavadoDTO.setImporte(lavadoImporteTemp);
                lavadoDTO.setIgv(lavadoIgvTemp);
                lavadoDTO.setTiempo(timeTemp);
                lavadoDTO.setCancelado(lavadoCanceladoTemp);
                lavadoDTO.setClienteNombre(ClienteNombreTemp);
                lavadoDTO.setClienteApellido(ClienteApellidoTemp);
                lavadoDTO.setCajeroNombre(CajeroNombreTemp);
                lavadoDTO.setCajeroApellido(CajeroApellidoTemp);
                lavadoDTOS.add(lavadoDTO);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al listar lavado 2  jbdc");
            System.out.println(s.getMessage());
        }
        return lavadoDTOS;
    }
}
