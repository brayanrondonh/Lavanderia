package dao;

import dto.LavadoDTO;

import java.sql.SQLException;
import java.util.List;

public interface LavadoDAO
{
    public int agregar_lavado(LavadoDTO lavadoDTO) throws SQLException;

    public int agregar_items_lavado(int id_lavado, double id_tipoLavado, double piezas) throws SQLException;

    public int actualizar_lavado(LavadoDTO lavadoDTO) throws SQLException;

    public int eliminar_lavado(LavadoDTO lavadoDTO) throws SQLException;

    public LavadoDTO consultar_lavado(LavadoDTO lavadoDTO)throws SQLException;

    public List<LavadoDTO> listar_lavado() throws SQLException;
}
