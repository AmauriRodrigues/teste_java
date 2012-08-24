public class Carro {
	private String placa;
	
	public Carro(String placaNumero){
		this.placa = placaNumero;
	}
	
	
	public String getPlaca(){
		return this.placa;
	}
	
	
	public String toString(){
		return "Carro placa: " + this.placa;
	}
	
}

