import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		while(sc.hasNext()) {
			int n = Integer.parseInt(sc.nextLine());
			
			HashMap<Integer, Integer[]> botas = new HashMap<Integer, Integer[]>();
			
			for(int i =0;i<n; i++) {
				String[] in = sc.nextLine().split(" ");
				int size = Integer.parseInt(in[0]);
				int pe = get_foot(in[1]);

				if(!botas.containsKey(size)) {
					Integer[] vect = new Integer[2];
					vect[0] = 0;
					vect[1] = 0;
					vect[pe]+=1;
					botas.put(size, vect);
				}
				else {
					Integer [] vect = botas.get(size);
					vect[pe]+=1;
					botas.put(size, vect);
				}
				
			}
			int resp = 0;
			
			for(int k:botas.keySet()) {
				Integer[] vectt = botas.get(k);
				resp += Math.min(vectt[0], vectt[1]);
			}
			System.out.println(resp);
			
			
			
		}

	}
	
	public static int get_foot(String s) {
		if(s.equals("D")) {
			return 1;
		}
		else { return 0;}
		
	}

}