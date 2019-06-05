package dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LavadoDTO
{
    private double peso;
    private double importe;
    private double total;
    private double igv;
    private Timestamp tiempo;
    private boolean cancelado = false;
    private String cajeroNombre;
    private String cajeroApellido;
    private String clienteNombre;
    private String clienteApellido;
    private String tipoLavado;
    private double tipoLavadoPrecioKg;
    private int id_lavado;
    private int id_cliente;
    private int id_cajero;
    private int id_tipoLavado;


    public LavadoDTO(){}

    public double getPeso()
    {
        return peso;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public double getImporte()
    {
        return importe;
    }

    public void setImporte(double importe)
    {
        this.importe = importe;
    }

    public int getId_lavado()
    {
        return id_lavado;
    }

    public void setId_lavado(int id_lavado)
    {
        this.id_lavado = id_lavado;
    }

    public double getTotal()
    {
        return total;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    public double getIgv()
    {
        return igv;
    }

    public void setIgv(double igv)
    {
        this.igv = igv;
    }

    public Timestamp getTiempo() {
        return tiempo;
    }

    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isCancelado()
    {
        return cancelado;
    }

    public void setCancelado(boolean cancelado)
    {
        this.cancelado = cancelado;
    }

    public String getCajeroNombre() {
        return cajeroNombre;
    }

    public void setCajeroNombre(String cajeroNombre) {
        this.cajeroNombre = cajeroNombre;
    }

    public String getCajeroApellido() {
        return cajeroApellido;
    }

    public void setCajeroApellido(String cajeroApeliido) {
        this.cajeroApellido = cajeroApeliido;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteApellido() {
        return clienteApellido;
    }

    public void setClienteApellido(String clienteApellido) {
        this.clienteApellido = clienteApellido;
    }

    public String getTipoLavado() {
        return tipoLavado;
    }

    public void setTipoLavado(String tipoLavado) {
        this.tipoLavado = tipoLavado;
    }

    public double getTipoLavadoPrecioKg() {
        return tipoLavadoPrecioKg;
    }

    public void setTipoLavadoPrecioKg(double tipoLavadoPrecioKg) {
        this.tipoLavadoPrecioKg = tipoLavadoPrecioKg;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_cajero() {
        return id_cajero;
    }

    public void setId_cajero(int id_cajero) {
        this.id_cajero = id_cajero;
    }

    public int getId_tipoLavado() {
        return id_tipoLavado;
    }

    public void setId_tipoLavado(int id_tipoLavado) {
        this.id_tipoLavado = id_tipoLavado;
    }

    @Override
    public String toString()
    {
        return "LavadoDTO = idLavado: "+id_lavado+", Peso: "+peso+", Importe: "+importe+", Total: "+total+" IGV: "+igv+", Tiempo: "+tiempo+" Cancelado: "+cancelado+", Cajero Nombre: "+cajeroNombre+", Cajero Apellido: "+cajeroApellido+", Cliente Nombre: "+clienteNombre+", Cliente Apellido: "+clienteApellido+", Tipo Lavado: "+tipoLavado+", Tipo Lavado x KG: "+tipoLavadoPrecioKg+", Id Cliente: "+id_cliente+", Id Cajero: "+id_cajero+", Id Tipo Lavado: "+id_tipoLavado;
    }
}
