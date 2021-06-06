import java.util.Locale;
import java.util.Set;

public class Cupido {

    public static void RealizarMatches(Set<Candidato> candidatos)
    {
        Boolean todos;
        for (Candidato c :candidatos) {
            todos = c.interesse.trim().toLowerCase(Locale.ROOT) == "todos" ? true : false;

            for (Candidato x : candidatos) {
                if (x.id.equals(c.id))
                    continue;

                if (!todos)
                {
                    if(!(c.interesse.trim().toLowerCase(Locale.ROOT).equals(x.gender.trim().toLowerCase(Locale.ROOT))))
                        continue;
                }

                int score = 0;

                for (int i = 0; i < c.respostas.size(); i++) {
                    if(c.respostas.get(i) == x.respostas.get(i))
                        score++;
                }

                c.matches.add(new Tuple(x,score));
            }

        }





    }


}
