package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingThread extends Thread {
	private String servidor;

	public PingThread(String servidor) {
		this.servidor = servidor;
	}

	@Override
	public void run() {
		try {
			Process processo = Runtime.getRuntime().exec("ping -4 -c 10 " + servidor);
			BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
			String linha;

			long totalTempoPing = 0;
			int numPings = 0;

			while ((linha = leitor.readLine()) != null) {
				if (linha.contains("time=")) {
					int indiceIni = linha.indexOf("time=") + 5;
					int indiceFim = linha.indexOf(" ms", indiceIni);
					String tempPingStr = linha.substring(indiceIni, indiceFim);
					long tempPing = Long.parseLong(tempPingStr);
					totalTempoPing += tempPing;
					numPings++;
					System.out.println(servidor + ": Iteração " + numPings + ": " + tempPing + " ms");
				}
			}

			leitor.close();
			processo.waitFor();

			if (numPings > 0) {
				System.out.println(servidor + ": Tempo médio de ping: " + (totalTempoPing / numPings) + " ms");
			} else {
				System.out.println(servidor + ": Ping Descartado - Sistema Operacional nao compativel");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}