package model.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer Nquarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer nquarto, Date entrada, Date saida) {
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
	
	public String atualizar(Date entrada, Date saida) {
		Date agora = new Date();
		if(entrada.before(agora) || saida.before(agora)) {
			return "erro a atualização é somente para datas futuras";
		}if(!saida.after(entrada)) {
			return "DATA INVALIDA";
		}
		this.entrada = entrada;
		this.saida = saida;
		return null;
	}

	@Override
	public String toString() {
		return "Reserva "
				+ "quarto: " + Nquarto + " "
				+ "entrada: " + sdf.format(entrada) + " "
				+ "saida: " +  sdf.format(saida) + " "
				+ "duração: " + duracao() + " dias";
	}
	
	
	
	
}
