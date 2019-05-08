package jdbc;

import dao.CajeroDAO;

public class jdbc_cajero implements CajeroDAO
{
    private final String sql_agregarCajero = "insert into cajero (nombre,apellido,dni) value (?,?,?)";

    private final String sql_modificarCajero = "update cajero set nombre = ?, apellido = ?, dni = ? where id_cajero = ?";

    private final String sql_eliminarCajero = "delete from cajero where id_cajero = ?";
}
