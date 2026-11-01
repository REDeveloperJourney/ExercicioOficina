public class Automovel {
    // Atributos
    String placa;
    String modelo;
    String proprietario;
    String descricaoServico;
    int estimativaDias;
    int diasTrabalhados;
    int diaInicio;
    int diaConclusao;
    Mecanico mecanicoResponsavel;
    String situacao;   // Aguardando / Em Manutenção / Concluído
    
    // Construtor
    Automovel (String placa, String modelo, String proprietario,
                 String descricaoServico, int estimativaDias,
                 int diasTrabalhados, int diaInicio, int diaConclusao,
                 Mecanico mecanicoResponsavel, String situacao){
        this.placa=placa;
        this.modelo=modelo;
        this.proprietario=proprietario;
        this.descricaoServico=descricaoServico;
        this.estimativaDias=estimativaDias;
        this.diasTrabalhados=diasTrabalhados;
        this.diaInicio=diaInicio;
        this.diaConclusao=diaConclusao;
        this.mecanicoResponsavel=mecanicoResponsavel;
        this.situacao=situacao;
    }
    
}