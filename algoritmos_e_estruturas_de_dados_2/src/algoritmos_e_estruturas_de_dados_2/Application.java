package algoritmos_e_estruturas_de_dados_2;

import java.util.Scanner;

public class Application {
	private static Heap heap = new Heap();
	
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

	    while (input.hasNext()) {
	      String value = input.next();

	      if (value.equals("quit")) {
	    	  break;
	      }
	      
	      if (value.equals("get")) {
	    	  System.out.println(heap.get());
	      }
	      
	      if (value.matches("[0-9]+")) {
	    	  heap.put(Integer.parseInt(value));
	      }

	      heap.print();
	    }
	    
	    input.close();
	}
}
