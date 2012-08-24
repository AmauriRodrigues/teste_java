import java.util.Date;

public class Estacionamento {
	private Vaga vagas[];
	private double valorHora;
	private double valorRecebidoTotal;
	
	public Estacionamento(int vagasDisponivel){
		this.iniciaVagas(vagasDisponivel);
		this.valorHora = 5;
	}
	
	
	private void iniciaVagas(int vagasDisponivel){
		this.vagas = new Vaga[vagasDisponivel];
		
		for (int i = 0; i < vagasDisponivel; i++){
			this.vagas[i] = new Vaga();
		}
	}

	
	public void estacionar(Carro carro) {
		Vaga vaga = this.proximaVagaLivre();
		
		vaga.ocupar(carro);
	}
	
	
	public String sair(String placa){
		String informacaoSaida = "";
		
		double valorTotal = 0;
		Vaga vaga = this.procurarVagaComCarro(placa);
		
		if (vaga != null){
			// calcula valor do periodo estacionado
			valorTotal = vaga.getValorTotal(this.valorHora);
			
			// recebe o valor pago
			this.recebePagamento(valorTotal);
			
			// 
			informacaoSaida = vaga.toString() + "\nData Saida: " + new Date() + "\nValor Total: " + valorTotal + "\n";
			
			// sai da vaga
			vaga.desocupar();
		}
		else{
			informacaoSaida = "Carro não encontrado: " + placa;
		}
		
		return informacaoSaida;
	}
	
	
	private Vaga procurarVagaComCarro(String placa) {
		Vaga vaga = null;
		Carro carro = new Carro(placa);
		
		for (int i = 0; i < this.vagas.length; i++){
			if (this.vagas[i].isCarroEstacionado(carro)){
				vaga = this.vagas[i];
			}
		}
		
		return vaga;
	}


	public Vaga proximaVagaLivre(){
		Vaga vaga = null;
		for (int i = 0; i < this.vagas.length; i++) {
			if (this.vagas[i].estaOcupada() == false){
				vaga = vagas[i];
				break;
			}
		}
		
		return vaga;
	}
	
	
	public void recebePagamento(double valor){
		this.valorRecebidoTotal = this.valorRecebidoTotal + valor;
	}
	
	
	public double getTotalRecebido(){
		return this.valorRecebidoTotal;
	}
}
