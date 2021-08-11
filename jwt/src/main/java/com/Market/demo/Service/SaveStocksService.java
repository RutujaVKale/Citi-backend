package com.Market.demo.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Market.demo.Model.Savestock;
import com.Market.demo.Model.StockDetails;
import com.Market.demo.Model.UserLoginDetail;
import com.Market.demo.Repository.StockRepository;
import com.Market.demo.Repository.UserAuthenticationRepository;

@Service
public class SaveStocksService {

	@Autowired
	StockRepository stockrepo;

	// @Autowired
	Savestock stock1;

	@Autowired
	UserAuthenticationRepository userrepo;

	@Autowired
	NiftyService service;

//	public void saveStock(String username, String stockname) {
//		
//		UserLoginDetail userId = userrepo.findByUsername(username);
//		int userid = userId.getUserId();
//		
//		stock1 = new Savestock();
//		stock1.setId(5);
//		stock1.setUserid(userid);
//		stock1.setStockname(stockname);
//		stockrepo.save(stock1);
////		try {
////			stockrepo.save(stock1);
////		}catch(DataIntegrityViolationException e) {
////			System.out.println("data voilation");
////		}		
//	}
//	

	// save stock in db
	public void saveStock(Savestock s) {
//		stock1 =  new Savestock();
//		stock1.setUsername(s.getUsername());
//		stock1.setStockname(s.getStockname());
		System.out.println(s.getUsername() + " " + s.getStockname());
		stockrepo.save(s);
	}

	// get stocks saved by user
	public String[] getStockSaved(String username) {
		List<Savestock> list = stockrepo.findAllByUsername(username);
		// System.out.println(l.size());
		// return stockrepo.findAllByUsername(username);
		// List<String> company = new ArrayList<String>();
		String[] company = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			// Savestock s = list.get(i);
			// company.add(list.get(i).getStockname());
			company[i] = list.get(i).getStockname();
		}
		// String[] savedCompanies =company.toArray();
		return company;

	}

	public ArrayList<StockDetails> displayStockSavedByUser(String username) throws IOException {
		return service.getStockDetails(getStockSaved(username));
	}

}
