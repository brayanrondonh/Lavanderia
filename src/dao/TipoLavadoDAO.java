package dao;

import domain.TipoLavado;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface TipoLavadoDAO
{
    public boolean agregarTipoLavado (String tipo, double precio) throws SQLException;

    public List<TipoLavado> listar() throws SQLException, IOException;

    public boolean modificarTipoLavado (String tipo, double precio, int id) throws SQLException, IOException;

    public boolean eliminarTipoLavado (int id) throws SQLException, IOException;
}
