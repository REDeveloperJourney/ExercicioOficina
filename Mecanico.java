public class Mecanico {
    // Atributo
    String id_nome;
    String status; // Livre / Ocupado
    Automovel automovelAtual;
    
    // Construtor
    Mecanico(String id_nome, String status, Automovel automovelAtual){
        this.id_nome=id_nome;
        this.status=status;
        this.automovelAtual=automovelAtual;
    }
}