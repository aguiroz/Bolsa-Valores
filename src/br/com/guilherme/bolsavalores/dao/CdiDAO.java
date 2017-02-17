package br.com.guilherme.bolsavalores.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.guilherme.bolsavalores.model.Cdi;

public class CdiDAO {

	private Calendar start;
	private Calendar end;
	
	private List<Cdi> listaCdi;
	
	public CdiDAO(){
		
		start = Calendar.getInstance();
		end = Calendar.getInstance();
		
		start.set(2012, 7, 21);
		
		if(end.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
			end.add(Calendar.DATE, -1);
		} else if(end.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
			end.add(Calendar.DATE, -2);
		}	
	}
	
	public void baixarCdi(){
		URL url;
		URLConnection urlConnection;
		Scanner scanner = null;
		
		File file;
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		
		String urlCdi = "ftp://ftp.cetip.com.br/IndiceDI/";
		String pathFile = "arquivos/";
		
		while(start.getTimeInMillis() != end.getTimeInMillis()){
			
			String dataArquivo = String.valueOf(new SimpleDateFormat("yyyy/MM/dd").format(start.getTime()) + ".txt");
			file = new File(pathFile + dataArquivo);
			
			if(!file.exists()){
				try {				
					url = new URL(urlCdi + dataArquivo);
					urlConnection = url.openConnection();
					scanner = new Scanner(urlConnection.getInputStream());
					if(scanner.hasNext()){
						fileWriter = new FileWriter(file);
						printWriter = new PrintWriter(fileWriter);
						printWriter.print(scanner.nextLine());
						
						printWriter.close();
						fileWriter.close();
						scanner.close();	
					}
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			start.add(Calendar.DATE, 1);
		}
	}
	
	public List<Cdi> getCdi(Calendar start, Calendar end){
		
		if(start.getTimeInMillis() < this.start.getTimeInMillis())
			return null;
			
		File file;
		FileReader fileReader;
		BufferedReader bufferedReader;
		
		String pathFile = "arquivos/";
		
		while(start.getTimeInMillis() != end.getTimeInMillis()){
			String dataArquivo = String.valueOf(new SimpleDateFormat("yyyy/MM/dd").format(start.getTime()));
			file = new File(pathFile + dataArquivo + ".txt");
			
			if(file.exists()){
				try {
					fileReader = new FileReader(file);
					bufferedReader = new BufferedReader(fileReader);
					
					Cdi cdi = new Cdi();
					cdi.setData(start);
					cdi.setValor(Double.parseDouble(bufferedReader.readLine()));
					listaCdi.add(cdi);
					
					bufferedReader.close();
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return listaCdi;
	}
}
