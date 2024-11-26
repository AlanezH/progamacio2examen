package sistemagym;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGym {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Membresia basica = new Membresia("Básica", 100.0);
        Membresia premium = new Membresia("Premium", 200.0);
        int opcion;
        do {
            System.out.println("*** Membresías de Gimnasio ***");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Ver Usuarios");
            System.out.println("3. Cancelar Membresía");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarUsuario(basica, premium);
                    break;
                case 2:
                    verUsuarios();
                    break;
                case 3:
                    cancelarMembresia();
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void registrarUsuario(Membresia basica, Membresia premium) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el correo del usuario: ");
        String correo = scanner.nextLine();

        System.out.println("Seleccione el tipo de membresía:");
        System.out.println("1. Básica (100.0 BOB)");
        System.out.println("2. Premium (200.0 BOB)");
        int opcionMembresia = scanner.nextInt();
        scanner.nextLine();

        Membresia membresiaSeleccionada = opcionMembresia == 1 ? basica : premium;

        Usuario usuario = new Usuario(nombre, correo, membresiaSeleccionada);
        usuarios.add(usuario);
        System.out.println("sistemagym.Usuario registrado exitosamente.");
    }

    private static void verUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    private static void cancelarMembresia() {
        System.out.print("Ingrese el nombre del usuario para cancelar su membresía: ");
        String nombre = scanner.nextLine();

        Usuario usuarioEncontrado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            usuarioEncontrado.cancelarMembresia();
            System.out.println("Membresía cancelada exitosamente.");
        } else {
            System.out.println("sistemagym.Usuario no encontrado.");
        }
    }
}
