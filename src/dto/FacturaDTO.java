package dto;

public class FacturaDTO
{
    //private date fecha;
    //private time hora;
    private String nombreEmpresa;
    private String nombreComercial;
    private String direccion;
    private String ruc;
    private String telefono;
    private String num_operacion;
    private String num_boleta;
    private double igv;
    private String id_factura;
    private boolean cancelado;

    public FacturaDTO(){}

    //No se agregaron mas contructores ya que es una clase de solo lectura

    /*public date getFecha()
    {
        return fecha;
    }

    public time getHora()
    {
        return hora;
    }*/

    public String getNombreEmpresa()
    {
        return nombreEmpresa;
    }

    public String getNombreComercial()
    {
        return nombreComercial;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public String getRuc()
    {
        return ruc;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public String getNum_operacion()
    {
        return num_operacion;
    }

    public String getNum_boleta()
    {
        return num_boleta;
    }

    public double getIgv()
    {
        return igv;
    }

    public String getId_factura()
    {
        return id_factura;
    }

    public boolean isCancelado()
    {
        return cancelado;
    }
}
