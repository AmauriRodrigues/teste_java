public class OlaMundo{
	public static void main(String Args[]){
		OlaMundo olaMundo = new OlaMundo();
		olaMundo.falar("Ola Mundo, eu tenho metodo....");
                  olaMundo.falar("Esta linha nao existia....");
	}
	
	public void falar(String frase){
		System.out.println(frase);
	}
}