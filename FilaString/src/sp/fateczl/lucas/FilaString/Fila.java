package sp.fateczl.lucas.FilaString;

public class Fila {
	
	No inicio;
	No fim;
	
	public Fila() {
		inicio = null;
		fim = null;
	}
	
	public boolean isEmpty() {
		if (inicio == null && fim == null)
			return true;
		else
			return false;
	}
	
	public void insert(String valor) {
		No elemento = new No();
		elemento.dado = valor;
		
		if (inicio == null) {
			inicio = elemento;
			fim = elemento;
			elemento.proximo = null;
		} else if(inicio == fim && inicio != null) {
			fim = elemento;
			inicio.proximo = fim;
			fim.proximo = null;
		} else {
			fim.proximo = elemento;
			elemento.proximo = null;
			fim = elemento;
		}
	}
	
	public String remove() throws Exception {
		if (isEmpty())
			throw new Exception("Não há elementos na fila");
		
		No auxiliar = inicio;
		if (inicio == fim && inicio != null) {
			inicio = null;
			fim = null;
		} else
			inicio = inicio.proximo;
		
		return auxiliar.dado;
	}
	
	public void list() throws Exception {
		if (isEmpty())
			throw new Exception("Não há elementos na fila");
		
		No auxiliar = inicio;
		while(auxiliar != null) {
			System.out.println(auxiliar.dado);
			auxiliar = auxiliar.proximo;
		}
	}
	
	public int size() {
		int cont = 0;
		if (!isEmpty()) {
			No auxiliar = inicio;
			while(auxiliar != null) {
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		
		return cont;
	}
	
	public String get(int posicao) throws Exception {
		if (isEmpty())
			throw new Exception("Fila Vazia");		
		if (posicao < 0)
			throw new Exception("Posição inexistente");
		
		int tamanho = size();
		if (posicao > tamanho - 1)
			throw new Exception("Posição inexistente na fila");
		
		int cont = 0;
		No auxiliar = inicio;
		while(cont < posicao) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		
		return auxiliar.dado;
	}
	
}
