public class JogoDaVelha {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int tabuleiro[][] = new int[3][3];
    protected int jogador;

    public JogoDaVelha() {
        limpaTabuleiro();
    }


    public void limpaTabuleiro() {
        for(int i = 0;i<3;i++) {
            for (int j=0; j<3; j++) {
                tabuleiro[i][j]=VAZIO;
            }
        }
        jogador = X;
    }

    public void poePeca(int i, int j) {
        if (i<0||i>2||j<0||j>2){
            throw new IllegalArgumentException("Posição Inválida");
        }
        if (tabuleiro[i][j]!=VAZIO) throw new IllegalArgumentException("Posição Ocupada");
        tabuleiro[i][j]=jogador;
        jogador = -jogador;
    }

    public boolean eVencedor(int marca) {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            int cont = 0;
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == marca) cont++;
            }
            if (cont == 3) return true;
        }

        // Verifica colunas
        for (int j = 0; j < 3; j++) {
            int cont = 0;
            for (int i = 0; i < 3; i++) {
                if (tabuleiro[i][j] == marca) cont++;
            }
            if (cont == 3) return true;
        }

        // Diagonal principal
        int diagonal1 = 0;
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][i] == marca) diagonal1++;
        }
        if (diagonal1 == 3) return true;

        // Diagonal secundária
        int diagonal2 = 0;
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][3 - 1 - i] == marca) diagonal2++;
        }
        if (diagonal2 == 3) return true;

        return false;
    }

    public int vencedor() {
        if (eVencedor(X)) return X;
        if (eVencedor(O)) return O;
        return 2;
    }

    
    public String toString() {
        /** Implementar o método to String que deve retornar
         * uma string com o tabuleiro do jogo da velha com as peças
         * nas posições corretas.
         */
        String retorno = "";
        for (int i=0; i<3;i++){
            for (int j=0; j<3; j++){
                if(tabuleiro[i][j]==X) {
                    retorno += ("X");
                } else if (tabuleiro[i][j]==O) {
                    retorno += ("O");
                } else {
                    retorno += (" ");
                }
                if (j<2){
                    retorno += ("|");
                }
            }
            //System.out.println();
            if (i<2){
                retorno += ("\n-----\n");
            }

        }   
        return retorno;
    }
}