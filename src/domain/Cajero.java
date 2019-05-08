package domain;

public class Cajero
{
    private String nombreCajero;
    private String apellidoCajero;
    private String dniCajero;
    private int id_cajero;

    public Cajero(){}

    public Cajero(String nombreCajero, String apellidoCajero, String dniCajero)
    {
        this.nombreCajero = nombreCajero;
        this.apellidoCajero = apellidoCajero;
        this.dniCajero = dniCajero;
    }

    public String getNombreCajero()
    {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero)
    {
        this.nombreCajero = nombreCajero;
    }

    public String getApellidoCajero()
    {
        return apellidoCajero;
    }

    public void setApellidoCajero(String apellidoCajero)
    {
        this.apellidoCajero = apellidoCajero;
    }

    public String getDniCajero()
    {
        return dniCajero;
    }

    public void setDniCajero(String dniCajero)
    {
        this.dniCajero = dniCajero;
    }

    public int getId_cajero()
    {
        return id_cajero;
    }

    public void setId_cajero(int id_cajero)
    {
        this.id_cajero = id_cajero;
    }

    @Override
    public String toString()
    {
        return "Cajero = id_cajero: "+id_cajero+", Nombre Cajero: "+nombreCajero+", Apellido Cajero: "+apellidoCajero+", DNI Cajero: "+dniCajero;
    }
}
