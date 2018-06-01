package model;

public class ObjetoRecomendar implements Comparable<ObjetoRecomendar>{
	
	public String Nombre;
	public String Temperatura;
	public String Direccion;
	public String Departamento;
	public String Municipio;
	public String Tipo;
	public Double Valor;
	
	public ObjetoRecomendar(String nombre, double valor) {
		Nombre = nombre;
		Valor = valor;
	}
	public ObjetoRecomendar(String nombre, String temperatura, String direccion, String departamento, String municipio, String tipo, Double valor ) {
		Nombre = nombre;
		Temperatura = temperatura;
		Direccion = direccion;
		Departamento = departamento;
		Municipio = municipio;
		Tipo = tipo;
		Valor = valor;
	}
	
	@Override
	public int compareTo(ObjetoRecomendar o) {
		if(Valor > o.Valor) {
			return -1;
		}
		if(Valor < o.Valor){
			return 1;
		}
		return 0;
	}

}
