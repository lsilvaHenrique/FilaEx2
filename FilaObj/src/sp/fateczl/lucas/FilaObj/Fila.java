package sp.fateczl.lucas.FilaObj;

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
    
    public void insert(final Object valor) {
        final No elemento = new No();
        elemento.dado = valor;
        elemento.proximo = null;
        if (this.isEmpty()) {
            this.inicio = elemento;
            this.fim = this.inicio;
        }
        else if (this.inicio == this.fim && this.inicio != null) {
            this.fim = elemento;
            this.inicio.proximo = this.fim;
        }
        else {
            this.fim.proximo = elemento;
            this.fim = elemento;
        }
    }
    
    public Object remove() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Fila Vazia !!!");
        }
        final Object valor = this.inicio.dado;
        if (this.inicio == this.fim && this.inicio != null) {
            this.inicio = null;
            this.fim = this.inicio;
        }
        else {
            this.inicio = this.inicio.proximo;
        }
        return valor;
    }
    
    public void list() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Fila Vazia !!!");
        }
        for (No auxiliar = this.inicio; auxiliar != null; auxiliar = auxiliar.proximo) {
            System.out.print(auxiliar.dado + " ");
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
}
