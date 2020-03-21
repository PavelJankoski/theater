package com.wpproject.theater.web.rest;

import com.wpproject.theater.models.Show;
import com.wpproject.theater.service.ShowService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/shows", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ShowController {
    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }


    @GetMapping
    public ResponseEntity<List<Show>> getAllShows(){
        return ResponseEntity.ok().body(this.showService.getAllShows());
    }


    @GetMapping("/paged")
    public Page<Show> getAllShowsPaged(@RequestHeader(name = "page", defaultValue = "0", required = false) Integer pageNo,
                                  @RequestHeader(name = "page-size", defaultValue = "6", required = false) Integer pageSize,
                                  @RequestHeader(name = "sort", defaultValue = "from") String sortBy){

        return showService.getAllShowsPaged(pageNo,pageSize,sortBy);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowByTitle(@PathVariable long id){
        return ResponseEntity.ok().body(showService.findShowById(id));
    }

    @GetMapping(params = "term")
    public ResponseEntity<List<Show>> searchShow(@RequestParam String term){
        List<Show> list = this.showService.searchShow(term);
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Show> createShow(@RequestBody Show show){
        return ResponseEntity.ok().body(this.showService.createShow(show));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable long id, @RequestBody Show show){
        show.setId(id);
        return ResponseEntity.ok().body(this.showService.updateShow(show));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUser(@PathVariable long id){
        this.showService.deleteShow(id);
        return HttpStatus.OK;

    }

    @PostMapping("/{id}/image")
    public HttpStatus handleImagePost(@PathVariable long id, @RequestParam("formData") MultipartFile showImage){

        showService.saveImage(id, showImage);

        return HttpStatus.OK;
    }
}
