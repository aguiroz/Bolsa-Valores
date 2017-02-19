package br.com.guilherme.bolsavalores.controller;

import br.com.guilherme.bolsavalores.dao.CblcDAO;
import br.com.guilherme.bolsavalores.model.Cblc;

public class CblcController {

	private CblcDAO cblcDao;
	private Cblc cblc;
	
	public CblcController(){
		cblcDao = new CblcDAO();
	}
	
	public Cblc getCblc(String symbol){
		cblc = cblcDao.getCblc(symbol);
		return cblc;
	}
}
