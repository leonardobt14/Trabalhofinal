import java.util.Locale;
import java.util.Scanner;

public class Projeto {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n;
		System.out.print("Informe a quantidade de clientes: ");
		n = sc.nextInt();

		String[] nome = new String[n];
		String[] telefone = new String[n];
		int[] tipo = new int[n];
		int[] minutos = new int[n];
		double[] valordaconta = new double[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Dados do " + (i + 1) + "o. cliente: ");
			System.out.print("Nome: ");
			sc.nextLine();
			nome[i] = sc.nextLine();
			System.out.print("Telefone: ");
			telefone[i] = sc.next();

			System.out.print("Tipo: ");
			tipo[i] = sc.nextInt();
			if (tipo[i] != 0 && tipo[i] != 1 && tipo[i] != 2) {
				while (tipo[i] != 0 && tipo[i] != 1 && tipo[i] != 2) {
					System.out.print("Tentativa Inválida, digite um tipo de assinatura válido 0, 1 ou 2: ");
					tipo[i] = sc.nextInt();
				}
			}

			System.out.print("Minutos: ");
			minutos[i] = sc.nextInt();
			System.out.println();
		}

		double[][] mattipos = new double[3][2];
		System.out.println("Informe o preco basico e excedente de cada tipo de conta:");
		for (int a = 0; a < 3; a++) {
			System.out.print("Tipo " + a + ": ");
			for (int j = 0; j < 2; j++) {
				mattipos[a][j] = sc.nextDouble();
			}
		}
		System.out.println();

		for (int i = 0; i < n; i++) {
			for (int a = 0; a < 3; a++) {
				for (int j = 0; j < 2; j++) {
					double minutomais = minutos[i] - 90;
					if (minutos[i] <= 90) {
						valordaconta[i] = mattipos[tipo[i]][0];
						j = 2;
					} else {
						valordaconta[i] = mattipos[tipo[i]][0] + minutomais * mattipos[tipo[i]][1];
						j = 2;
					}
					a = 3;
				}
			}
		}

		int opcao;

		do {
			System.out.println("MENU DE OPCOES:");
			System.out.println("1) Relatorio de clientes");
			System.out.println("2) A receita total");
			System.out.println("3) Conta foi mais barata");
			System.out.println("4) Consumo medio de clientes tipo 1");
			System.out.println("5) Clientes que consumiram acima de 120 minutos");
			System.out.println("6) A porcentagem de clientes tipo 2");
			System.out.println("7) Sair");
			System.out.print("Informe uma opcao: ");
			opcao = sc.nextInt();

			if (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5 && opcao != 6 && opcao != 7) {
				System.out.println();
				while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5 && opcao != 6 && opcao != 7) {
					System.out.print("Opção Inválida! Tente Novamente: ");
					opcao = sc.nextInt();
				}
			}

			if (opcao == 1) {
				System.out.println();
				for (int i = 0; i < n; i++) {
					System.out.print(nome[i] + ",");
					System.out.print(" " + telefone[i] + ",");
					System.out.print(" Tipo " + tipo[i] + ",");
					System.out.print(" Minutos: " + minutos[i] + ",");
					System.out.printf(" Conta = R$ %.2f%n", valordaconta[i]);
				}
				System.out.println();

			} else if (opcao == 2) {
				System.out.println();
				double somatotal = 0;
				for (int i = 0; i < n; i++) {
				 somatotal += valordaconta[i];
				}
				System.out.printf("A Receita total é de: R$ %.2f%n" , somatotal);
				System.out.println();

			} else if (opcao == 3) {
				System.out.println();
				
				double contamaisbarata = valordaconta[0];
				String nomemaisbarata = nome[0], telefonemaisbarata = telefone [0];
				
				for (int i = 0; i < n; i++) {
					if (valordaconta[i] < contamaisbarata) {
						contamaisbarata = valordaconta[i];
						nomemaisbarata = nome[i];
						telefonemaisbarata = telefone[i];
					}
				}
				System.out.print("A Conta mais barata foi de: " + nomemaisbarata + ", Telefone: " + telefonemaisbarata);
				System.out.println();
				System.out.println();

			} else if (opcao == 4) {
				System.out.println();
				int consumomediotipo1 = 0;
				int consumotipo1 = 0;
				int tipo1 = 0;
				
				for (int i = 0; i < n; i++) {
					if (tipo[i] == 1) {
					tipo1++;
					consumotipo1 += minutos[i];
					consumomediotipo1 = consumotipo1 / tipo1;
					}
					if (i == n - 1) {
					System.out.print("O Consumo medio de clientes do tipo 1 foi de: " + consumomediotipo1 + " Minutos");
					}
				}

				System.out.println();
				System.out.println();

				
				
			} else if (opcao == 5) {
				System.out.println();
				int clientesacima120 = 0;
				for (int i = 0; i < n; i++) {
					if (minutos[i] > 120) {
						clientesacima120++;
					}
				}
				System.out.print("Quantidade de clientes que consumiram acima de 120 minutos: " + clientesacima120 + " Clientes");
				System.out.println();
				System.out.println();

			} else if (opcao == 6) {
				System.out.println();
				int tipo2 = 0;
				double porcentagemtipo2 = 0;
				for (int i = 0; i < n; i++) {
					if (tipo[i] == 2) {
						tipo2++;
					}
				}
				porcentagemtipo2 = (tipo2 * 100) / n;
				System.out.printf("Porcentagem de clientes tipo 2: %.1f%%%n", porcentagemtipo2);
				System.out.println();
			}

		} while (opcao != 7);
		
		System.out.println();
		System.out.print("FIM DO PROGRAMA!");

		
		sc.close();
	}
}
