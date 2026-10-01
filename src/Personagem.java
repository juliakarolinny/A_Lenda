public abstract class Personagem implements Combate{
    private String nome;
    private int vida;
    private int vidaMaxima;
    private int energia;
    private int energiaMaxima;
    private int nivel;
    private int poder;

    protected Personagem(String nome, int vidaMaxima, int energiaMaxima, int nivel, int poder) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.energiaMaxima = energiaMaxima;
        this.energia = energiaMaxima;
        this.nivel = nivel;
        this.poder = poder;


    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    protected void setVida(int vida) {
        this.vida = vida;
        if (this.vida > vidaMaxima) {
            this.vida = vidaMaxima;
        }
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }
    public int getEnergiaMaxima() {
        return energiaMaxima;
    }

    public int getEnergia() {
        return energia;
    }

    protected void setEnergia(int energia) {
        this.energia = energia;
        if (this.energia > energiaMaxima) {
            this.energia = energiaMaxima;
        }
        if (this.energia < 0) {
            this.energia = 0;
        }

    }
    public int getNivel() {
        return nivel;
    }
    protected void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getPoder(){
        return poder;
    }
    protected void setPoder(int poder){
        this.poder = poder;
    }
    public void curar(int quantidade) {
        this.vida += quantidade;
        if (this.vida > vidaMaxima) {
            this.vida = vidaMaxima;
        }
    }
    public String gastarEnergia(int quantidade) {
        if (energia >= quantidade) {
            energia -= quantidade;
            return "Energia gasta com sucesso.";
        }
        return "Energia insuficiente!";
    }
    protected void recuperarEnergia(int quantidade) {
        energia += quantidade;
        if (energia > energiaMaxima) {
            energia = energiaMaxima;
        }
    }


    @Override
    public void receberDano(int dano) {
        vida -= dano;
        if(vida <0){
            vida=0;
        }

    }

    @Override
    public String estaVivo() {
        if(vida> 0) {
            return "O personagem esta vivo.";
        }
        return "Não.O personagem esta morto.";
    }
    public abstract int calcularataque();
    @Override
    public void atacar(Combate alvo) {
        int dano = calcularataque();
        IO.println(nome
                + " ataca "
                + alvo.getNome()
                + " causando "
                + dano
                + " de dano!");

        alvo.receberDano(dano);
    }


    public int calcularAtaque(){
        return 0;
    }
}