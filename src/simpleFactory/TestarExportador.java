package simpleFactory;

import java.util.ArrayList;
import java.util.List;

public class TestarExportador {
    public static void main(String[] args) {
        final List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, "TV", "LG", "1234-a", 1200));
        produtos.add(new Produto(2, "Geladeira", "Electrolux", "Delux", 400));
        produtos.add(new Produto(3, "Notebook", "Asus", "Predator", 850));

        ExportadorListaProduto exportadorCsv = ExportadorListaProduto.newInstance("csv");
        System.out.println("Lista de Produtos em CSV\n");
        System.out.println(exportadorCsv.exportar(produtos));
    }
}
