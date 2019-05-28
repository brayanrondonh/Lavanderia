package dto;

public class TipoLavadoDTO
{
    private String tipoLavado;
    private double precioxkg;
    private int id_tipoLavado;

    public TipoLavadoDTO(){}

    public TipoLavadoDTO(String tipoLavado, double precioxkg)
    {
        this.tipoLavado = tipoLavado;
        this.precioxkg = precioxkg;
    }

    public String getTipoLavado()
    {
        return tipoLavado;
    }

    public void setTipoLavado(String tipoLavado)
    {
        this.tipoLavado = tipoLavado;
    }

    public double getPrecioxkg()
    {
        return precioxkg;
    }

    public void setPrecioxkg(double precioxkg)
    {
        this.precioxkg = precioxkg;
    }

    public int getId_tipoLavado()
    {
        return id_tipoLavado;
    }

    public void setId_tipoLavado(int id_tipoLavado)
    {
        this.id_tipoLavado = id_tipoLavado;
    }

    @Override
    public String toString()
    {
        return "Tipo LavadoDTO = id_TipoLavado"+id_tipoLavado+", Tipo LavadoDTO: "+tipoLavado+", Precio x KG: "+precioxkg;
    }
}
