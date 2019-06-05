package jdbc;

import dao.FacturaDAO;
import dto.FacturaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class jdbc_factura implements FacturaDAO
{
    private Connection userConn = null;

    private final String sql_agregar = "insert into factura (nombre_empresa,nombre_comercial,ruc,direccion,telefono,numero_operacion,numero_boleta) value (?,?,?,?,?,?,?)";

    private final String sql_actualizar = "update factura set nombre_empresa = ?,nombre_comercial = ?,ruc = ?,direccion = ?,telefono = ?,numero_operacion = ?,numero_boleta = ? where id_factura = ?";

    private final String sql_eliminar = "delete from factura where id_factura = ?";

    private final String sql_consultar = "select * from factura where id_factura = ?";

    private final String sql_listar = "select * from factura";

    public int agregar_factura(FacturaDTO facturaDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_agregar);
            int index =1;
            pstmt.setString(index++,facturaDTO.getNombreEmpresa());
            pstmt.setString(index++,facturaDTO.getNombreComercial());
            pstmt.setString(index++,facturaDTO.getRuc());
            pstmt.setString(index++,facturaDTO.getDireccion());
            pstmt.setString(index++,facturaDTO.getTelefono());
            pstmt.setInt(index++,facturaDTO.getNum_operacion());
            pstmt.setInt(index++, facturaDTO.getNum_boleta());
            row = pstmt.executeUpdate();
            System.out.println("Filas afectadas");
        }
        catch (SQLException s)
        {
            System.out.println("Error al agregar factura en el jdbc");
            System.out.println(s.getMessage());
        }
        return row;
    }

    public int actualizar_factura(FacturaDTO facturaDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 1;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_actualizar);
            int index = 1;
            pstmt.setString(index++,facturaDTO.getNombreEmpresa());
            pstmt.setString(index++,facturaDTO.getNombreComercial());
            pstmt.setString(index++,facturaDTO.getRuc());
            pstmt.setString(index++,facturaDTO.getDireccion());
            pstmt.setString(index++,facturaDTO.getTelefono());
            pstmt.setInt(index++,facturaDTO.getNum_operacion());
            pstmt.setInt(index++,facturaDTO.getNum_boleta());
            pstmt.setInt(index,facturaDTO.getId_factura());
            row = pstmt.executeUpdate();
        }
        catch (SQLException s)
        {
            System.out.println("Error al actualizar factura en el jdbc");
            System.out.println(s.getMessage());
        }
        return row;
    }

    public int eliminar_factura(FacturaDTO facturaDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int row = 0;
        try
        {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_eliminar);
            pstmt.setInt(1,facturaDTO.getId_factura());
            row = pstmt.executeUpdate();
            System.out.println("Filas afectadas: "+row);
        }
        catch (SQLException s)
        {
            System.out.println("Error al eliminar factura en el jdbc");
            System.out.println(s.getMessage());
        }
        return row;
    }

    public FacturaDTO consultar_factura(FacturaDTO facturaDTO)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        FacturaDTO facturaDTO1 = null;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_consultar);
            pstmt.setInt(1,facturaDTO.getId_factura());
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                facturaDTO1 = new FacturaDTO();
                facturaDTO1.setId_factura(rs.getInt(1));
                facturaDTO1.setNombreEmpresa(rs.getString(2));
                facturaDTO1.setNombreComercial(rs.getString(3));
                facturaDTO1.setRuc(rs.getString(4));
                facturaDTO1.setDireccion(rs.getString(5));
                facturaDTO1.setTelefono(rs.getString(6));
                facturaDTO1.setNum_operacion(rs.getInt(7));
                facturaDTO1.setNum_boleta(rs.getInt(9));
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al consultar factura e el jdbc");
            System.out.println(s.getMessage());
        }
        return facturaDTO1;
    }

    public List<FacturaDTO> listar_factura()
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<FacturaDTO> facturaDTOS = new ArrayList<>();
        FacturaDTO facturaDTO = null;
        try
        {
            conn = (this.userConn!=null) ? this.userConn : Conexion.getConnection();
            pstmt = conn.prepareStatement(sql_listar);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                facturaDTO = new FacturaDTO();
                facturaDTO.setId_factura(rs.getInt(1));
                facturaDTO.setNombreEmpresa(rs.getString(2));
                facturaDTO.setNombreComercial(rs.getString(3));
                facturaDTO.setRuc(rs.getString(4));
                facturaDTO.setDireccion(rs.getString(5));
                facturaDTO.setTelefono(rs.getString(6));
                facturaDTO.setNum_operacion(rs.getInt(7));
                facturaDTO.setNum_boleta(rs.getInt(9));
                facturaDTOS.add(facturaDTO);
            }
        }
        catch (SQLException s)
        {
            System.out.println("Error al listar factura en el jdbc");
            System.out.println(s.getMessage());
        }
        return facturaDTOS;
    }
}
