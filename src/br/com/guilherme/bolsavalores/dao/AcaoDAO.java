package br.com.guilherme.bolsavalores.dao;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.guilherme.bolsavalores.model.Acao;

public class AcaoDAO {

	private static final int DATE = 0;
	private static final int OPEN = 1;
	private static final int HIGH = 2;
	private static final int LOW = 3;
	private static final int CLOSE = 4;	
	private static final int VOLUME = 5;
	private static final int ADJCLOSE = 6;
	
	private List<Acao> listaAcao;
	
	public List<Acao> listarAcoes(String symbol, Calendar start, Calendar end){
		
		String query = montarQuery(symbol, start, end);
		URL url;
		URLConnection urlConnection;
		Scanner scanner = null;
		
		try {
			
			url = new URL(query);
			urlConnection = url.openConnection();
			
			scanner = new Scanner(urlConnection.getInputStream());
			
			while(scanner.hasNext()){
				String[] line = scanner.nextLine().split(",");
								
				Calendar date = Calendar.getInstance();
				date.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(line[DATE]));
				
				Double open = Double.parseDouble(line[OPEN]);
				Double high = Double.parseDouble(line[HIGH]);
				Double low = Double.parseDouble(line[LOW]);
				Double close = Double.parseDouble(line[CLOSE]);
				Integer volume = Integer.parseInt(line[VOLUME]);
				Double adjClose = Double.parseDouble(line[ADJCLOSE]);
				
				Acao acao = new Acao();
				acao.setDate(date);
				acao.setOpen(open);
				acao.setHigh(high);
				acao.setLow(low);
				acao.setClose(close);
				acao.setVolume(volume);
				acao.setAdjClose(adjClose);
			}
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			
			scanner.close();
		
		}
		
		return listaAcao;
	}
	
	private String montarQuery(String symbol, Calendar start,
			Calendar end){

		StringBuilder query = new StringBuilder();
		query.append("http://chart.finance.yahoo.com/table.csv?s=" + symbol);
		query.append(".SA&a=" + start.get(Calendar.MONTH));
		query.append("&b=" + start.get(Calendar.DAY_OF_MONTH));
		query.append("&c=" + start.get(Calendar.YEAR));
		query.append("&d=" + end.get(Calendar.MONTH));
		query.append("&e=" + end.get(Calendar.DAY_OF_MONTH));
		query.append("&f=" + end.get(Calendar.YEAR));
		query.append("&g=d");
		query.append("&ignore=.csv");
		
		return query.toString();
	}
	
}
