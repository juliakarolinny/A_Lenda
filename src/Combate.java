public interface Combate {
    public void atacar(Combate alvo);
    public void receberDano(int dano);
    public boolean estaVivo();
    public String getNome();
}
