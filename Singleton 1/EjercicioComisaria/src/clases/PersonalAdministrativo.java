package clases;

public class PersonalAdministrativo extends Persona {
 	private String sector;

    public PersonalAdministrativo(String codigo, String nombres, String apellidos, String DNI, String sector) {
        super(codigo, nombres, apellidos, DNI);
        this.sector = sector;
    }

}
