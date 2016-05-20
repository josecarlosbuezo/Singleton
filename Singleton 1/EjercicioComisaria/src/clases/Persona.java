package clases;

public class Persona{
    private String codigo;
    private String nombres;
    private String apellidos;
    private String DNI;

    public Persona(String codigo, String nombres, String apellidos, String DNI) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.DNI = DNI;
    }

    public String getApellidos() {
        return apellidos;
    }
        
    @Override
    public String toString() {
        return "\nCódigo: "+codigo
              +"\nNombres: "+nombres
              +"\nApellidos: "+apellidos
              +"\nDNI: "+DNI;
    }    

}
