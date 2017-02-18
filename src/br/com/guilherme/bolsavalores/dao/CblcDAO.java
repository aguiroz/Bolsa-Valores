package br.com.guilherme.bolsavalores.dao;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Scanner;
import br.com.guilherme.bolsavalores.model.Cblc;

public class CblcDAO {

	Cblc cblc;
	
	public CblcDAO(){
		cblc = new Cblc();
	}
	
	public Cblc getCblc(String symbol){
		String header;
		String linha;
		URL url;
		URLConnection urlConnection;
		Scanner scanner = null;
		
		try{
			url = new URL("http://www.cblc.com.br/cblc/consultas/Arquivos/DBTCER9999.txt");
			urlConnection = url.openConnection();
			scanner = new Scanner(urlConnection.getInputStream());
			
			header = scanner.nextLine();
			linha = scanner.nextLine();

			while(!linha.substring(2, 22).contains(symbol) && scanner.hasNext()){
				linha = scanner.nextLine();
			}
			
			Calendar data = Calendar.getInstance();			
			data.set(Calendar.YEAR, Integer.parseInt(header.substring(32, 36)));
			data.set(Calendar.MONTH, Integer.parseInt(header.substring(36, 38)) - 1);
			data.set(Calendar.DATE, Integer.parseInt(header.substring(38, 40)));
			int numeroContratos = Integer.parseInt(linha.substring(52, 62));
			int qtdAcoes = Integer.parseInt(linha.substring(63, 73));
			double valor = Double.parseDouble(linha.substring(73, 93));
			double doador = Double.parseDouble(linha.substring(73, 93)) / 100;
			double tomador = Double.parseDouble(linha.substring(121, 128)) / 100;
			
			cblc.setData(data);
			cblc.setNumeroContratos(numeroContratos);
			cblc.setQtdAcoes(qtdAcoes);
			cblc.setValor(valor);
			cblc.setDoador(doador);
			cblc.setTomador(tomador);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			scanner.close();
		}
		return cblc;
	}
}
