
public class Voinu extends Heroi {

    private static final int CUSTO_ENERGIA_QUINWAN = 20;

    public Voinu(String nome) {
        super(nome, 1, 45);
    }

    @Override
    public void usarQuinwan(Combate alvo) {
        if (gastarEnergia(CUSTO_ENERGIA_QUINWAN)) {
            int dano = calcularAtaque() + (getPoder() * 3 / 2);
            IO.println(getNome()
                    + " conjura a "
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
        return "Onda de Voinu";
    }

    @Override
    public int getCustoEnergiaQuinwan() {
        return CUSTO_ENERGIA_QUINWAN;
    }
}