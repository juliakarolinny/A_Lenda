import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Heroi heroiAtual;
    private static final List<Vilao> viloes = criarViloes();
    private static final List<String> viloesDerrotados = new ArrayList<>();
    private static int sorteTutuman = 17;

    public static void main(String[] args) {
        IO.println("A LENDA DE QUINWAN");
        escolherHeroi();
        loopPrincipal();
    }

    private static void escolherHeroi() {
        IO.println("Escolha seu heroi:");
        IO.println("1) Kaynam - forca bruta, golpes devastadores");
        IO.println("2) Otosuanay - equilibrio entre ataque e cura");
        IO.println("3) Voinu - poder rapido e economico em energia");
        IO.println("4) Truaya - ataques sombrios que roubam vida");
        IO.println("Opcao: ");

        int opcao = Integer.parseInt(IO.readln());
        TipoHeroi tipo;

        switch (opcao) {
            case 2:
                tipo = TipoHeroi.OTOSUANAY;
                break;
            case 3:
                tipo = TipoHeroi.VOINU;
                break;
            case 4:
                tipo = TipoHeroi.TRUAYA;
                break;
            default:
                tipo = TipoHeroi.KAYNAM;
                break;
        }

        String nomeHeroi = tipo.name();
        heroiAtual = criarHeroi(tipo, nomeHeroi);
        IO.println(nomeHeroi
                + ", o(a) "
                + tipo
                + ", esta pronto(a) para a aventura!");
    }

    private static Heroi criarHeroi(TipoHeroi tipo, String nome) {
        switch (tipo) {
            case OTOSUANAY:
                return new Otosuanay(nome);
            case VOINU:
                return new Voinu(nome);
            case TRUAYA:
                return new Truaya(nome);
            default:
                return new Kaynam(nome);
        }
    }

    private static List<Vilao> criarViloes() {
        List<Vilao> lista = new ArrayList<>();
        lista.add(new Tenebrione());
        lista.add(new Uicuinam());
        lista.add(new Masterpat());
        lista.add(new Ritinora());
        lista.add(new Mainsei());
        lista.add(new Zeyona());
        lista.add(new Mupintin());
        lista.add(new Funpycoi());
        return lista;
    }

    private static void loopPrincipal() {
        int jogando = 1;
        while (jogando == 1) {
            if (!heroiAtual.estaVivo()) {
                jogando = 0;
            } else {
                Vilao proximoVilao = proximoVilaoNaoDerrotado();

                IO.println("Bioma atual: "
                        + biomaAtual()
                        + " - "
                        + biomaAtual().getDescricao());

                int tamanhoJoias = 0;
                for (Joia j : heroiAtual.getJoias()) {
                    tamanhoJoias = tamanhoJoias + 1;
                }

                IO.println(heroiAtual.getNome() + " | Nivel "
                        + heroiAtual.getNivel()
                        + " | Vida "
                        + heroiAtual.getVida()
                        + "/" + heroiAtual.getVidaMaxima()
                        + " | Energia "
                        + heroiAtual.getEnergia()
                        + "/"
                        + heroiAtual.getEnergiaMaxima()
                        + " | Joias "
                        + tamanhoJoias);

                IO.println("1) Explorar bioma (procurar fruta Tutuman)");

                String nomeVilaoTexto = "ninguem - jornada concluida";
                if (proximoVilao != null) {
                    nomeVilaoTexto = proximoVilao.getNome();
                }
                IO.println("2) Enfrentar " + nomeVilaoTexto);
                IO.println("3) Descansar (montar acampamento)");
                IO.println("4) Ver inventario");
                IO.println("5) Sair");
                IO.println("Escolha: ");

                int escolha = Integer.parseInt(IO.readln());
                jogando = processarEscolhaMenu(escolha, proximoVilao);
            }
        }

        if (!heroiAtual.estaVivo()) {
            IO.println();
            IO.println("=====================================================");
            IO.println(heroiAtual.getNome() + " caiu em batalha. FIM DE JOGO.");
            IO.println("=====================================================");
        }
    }

    private static int processarEscolhaMenu(int escolha, Vilao proximoVilao) {
        switch (escolha) {
            case 1:
                explorarBioma();
                return 1;
            case 2:
                return tratarBatalhaVilao(proximoVilao);
            case 3:
                heroiAtual.descarcar();
                return 1;
            case 4:
                heroiAtual.getInventario().listar();
                return 1;
            case 5:
                IO.println("Ate a proxima aventura!");
                return 0;
            default:
                IO.println("Opcao invalida.");
                return 1;
        }
    }

    private static int tratarBatalhaVilao(Vilao proximoVilao) {
        int temVilao = 0;
        if (proximoVilao != null) {
            temVilao = 1;
        }

        switch (temVilao) {
            case 1:
                return enfrentarVilao(proximoVilao);
            default:
                IO.println("Nao ha mais nenhum vilao a enfrentar por aqui.");
                return 1;
        }
    }

    private static Bioma biomaAtual() {
        Vilao proximo = proximoVilaoNaoDerrotado();
        if (proximo != null) {
            return proximo.getBiomaOrigem();
        }
        return Bioma.FUNPON;
    }

    private static Vilao proximoVilaoNaoDerrotado() {
        for (Vilao vilao : viloes) {
            String nomeVilao = vilao.getNome();
            int encontrado = 0;
            for (String derrotado : viloesDerrotados) {
                if (derrotado.equals(nomeVilao)) {
                    encontrado = 1;
                }
            }
            switch (encontrado) {
                case 0:
                    return vilao;
                default:
                    break;
            }
        }
        return null;
    }

    private static void explorarBioma() {
        IO.println(heroiAtual.getNome()
                + " explora "
                + biomaAtual()
                + "...");
        sorteTutuman = (sorteTutuman * 3) + 7;
        int resto = sorteTutuman % 100;

        int achouFruta = 0;
        if (resto < 55) {
            achouFruta = 1;
        }

        switch (achouFruta) {
            case 1:
                sorteTutuman = (sorteTutuman * 2) + 1;
                int curaFruta = 150 + (sorteTutuman % 150);
                Fruta tutuman = new Fruta("Tutuman", curaFruta);
                heroiAtual.getInventario().adicionar(tutuman);
                heroiAtual.curar(tutuman.getCuraVida());
                IO.println("Encontrou uma fruta Tutuman! "
                        + tutuman.getDescricao());
                IO.println("Vida atual: " + heroiAtual.getVida()
                        + "/"
                        + heroiAtual.getVidaMaxima());
                break;
            default:
                IO.println("Nada de interessante encontrado desta vez.");
                break;
        }
    }

    private static int enfrentarVilao(Vilao vilao) {
        Batalha batalha = new Batalha(heroiAtual, vilao);
        boolean venceu = batalha.iniciar();

        if (!venceu) {
            IO.println("O heroi foi derrotado pelo vilao " + vilao.getNome() + ".");
            return 0;
        }

        IO.println("Vitoria sobre o vilao " + vilao.getNome() + "!");
        viloesDerrotados.add(vilao.getNome());
        heroiAtual.evoluir(vilao.getNivel() / 20);

        Joia joia = new Joia(vilao.getNome());
        heroiAtual.receberJoia(joia);
        IO.println("Voce recebeu: " + joia.getNome());

        vilao.aplicarRecompensa(heroiAtual);

        mostrarPedacoDaHistoria(viloesDerrotados.size() - 1);

        int eFunpycoi = 0;
        if (vilao.getNome().equals("Funpycoi")) {
            eFunpycoi = 1;
        }

        switch (eFunpycoi) {
            case 1:
                finalDaHistoria();
                IO.println("A jornada chegou ao fim com a derrota de Funpycoi.");
                return 0;
            default:
                IO.println("A jornada continua rumo ao proximo desafio.");
                return 1;
        }
    }

    private static final int VELOCIDADE_DIGITACAO_MS = 35;
    private static final String[] PEDACOS_DA_HISTORIA = {

            "A joia de Tenebrione pulsa na sua mao como um coracao vivo.\n"
                    + "Ela esta quente... e parece sussurrar.",

            "No pantano, a nevoa fica mais espessa.\n"
                    + "A joia repete baixinho um nome que nao e o seu: Funpycoi.",

            "Na pedra das cavernas, um aviso antigo foi gravado:\n"
                    + "Quem junta as joias deixa de ser dono de si.",

            "Ritinora lutou como quem ja conhecia cada golpe seu.\n"
                    + "Antes de cair, ela diz: Todos nos achamos que seria diferente.",

            "Acima das nuvens, Mainsei sorri ao perder.\n"
                    + "A joia que voce carrega esta mais pesada, nao esta? Ela cresce a cada vitoria.",

            "A ventania de Zeyona se acalma e ela sussurra:\n"
                    + "Funpycoi tambem chegou ate aqui... e tambem acreditava na liberdade.",

            "Do alto, voce enxerga Funpon, cercada por nevoas de fogo escuro.\n"
                    + "Cada joia brilha em direcao a ilha, como se ela fosse a sua casa."
    };

    private static void mostrarPedacoDaHistoria(int indice) {
        if (indice < 0 || indice >= PEDACOS_DA_HISTORIA.length) {
            return;
        }
        IO.println();
        for (String linha : PEDACOS_DA_HISTORIA[indice].split("\n")) {
            contar(linha);
        }
        IO.println();// IA PARA DEIXAR LENTO ACIMA
    }

    private static void finalDaHistoria() {
        contar("Com Funpycoi derrotado, "
                + heroiAtual.getNome()
                + " junta a ultima joia -");
        contar("a Joia do Nevoeiro - as demais, formando o Amuleto do Nevoeiro.");
        Amuleto amuleto = new Amuleto(heroiAtual.getJoias());
        heroiAtual.getInventario().adicionar(amuleto);

        contar(heroiAtual.getNome()
                + " acreditava que o Amuleto traria liberdade...");
        contar("Mas o Amuleto absorve todo o poder do mundo atraves dele.");
        contar(heroiAtual.getNome()
                + " se torna o novo guardiao da ilha de Funpon,");
        contar("preso para a eternidade na batalha final que antes pertencia a Funpycoi.");
        contar("========= FIM DA JORNADA ANTIGO HEROI.==========");
    }
    private static void contar(String texto) {
        for (char letra : texto.toCharArray()) {
            IO.print(letra);
            System.out.flush();
            if (letra == '.' || letra == ',' || letra == '!' || letra == '?') {
                pausa(250);
            } else {
                pausa(VELOCIDADE_DIGITACAO_MS);
            }
        }
        IO.println();
        pausa(2500);
    }

    private static void pausa(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}