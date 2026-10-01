import java.util.ArrayList;
import java.util.List;

public abstract class Heroi extends Personagem implements Descanso {

    private static final int vida_naxima_heroi = 1000;
    private static final int energis_maxima_heroi = 200;

    private final Inventario inventario = new Inventario();
    private final List<Joia> joias = new ArrayList<>();
    private final List<Bioma> biomasDesbloqueados = new ArrayList<>();

    protected Heroi(String nome, int nivel, int poderBase) {
        super(nome, vida_naxima_heroi, energis_maxima_heroi, nivel, poderBase);
        biomasDesbloqueados.add(Bioma.FLEIMAN);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public List<Joia> getJoias() {
        return joias;
    }

    public List<Bioma> getBiomasDesbloqueados() {
        return biomasDesbloqueados;
    }

    public void receberJoia(Joia joia) {
        joias.add(joia);
        inventario.adicionar(joia);
    }

    public void desbloquearBioma(Bioma bioma) {
        int biomasEncontrados = 0;

        for (Bioma b : biomasDesbloqueados) {
            if (b == bioma) {
                biomasEncontrados = biomasEncontrados + 1;
            }
        }

        if (biomasEncontrados == 0) {
            biomasDesbloqueados.add(bioma);
            IO.println(">> Novo bioma desbloqueado: " + bioma + "!");
        }
    }

    public void ganharPoder(int bonus) {
        setPoder(getPoder() + bonus);
    }

    public void evoluir(int ganhoNivel) {
        setNivel(getNivel()
                + ganhoNivel);
        setPoder(getPoder()
                + ganhoNivel / 2);
        IO.println(getNome()
                + " subiu de nivel! Nivel atual: "
                + getNivel()
                + " | Poder atual: "
                + getPoder());
    }

    public void restaurarNivelEPoder(int nivel, int poder) {
        setNivel(nivel);
        setPoder(poder);
    }

    public void restaurarVidaEEnergia(int vida, int energia) {
        setVida(vida);
        setEnergia(energia);
    }

    @Override
    public int calcularAtaque() {
        return 10 + (getNivel() / 10) + (getPoder() / 5);
    }

    @Override
    public void descansavel() {
        IO.println(getNome()
                + " monta acampamento e dorme...");
        recuperarEnergia(getEnergiaMaxima());
        IO.println(getNome()
                + " acordou revigorado. Energia: "
                + getEnergia()
                + "/"
                + getEnergiaMaxima());
    }

    public  void usarQuinwan(Combate alvo) {

    }

    public  String getNomeQuinwan(){
        return"";
    }

    public int getCustoEnergiaQuinwan(){
        return 0;
    }
}
