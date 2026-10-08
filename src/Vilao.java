public class Vilao extends Personagem{

        private static final int energia_maxima_vilao = 200;

        private final Bioma biomaOrigem;
        private final Item recompensa;
        private final int ataqueBase;

        protected Vilao(String nome, int nivel, int vidaMaxima, int ataqueBase, Bioma biomaOrigem, Item recompensa) {
            super(nome, vidaMaxima, energia_maxima_vilao, nivel, nivel);
            this.ataqueBase = ataqueBase;
            this.biomaOrigem = biomaOrigem;
            this.recompensa = recompensa;
        }

        public Bioma getBiomaOrigem() {
            return biomaOrigem;
        }

        public Item getRecompensa() {
            return recompensa;
        }

        public int getAtaqueBase() {
            return ataqueBase;
        }

    @Override
    public final int calcularAtaque() {
        int vidaPerdida = getVidaMaxima() - getVida();
        int bonusPorFuria = (vidaPerdida * ataqueBase) / getVidaMaxima();
        return ataqueBase + bonusPorFuria;
        }



    public void aplicarRecompensa(Heroi heroi) {
            heroi.getInventario().adicionar(recompensa);

            recompensa.aplicar(heroi);
        }


}

