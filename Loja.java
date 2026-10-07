import java.util.Scanner;
 
public class Loja {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        // vetores paralelos: a mesma posição i é o mesmo produto
        // (em Java o índice começa em 0, por isso as posições são 0 a 4)
        String[] nome = new String[5];
        String[] categoria = new String[5];
        double[] preco = new double[5];
        int[] qtd = new int[5];
 
        // cadastro dos produtos
        nome[0] = "Creme de Pentear Meus cachoxx";
        categoria[0] = "CREME";
        preco[0] = 40.00;
 
        nome[1] = "Ativador Meus cachoxx";
        categoria[1] = "CREME";
        preco[1] = 35.00;
 
        nome[2] = "Finalizador Meus cachoxx";
        categoria[2] = "CREME";
        preco[2] = 45.00;
 
        nome[3] = "Touca de Cetim";
        categoria[3] = "ACESSORIO";
        preco[3] = 10.00;
 
        nome[4] = "Pente Garfo";
        categoria[4] = "ACESSORIO";
        preco[4] = 12.00;
 
        nome[0] = "Creme de Pentear Meus cachoxx";
        categoria[0] = "CREME";
        preco[0] = 40.00;
 
        nome[0] = "Creme de Pentear Meus cachoxx";
        categoria[0] = "CREME";
        preco[0] = 40.00;
 
        nome[0] = "Creme de Pentear Meus cachoxx";
        categoria[0] = "CREME";
        preco[0] = 40.00;
 
        nome[0] = "Creme de Pentear Meus cachoxx";
        categoria[0] = "CREME";
        preco[0] = 40.00;
 
        nome[0] = "Creme de Pentear Meus cachoxx";
        categoria[0] = "CREME";
        preco[0] = 40.00;
 
        nome[0] = "Creme de Pentear Meus cachoxx";
        categoria[0] = "CREME";
        preco[0] = 40.00;
       
        nome[0] = "Creme de Pentear Meus cachoxx";
        categoria[0] = "CREME";
        preco[0] = 40.00;
 
 
        // carrinho começa zerado
        for (int i = 0; i < 5; i++) {
            qtd[i] = 0;
        }
 
        int opcao = -1;
        while (opcao != 0) {
            mostrarMenu();
            opcao = sc.nextInt();
            sc.nextLine(); // limpa o Enter que sobrou depois do número
 
            if (opcao == 1) {
                // ver todos os produtos
                for (int i = 0; i < 5; i++) {
                    System.out.printf("%d - %s (%s) - R$ %.2f%n",
                            i + 1, nome[i], categoria[i], preco[i]);
                }
 
            } else if (opcao == 2) {
                // filtrar por categoria
                System.out.print("Digite a categoria (CREME ou ACESSORIO): ");
                String cat = sc.nextLine();
                for (int i = 0; i < 5; i++) {
                    if (categoria[i].equalsIgnoreCase(cat)) {
                        System.out.printf("%d - %s - R$ %.2f%n",
                                i + 1, nome[i], preco[i]);
                    }
                }
 
            } else if (opcao == 3) {
                // busca sequencial pelo nome
                System.out.print("Digite o nome do produto: ");
                String termo = sc.nextLine();
                boolean achou = false;
                int posicao = -1;
                int i = 0;
                while (i < 5 && !achou) {
                    if (nome[i].equalsIgnoreCase(termo)) {
                        achou = true;
                        posicao = i;
                    }
                    i++;
                }
                if (achou) {
                    System.out.printf("Encontrado: %s - R$ %.2f%n",
                            nome[posicao], preco[posicao]);
                } else {
                    System.out.println("Produto não encontrado");
                }
 
            } else if (opcao == 4) {
                // adicionar ao carrinho
                System.out.print("Digite o código do produto (1 a 5): ");
                int codigo = sc.nextInt();
                if (codigo >= 1 && codigo <= 5) { // evita posição fora do vetor
                    System.out.print("Quantas unidades? ");
                    int quantidade = sc.nextInt();
                    qtd[codigo - 1] = qtd[codigo - 1] + quantidade;
                } else {
                    System.out.println("Código inválido");
                }
 
            } else if (opcao == 5) {
                // ver carrinho e total
                double total = 0;
                for (int i = 0; i < 5; i++) {
                    if (qtd[i] > 0) {
                        double sub = subtotal(preco[i], qtd[i]);
                        System.out.printf("%s x%d = R$ %.2f%n", nome[i], qtd[i], sub);
                        total = total + sub;
                    }
                }
                double valorFinal = aplicarDesconto(total);
                System.out.printf("Total sem desconto: R$ %.2f%n", total);
                System.out.printf("Total final: R$ %.2f%n", valorFinal);
 
            } else if (opcao == 0) {
                System.out.println("Obrigada pela visita!");
 
            } else {
                System.out.println("Opção inválida");
            }
        }
 
        sc.close();
    }
 
    // sub-rotina sem parâmetros e sem retorno
    public static void mostrarMenu() {
        System.out.println("\n=== LOJA CACHEADAS ===");
        System.out.println("1 - Ver todos os produtos");
        System.out.println("2 - Ver por categoria");
        System.out.println("3 - Buscar produto pelo nome");
        System.out.println("4 - Adicionar ao carrinho");
        System.out.println("5 - Ver carrinho e total");
        System.out.println("0 - Sair");
    }
 
    // sub-rotina com parâmetros e retorno
    public static double subtotal(double p, int q) {
        return p * q;
    }
 
    // 10% de desconto a partir de R$ 100, senão 5%
    public static double aplicarDesconto(double valor) {
        double desconto; // variável local
        if (valor >= 100) {
            desconto = valor * 10 / 100;
        } else {
            desconto = valor * 5 / 100;
        }
        return valor - desconto;
    }
}