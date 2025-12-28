package com.example.finalproject.api;


import com.example.finalproject.dto.GenreDto;
import com.example.finalproject.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/genres")
public class GenreApi {

    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(genreService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(genreService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addGenre(@RequestBody GenreDto genreDto){
        genreService.addGenre(genreDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGenre(@PathVariable("id") Long id,
                                         @RequestBody GenreDto genreDto){
        genreService.updateGenre(id, genreDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable("id") Long id){
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

