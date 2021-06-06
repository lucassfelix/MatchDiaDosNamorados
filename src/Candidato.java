import com.sun.source.tree.Tree;

import java.util.*;

public class Candidato {

    public String id;

    public String gender;
    public String interesse;

    public PriorityQueue<Tuple> matches;

    public List<Integer> respostas;


    public Candidato(String id, String gender, String interesse, List<Integer> respostas) {
        this.id = id;
        this.gender = gender;
        this.interesse = interesse;
        this.respostas = respostas;
        matches = new PriorityQueue<>();
    }

    private String printMatches()
    {
        String res = " Matches: ";
        for (int i = 0; i < 3; i++) {
            if(!matches.isEmpty())
                res += matches.remove() + " ";
        }
        return res;
    }

    @Override
    public String toString() {
        return id + printMatches() + "\n";
    }
}
