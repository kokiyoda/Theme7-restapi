package com.theme7.restapi;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Validated
@RestController
public class PokemonController {


    @GetMapping("/pokemons/{id}")
    public Pokemon getPokemons(@PathVariable("id") int id){
        return new Pokemon(id,"フシギダネ","ばなばな");
    }

    @PostMapping("/pokemons")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Valid PokemonCreateForm form, UriComponentsBuilder uriBuilder) {
        URI url = uriBuilder
                .path("/pokemons/{id}")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("massage", "poke successfully created"));
    }

    @PatchMapping("/pokemons/{id}")
    public ResponseEntity<Map<String,String>> update(@PathVariable("id") int id, @RequestBody @Valid PokemonUpdateForm form){
        return ResponseEntity.ok(Map.of("massage","nickname successfully updated"));
    }

    @DeleteMapping("/pokemons/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id){
        return ResponseEntity.ok(Map.of("massage","poke successfully deleted"));
    }
}
