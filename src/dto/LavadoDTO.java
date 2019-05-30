package dto;

import java.time.LocalDateTime;

public class LavadoDTO
{
    private double peso;
    private double importe;
    private double total;
    private double igv;
    private boolean cancelado = false;
    private int id_lavado;

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

    public boolean isCancelado()
    {
        return cancelado;
    }

    public void setCancelado(boolean cancelado)
    {
        this.cancelado = cancelado;
    }

    @Override
    public String toString()
    {
        return "LavadoDTO = idLavado: "+id_lavado+", Peso: "+peso+", Importe: "+importe+", Total: "+total+" IGV: "+igv+" Cancelado: "+cancelado;
    }
}
