package Agencia;

import java.math.BigDecimal;
import java.sql.Date;


public class Pacote {
	
	private int idPacote;
	
	private Date dataDePartida;
	
	private Date dataDeRetorno;
	
	private BigDecimal precototal;

	public int getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(int idPacote) {
		this.idPacote = idPacote;
	}

	public Date getDataDePartida() {
		return dataDePartida;
	}

	public void setDataDePartida(Date dataDePartida) {
		this.dataDePartida = dataDePartida;
	}

	public Date getDataDeRetorno() {
		return dataDeRetorno;
	}

	public void setDataDeRetorno(Date dataDeRetorno) {
		this.dataDeRetorno = dataDeRetorno;
	}

	public BigDecimal getPrecototal() {
		return precototal;
	}

	public void setPrecototal(BigDecimal precototal) {
		this.precototal = precototal;
	}


}
