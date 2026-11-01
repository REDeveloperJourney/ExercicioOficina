public class Pilha {
    
    No topo;
    
    public Pilha() {
        topo = null;    
    }
    
    // verifica se pilha esta vazia
    public boolean estaVazia() {
       return topo == null;
    }
    
    // incluir no topo da pilha
    public void empilhar(Automovel auto) {
		No novo = new No(auto);
		novo.proximo = topo;
		topo = novo;      
    }
    
    // retirar do topo da pilha
    public No desempilhar() {
		if (estaVazia()) {
			System.out.println("Pilha Vazia!");
			return null;
		}
		No removido = topo;
		topo = topo.proximo;
		return removido;    }
    
    // exibe itens da pilha
    public void exibirPilha() {
		if (estaVazia()) {
			System.out.println("Pilha Vazia!");
			return;
		}
		No atual = topo;
		while (atual != null) {
        System.out.println("Placa: " + atual.auto.placa);
        System.out.println("Modelo: " + atual.auto.modelo);
        System.out.println("Proprietário: " + atual.auto.proprietario);
        System.out.println("Serviço: " + atual.auto.descricaoServico);
        System.out.println("Inicio do trabalho: " + atual.auto.diaInicio);
        System.out.println("Conclusao do trabalho: " + atual.auto.diaConclusao);
        System.out.println("Estimativa: " + atual.auto.estimativaDias + " dias");
        System.out.println("Situação: " + atual.auto.situacao);
        System.out.println("------------------------------");
        atual = atual.proximo;
    }
    }
    
    // mostra item do topo
    public No topoDaPilha(){
        if (estaVazia()) {
			System.out.println("Pilha Vazia!");
			return null;
		}
	System.out.println("Placa: " + topo.auto.placa);
        System.out.println("Modelo: " + topo.auto.modelo);
        System.out.println("Proprietário: " + topo.auto.proprietario);
        System.out.println("Serviço: " + topo.auto.descricaoServico);
        System.out.println("Inicio do trabalho: " + topo.auto.diaInicio);
        System.out.println("Conclusao do trabalho: " + topo.auto.diaConclusao);
        System.out.println("Estimativa: " + topo.auto.estimativaDias + " dias");
        System.out.println("Situação: " + topo.auto.situacao);
        System.out.println("------------------------------");
		return topo; 
    }
}