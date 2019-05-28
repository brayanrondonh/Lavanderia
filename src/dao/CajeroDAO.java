package dao;

import dto.CajeroDTO;
import java.sql.SQLException;
import java.util.List;

public interface CajeroDAO
{
    public boolean agregar(CajeroDTO cajero) throws SQLException;

    public boolean modificar(CajeroDTO cajero) throws SQLException;

    public boolean eliminar(CajeroDTO cajero) throws SQLException;

    public List<CajeroDTO> listar() throws SQLException;

    public CajeroDTO consultar(CajeroDTO cajeroDTO) throws SQLException;
}
