package principal;

import clases.Lector;
import clases.PersonalAdministrativo;
import clases.Policia;
import java.util.ArrayList;

public class SistemaRegistros {
    
    private static SistemaRegistros unicaInstancia;

    public static SistemaRegistros getInstancia() {
        if(unicaInstancia == null)
            unicaInstancia = new SistemaRegistros();
        return unicaInstancia;
    }
    
    private SistemaRegistros() {}
    
    private ArrayList<Policia> ListaPolicia = new ArrayList();
    private ArrayList<PersonalAdministrativo> ListaAdministrativo = new ArrayList();
    private final String nombreComisaria = "AGUILAS NEGRAS";

    public void ejecutar() {
        int opt;
        do{
            opt = menu();
            switch (opt){
                case 1:
                    registrarPolicia();
                    break;
                case 2:
                    registrarPersonal();
                    break;
                case 3:
                    calcularSaldo();
                    break;
                case 4:
                    listarPoliciaEdad();
                    break;
                case 5:
                    listarPoliciaSueldo();
                    break;
                case 6:
                    listarPersonal();
                    break;
                case 7:		
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("La opcion no es valida");	
            }

        }while (opt!=7);
    }

    public int  menu(){
            String opciones=
                "\n MENU PINCIPAL DE LA COMISARÍA "+nombreComisaria+
                "\n1.Registrar Policia "+
                "\n2.Resgistrar PersonalAdministrativo"+
                "\n3.Calcular el saldo del policia"+
                "\n4.Listar ascendentemente los Policias por edad"+
                "\n5.Listar Segun el sueldo de los policias"+
                "\n6.Listar alfabeticamente al PersonalAdministrativo por apellidos"+
                "\n7.Salir"+
                "\nSeleccione Opcion: ";
            return Integer.parseInt(Lector.leer(opciones));
    }


    public void registrarPolicia(){
        String nombre=Lector.leer("Ingrese nombre: ");
        String apellido=Lector.leer("Ingrese apellidos: ");
        String codigo=Lector.leer("Ingrese codigo: ");
        String DNI=Lector.leer("Ingrese DNI: ");
        int edad=Integer.parseInt(Lector.leer("Ingrese su edad: "));
        int rango = -1;
        while(rango<1||rango>5) // while( !(rango>=1&&rango<=5) )
            rango = Integer.parseInt(Lector.leer("Ingrese su rango: "));
//        do{
//            rango = Integer.parseInt(Lector.leer("Ingrese su rango: "));
//        }while(rango<1||rango>5);
        ListaPolicia.add( new Policia(nombre,apellido,codigo,DNI,edad,rango) );
    }

    private void registrarPersonal() {
        String codigo = Lector.leer("Ingrese código: ");
        String nombres = Lector.leer("Ingrese nombres: ");
        String apellidos = Lector.leer("Ingrese apellidos: ");
        String DNI = Lector.leer("Ingrese DNI: ");
        String sector = Lector.leer("Ingrese sector: ");
        ListaAdministrativo.add( new PersonalAdministrativo(codigo, nombres, apellidos, DNI, sector) ); 
    }

    private void calcularSaldo() {        
//        for(int i=0; i<ListaPolicia.size(); ++i)
//            ListaPolicia.get(i).calcularS();
        
//        FOR EACH.
        for(Policia p : ListaPolicia)
            p.calcularS();
    }   

    private void listarPoliciaEdad() {
//        MÉTODO DE LA BURBUJA.
        for(int i=0; i<ListaPolicia.size()-1; ++i)
            for(int j=i+1; j<ListaPolicia.size(); ++j)
                if(ListaPolicia.get(i).getEdad() > ListaPolicia.get(j).getEdad()) {
                    Policia temporal = ListaPolicia.get(i);
                    ListaPolicia.set(i, ListaPolicia.get(j));
                    ListaPolicia.set(j, temporal);
                }
        
        for(Policia p : ListaPolicia)
            System.out.println( p.toString() );
    }

    private void listarPoliciaSueldo() {
//        MÉTODO DE LA BURBUJA.
        for(int i=0; i<ListaPolicia.size()-1; ++i)
            for(int j=i+1; j<ListaPolicia.size(); ++j)
                if(ListaPolicia.get(i).getSaldo() < ListaPolicia.get(j).getSaldo()) {
                    Policia temporal = ListaPolicia.get(i);
                    ListaPolicia.set(i, ListaPolicia.get(j));
                    ListaPolicia.set(j, temporal);
                }
        
        for(Policia p : ListaPolicia)
            System.out.println( p.toString() );        
    }

    private void listarPersonal() {
//        MÉTODO DE LA BURBUJA.
        for(int i=0; i<ListaAdministrativo.size()-1; ++i)
            for(int j=i+1; j<ListaAdministrativo.size(); ++j)
                if(ListaAdministrativo.get(i).getApellidos().compareTo(ListaAdministrativo.get(j).getApellidos())>0) {
                    PersonalAdministrativo temporal = ListaAdministrativo.get(i);
                    ListaAdministrativo.set(i, ListaAdministrativo.get(j));
                    ListaAdministrativo.set(j, temporal);
                }        
        
        for(PersonalAdministrativo adm : ListaAdministrativo)
            System.out.println( adm.toString() );
    }
    
    


}