import static java.lang.IO.println;

public class Batalha {
    private final Heroi heroi;
    private final Vilao vilao;



    public Batalha(Heroi heroi, Vilao vilao) {
        this.heroi = heroi;
        this.vilao = vilao;
    }

    public boolean iniciar(){
        IO.println("------------------------------\n");
        IO.println(
                vilao.getNome()
                + "(De Nivel"
                + vilao.getNivel()
                + "\nApareceu no meio do seu caminho!");
        IO.println("-------------------------------\n");

        while (heroi.estaVivo() && vilao.estaVivo()) {
            exibirStatus();
            int escolha = menuAcao();

            switch (escolha) {
                case 1:
                    heroi.atacar(vilao);
                    break;
                case 2:
                    heroi.usarQuinwan(vilao);
                    break;
                case 3:
                    heroi.descansavel();
                    break;
                default:
                    IO.println("Acao invalida - " + heroi.getNome() + " hesita e perde a vez!");
                    break;
            }

            if (vilao.estaVivo()) {
                vilao.atacar(heroi);
            }
        }

        IO.println();
        if (heroi.estaVivo()) {
            IO.println(vilao.getNome() + " foi derrotado!");
            return true;
        } else {
            IO.println(heroi.getNome() + " foi derrotado por " + vilao.getNome() + "...");
            return false;
        }
    }

    private void exibirStatus() {
        IO.println();
        IO.println(heroi.getNome()
                + " | Vida: "
                + heroi.getVida()
                + "/"
                + heroi.getVidaMaxima()
                + " | Energia: "
                + heroi.getEnergia()
                + "/"
                + heroi.getEnergiaMaxima());

       IO.println(vilao.getNome()
               + " | Vida: "
               + vilao.getVida()
               + "/"
               + vilao.getVidaMaxima());
    }

    private int menuAcao() {
        IO.println("1) Atacar  2) "
                + heroi.getNomeQuinwan()
                + " (custa "
                + heroi.getCustoEnergiaQuinwan()
                + " energia)  3) Descansar (cuidado: o vilao ataca durante o descanso)");

        IO.println("Escolha: ");
        return Integer.parseInt(IO.readln());
    }
}