import com.sun.source.tree.Tree;

import java.util.*;

public class Candidato {

    public String id;
    public String info;

    public String gender;
    public String interesse;

    public PriorityQueue<Tuple> matches;

    public List<Integer> respostas;


    public Candidato(String id, String info, String gender, String interesse, List<Integer> respostas) {
        this.id = id;
        this.info = info;
        this.gender = gender;
        this.interesse = interesse;
        this.respostas = respostas;
        matches = new PriorityQueue<>();
    }

    private String printMatches()
    {
        var res = " Matches: ";
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
