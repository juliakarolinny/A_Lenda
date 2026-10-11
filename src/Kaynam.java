public class Kaynam extends Heroi {

    private static final int CUSTO_ENERGIA_QUINWAN = 40;

    public Kaynam(String nome) {
        super(nome, 1, 50);
    }

    @Override
    public void usarQuinwan(Combate alvo) {
        if (gastarEnergia(CUSTO_ENERGIA_QUINWAN)) {
            int dano = calcularAtaque() * 2 + getPoder();
            IO.println(getNome()
                    + " invoca a "
                    + getNomeQuinwan()
                    + " sobre "
                    + alvo.getNome()
                    + "!");
            alvo.receberDano(dano);
        } else {
            IO.println(getNome()
                    + " nao tem energia suficiente para usar "
                    + getNomeQuinwan()
                    + ".");
        }
    }

    @Override
    public String getNomeQuinwan() {
        return "Furia de Kaynam";
    }

    @Override
    public int getCustoEnergiaQuinwan() {
        return CUSTO_ENERGIA_QUINWAN;
    }
}