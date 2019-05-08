package domain;

public class Cliente
{
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String correo;
    private int id_cliente;

    public Cliente(){}

    public Cliente(String nombre, String apellido, String dni, String telefono, String correo)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId_cliente()
    {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente)
    {
        this.id_cliente = id_cliente;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public String getDni()
    {
        return dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getCorreo()
    {
        return correo;
    }

    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    @Override
    public String toString()
    {
        return "Cliente = id_cliente: "+id_cliente+", Nombre: "+nombre+", Apellido: "+apellido+", DNI: "+dni+", Telefono: "+telefono+", Correo: "+correo;
    }
}
