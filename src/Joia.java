public class Joia implements  Item{

        private final String origem;

        public Joia(String origem) {
            this.origem = origem;
        }

        public String getOrigem() {
            return origem;
        }

        @Override
        public String getNome() {
            return "Joia de "
                    + origem;
        }

        @Override
        public String getDescricao() {
            return "Uma joia mistica obtida ao derrotar "
                    + origem
                    + ".";
        }

        @Override
        public String getId() {
            return "JOIA";
        }


        @Override
        public void aplicar(Heroi heroi) {
            heroi.receberJoia(this);
            IO.println("Voce recebeu: " + getNome());
        }
    }

