public class PoderNovo implements Item{

        private final String nome;
        private final int bonusPoder;

        public PoderNovo(String nome, int bonusPoder) {
            this.nome = nome;
            this.bonusPoder = bonusPoder;
        }

        public int getBonusPoder() {
            return bonusPoder;
        }

        @Override
        public String getNome() {
            return nome;
        }

        @Override
        public String getDescricao() {
            return "Poder "
                    + nome
                    + " - aumenta seu poder (Quinwan) em "
                    + bonusPoder
                    + " pontos.";
        }

        @Override
        public String getId() {
            return "PODER";
        }


        @Override
        public void aplicar(Heroi heroi) {
            heroi.ganharPoder(this.bonusPoder);
            IO.println("Voce recebeu: " + getDescricao());
        }
    }

