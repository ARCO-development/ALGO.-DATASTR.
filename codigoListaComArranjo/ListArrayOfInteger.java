/**
 * Classe que implementa uma lista linear usando arranjo.
 * @author Isabel H. Manssour
 */

public class ListArrayOfInteger {

    // Atributos
    private static final int INITIAL_SIZE = 10;
    private Integer[] data;
    private int count;

    /**
     * Construtor da lista.
     */
    public ListArrayOfInteger() {
        this(INITIAL_SIZE);
    }

    /**
     * Construtor da lista.
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListArrayOfInteger(int tam) {
        if (tam <= 0) {
            tam = INITIAL_SIZE;
        }
        data = new Integer[tam];
        count = 0;
    }

    /**
     * Esvazia a lista.
     */
    public void clear() { // O(1)
        data = new Integer[INITIAL_SIZE];
        count = 0;
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() { // O(1)
        return (count == 0);
    }

    /**
     * Retorna o numero de elementos armazenados na lista.
     * @return o numero de elementos da lista
     */
    public int size() { // O(1)
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) { // O(n)
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int get(int index) { // O(1)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }
    
    @Override
    public String toString() { // O(n)
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        s.append("\n");
        return s.toString();
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    ////////////////////////////////////////////
    // PARA FAZER JUNTO COM A PROFESSORA
    ////////////////////////////////////////////
    
    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int set(int index, Integer element) { // O(1)
        return 0;
    }    

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     *
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) { // O(n)
        return true;
    }
    
    /**
     * Procura pelo elemento passado por parametro na lista e retorna true se a 
     * lista contem este elemento.
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */
    public boolean contains(Integer element) { // O(n)
        return false; 
    }
    
    /**
     * Insere um elemento em uma determinada posicao da lista
     *
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) {

    }


    
    
    ////////////////////////////////////////////
    // EXERCICIOS: Implemente os metodos 
    // conforme a documentacao javadoc e
    // indique a notacao O().
    ////////////////////////////////////////////
    
    
    /**
     * Remove o elemento de uma determinada posicao da lista
     *
     * @param index a posição da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int removeByIndex(int index) {
        //Primeiro verifica se o index é válido
        if (index <  0 || index >= size())
            throw new IndexOutOfBoundsException();

            Integer aux = data[index];

        //faz remoção
        for (int j = index; j < count-1; j++) {
            data[j] = data[j+1];
        }
        data[count-1] = null;
        count--;

        return aux;
    }
   
    
    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     *
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(Integer element) {
        // apresente a implementacao
        return -1;
    }

    
    /**
     * Procura pelo elemento passado por parametro na lista e retorna true se a 
     * lista contem este elemento.
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */    
    public boolean containsRecursivo(Integer element) {
        return containsRecursivoAux(element, 0);
    }    
    private boolean containsRecursivoAux(Integer element, int i) {
        if (i >= count)
        return false;
        if (data[i].equals(element))
        return true;

        return containsRecursivoAux(element, i++);
    }

    
    /**
     * Retorna um arranjo que contem os elementos da lista original entre 
     * fromIndex (inclusivo) e toIndex (exclusivo).
     * @param fromIndex posicao a partir da qual os elementos serao inseridos no
     * arranjo a ser retornado
     * @param toIndex indica a posicao final dos elementos que devem ser inseridos
     * @return Um arranjo com um subconjunto dos elementos da lista.
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size)
     * @throws IllegalArgumentException se (fromIndex > toIndex)
     */   
    public Integer[] subList (int fromIndex , int toIndex) {
        if (fromIndex < 0 || toIndex > size())
            throw new IndexOutOfBoundsException();
        if (fromIndex > toIndex)
            throw new IllegalArgumentException();

        //Instancia o array que será retornado
        Integer[] a = new Integer[toIndex - fromIndex];
        
        for (int i = fromIndex, j = 0; i < toIndex; i++, j++)
        {
            a[j] = data[i];
        }

        return a;
    }
    //notacao O n\2 
    public void reverse() {
        int j = size() - 1;
        int size;
        if (size() % 2 == 0) {
            size = (size()/2);
        } else 
        {
            size = (size()/2) + 1;
        }

        for (int i = 0; i < size; i++)
        {
            Integer aux = data[i];
            data[i] = data[j];
            data[j] = aux;
            j--;
        }

    }
    //notacao O n (linear)
     public int countOcurrencies(int element) {
        int count = 0;
        for (int i = 0; i < size(); i++)
        {
            if (element == (data[i]))
            {
                count++;
            }
        }
        return count;
    }
    
}
//  [5, 4, 3, 2, 1]
//  [1]
//  [4, 3, 2, 1]
//  [1, 2]
//  [1, 2, 3, 4, 5, 6]