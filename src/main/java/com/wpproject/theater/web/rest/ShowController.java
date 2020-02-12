package com.wpproject.theater.web.rest;

import com.wpproject.theater.models.Show;
import com.wpproject.theater.service.ShowService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ShowController {
    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Show>> getAllShows(@RequestParam(defaultValue = "0") Integer pageNo,
                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                  @RequestParam(defaultValue = "date") String sortBy){

        List<Show> list = showService.getAllShows(pageNo,pageSize,sortBy);
        return new ResponseEntity<List<Show>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Show> getShowByTitle(@PathVariable long id){
        return ResponseEntity.ok().body(showService.findShowById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Show> createShow(@RequestBody Show show){
        return ResponseEntity.ok().body(this.showService.createShow(show));
    }
    @PutMapping("{id}")
    public ResponseEntity<Show> updateShow(@PathVariable long id, @RequestBody Show show){
        show.setId(id);
        return ResponseEntity.ok().body(this.showService.updateShow(show));
    }

    @DeleteMapping("{id}")
    public HttpStatus deleteUser(@PathVariable long id){
        this.showService.deleteShow(id);
        return HttpStatus.OK;

    }

    @PostMapping("{id}/image")
    public String handleImagePost(@PathVariable long id, @RequestParam("imagefile") MultipartFile file){

        showService.saveImage(id, file);

        return "redirect:/" + id;
    }
}
