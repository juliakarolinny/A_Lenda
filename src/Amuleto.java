import java.util.List;

public class Amuleto implements Item {
    private final List<Joia> joias;

    public Amuleto(List<Joia> joias) {
        this.joias = joias;
    }

    public int getQuantidadeJoias() {
        int joiasEncontradas = 0;
        for (Joia j : joias) {
            joiasEncontradas = joiasEncontradas + 1;
        }
        return joiasEncontradas;
    }

    @Override
    public String getNome() {
        return "Amuleto do Nevoeiro";
    }

    @Override
    public String getDescricao() {
        return "Formado por "
                + getQuantidadeJoias()
                + " joias. Prometia liberdade...";
    }

    @Override
    public String getId() {
        return "AMULETO";
    }

    @Override
    public void aplicar(Heroi heroi) {
        IO.println("O "
                + getNome()
                + " brilha intensamente com suas "
                + getQuantidadeJoias()
                + " joias!");
    }
}
