public class Otosuanay extends Heroi {

    private static final int CUSTO_ENERGIA_QUINWAN = 35;

    public Otosuanay(String nome) {
        super(nome, 1, 40);
    }

    @Override
    public void usarQuinwan(Combate alvo) {
        String resultadoEnergia = gastarEnergia(CUSTO_ENERGIA_QUINWAN);
        if (resultadoEnergia.equals("Energia gasta com sucesso.")) {
            int dano = calcularataque() + getPoder();
            int cura = getPoder() / 2;

            IO.println(getNome()
                    + " invoca a "
                    + getNomeQuinwan()
                    + " sobre "
                    + alvo.getNome()
                    + "!");
            alvo.receberDano(dano);

            restaurarVidaEEnergia(getVida() + cura, getEnergia());
            IO.println(getNome() +
                    " recupera "
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


    @Override
    public void descarcar() {
        restaurarVidaEEnergia(getVida() + 20, getEnergia() + 30);
        IO.println(getNome() + " descansou e recuperou vida e energia!");
    }


    @Override
    public int calcularataque() {
        return getNivel() * 10 + getPoder();
    }
}