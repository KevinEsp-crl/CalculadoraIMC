
import com.mycompany.calculadoraimc.modelo.MedicionIMC;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoIMCTest {

    @Test
    public void probarCalculoIMC() {
        MedicionIMC medicion = new MedicionIMC();

        medicion.setPeso(70);
        medicion.setEstatura(1.75);

        double resultado = medicion.calcularIMC();

        assertEquals(22.86, resultado, 0.01);
    }

    @Test
    public void probarValoresInvalidos() {
        MedicionIMC medicion = new MedicionIMC();

        medicion.setPeso(0);
        medicion.setEstatura(1.75);

        double resultado = medicion.calcularIMC();

        assertEquals(0, resultado);
    }
}