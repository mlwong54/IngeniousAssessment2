package com.example.Assessment2.Service;

import com.example.Assessment2.Entity.Stock;
import com.example.Assessment2.Repository.StockRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public void stockInsertDaily(){
        Document doc = null;
        try {
            doc = Jsoup.connect("https://klse.i3investor.com/web/index").get();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        String scriptContent = doc.select("script").html();
        Pattern pattern = Pattern.compile("const gainers = (\\d+);.*?const losers = (\\d+);", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(scriptContent);
        if (matcher.find()) {
            int gainers = Integer.parseInt(matcher.group(1));
            int losers = Integer.parseInt(matcher.group(2));
            System.out.println("Gainers: " + gainers);
            System.out.println("Losers: " + losers);
            Stock newEntry = new Stock(
                    new Date(),gainers,losers
            );
            this.stockRepository.save(newEntry);
        }
    }


}
