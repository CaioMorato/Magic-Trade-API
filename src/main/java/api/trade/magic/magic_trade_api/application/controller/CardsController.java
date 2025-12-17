package api.trade.magic.magic_trade_api.application.controller;

import api.trade.magic.magic_trade_api.infra.entity.Card;
import api.trade.magic.magic_trade_api.infra.repository.CardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardsController {
    private final CardRepository _cardRepository;

    public CardsController(CardRepository _cardRepository) {
        this._cardRepository = _cardRepository;
    }

    @PostMapping
    public Card create(@RequestBody Card card){
        return _cardRepository.save(card);
    }

    @GetMapping
    public List<Card> list(){
        return _cardRepository.findAll();
    }
}
