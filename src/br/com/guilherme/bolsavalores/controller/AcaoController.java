package br.com.guilherme.bolsavalores.controller;

import java.util.Calendar;
import java.util.List;

import br.com.guilherme.bolsavalores.dao.AcaoDAO;
import br.com.guilherme.bolsavalores.model.Acao;

public class AcaoController {

	private AcaoDAO acaoDao;
	private List<Acao> listaAcao;
	
	public AcaoController(){
		acaoDao = new AcaoDAO();
	}
	
	public double[] getPercentualAcao(String symbol, Calendar start, Calendar end){
		
		listaAcao = acaoDao.listarAcao(symbol, start, end);

		double[] percentual = new double[listaAcao.size()];
		percentual[0] = 100;
		
		for(int i = 1; i < listaAcao.size(); i++){
			percentual[i] = listaAcao.get(i).getClose() / listaAcao.get(0).getClose();
		}
		
		return percentual;
	}
	
	
}
