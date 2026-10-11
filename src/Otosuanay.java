public class Otosuanay extends Heroi {

    private static final int CUSTO_ENERGIA_QUINWAN = 35;

    public Otosuanay(String nome) {
        super(nome, 1, 40);
    }

    @Override
    public void usarQuinwan(Combate alvo) {
        if (gastarEnergia(CUSTO_ENERGIA_QUINWAN)) {
            int dano = calcularAtaque() + getPoder();
            int cura = getPoder() / 2;

            IO.println(getNome()
                    + " invoca a "
                    + getNomeQuinwan()
                    + " sobre "
                    + alvo.getNome()
                    + "!");
            alvo.receberDano(dano);

            curar(cura);
            IO.println(getNome()
                    + " recupera "
                    + cura
                    + " pontos de vida. Vida atual: "
                    + getVida());
        } else {
            IO.println(getNome()
                    + " nao tem energia suficiente para usar "
                    + getNomeQuinwan()
                    + ".");
        }
    }

    @Override
    public String getNomeQuinwan() {
        return "Bencao de Otosuanay";
    }

    @Override
    public int getCustoEnergiaQuinwan() {
        return CUSTO_ENERGIA_QUINWAN;
    }
}