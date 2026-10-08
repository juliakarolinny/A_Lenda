public class Kaynam extends Heroi {

    private static final int CUSTO_ENERGIA_QUINWAN = 40;

    public Kaynam(String nome) {
        super(nome, 1, 50);
    }

    @Override
    public void usarQuinwan(Combate alvo) {
        String resultadoEnergia = gastarEnergia(CUSTO_ENERGIA_QUINWAN);


        if (resultadoEnergia.equals("Energia gasta com sucesso.")) {

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


    @Override
    public void descarcar() {
        restaurarVidaEEnergia(getVida() + 20, getEnergia() + 30);
        IO.println(getNome() + " descansou e recuperou vida e energia!");
    }


    @Override
    public int calcularAtaque() {
        return getNivel() * 10 + getPoder();
    }
}