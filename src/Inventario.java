import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private final List<Item> itens = new ArrayList<>();

    public void adicionar(Item item) {
        itens.add(item);
    }

    public List<Item> getItens() {
        return itens;
    }

    public String verificarItem(String idDesejado) {
        for (Item item : itens) {
            if (item.getId().equals(idDesejado)) {
                return "Item encontrado: " + item.getNome();
            }
        }
        return "Voce nao tem este item.";
    }

    public void listar() {
        int itensExibidos = 0;

        for (Item item : itens) {
            IO.println("  - " + item.getNome() + ": " + item.getDescricao());
            itensExibidos = itensExibidos + 1;
        }

        if (itensExibidos == 0) {
            IO.println("  (inventario vazio)");
        }
    }
}