public class Chave implements Item{

        private final Bioma biomaQueDesbloqueia;

        public Chave(Bioma biomaQueDesbloqueia) {
            this.biomaQueDesbloqueia = biomaQueDesbloqueia;
        }

        public Bioma getBiomaQueDesbloqueia() {
            return biomaQueDesbloqueia;
        }

        @Override
        public String getNome() {
            return "Chave de "
                    + biomaQueDesbloqueia;
        }

        @Override
        public String getDescricao() {
            return "Abre o caminho para o bioma "
                    + biomaQueDesbloqueia
                    + ".";
        }

        @Override
        public String getId() {
            return "CHAVE";
        }


        @Override
        public void aplicar(Heroi heroi) {
            heroi.desbloquearBioma(this.biomaQueDesbloqueia);
            IO.println("Voce recebeu: " + getNome());
        }
    }

