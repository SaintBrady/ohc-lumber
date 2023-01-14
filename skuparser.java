import java.io.*;
import java.util.*;

public class skuparser {
	
	public static void main(String[] args) throws Exception {

		File file = new File("input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		PrintWriter out = new PrintWriter("output.txt");

		String st, sku, price;
		boolean readingSkus = false;
		Map<String, String> map = new HashMap<String, String>();

		while((st = br.readLine()) != null) {

			if(st.equals(" ")) readingSkus = false;

			if(readingSkus == false) {

				if(st.startsWith("---")) {

					st = br.readLine();
					st = br.readLine();
					readingSkus = true;

					int endSpace = st.length() - 10;
					while(true) {
						if(st.charAt(endSpace) == ' ') endSpace++;
						else break;
					}

					sku = st.substring(2, st.indexOf(" ", 2));
					price = st.substring(endSpace, st.length());
					out.println(sku + " " + price);
				}
			}
			else {
				int endSpace = st.length() - 10;
				while(true) {
					if(st.charAt(endSpace) == ' ') endSpace++;
					else break;
				}

				sku = st.substring(2, st.indexOf(" ", 2));
				price = st.substring(endSpace, st.length());
				out.println(sku + " " + price);
			}
		}
		out.close();
	}
}