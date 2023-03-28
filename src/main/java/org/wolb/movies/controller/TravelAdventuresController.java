package org.wolb.movies.controller;

import org.wolb.movies.model.Adventure;
import org.wolb.movies.repository.AdventureRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traveladventures")
public class TravelAdventuresController {

    private final AdventureRepository adventureRepository;

    public TravelAdventuresController(AdventureRepository adventureRepo) {
        this.adventureRepository = adventureRepo;
    }

    @GetMapping({ "", "/", "/all" })
    public Iterable<Adventure> getAllAdventure() {
        Iterable<Adventure> adventureList = this.adventureRepository.findAll();

        return adventureList;
    }

    @GetMapping("/bycountry/{country}")
    public Iterable<Adventure> getAllAdventureByCountry(@PathVariable String country) {
        Iterable<Adventure> adventureList = this.adventureRepository.findByCountry(country);

        return adventureList;
    }

    @GetMapping("/bystate")
    public Iterable<Adventure> getAllAdventureByState(@RequestParam String state) {
        Iterable<Adventure> adventureList = this.adventureRepository.findByState(state);

        return adventureList;
    }

    @PostMapping({ "", "/" })
    public Adventure saveAdventure(@RequestBody Adventure adventure) {
        Adventure adventureList = this.adventureRepository.insert(adventure);

        return adventureList;
    }
    // Add controller methods below:

}
