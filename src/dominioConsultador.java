import java.net.InetAddress;
import java.net.UnknownHostException;

// muestra la información del equipo local
public class dominioConsultador {

    public static void main(String[] args) {

        // obtenemos los datos del equipo local
        try {
            InetAddress equipo = InetAddress.getLocalHost();

            System.out.println("nombre del equipo: " + equipo.getHostName());
            System.out.println("ip del equipo: " + equipo.getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println("no se ha podido obtener la informacion del equipo.");
        }
    }
}