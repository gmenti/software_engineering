package algoritmos_e_estruturas_de_dados_2;

public class Heap {
	private static final int INITIAL_SIZE = 1;
	private int vetor[];
	private int size;
	
	public Heap() {
		this.size = INITIAL_SIZE;
		this.vetor = new int[100];
		this.vetor[INITIAL_SIZE] = 0;
	}
	
	private int left(int index) {
		return 2 * index;
	}
	
	private int right(int index) {
		return 2 * index + 1;
	}
	
	private int parent(int index) {
		return index / 2;
	}
	
	private void swim(int elementIndex) {
		if (elementIndex <= INITIAL_SIZE) {
			return;
		}
		
		int parentIndex = this.parent(elementIndex);
		int parent = this.vetor[parentIndex];
		int element = this.vetor[elementIndex];
		
		if (parent < element) {
			return;
		}
		
		this.vetor[elementIndex] = parent;
		this.vetor[parentIndex] = element;
		
		this.swim(parentIndex);
	}
	
	private void sink(int elementIndex) {
		int leftIndex = this.left(elementIndex);
		
		if (leftIndex > this.size) {
			return;
		}
		
		int rightIndex = this.left(elementIndex);
		int bestIndex = leftIndex;
		
		if (leftIndex < this.size && this.vetor[leftIndex] < this.vetor[rightIndex]) {
			bestIndex = rightIndex;
		}
		
		int element = this.vetor[elementIndex];
		
		if (element >= this.vetor[bestIndex]) {
			return;
		}
		
		this.vetor[elementIndex] = this.vetor[bestIndex];
		this.vetor[bestIndex] = element;
		
		this.sink(bestIndex);
	}
	
	public void put(int element) {
		this.vetor[this.size] = element;
		this.swim(this.size);
		this.size++;
	}
	
	public int get() {
		if (this.size == INITIAL_SIZE) {
			throw new UnsupportedOperationException("Heap vazio!");
		}
		
		int result = this.vetor[INITIAL_SIZE];
		this.vetor[INITIAL_SIZE] = this.vetor[--this.size];
		this.sink(INITIAL_SIZE);
		
		return result;
	}
	
	private void print( int b, int elem, int sp )  {
	    int i, j;
	
	    System.out.println( "" );
	    for( j = 0; j < size; j++ ) System.out.print( vetor[j] + " " );
	    System.out.println( "" );
	
	    while ( true ) {
	      for( j = 0; j <= sp / 2; j++ ) System.out.print( " " );
	      for( i = b; i < b + elem; i++ ) {
	        if ( i == size ) return;
	        System.out.print( vetor[i] );
	        for( j = 0; j < sp; j++ ) System.out.print( " " );
	      }
	      System.out.println( "" );
	      b = b + elem;
	      elem = 2 * elem;
	      sp = sp / 2;
	    }
	}

	public void print( )  {
		System.out.println( "" );
		print( 1, 1, 32 );
		System.out.println( "" );
	}
}
