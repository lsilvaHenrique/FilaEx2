package sp.fateczl.lucas.FilaInt;

public class Fila
{
    No inicio;
    No fim;
    
    public Fila() {
        this.inicio = null;
        this.fim = null;
    }
    
    public boolean isEmpty() {
        return this.inicio == null && this.fim == null;
    }
    
    public void insert(final int valor) {
        final No elemento = new No();
        elemento.dado = valor;
        if (this.inicio == null) {
            this.inicio = elemento;
            this.fim = elemento;
            elemento.proximo = null;
        }
        else if (this.inicio == this.fim && this.inicio != null) {
            this.fim = elemento;
            this.inicio.proximo = this.fim;
            this.fim.proximo = null;
        }
        else {
            this.fim.proximo = elemento;
            elemento.proximo = null;
            this.fim = elemento;
        }
    }
    
    public int remove() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("N\u00e3o h\u00e1 elementos na fila");
        }
        final No auxiliar = this.inicio;
        if (this.inicio == this.fim && this.inicio != null) {
            this.inicio = null;
            this.fim = null;
        }
        else {
            this.inicio = this.inicio.proximo;
        }
        return auxiliar.dado;
    }
    
    public void list() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("N\u00e3o h\u00e1 elementos na fila");
        }
        for (No auxiliar = this.inicio; auxiliar != null; auxiliar = auxiliar.proximo) {
            System.out.println(auxiliar.dado);
        }
    }
    
    public int size() {
        int cont = 0;
        if (!this.isEmpty()) {
            for (No auxiliar = this.inicio; auxiliar != null; auxiliar = auxiliar.proximo) {
                ++cont;
            }
        }
        return cont;
    }
    
    public int get(final int posicao) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Fila Vazia");
        }
        if (posicao < 0) {
            throw new Exception("Posi\u00e7\u00e3o inexistente");
        }
        final int tamanho = this.size();
        if (posicao > tamanho - 1) {
            throw new Exception("Posi\u00e7\u00e3o inexistente na fila");
        }
        int cont = 0;
        No auxiliar = this.inicio;
        while (cont < posicao) {
            auxiliar = auxiliar.proximo;
            ++cont;
        }
        return auxiliar.dado;
    }
}
