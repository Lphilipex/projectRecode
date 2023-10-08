package Agencia;

public class Reservas {
    
    private int idCliente;
    private int idPacote;
    private String nome;
    private String telefone;
    private String preferenciaDeViagem;
    private String observacao;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(int idPacote) {
        this.idPacote = idPacote;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPreferenciaDeViagem() {
        return preferenciaDeViagem;
    }

    public void setPreferenciaDeViagem(String preferenciaDeViagem) {
        this.preferenciaDeViagem = preferenciaDeViagem;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
