public class Fruta implements Item {

    private final String nome;
    private final int curaVida;

    public Fruta(String nome, int curaVida) {
        this.nome = nome;
        this.curaVida = curaVida;
    }

    public int getCuraVida() {
        return curaVida;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescricao() {
        return "Fruta "
                + nome
                + " - restaura "
                + curaVida
                + " pontos de vida.";
    }

    @Override
    public String getId() {
        return "FRUTA";
    }

    @Override
    public void aplicar(Heroi heroi) {
        heroi.restaurarVidaEEnergia(
                heroi.getVida()
                + curaVida, heroi.getEnergia());

        IO.println(heroi.getNome()
                + " comeu "
                + nome
                + " e recuperou "
                + curaVida
                + " de vida!");
    }

    }



