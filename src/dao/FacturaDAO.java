package dao;

import dto.FacturaDTO;

import java.sql.SQLException;
import java.util.List;

public interface FacturaDAO
{
    public int agregar_factura(FacturaDTO facturaDTO) throws SQLException;

    public int actualizar_factura(FacturaDTO facturaDTO) throws SQLException;

    public int eliminar_factura(FacturaDTO facturaDTO) throws SQLException;

    public FacturaDTO consultar_factura(FacturaDTO facturaDTO) throws SQLException;

    public List<FacturaDTO> listar_factura() throws SQLException;
}
