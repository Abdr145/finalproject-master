package com.example.finalproject.api;


import com.example.finalproject.dto.MovieDto;
import com.example.finalproject.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieApi {

    private final MovieService movieService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(movieService.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody MovieDto movieDto){
        movieService.addMovie(movieDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable("id") Long id,
                                         @RequestBody MovieDto movieDto){
        movieService.updateMovie(id, movieDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
