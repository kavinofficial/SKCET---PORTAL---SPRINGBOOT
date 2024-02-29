package com.kavin.qn1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kavin.qn1.model.Children;
import com.kavin.qn1.repository.ChildrenRepo;

@Service
public class ChildrenService {
    @Autowired
    private ChildrenRepo childrenRepo;

    public Page<Children> pagination(int offset, int size) {
        return childrenRepo
                .findAll(PageRequest.of(offset, size));
    }

    public List<Children> sorting(String field) {
        return childrenRepo.findAll(Sort.by(Direction.ASC, field));
    }

    public Page<Children> pageSort(int offset, int pagesize, String field) {
        return childrenRepo.findAll(PageRequest.of(offset, pagesize, Sort.by(Direction.ASC, field)));
    }

    public Children postPage(Children l) {
        return childrenRepo.save(l);
    }
}
