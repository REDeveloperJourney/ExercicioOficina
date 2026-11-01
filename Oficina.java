import java.util.Scanner;
public class Oficina {
	Scanner input=new Scanner(System.in);
	public static void limparTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	public String Obrigatoria(String mensagem) {
		String valor;
		while (true) {
			System.out.print(mensagem);
			valor = input.nextLine().trim();
			if (!valor.isEmpty()) {
				return valor;
			}
			System.out.println("Erro: este campo não pode ficar em branco.");
		}
	}
	public void prosseguir() {
		System.out.println("Pressione ENTER para continuar...");
		input.nextLine();
	}
	public void menu() {
		boolean sair=false;
		Mecanico A = new Mecanico("1 : Mecanico 1", "Livre", null);
		Mecanico B = new Mecanico("2 : Mecanico 2", "Livre", null);
		Fila espera = new Fila();
		Automovel[] trabalhando= new Automovel[2];
		Pilha pronto=new Pilha();
		int dia=1;

		while(sair==false) {
			limparTela();

			System.out.println("===============================================");
			System.out.println("    OFICINA MECÂNICA - CONTROLE DE ATENDIMENTO\n Dia Atual da Oficina ["+dia+"]");
			System.out.println("===============================================\n");
			System.out.println("1. Cadastrar automóvel (Entrada na Fila)");
			System.out.println("2. Avançar um dia de trabalho na oficina");
			System.out.println("3. Consultar status dos mecânicos");
			System.out.println("4. Exibir fila de espera");
			System.out.println("5. Exibir serviços concluídos (Pilha)");
			System.out.println("6. Consultar último serviço concluído");
			System.out.println("7. Reabrir último serviço concluido");
			System.out.println("8. Encerrar");
			System.out.println("================================================");
			System.out.print("Escolha uma opção: ");
			String menuStr=input.nextLine();
			int menu= Integer.parseInt(menuStr);
			switch(menu) {
			case 1:
				//cadastrar automovel
				boolean cadastrar = true;
				while (cadastrar) {
					String placa = Obrigatoria("Digite a placa: ");
					String modelo = Obrigatoria("Digite o modelo: ");
					String proprietario = Obrigatoria("Digite o proprietário: ");
					String descricaoServico = Obrigatoria("Digite a descrição do serviço necessário:");

					int estimativaDias;
					while (true) {
						System.out.print("Digite a estimativa de dias: ");
						try {
							estimativaDias = Integer.parseInt(input.nextLine());
							if (estimativaDias > 0) {
								break;
							}
							else {
								System.out.println("Erro: o valor deve ser maior que zero.");
							}
						} catch (NumberFormatException e) {
							System.out.println("Erro: digite apenas números inteiros.");
						}
					}
					Mecanico mecanicoResponsavel=null;
					int diaInicio=0;
					int diaConclusao=0;
					String situacao="Aguardando";

					Automovel carro = new Automovel(placa, modelo, proprietario,
					                                descricaoServico, estimativaDias,
					                                0,diaInicio, diaConclusao, mecanicoResponsavel, situacao);
					espera.enfileirar(carro);

					System.out.print("Cadastrar mais? (1-Sim / 2-Não): ");
					int escolha = Integer.parseInt(input.nextLine());
					if (escolha == 2) cadastrar = false;
					limparTela();
				}
				break;
			case 2:
				//avancar dia de trabalho
				if (trabalhando[0] != null && trabalhando[0].situacao.equals("Em Manutenção")) {
					trabalhando[0].diasTrabalhados++;

					if (trabalhando[0].diaConclusao == dia||trabalhando[0].diaConclusao == dia-1) {
						trabalhando[0].situacao = "Pronto";
						pronto.empilhar(trabalhando[0]);
						A.status = "Livre";
						A.automovelAtual = null;
						trabalhando[0] = null;
					}
				}
				if (trabalhando[1] != null && trabalhando[1].situacao.equals("Em Manutenção")) {
					trabalhando[1].diasTrabalhados++;

					if (trabalhando[1].diaConclusao == dia||trabalhando[1].diaConclusao == dia-1) {
						trabalhando[1].situacao = "Pronto";
						pronto.empilhar(trabalhando[1]);
						B.status = "Livre";
						B.automovelAtual = null;
						trabalhando[1] = null;
					}
				}
				if (!espera.estaVazia()) {
					if (A.status.equals("Livre")) {
						No removido = espera.desenfileirar();
						Automovel carro = removido.auto;
						carro.situacao = "Em Manutenção";
						carro.mecanicoResponsavel = A;
						carro.diaInicio = dia;
						carro.diaConclusao = dia + carro.estimativaDias - 1;
						trabalhando[0] = carro;
						A.status = "Ocupado";
						A.automovelAtual = carro;
					} else {

					}
					if (!espera.estaVazia()&&B.status.equals("Livre")) {
						No removido = espera.desenfileirar();
						Automovel carro = removido.auto;
						carro.situacao = "Em Manutenção";
						carro.mecanicoResponsavel = B;
						carro.diaInicio = dia;
						carro.diaConclusao = dia + carro.estimativaDias - 1;
						trabalhando[1] = carro;
						B.status = "Ocupado";
						B.automovelAtual = carro;
					}
				} else if(A.status.equals("Livre")&&B.status.equals("Livre")) {
					limparTela();
					System.out.println("Sem carro na fila e Mecanicos sem trabalho");
				}
				dia++;
				prosseguir();
				break;
			case 3:
				//Consultar status dos mecanicos
				limparTela();
				System.out.println("=========STATUS DOS FUNCIONARIOS========");
				System.out.println(A.id_nome+" : "+A.status);
				System.out.println(B.id_nome+" : "+B.status);
				prosseguir();
				break;
			case 4:
				//exibir fila de espera
				limparTela();
				System.out.println("=============FILA DE ESPERA=============");
				espera.exibirFila();
				prosseguir();

				break;
			case 5:
				//exibir pilha pronta
				limparTela();
				System.out.println("==============CARROS PRONTOS============");
				pronto.exibirPilha();
				prosseguir();
				break;
			case 6:
				//consultar topo da pilha
				limparTela();
				System.out.println("========= ULTIMO CARRO PRONTO===========");
				if (pronto.estaVazia()) {                          
				System.out.println("Nenhum carro pronto ainda.");
					prosseguir();
					break;
				}
				pronto.topoDaPilha();
				prosseguir();
				break;
			case 7:
				//reabrir ultimo servico
				if (pronto.estaVazia()) {                          
					System.out.println("Não há serviços concluídos para reabrir.");
					prosseguir();
					break;
				}
				limparTela();
				No removido=pronto.desempilhar();
				Automovel carro=removido.auto;
				System.out.println("Digite a descrição do serviço necessário: ");
				carro.descricaoServico=input.nextLine();
				int estimativaDias;
				while (true) {
					System.out.print("Digite a estimativa de dias: ");
					try {
						carro.estimativaDias = Integer.parseInt(input.nextLine());
						if (carro.estimativaDias > 0) {
							break;
						}
						else {
							System.out.println("Erro: o valor deve ser maior que zero.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Erro: digite apenas números inteiros.");
					}
				}
				carro.diasTrabalhados=0;
				carro.mecanicoResponsavel=null;
				carro.diaInicio=0;
				carro.diaConclusao=0;
				carro.situacao="Aguardando";
				espera.enfileirar(carro);

				prosseguir();
				break;
			case 8:
				//sair do programa
				sair=true;
				break;
			default:
				limparTela();
				System.out.println("Opcao invalida");

			}
		}
	}
}
