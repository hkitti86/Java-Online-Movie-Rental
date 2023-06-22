package com.booleanuk.movie.api.Controller;

import com.booleanuk.movie.api.Model.BasketContent;
import com.booleanuk.movie.api.Repository.BasketContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class BasketContentController {

    @Autowired
    private BasketContentRepository basketContentRepository;

    @GetMapping
    public List<BasketContent> getAllBasketContent(){
        return this.basketContentRepository.findAll();
    }
}
