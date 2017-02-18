package br.com.guilherme.bolsavalores.controller;

import java.util.Calendar;
import java.util.List;
import br.com.guilherme.bolsavalores.dao.CdiDAO;
import br.com.guilherme.bolsavalores.model.Cdi;

public class CdiController {

	private CdiDAO cdiDao;
	private List<Cdi> listaCdi;
	
	public CdiController(){
		cdiDao = new CdiDAO();
	}
	
	public double[] getPercentualCdi(Calendar start, Calendar end){
		
		listaCdi = cdiDao.getCdi(start, end);
		
		double[] percentual = new double[listaCdi.size()];
		percentual[0] = 100;
		
		for(int i = 1; i < listaCdi.size(); i++){
			percentual[i] = listaCdi.get(i).getValor() / listaCdi.get(0).getValor();
		}
		
		return percentual;
	}
	
	public void atualizarCdi(){
		cdiDao.baixarCdi();
	}
}

