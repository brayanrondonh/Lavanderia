package dao;

import dto.TipoLavadoDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface TipoLavadoDAO
{
    public boolean agregar (TipoLavadoDTO tipoLavadoDTO) throws SQLException;

    public List<TipoLavadoDTO> listar() throws SQLException, IOException;

    public boolean modificar (TipoLavadoDTO tipoLavadoDTO) throws SQLException, IOException;

    public boolean eliminar (TipoLavadoDTO tipoLavadoDTO) throws SQLException, IOException;
}
