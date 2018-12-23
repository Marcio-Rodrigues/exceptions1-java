package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;
import model.exceptions.DomainException;

public class Principal {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		try {
		System.out.print("NUMERO DO QUARTO: ");
		int nquarto = sc.nextInt();

		System.out.print("DATA DE ENTRADA(dd/MM/yyyy): ");
		Date entrada = sdf.parse(sc.next());

		System.out.print("DATA DE SAIDA(dd/MM/yyyy): ");
		Date saida = sdf.parse(sc.next());

		Reserva reserva = new Reserva(nquarto, entrada, saida);
		System.out.println(reserva);

		System.out.println();
		System.out.println("ATUALISE SUA RESERVA");

		System.out.print("DATA DE ENTRADA(dd/MM/yyyy): ");
		entrada = sdf.parse(sc.next());

		System.out.print("DATA DE SAIDA(dd/MM/yyyy): ");
		saida = sdf.parse(sc.next());
		
		reserva.atualizar(entrada, saida);
		System.out.println(reserva);
		}
		catch(ParseException eMarcio){
			System.out.println("formato de data invalida");
		}
		catch(DomainException eMarcio){
			System.out.println("Erro na reserva: "+ eMarcio.getMessage());
		}
		catch(RuntimeException eMarcio) {
			System.out.println("Erro inesperado");
		}
		sc.close();
	}

}
