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
public class NameController {


    @GetMapping("/pokes/{id}")
    public Name getPokes(@PathVariable("id")@Min(1) int id){
        return new Name(id,"フシギダネ","ばなばな");
    }

    @PostMapping("/pokes")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Valid NameCreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/pokes/{id}")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("massage", "poke successfully created"));
    }

    @PatchMapping("/pokes/{id}")
    public ResponseEntity<Map<String,String>> update(@PathVariable("id")@Min(1) int id, @RequestBody @Valid NameUpdateForm form){
        return ResponseEntity.ok(Map.of("massage","nickname successfully updated"));
    }

    @DeleteMapping("/pokes/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id")@Min(1) int id){
        return ResponseEntity.ok(Map.of("massage","poke successfully deleted"));
    }
}
