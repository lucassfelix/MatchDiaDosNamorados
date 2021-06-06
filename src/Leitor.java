import java.io.*;
import java.util.*;

public class Leitor {


    public static Set<Candidato> Read(String pathToCsv) throws IOException {

        String row;

        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));

        Set<Candidato> candidatoSet = new HashSet<>();

        csvReader.readLine(); // Linha inicial ignorada

        Map<String,Integer> idRespostas = new HashMap<>();
        int idResposta = 0;

        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split("\t");
            var nome = data[1].trim();
            var info = data[2];
            var gender = data[3];
            var interesse = data[4];

            List<Integer> respostasCandidato = new ArrayList<>();

            for (int i = 5; i < data.length; i++) {
                var resposta = data[i];
                if(idRespostas.containsKey(resposta))
                {
                    respostasCandidato.add(idRespostas.get(resposta));
                }
                else
                {
                    idRespostas.put(resposta,idResposta);
                    respostasCandidato.add(idResposta++);
                }
            }

            Candidato novoCandidato = new Candidato(nome, info, gender, interesse, respostasCandidato);

            candidatoSet.add(novoCandidato);
        }
        csvReader.close();

        return candidatoSet;
    }

    public static void EscreverResultados(Set<Candidato> candidatos) throws IOException {

        FileWriter csvWriter = new FileWriter("RESULTADOS.csv");

        for (Candidato c :
                candidatos) {
            csvWriter.append(c.toString());
        }
        csvWriter.flush();
        csvWriter.close();
    }





}
