package entitis;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entitis.enun.NivelTrabalhador;

public class Trabalhador {
	
	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;
	
	private Departamento dep;
	// Tem muitos Contratos (UML)
	private List<HoraContrato> horaContrato = new ArrayList<>();
	

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento dep) {
		
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.dep = dep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Departamento getDep() {
		return dep;
	}

	public void setDep(Departamento dep) {
		this.dep = dep;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}
	
	public List<HoraContrato> getHoraContrato() {
		return horaContrato;
	}
	
	public void adicionarContratos(HoraContrato horaContrato) {
		this.horaContrato.add(horaContrato);
	}
	
	public void removerrContratos(HoraContrato horaContrato) {
		this.horaContrato.remove(horaContrato);
	}
	
	public double renda(int ano, int mes) {
		double sum = salarioBase;
		Calendar cal = Calendar.getInstance();
		for(HoraContrato c : horaContrato) {
			cal.setTime(c.getDate());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				sum += c.valorTotal();
			}
		}
		return sum;
	}
	
}
