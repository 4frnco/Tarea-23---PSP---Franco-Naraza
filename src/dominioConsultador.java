import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.UnknownHostException;
import java.util.Scanner;

// muestra la información del equipo local y consulta dominios
public class dominioConsultador {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // obtenemos los datos del equipo local
        try {
            InetAddress equipo = InetAddress.getLocalHost();

            System.out.println("nombre del equipo: " + equipo.getHostName());
            System.out.println("ip del equipo: " + equipo.getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println("no se ha podido obtener la informacion del equipo.");
        }

        String dominio;

        // pedimos dominios hasta que el usuario escriba salir
        do {
            System.out.println("\n--- CONSULTA DE DOMINIOS ---");
            System.out.println("ejemplos: minecraft.net, twitch.tv, steampowered.com");
            System.out.print("introduce un dominio (o salir): ");

            dominio = teclado.nextLine().trim();

            if (!dominio.equalsIgnoreCase("salir")) {

                if (dominio.isEmpty()) {
                    System.out.println("error: debes introducir un dominio.");

                } else {

                    // consultamos todas las direcciones del dominio
                    try {
                        InetAddress[] direcciones = InetAddress.getAllByName(dominio);

                        System.out.println("\ndirecciones encontradas:");

                        // recorremos todas las direcciones
                        for (InetAddress direccion : direcciones) {

                            if (direccion instanceof Inet4Address) {
                                System.out.println("IPv4: "
                                        + direccion.getHostAddress());

                            } else if (direccion instanceof Inet6Address) {
                                System.out.println("IPv6: "
                                        + direccion.getHostAddress());
                            }
                        }

                    } catch (UnknownHostException e) {
                        System.out.println("error: no se ha encontrado el dominio.");
                    }
                }
            }

        } while (!dominio.equalsIgnoreCase("salir"));

        System.out.println("\nprograma finalizado.");

        teclado.close();
    }
}