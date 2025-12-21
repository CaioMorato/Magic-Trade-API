package api.trade.magic.magic_trade_api.application.controller;

import api.trade.magic.magic_trade_api.infra.entity.Card;
import api.trade.magic.magic_trade_api.infra.repository.CardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardsController {
    private final CardRepository cardRepository;

    public CardsController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @PostMapping
    public Card create(@RequestBody Card card){
        return cardRepository.save(card);
    }

    @GetMapping
    public List<Card> list(){
        return cardRepository.findAll();
    }
}
