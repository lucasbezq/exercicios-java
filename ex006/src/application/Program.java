package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Map<String, Integer> votos = new HashMap<>();

		System.out.print("Enter the file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String candidato = fields[0];
				int qntdVotos = Integer.parseInt(fields[1]);

				if (votos.containsKey(candidato)) {
					int totalVotos = votos.get(candidato);
					votos.put(candidato, qntdVotos + totalVotos);
				} else {
					votos.put(candidato, qntdVotos);
				}
				line = br.readLine();
			}
			for (String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));
			}
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		sc.close();
	}
}
