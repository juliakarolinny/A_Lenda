public class Truaya extends Heroi {

    private static final int CUSTO_ENERGIA_QUINWAN = 30;

    public Truaya(String nome) {
        super(nome, 1, 48);
    }

    @Override
    public void usarQuinwan(Combate alvo) {
        if (gastarEnergia(CUSTO_ENERGIA_QUINWAN)) {
            int dano = calcularAtaque() + getPoder();
            IO.println(getNome()
                    + " executa o "
                    + getNomeQuinwan()
                    + " em "
                    + alvo.getNome()
                    + "!");
            alvo.receberDano(dano);

            int roubo = dano / 3;
            curar(roubo);
            IO.println(getNome()
                    + " rouba "
                    + roubo
                    + " pontos de vida. Vida atual: "
                    + getVida());
        } else {
            IO.println(getNome()
                    + " nao tem energia suficiente para usar "
                    + getNomeQuinwan() + ".");
        }
    }

    @Override
    public String getNomeQuinwan() {
        return "Roubo Vital de Truaya";
    }

    @Override
    public int getCustoEnergiaQuinwan() {
        return CUSTO_ENERGIA_QUINWAN;
    }
}