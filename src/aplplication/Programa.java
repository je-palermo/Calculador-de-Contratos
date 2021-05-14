package aplplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entitis.Departamento;
import entitis.HoraContrato;
import entitis.Trabalhador;
import entitis.enun.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdt = new SimpleDateFormat("DD/MM/YYYY");
		
		System.out.print("Insira o nome do departamento: ");
		Departamento dep = new Departamento(sc.nextLine()) ;
		
		System.out.println("Insira os dados do trabalhador: ");
		
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Nivel: ");
		String nivel = sc.nextLine();
		NivelTrabalhador nivelTrabalhador = NivelTrabalhador.valueOf(nivel);
		
		System.out.print("Base Salarial: ");
		Double salarioBase = sc.nextDouble();
		
		
		Trabalhador trabalhador = new Trabalhador(nome, nivelTrabalhador, salarioBase, dep);
		
		System.out.print("Quantos contratos para esse trabalhador? ");
		int numContratos = sc.nextInt();
		
		for (int i=1; i<numContratos; i++) {
			System.out.println("Insira os dados do contrato nº " + i + " :");
			System.out.print("Date (DD/MM/YYYY): ");
			Date dataContrato = sdt.parse(sc.next());
			System.out.print("Valor por Hora: ");
			Double valorPorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			Integer duracaoPorHora = sc.nextInt();
			
			HoraContrato contrato = new HoraContrato(dataContrato, valorPorHora, duracaoPorHora);
			trabalhador.adicionarContratos(contrato);
			
		}
		
		System.out.println();
		
		System.out.print("Insira o mês e o ano para calcular a renda (MM / AAAA): ");
		String mesEano = sc.next();
		int mes = Integer.parseInt(mesEano.substring(0, 2));
		int ano = Integer.parseInt(mesEano.substring(3));
		
		
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDep().getNome());
		System.out.println("Renda para: " + mesEano + ": " 
		+ String.format("%.2f", trabalhador.renda(ano, mes))); 
	
		sc.close();

	}

}
