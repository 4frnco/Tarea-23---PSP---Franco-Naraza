import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

// muestra la información del equipo local y pide un dominio
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

        // pedimos un dominio
        System.out.print("\nintroduce un dominio: ");
        String dominio = teclado.nextLine();

        System.out.println("dominio introducido: " + dominio);

        teclado.close();
    }
}