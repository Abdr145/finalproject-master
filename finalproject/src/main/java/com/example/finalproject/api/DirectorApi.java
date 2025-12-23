package com.example.finalproject.api;


import com.example.finalproject.dto.DirectorDto;
import com.example.finalproject.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/directors")
public class DirectorApi {

    private final DirectorService directorService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(directorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(directorService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addDirector(@RequestBody DirectorDto directorDto){
        directorService.addDirector(directorDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDirector(@PathVariable("id") Long id,
                                            @RequestBody DirectorDto directorDto){
        directorService.updateDirector(id, directorDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDirector(@PathVariable("id") Long id){
        directorService.deleteDirector(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
