package domain;

public class Lavado
{
    private double peso;
    private double importe;
    private double total;
    private int id_lavado;

    public Lavado(){}

    public Lavado(double peso, double importe, double total)
    {
        this.peso = peso;
        this.importe = importe;
        this.total = total;
    }

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

    @Override
    public String toString()
    {
        return "Lavado = idLavado: "+id_lavado+", Peso: "+peso+", Importe: "+importe+", Total: "+total;
    }
}
