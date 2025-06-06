package com.example.Assessment2.Controller;


import com.example.Assessment2.Entity.Stock;
import com.example.Assessment2.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class StockController {
    @Autowired
    private StockRepository stockRepository;

    @GetMapping({"/"})
    public String getStocks(Model model) {
        List<Stock> stocks = stockRepository.findAll();
        model.addAttribute("stocks", stocks);
        return "index.html";
    }
}
