import java.text.DecimalFormat;

public class Tuple implements Comparable<Tuple>{
    public final Candidato candidato;
    public final int score;
    public Tuple(Candidato candidato, int score) {
        this.candidato = candidato;
        this.score = score;
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        double percent = Double.valueOf(score)/Double.valueOf(candidato.respostas.size()) * 100;
        return candidato.id + '{' + df.format(percent) + "%}";
    }

    @Override
    public int compareTo(Tuple o) {
        return -Integer.compare(this.score,o.score);
    }
}