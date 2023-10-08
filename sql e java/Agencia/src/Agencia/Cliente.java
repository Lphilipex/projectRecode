package Agencia; 

public class Cliente {
    private int idCliente;
    private String nome;
    private String telefone;
    private String preferenciaDeViagem;
    private String observacoes;

   
    public Cliente() {
    }

 
    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getPreferenciaDeViagem() {
        return preferenciaDeViagem;
    }

    public String getObservacoes() {
        return observacoes;
    }

    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPreferenciaDeViagem(String preferenciaDeViagem) {
        this.preferenciaDeViagem = preferenciaDeViagem;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
