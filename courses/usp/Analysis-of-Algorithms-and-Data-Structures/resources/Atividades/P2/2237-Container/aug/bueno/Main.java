import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


class Node{
	Integer [] container;
	int custo; 
	String hash;
	
	public Node(Integer[] container, int custo) {
		super();
		this.container = container;
		this.custo = custo;
		this.hash = generate_hash();
	}
	
	public String generate_hash() {
		String s= "";
		for(int i = 0 ; i< 8; i++) {
			s = s+ "/ "+ this.container[i];
		}
		return s;
	}
	public int getCusto() {
        return custo;
    }
	
}


public class Main {
	
	
		
	public static Integer [] trocar(Integer [] m, int a, int b) {
		Integer [] novo = new Integer[m.length];
		System.arraycopy(m, 0, novo, 0, m.length);
		
		int aux = m[a];
		novo[a] = m[b];
		novo[b] = aux;
		return novo;
		
	}

	
	public static void tentarTrocar(Node n, int a, int b, PriorityQueue<Node> p, Set<String> s) {
		
		int custo = n.container[a]+ n.container[b] + n.custo;
		Node clone = new Node(trocar(n.container, a, b), custo);
		if(!s.contains(clone.hash)) {
			p.add(clone);
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Integer [] start = new Integer [8];
		Integer [] finish = new Integer [8];
		
		for(int i = 0 ; i < 8; i++) {
			start[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < 8; i++) {
			finish[i] = sc.nextInt();
		}
		
		Node s = new Node(start, 0);
		PriorityQueue<Node> queue = new PriorityQueue<>(5, (a, b) -> a.getCusto() - b.getCusto());
		queue.add(s);
		Set<String> visited = new TreeSet<String>();
		
		Node f = new Node(finish, 0);
		String final_hash = f.hash;
		
		while(!queue.isEmpty()) {
			Node atual = queue.poll();
			
			String h = atual.hash;
			if(visited.contains(h)) continue;
			
			if(h.equals(final_hash)) {
				System.out.println(atual.custo);
			}
			visited.add(h);
			
			tentarTrocar(atual, 0, 1, queue, visited);
	        tentarTrocar(atual, 1, 2, queue, visited);
	        tentarTrocar(atual, 2, 3, queue, visited);

	        tentarTrocar(atual, 4, 5, queue, visited);
	        tentarTrocar(atual, 5, 6, queue, visited);
	        tentarTrocar(atual, 6, 7, queue, visited);

	        tentarTrocar(atual, 0, 4, queue, visited);
	        tentarTrocar(atual, 1, 5, queue, visited);
	        tentarTrocar(atual, 2, 6, queue, visited);
	        tentarTrocar(atual, 3, 7, queue, visited);
			
		}
		
	}
}