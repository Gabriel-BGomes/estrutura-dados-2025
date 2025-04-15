import java.util.Random;
import java.util.Scanner;

public class JogaJogoDaVelha {
    public static void main(String[] args) {
        System.out.println("Jogando até ganhar");
        Scanner scanner = new Scanner(System.in);
        Random gerador = new Random();
        int continuar = 1;

        while (continuar == 1) {
 
            JogoDaVelha jogo = new JogoDaVelha();
            int jogadas = 0;
            int totalJogadas =  9;

            while (jogadas < totalJogadas && jogo.vencedor() == 2) {
                int i = gerador.nextInt(3);
                int j = gerador.nextInt(3);

                if (jogo.tabuleiro[i][j] == JogoDaVelha.VAZIO) {
                    jogo.poePeca(i, j);
                    jogadas++;
                }
            }

            System.out.println("Tabuleiro Final:");
            System.out.println(jogo);

            int resultado = jogo.vencedor();
            if (resultado == JogoDaVelha.X) {
                System.out.println("O vencedor foi o X!");
            } else if (resultado == JogoDaVelha.O) {
                System.out.println("O vencedor foi o O!");
            } else {
                System.out.println("Empate!");
            }

            System.out.println("Deseja jogar novamente? (1 para sim / 2 para não): ");
            continuar = scanner.nextInt();
        }

        System.out.println("Jogo acabou.");
        scanner.close();
    }
}
