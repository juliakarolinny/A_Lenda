public interface Combate {
    public void atacar(Combate alvo);
    public void receberDano(int dano);
    public String estaVivo();
    public String getNome();
}
