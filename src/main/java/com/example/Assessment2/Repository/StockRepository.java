package com.example.Assessment2.Repository;

import com.example.Assessment2.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

}