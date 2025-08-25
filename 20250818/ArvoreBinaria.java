public class ArvoreBinaria implements Arvore {

    private NodoArvore raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }  

    // --- MÉTODO DE PESQUISA ---
    // Esse método é um modelo do tipo de recursão que pode 
    // ser utilizado para implementar a pesquisa 
    // em outras estruturas de dados e na inserção de 
    // valores na árvore
    /**
     * Método público para pesquisar um valor na árvore.
     * @param valor O valor a ser procurado.
     * @return O nó que contém o valor, ou null se não for encontrado.
     */
    @Override
    public NodoArvore pesquisa(int valor) {
        return pesquisaRecursivo(this.raiz, valor);
    }

    /**
     * Método auxiliar recursivo para buscar um valor. [cite: 7]
     * Compara o valor com o nó atual e decide se continua a busca
     * na subárvore esquerda ou direita. [cite: 1, 7]
     *
     * @param noAtual O nó raiz da subárvore de busca.
     * @param valor O valor a ser procurado.
     * @return O nó encontrado ou null.
     */
    private NodoArvore pesquisaRecursivo(NodoArvore noAtual, int valor) {
        if (noAtual == null || noAtual.chave == valor) {
            return noAtual;
        }

        if (valor < noAtual.chave) {
            return pesquisaRecursivo(noAtual.filhoEsquerda, valor);
        } else {
            return pesquisaRecursivo(noAtual.filhoDireita, valor);
        }
    }



    @Override
    public void inserir(int valor) {
        // throw new UnsupportedOperationException("Not supported yet.");
        inserirRecursivo(this.raiz, valor);
    }

    public NodoArvore inserirRecursivo(NodoArvore noAtual, int valor) {
        if (noAtual == null) {
            return new NodoArvore(valor);
        }
        if (valor < noAtual.chave) {
            noAtual.filhoEsquerda = inserirRecursivo(noAtual.filhoEsquerda, valor);
        } else if (valor > noAtual.chave) {
            noAtual.filhoDireita = inserirRecursivo(noAtual.filhoDireita, valor);
        }
        return noAtual;
    }



    @Override
    public void remover(int valor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
