package com.kavin.qn1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.qn1.model.Children;
import com.kavin.qn1.service.ChildrenService;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class ChildrenController {
    private ChildrenService childrenService;

    public ChildrenController(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }

    @GetMapping("/children/{offset}/{pagesize}")
    public ResponseEntity<List<Children>> getMethodName(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pagesize) {
        List<Children> list = childrenService.pagination(offset, pagesize).toList();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/children/sortBy/{field}")
    public ResponseEntity<List<Children>> getSort(@PathVariable("field") String field) {
        List<Children> list = childrenService.sorting(field);
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Children>> getPageSort(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pagesize,
            @PathVariable("field") String field) {
        List<Children> list = childrenService.pageSort(offset, pagesize, field).toList();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PostMapping("/children")
    public ResponseEntity<Children> postMethodName(@RequestBody Children entity) {
        Children c = childrenService.postPage(entity);
        if (c != null) {
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
