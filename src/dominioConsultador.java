import java.net.InetAddress;
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
            System.out.print("\nintroduce un dominio (o salir): ");
            dominio = teclado.nextLine().trim();

            if (!dominio.equalsIgnoreCase("salir")) {

                // consultamos todas las direcciones del dominio
                try {
                    InetAddress[] direcciones = InetAddress.getAllByName(dominio);

                    System.out.println("direcciones encontradas:");

                    for (int i = 0; i < direcciones.length; i++) {
                        System.out.println(direcciones[i].getHostAddress());
                    }

                } catch (UnknownHostException e) {
                    System.out.println("error: no se ha encontrado el dominio.");
                }
            }

        } while (!dominio.equalsIgnoreCase("salir"));

        System.out.println("programa finalizado.");

        teclado.close();
    }
}