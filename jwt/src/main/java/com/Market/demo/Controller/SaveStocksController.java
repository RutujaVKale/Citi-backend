package com.Market.demo.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Market.demo.Model.Savestock;
import com.Market.demo.Model.StockDetails;
import com.Market.demo.Service.SaveStocksService;

@RestController
public class SaveStocksController {
	
	@Autowired
	SaveStocksService service;
	
//	@PostMapping("/saveStock/{username}/{stockname}")
//	@Transactional
//	public String saveStock(@PathVariable("username") String username, @PathVariable("stockname") String stockname) {
//		System.out.println("save me");
//		service.saveStock(username, stockname);
//		
//		return stockname;
//		
//	}
	
	//saves stock when user clicks on save button
	//pass me object
	@PostMapping("/saveStock")
	@CrossOrigin
	@Transactional
	public String saveStock(@RequestBody Savestock s) {
		
		System.out.println("save me");		
		service.saveStock(s);		
		return "saved";		
	}
	
	//displays stock when user clicks on my saved stocks
	@GetMapping("/savedstock/{username}")
	@CrossOrigin
	@Transactional
	public ArrayList<StockDetails> getSavedStock(@PathVariable("username") String Username) throws IOException{
		System.out.println("i am called for "+Username);
		return service.displayStockSavedByUser(Username);
	}

}

