package dao;

import domain.Cajero;

import java.sql.SQLException;
import java.util.List;

public interface CajeroDAO
{
    public boolean agregar(String nombre, String apellido, String dni) throws SQLException;

    public boolean modificar(String nombre, String apellido, String dni) throws SQLException;

    public boolean eliminar(int id) throws SQLException;

    public List<Cajero> listar() throws SQLException;
}
