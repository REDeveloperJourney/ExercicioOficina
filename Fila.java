public class Fila {

	No inicio;

	public Fila() {
		inicio = null;
	}
    // confere se a lista esta vazia
	public boolean estaVazia() {
		return inicio == null;
	}

	// incluir no final da fila
	public void enfileirar(Automovel auto) {
	    No novo = new No(auto);
		if (estaVazia()) {
			inicio = novo;
			return;
		}
		No atual = inicio;
		while (atual.proximo != null) {
			atual = atual.proximo;
		}
		atual.proximo = novo;
	}

	// retirar do inicio da fila
	public No desenfileirar() {
		if (estaVazia()) {
			System.out.println("Fila Vazia!");
			return null;
		}
		No removido = inicio;
		inicio = inicio.proximo;
		return removido;
	}
   
    // exibe os carros na fila
	public void exibirFila() {
		if (estaVazia()) {
			System.out.println("Fila Vazia!");
		}
		No atual = inicio;
		while (atual != null) {
	    System.out.println("Placa: " + atual.auto.placa);
        System.out.println("Modelo: " + atual.auto.modelo);
        System.out.println("Proprietário: " + atual.auto.proprietario);
        System.out.println("Serviço: " + atual.auto.descricaoServico);
        System.out.println("Estimativa: " + atual.auto.estimativaDias + " dias");
        System.out.println("Inicio do trabalho: " + atual.auto.diaInicio);
        System.out.println("Conclusao do trabalho: " + atual.auto.diaConclusao);
        System.out.println("Situação: " + atual.auto.situacao);
        System.out.println("------------------------------");
        atual = atual.proximo;
    }
	}
	
	// mostra o primeiro carro da Fila
	public No primeiro(){
	    if (estaVazia()) {
			System.out.println("Fila Vazia!");
			return null;
		}
		return inicio;
	}
}