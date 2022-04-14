import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
//		T = fs.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int k = fs.nextInt();
			char[] s = fs.next().toCharArray();
			int[] counter = new int[26];
			Arrays.fill(counter, 0);
			for(int i = 0; i < s.length; i++) {
				counter[s[i]-'a']++;
			}
			boolean valid = true;
			for(int i = 0; i < 26; i++) {
				if(counter[i] % k != 0) {
					valid = false;
					break;
				}
			}
			if(!valid) {
				out.println(-1);
				break;
			}
			String word = "";
			for(int i = 0; i < 26; i++) {
				if(counter[i] > 0) {
					String temp = repeatString(String.valueOf((char) (i + 'a')), counter[i] / k);
					word += temp;
				}
			}
			out.println(repeatString(word, k));
		}
		out.close();
	}
	
	static String repeatString(String word, int repeatNum) {
		String res = "";
		for(int i = 0; i < repeatNum; i++) {
			res += word;
		}
		return res;
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for(int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
		
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
