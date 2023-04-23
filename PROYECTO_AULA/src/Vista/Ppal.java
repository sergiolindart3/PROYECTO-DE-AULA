package Vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import Modelo.*;

/**
 *
 * @author Jorman Noriega, Andres Contreras, Julio Rios, Sergio Arango
 */
public class Ppal {

    public static void main(String[] args) {

        ArrayList<Usuario> usuarios = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int OP = 0;
        int pos;
        double saldo;
        String usuario, contraseña, correo;

        do {
            System.out.println("\n********** MENU PRINCIPAL **********");
            System.out.println("1) INICIAR SESION");
            System.out.println("2) REGISTRARSE");
            System.out.println("3) SALIR");
            System.out.print("-> INGRESE UNA OPCION:  ");
            OP = sc.nextInt();
            sc.nextLine();

            switch (OP) {
                case 1:
                    System.out.println("\n********** INICIAR SESION **********");
                    System.out.print("USUARIO: ");
                    usuario = sc.nextLine();
                    System.out.print("CLAVE: ");
                    contraseña = sc.nextLine();
                    pos = validarAcceso(usuario, contraseña, usuarios);
                    OP = 0;

                    do {
                        System.out.println("\nSU SALDO:" + usuarios.get(pos).getSaldo());
                        System.out.println("1) AGREGAR INGRESO");
                        System.out.println("2) AGREGAR EGRESO");
                        System.out.println("3) AGREGAR DEUDAS");
                        System.out.println("4) CERRAR SESION");
                        System.out.print("-> INGRESE UNA OPCION: ");
                        OP = sc.nextInt();
                        sc.nextLine();
                        String asunto;

                        switch (OP) {
                            case 1:
                                System.out.println("\n********** INGRESOS **********");
                                System.out.print("DIGITE LA CANTIDAD:  ");
                                double nuevoIngreso = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("DIGITE EL ASUNTO:  ");
                                asunto = sc.nextLine();
                                usuarios.get(pos).getSaldo().registrarIngreso(nuevoIngreso, asunto);
                                System.out.println("INGRESOS REGISTRADOS");
                                System.out.println(usuarios.get(pos).getSaldo().getIngresos());

                                break;
                            case 2:
                                System.out.println("\n********** EGRESOS **********");
                                System.out.print("DIGITE LA CANTIDAD:  ");
                                double nuevoEgreso = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("DIGITE EL ASUNTO:  ");
                                asunto = sc.nextLine();
                                usuarios.get(pos).getSaldo().registrarEgreso(nuevoEgreso, asunto);
                                System.out.println("EGRESOS REGISTRADOS ");
                                System.out.println(usuarios.get(pos).getSaldo().getEgresos());

                                break;
                            case 3:
                                System.out.println("\n********** DEUDAS **********");
                                System.out.print("DIGITE LA CANTIDAD:  ");
                                double nuevaDeuda = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("DIGITE EL ASUNTO:  ");
                                asunto = sc.nextLine();
                                System.out.println("DIGITE LA FECHA DE SU DEUDA");
                                System.out.print("DIA: ");
                                int dia = sc.nextInt();
                                System.out.print("MES: ");
                                int mes = sc.nextInt();
                                System.out.print("ANO: ");
                                int año = sc.nextInt();
                                LocalDate fecha = LocalDate.of(año, mes, dia);
                                usuarios.get(pos).getSaldo().registrarDeudas(nuevaDeuda, asunto, fecha);
                                System.out.println("DEUDAS REGISTRADAS");
                                System.out.println(usuarios.get(pos).getSaldo().getDeudas());

                                break;
                            case 4:
                                
                                break;
                            default:
                                System.out.println("ERROR... ESTA ALTERNATIVA NO EXISTE EN EL MENU, INTENTE NUEVAMENTE");
                                
                                break;
                        }
                    } while (OP != 4);
                    
                    break;
                case 2:
                    System.out.println("\n********** REGISTRO DE USUARIO **********");
                    System.out.print("USUARIO: ");
                    usuario = sc.nextLine();
                    System.out.print("CLAVE: ");
                    contraseña = sc.nextLine();
                    System.out.print("EMAIL: ");
                    correo = sc.nextLine();
                    System.out.print("SALDO INICIAL: ");
                    saldo = sc.nextDouble();
                    System.out.println("OK... USUARIO REGISTRADO CORRECTAMENTE");
                    usuarios.add(new Usuario(usuario, correo, contraseña, (new Saldo(saldo))));
                    
                    break;
                case 3:
                    
                    break;
                default:
                    System.out.println("ERROR... ESTA ALTERNATIVA NO EXISTE EN EL MENU, INTENTE NUEVAMENTE");
                    
                    break;
            }
        } while (OP != 3);
    }

    public static int validarAcceso(String usernames, String passwords, ArrayList<Usuario> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            if ((usuarios.get(i).getNombre().equals(usernames)) && (usuarios.get(i).getContraseña().equals(passwords))) {
                System.out.println("\nUSUARIO ENCONTRADO, BIENVENIDO A LA APP");
                return i;
            }
        }
        System.out.println("\nERROR... USUARIO NO ENCONTRADO O INCORRECTO");
        return -1;
    }
}
