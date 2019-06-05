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

    private final String sql_agregar = "insert into lavado (peso, importe, total, igv, cancelado, id_cliente, id_cajero, id_tipolavado) value (?,?,?,?,?,?,?,?)";

    private final String sql_actualizar = "update lavado set peso = ?, importe = ?, total = ?, igv = ?, cancelado = ?, id_cliente = ?, id_tipolavado = ?, id_cajero = ? where id_lavado = ?";

    private final String sql_borrar = "delete from lavado where id_lavado = ?";

    private final String sql_consultar = "select lavado.id_lavado, lavado.peso, lavado.importe, lavado.total, lavado.igv, lavado.fecha_hora, lavado.cancelado, cajero.nombre, cajero.apellido, cliente.nombre, cliente.apellido, tipolavado.tipoLavado, tipolavado.precio_kg, lavado.id_cliente, lavado.id_cajero, lavado.id_tipoLavado from lavado inner join cajero on cajero.id_cajero = lavado.id_cajero inner join cliente on cliente.id_cliente = lavado.id_cliente inner join tipolavado on tipolavado.id_tipoLavado = lavado.id_tipolavado where id_lavado = ?";

    private final String sql_listar = "select lavado.id_lavado, lavado.peso, lavado.importe, lavado.total, lavado.igv, lavado.fecha_hora, lavado.cancelado, cajero.nombre, cajero.apellido, cliente.nombre, cliente.apellido, tipolavado.tipoLavado, tipolavado.precio_kg from lavado inner join cajero on cajero.id_cajero = lavado.id_cajero inner join cliente on cliente.id_cliente = lavado.id_cliente inner join tipolavado on tipolavado.id_tipoLavado = lavado.id_tipolavado";

    public jbdc_lavado() {}

    public jbdc_lavado(Connection conn)
    {
        this.userConn = conn;
    }

    @Override
    public int agregar_lavado(LavadoDTO lavadoDTO)
    {
        Connection conn =  null;
        PreparedStatement pstmt = null;
        int row = 0;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_agregar);
            int index = 1;
            pstmt.setDouble(index++,lavadoDTO.getPeso());
            pstmt.setDouble(index++,lavadoDTO.getImporte());
            pstmt.setDouble(index++,lavadoDTO.getTotal());
            pstmt.setDouble(index++,lavadoDTO.getIgv());
            pstmt.setBoolean(index++,lavadoDTO.isCancelado());
            pstmt.setInt(index++,1);
            pstmt.setInt(index++,3);
            pstmt.setInt(index,2);
            row = pstmt.executeUpdate();
            if (row == 1)
            System.out.println("Filas afectadas: "+row);
        }
        catch (SQLException s)
        {
            System.out.println("Error en el insert de lavado jdbc");
            System.out.println(s.getMessage());
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
            pstmt.setDouble(index++,lavadoDTO.getPeso());
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
    public LavadoDTO consultar_lavado(LavadoDTO lavadoDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LavadoDTO lavadoDTO1 = null;
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
                lavadoDTO1.setPeso(rs.getDouble(2));
                lavadoDTO1.setImporte(rs.getDouble(3));
                lavadoDTO1.setTotal(rs.getDouble(4));
                lavadoDTO1.setIgv(rs.getDouble(5));
                lavadoDTO1.setTiempo(rs.getTimestamp(6));
                lavadoDTO1.setCancelado(rs.getBoolean(7));
                lavadoDTO1.setCajeroNombre(rs.getString(8));
                lavadoDTO1.setCajeroApellido(rs.getString(9));
                lavadoDTO1.setClienteNombre(rs.getString(10));
                lavadoDTO1.setClienteApellido(rs.getString(11));
                lavadoDTO1.setTipoLavado(rs.getString(12));
                lavadoDTO1.setTipoLavadoPrecioKg(rs.getDouble(13));
                lavadoDTO1.setId_cliente(rs.getInt(14));
                lavadoDTO1.setId_cajero(rs.getInt(15));
                lavadoDTO1.setId_tipoLavado(rs.getInt(16));
            }
        }catch (SQLException s)
        {
            System.out.println("Error en consultar lavado jbdc");
            System.out.println(s.getMessage());
        }
        return lavadoDTO1;
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
                double lavadoPesoTemp = rs.getDouble(2);
                double lavadoImporteTemp = rs.getDouble(3);
                double lavadoTotalTemp = rs.getDouble(4);
                double lavadoIgvTemp = rs.getDouble(5);
                Timestamp timeTemp = rs.getTimestamp(6);
                boolean lavadoCanceladoTemp = rs.getBoolean(7);
                String cajeroNombreTemp = rs.getString(8);
                String cajeroApellidoTemp = rs.getString(9);
                String clienteNombreTemp = rs.getString(10);
                String clienteApellidoTemp = rs.getString(11);
                String tipoLavadoTemp = rs.getString(12);
                double tipoLavadoPreciokgTemp = rs.getDouble(13);

                lavadoDTO = new LavadoDTO();
                lavadoDTO.setId_lavado(lavadoId_lavadoTemp);
                lavadoDTO.setPeso(lavadoPesoTemp);
                lavadoDTO.setImporte(lavadoImporteTemp);
                lavadoDTO.setTotal(lavadoTotalTemp);
                lavadoDTO.setIgv(lavadoIgvTemp);
                lavadoDTO.setTiempo(timeTemp);
                lavadoDTO.setCancelado(lavadoCanceladoTemp);
                lavadoDTO.setCajeroNombre(cajeroNombreTemp);
                lavadoDTO.setCajeroApellido(cajeroApellidoTemp);
                lavadoDTO.setClienteNombre(clienteNombreTemp);
                lavadoDTO.setClienteApellido(clienteApellidoTemp);
                lavadoDTO.setTipoLavado(tipoLavadoTemp);
                lavadoDTO.setTipoLavadoPrecioKg(tipoLavadoPreciokgTemp);
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
