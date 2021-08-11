package com.Market.demo.Controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Market.demo.Model.StockDetails;
import com.Market.demo.Service.NiftyService;


@RestController
@CrossOrigin(origins="*")
public class NiftyStocks {
	@Autowired
	NiftyService service;
	
	/********an api that returns list of [shareobjects] of nifty 50 large cap stocks**********/
	
	@GetMapping("/getStocks/{marketCap}")
	@CrossOrigin
	public ArrayList<StockDetails> getAllLargeCapNiftyStocks(@PathVariable String marketCap) throws IOException{
		return service.getAllStocksDetails(marketCap);
	}
	
	
	//top 5 stocks
	@GetMapping("/getTopStocks/{marketCap}")
	@CrossOrigin
	public ArrayList<StockDetails> getTopNiftyStocks(@PathVariable String marketCap) throws IOException{
		return service.getTopNiftyStocks(marketCap);
	}
	
}
