package jdbc;

import dao.LavadoDAO;
import dto.LavadoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class jbdc_lavado implements LavadoDAO
{
    private Connection userConn = null;

    private final String sql_agregar = "insert into lavado (peso, importe, total, igv, cancelado) value (?,?,?,?,?)";

    private final String sql_actualizar = "update lavado set peso = ?, importe = ?, total = ?, igv = ?, cancelado = ? where id_lavado = ?";

    private final String sql_borrar = "delete from lavado where id_lavado = ?";

    private final String sql_consultar = "select * from lavado where id_lavado = ?";

    private final String sql_listar = "select * from lavado";

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
            pstmt.setBoolean(index,lavadoDTO.isCancelado());
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
                lavadoDTO1.setCancelado(rs.getBoolean(7));
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
                int idTemp = rs.getInt(1);
                double pesoTemp = rs.getDouble(2);
                double importeTemp = rs.getDouble(3);
                double totalTemp = rs.getDouble(4);
                double igvTemp = rs.getDouble(5);

                boolean canceladoTemp = rs.getBoolean(7);

                lavadoDTO = new LavadoDTO();
                lavadoDTO.setId_lavado(idTemp);
                lavadoDTO.setPeso(pesoTemp);
                lavadoDTO.setImporte(importeTemp);
                lavadoDTO.setTotal(totalTemp);
                lavadoDTO.setIgv(igvTemp);
                lavadoDTO.setCancelado(canceladoTemp);
                lavadoDTOS.add(lavadoDTO);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al listar lavado jbdc");
            System.out.println(s.getMessage());
        }
        return lavadoDTOS;
    }
}
