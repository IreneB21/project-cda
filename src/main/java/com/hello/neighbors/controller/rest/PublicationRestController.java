package com.hello.neighbors.controller.rest;

import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.entity.dto.PublicationCreateDto;
import com.hello.neighbors.entity.dto.PublicationDeleteDto;
import com.hello.neighbors.entity.dto.PublicationUpdateDto;
import com.hello.neighbors.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rest/hello/neighbors/publication")
@CrossOrigin("${front.url}")
public class PublicationRestController {

    private PublicationService publicationService;

    //////////////// Endpoints ////////////////

    @PostMapping("/create")
    public ResponseEntity<Publication> createPublication(@RequestBody PublicationCreateDto dto) {
        Publication publication = publicationService.create(dto);
        return ResponseEntity.ok(publication);
    }

    @PatchMapping("/update")
    public ResponseEntity<Publication> updatePublication(@RequestBody PublicationUpdateDto dto) {
        Publication publication = publicationService.update(dto);
        return ResponseEntity.ok(publication);
    }

    @DeleteMapping("/delete")
    public void deletePublication(@RequestBody PublicationDeleteDto dto) {
        publicationService.delete(dto);
    }

    @Autowired
    public void setPublicationService(PublicationService publicationService) {
        this.publicationService = publicationService;
    }
}
