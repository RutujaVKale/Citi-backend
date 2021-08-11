package com.Market.demo.Repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Market.demo.Model.Savestock;


@Repository
public interface StockRepository extends JpaRepository<Savestock, Integer> {

	List<Savestock> findAllByUsername(String username);

}
