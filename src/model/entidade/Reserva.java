package model.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	private Integer Nquarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer nquarto, Date entrada, Date saida) throws DomainException {
	if(!saida.after(entrada)) {
		throw new DomainException("DATA INVALIDA");
	}
		Nquarto = nquarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNquarto() {
		return Nquarto;
	}

	public void setNquarto(Integer nquarto) {
		Nquarto = nquarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public long duracao() {
		long dias = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(dias, TimeUnit.MILLISECONDS);
	}
	
	public void atualizar(Date entrada, Date saida) throws DomainException{
		Date agora = new Date();
		if(entrada.before(agora) || saida.before(agora)) {
			throw new DomainException("erro a atualiza��o � somente para datas futuras");
		}if(!saida.after(entrada)) {
			throw new DomainException("DATA INVALIDA");
		}
		this.entrada = entrada;
		this.saida = saida;
	}

	@Override
	public String toString() {
		return "Reserva "
				+ "quarto: " + Nquarto + " "
				+ "entrada: " + sdf.format(entrada) + " "
				+ "saida: " +  sdf.format(saida) + " "
				+ "dura��o: " + duracao() + " dias";
	}
	
	
	
	
}
