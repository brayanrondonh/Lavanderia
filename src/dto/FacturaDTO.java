package dto;

public class FacturaDTO
{
    private String fecha_hora;
    private String nombreEmpresa;
    private String nombreComercial;
    private String direccion;
    private String ruc;
    private String telefono;
    private int num_operacion;
    private int num_boleta;
    private int id_factura;

    public FacturaDTO(){}

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNum_operacion() {
        return num_operacion;
    }

    public void setNum_operacion(int num_operacion) {
        this.num_operacion = num_operacion;
    }

    public int getNum_boleta() {
        return num_boleta;
    }

    public void setNum_boleta(int num_boleta) {
        this.num_boleta = num_boleta;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public String toString()
    {
        return "Factura: id_factura = "+id_factura+", nombre_empresa = "+nombreEmpresa+", nombre_comercial = "+nombreComercial+", RUC = "+ruc+", Dirección = "+direccion+", Telefono = "+telefono+", nummero operación = "+num_operacion+", numero boleta = "+num_boleta;
    }
}
