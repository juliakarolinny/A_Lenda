public enum Bioma {
    PEIUAN ("Pantano nebuloso e traiçoeiro"),
    SEIBMUN ("Submundo Cavernas profundas e sombrias"),
    FLEIMAN ("Floresta Mata densa cheia de perigos"),
    CENUEV ("Ceu ilhas flutuantes acima das nuvens"),
    MAROIU ("Mar oceano profundo e imprevisivel"),
    FUNPON ("Ilha circular envolta de nevoas de fogo escuro - palco da batalha final");

    private final String descricao;

    Bioma(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }

}
