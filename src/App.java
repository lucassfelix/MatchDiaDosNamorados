import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            var candidatos = Leitor.Read("input.tsv");

            Cupido.RealizarMatches(candidatos);

            Leitor.EscreverResultados(candidatos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
