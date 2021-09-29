package simpleFactory;

import java.util.Arrays;
import java.util.List;

public class AbstractExportadorListaProduto implements ExportadorListaProduto{
    protected static final List<String> TITULOS_COLUNAS = Arrays.asList("ID", "Descrição", "Marca", "Modelo", "Estoque");

    @Override
    public String abrirTabela() {
        return null;
    }

    @Override
    public String fecharTabela() {
        return null;
    }

    @Override
    public String abrirLinha() {
        return null;
    }

    @Override
    public String fecharLinha() {
        return null;
    }

    @Override
    public String fecharLinhaTitulos() {
        return null;
    }

    @Override
    public String abrirColuna(String valor) {
        return null;
    }

    @Override
    public String fecharColuna() {
        return null;
    }

    @Override
    public final String exportar(List<Produto> listaProdutos) {
        final StringBuilder sb = new StringBuilder();
        sb.append(abrirTabela());

        sb.append(gerarColunasLinha(TITULOS_COLUNAS));
        sb.append(fecharLinhaTitulos());
        gerarLinhasProdutos(sb, listaProdutos);

        sb.append(fecharTabela());
        return sb.toString();
    }

    private void gerarLinhasProdutos(StringBuilder sb, List<Produto> listaProdutos) {
        for (Produto produto : listaProdutos) {
            List<String> valoresCamposProduto =
                    Arrays.asList(String.valueOf(produto.getId()),
                            produto.getDescricao(),
                            produto.getMarca(),
                            produto.getModelo(),
                            String.valueOf(produto.getEstoque()));
            sb.append(gerarColunasLinha(valoresCamposProduto));
        }
    }

    protected String gerarColunasLinha(List<String> valores) {
        StringBuilder sb = new StringBuilder();
        sb.append(abrirLinha());
        for (String valor : valores) {
            sb.append(abrirColuna(valor))
                    .append(fecharColuna());
        }
        sb.append(fecharLinha());
        return sb.toString();
    }
}
