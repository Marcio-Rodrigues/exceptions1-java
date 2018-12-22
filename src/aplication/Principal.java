package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;

public class Principal {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.print("NUMERO DO QUARTO: ");
		int nquarto = sc.nextInt();
		
		System.out.print("DATA DE ENTRADA(dd/MM/yyyy): ");
		Date entrada = sdf.parse(sc.next());
		
		System.out.print("DATA DE SAIDA(dd/MM/yyyy): ");
		Date saida = sdf.parse(sc.next());
		
		if(!saida.after(entrada)) {
			System.out.println("DATA INVALIDA");
		}else {
			
			Reserva reserva = new Reserva(nquarto, entrada, saida);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("ATUALISE SUA RESERVA");
			
			System.out.print("DATA DE ENTRADA(dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			
			System.out.print("DATA DE SAIDA(dd/MM/yyyy): ");
			saida = sdf.parse(sc.next());
			
			Date agora = new Date();
			if(entrada.before(agora) || saida.before(agora)) {
				System.out.println("erro a atualização é somente para datas futuras");
			}else if(!saida.after(entrada)) {
				System.out.println("DATA INVALIDA");
			}else{
			reserva.atualizar(entrada, saida);
			System.out.println(reserva);
			}
		}
		
		
		sc.close();
	}

}
