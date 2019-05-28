package dao;

import dto.ClienteDTO;
import java.sql.SQLException;
import java.util.List;

public interface ClienteDAO
{
    public boolean agregar(ClienteDTO clienteDTO) throws SQLException;

    public boolean modificar(ClienteDTO clienteDTO) throws SQLException;

    public boolean eliminar(ClienteDTO clienteDTO) throws SQLException;

    public ClienteDTO consultar(ClienteDTO clienteDTO) throws SQLException;

    public List<ClienteDTO> listar() throws SQLException;
}
