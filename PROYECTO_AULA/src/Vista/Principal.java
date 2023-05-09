package Vista;

import java.time.LocalDate;
import java.util.ArrayList;
import Modelo.*;
import java.time.Month;

/**
 *
 * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public class Principal {

    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static LocalDate fechaActual = LocalDate.now();

    public static void main(String[] args) {

        //LogicaUsuario = new LogicaUsuario();
        int OP = 0;
        int pos;
        double saldo;
        String usuario, contraseña, correo;

        do {
            System.out.println("\n********** MENU PRINCIPAL **********");
            System.out.println("1) INICIAR SESION");
            System.out.println("2) REGISTRARSE");
            System.out.println("3) SALIR");
            System.out.println("");
            OP = Entrada.leerInt("INGRESE UNA OPCION: ");

            switch (OP) {
                case 1:
                    System.out.println("\n********** INICIAR SESION **********");

                    usuario = Entrada.leerString("USUARIO: ");
                    contraseña = Entrada.leerString("CONTRASEÑA: ");
                    pos = validarAcceso(usuario, contraseña);
                    OP = 0;
                    if (pos == -1) {
                        System.out.println("USUARIO NO ENCONTRADO: ");
                    } else {
                        do {
                            System.out.println("\nSU SALDO:" + usuarios.get(pos).getSaldo());
                            System.out.println("1) AGREGAR INGRESO");
                            System.out.println("2) AGREGAR EGRESO");
                            System.out.println("3) MODIFICAR CUENTA");
                            System.out.println("4) CERRAR SESION");
                            OP = Entrada.leerInt("INGRESE UNA OPCION: ");

                            switch (OP) {
                                case 1:
                                    agregarIngreso(pos);
                                    break;
                                case 2:
                                    agregarEgreso(pos);
                                    break;
                                case 3:
                                    modificarCuenta(pos);
                                    break;
                                case 4:
                                    System.out.println("Salida exitosa....");
                                    break;
                                default:
                                    System.out.println("ERROR... ESTA ALTERNATIVA NO EXISTE EN EL MENU, INTENTE NUEVAMENTE");
                                    break;
                            }
                        } while (OP != 4);
                    }
                    break;
                case 2:
                    registrarUsuario();
                    break;
                case 3:
                    System.out.println("Salida exitosa....");
                    break;
                default:
                    System.out.println("ERROR... ESTA ALTERNATIVA NO EXISTE EN EL MENU, INTENTE NUEVAMENTE");
                    break;
            }
        } while (OP != 3);
    }

    public static int validarAcceso(String usernames, String passwords) {
        for (int i = 0; i < usuarios.size(); i++) {
            if ((usuarios.get(i).getNombre().equals(usernames)) && (usuarios.get(i).getContraseña().equals(passwords))) {
                System.out.println("\nUSUARIO ENCONTRADO, BIENVENIDO A LA APP");
                return i;
            }
        }
        return -1;
    }

    public static void agregarIngreso(int pos) {
        System.out.println("\n********** INGRESOS **********");
        int tipoIngreso = Entrada.leerInt("(1) PARA INGRESO FIJO || (2) PARA INGRESO EVENTUAL: ");

        if (tipoIngreso == 1) {
            System.out.println("\n********** AGREGANDO INGRESO FIJO **********");
            System.out.println("");
            double nuevoIngreso = Entrada.leerDouble("DIGITE LA CANTIDAD: ");
            String asunto = Entrada.leerString("INGRESE EL ASUNTO: ");
            System.out.println("");
            System.out.println("********** FECHA DE INICIO DEL INGRESO **********");
            System.out.println("");
            int dia = Entrada.leerInt("DIGITE EL DIA DEL INGRESO: ");
            int mes = Entrada.leerInt("DIGITE EL MES DEL INGRESO: ");
            int año = Entrada.leerInt("DIGITE EL AÑO DEL INGRESO: ");
            LocalDate fechaInicio = LocalDate.of(año, mes, dia);
            LocalDate fechaSiguiente = fechaInicio;
            System.out.println("");
            System.out.println("********** FRECUENCIA DEL INGRESO **********");
            System.out.println("");
            int opcionFrecuencia = Entrada.leerInt("(1) PARA DIAS || (2) PARA MESES || (3) PARA AÑOS");

            if (opcionFrecuencia == 1) {
                int frecuenciaDias = Entrada.leerInt("DIGITE LA FRECUENCIA DE DIAS:");
                double saldoActual = usuarios.get(pos).getSaldo();

                while (fechaSiguiente.isBefore(LocalDate.now())) {
                    fechaSiguiente = fechaSiguiente.plusDays(frecuenciaDias);
                }

                usuarios.get(pos).registrarIngresoFijo(nuevoIngreso, asunto, frecuenciaDias, fechaInicio);

            } else {
                if (opcionFrecuencia == 2) {
                    int frecuenciaMeses = Entrada.leerInt("DIGITE LA FRECUENCIA DE MESES: ");
                    while (fechaSiguiente.isBefore(LocalDate.now())) {
                        fechaSiguiente = fechaSiguiente.plusDays(frecuenciaMeses);
                    }

                    usuarios.get(pos).registrarIngresoFijo(nuevoIngreso, asunto, frecuenciaMeses, fechaInicio);

                } else {
                    if (opcionFrecuencia == 3) {
                        int frecuenciaAño = Entrada.leerInt("DIGITE LA FRECUENCIA DE AÑOS:");

                        while (fechaSiguiente.isBefore(LocalDate.now())) {
                            fechaSiguiente = fechaSiguiente.plusDays(frecuenciaAño);
                        }

                        usuarios.get(pos).registrarIngresoFijo(nuevoIngreso, asunto, frecuenciaAño, fechaInicio);
                    } else {
                        System.out.println("INGRESE UNA OPCION VALIDA...");
                    }
                }
            }
        } else {
            if (tipoIngreso == 2) {

                System.out.println("\n********** AGREGANDO INGRESO EVENTUAL **********");
                double nuevoIngreso = Entrada.leerDouble("DIGITE LA CANTIDAD: ");
                String asunto = Entrada.leerString("INGRESE EL ASUNTO: ");
                usuarios.get(pos).registrarIngresoEventual(nuevoIngreso, asunto);
            } else {
                System.out.println("Dijite una opcion valida");
            }
        }

        System.out.println("********** INGRESOS REGISTRADOS **********");
        System.out.println("");
        System.out.println(usuarios.get(pos).getIngresos());

    }

    public static void agregarEgreso(int pos) {
        System.out.println("\n********** EGRESOS **********");
        int tipoEgreso = Entrada.leerInt("(1) PARA EGRESO FIJO || (2) PARA EGRESO EVENTUAL: ");
        if (tipoEgreso == 1) {
            System.out.println("\n********** AGREGANDO EGRESO FIJO **********");
            System.out.println("");
            double nuevoIngreso = Entrada.leerDouble("DIGITE LA CANTIDAD: ");
            String asunto = Entrada.leerString("INGRESE EL ASUNTO: ");
            System.out.println("");
            System.out.println("FECHA DE INICIO DEL EGRESO");
            System.out.println("");
            int dia = Entrada.leerInt("DIGITE EL DIA DEL EGRESO: ");
            int mes = Entrada.leerInt("DIGITE EL MES DEL EGRESO: ");
            int año = Entrada.leerInt("DIGITE EL AÑO DEL EGRESO: ");
            LocalDate fechaInicio = LocalDate.of(año, mes, dia);
            LocalDate fechaSiguiente = fechaInicio;
            System.out.println("");
            System.out.println("FRECUENCIA DEL EGRESO");
            System.out.println("");
            int opcionFrecuencia = Entrada.leerInt("(1) PARA DIAS || (2) PARA MESES || (3) PARA AÑOS");
            if (opcionFrecuencia == 1) {

                int frecuenciaDias = Entrada.leerInt("DIGITE LA FRECUENCIA DE DIAS:");

                while (fechaSiguiente.isBefore(LocalDate.now())) {
                    fechaSiguiente = fechaSiguiente.plusDays(frecuenciaDias);
                }

                usuarios.get(pos).registrarEgresoFijo(nuevoIngreso, asunto, frecuenciaDias, fechaInicio);

            } else {
                if (opcionFrecuencia == 2) {
                    int frecuenciaMeses = Entrada.leerInt("DIGITE LA FRECUENCIA DE MESES: ");

                    while (fechaSiguiente.isBefore(LocalDate.now())) {
                        fechaSiguiente = fechaSiguiente.plusDays(frecuenciaMeses);
                    }

                    usuarios.get(pos).registrarEgresoFijo(nuevoIngreso, asunto, frecuenciaMeses, fechaInicio);
                } else {
                    if (opcionFrecuencia == 3) {
                        int frecuenciaAño = Entrada.leerInt("DIGITE LA FRECUENCIA DE AÑOS:");

                        while (fechaSiguiente.isBefore(LocalDate.now())) {
                            fechaSiguiente = fechaSiguiente.plusDays(frecuenciaAño);
                        }

                        usuarios.get(pos).registrarEgresoFijo(nuevoIngreso, asunto, frecuenciaAño, fechaInicio);
                    } else {
                        System.out.println("INGRESE UNA OPCION VALIDA...");
                    }
                }
            }
        } else {
            if (tipoEgreso == 2) {
                System.out.println("\n********** AGREGANDO EGRESO EVENTUAL **********");
                double nuevoIngreso = Entrada.leerDouble("DIGITE LA CANTIDAD: ");
                String asunto = Entrada.leerString("INGRESE EL ASUNTO: ");
                usuarios.get(pos).registrarEgresoEventual(nuevoIngreso, asunto);
            } else {
                System.out.println("Dijite una opcion valida");
            }
        }
        System.out.println("********** EGRESOS REGISTRADOS **********");
        System.out.println("");
        System.out.println(usuarios.get(pos).getEgresos());
    }

    public static void registrarUsuario() {
        System.out.println("\n********** REGISTRO DE USUARIO **********");
        String usuario = Entrada.leerString("USUARIO: ");
        String contraseña = Entrada.leerString("CONTRASEÑA: ");
        String correo = Entrada.leerString("CORREO: ");
        usuarios.add(new Usuario(usuario, correo, contraseña));
        System.out.println("USUARIO REGISTRADO CORRECTAMENTE");
    }

    public static void modificarCuenta(int pos) {
        int OP;
        do {
            System.out.println("********** MODIFICAR CUENTA **********");
            System.out.println("1. CAMBIAR USUARIO.(USUARIO ACTUAL: " + usuarios.get(pos).getNombre() + ").");
            System.out.println("2. CAMBIAR CONTRASEÑA.");
            System.out.println("3. CAMBIAR CORREO.(CORREO ACTUAL: " + usuarios.get(pos).getCorreo() + ").");
            System.out.println("4. SALIR.");
            System.out.println("");
            OP = Entrada.leerInt("INGRESE UNA OPCION: ");
            switch (OP) {
                case 1:
                    System.out.println("********** MODIFICAR USUARIO **********");
                    String nuevoNombre = Entrada.leerString("NUEVO USUARIO: ");
                    usuarios.get(pos).setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("********** MODIFICAR CONTRASEÑA **********");
                    String nuevaContraseña = Entrada.leerString("NUEVA CONTRASEÑA : ");
                    usuarios.get(pos).setContraseña(nuevaContraseña);
                    break;
                case 3:
                    System.out.println("********** MODIFICAR CORREO **********");
                    String nuevoCorreo = Entrada.leerString("NUEVO CORREO: ");
                    usuarios.get(pos).setCorreo(nuevoCorreo);
                    break;
                case 4:
                    System.out.println("SALIDA EXITOSA...");
                    break;
                default:
                    System.out.println("INGRESE UNA OPCION VALIDA");
                    break;
            }
        } while (OP != 4);
    }
}
