public class TesteEstacionamento {
	
	public static void main(String[] args) {
		// cria instancia de estacionamento com 5 vagas disponiveis
		Estacionamento estacionamento= new Estacionamento(5);
		
		Carro uno1 = new Carro("ABC1234");
		estacionamento.estacionar(uno1);
		
		
		Carro gol1 = new Carro("AAA4321");
		estacionamento.estacionar(gol1);
		
		
		tempoDeEspera(2);
		String saida1 = estacionamento.sair("AAA4321");
		System.out.println(saida1);
		

		Carro gol2 = new Carro("ZZZ0001");
		estacionamento.estacionar(gol2);

		
		tempoDeEspera(2);
		String saida2 = estacionamento.sair("ABC1234");
		System.out.println(saida2);
		
		
		tempoDeEspera(5);
		String saida3 = estacionamento.sair("ZZZ0001");
		System.out.println(saida3);

		// 
		String saida4 = estacionamento.sair("ZZZ0009");
		System.out.println(saida4);

		
		// Total recebido ate o momento.
		System.out.println("\nValor total: " + estacionamento.getTotalRecebido());
		
	}
	
	public static void tempoDeEspera(int segundos){
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {

		}
	}
}
