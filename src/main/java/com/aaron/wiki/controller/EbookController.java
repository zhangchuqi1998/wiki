package com.aaron.wiki.controller;

import com.aaron.wiki.domain.Ebook;
import com.aaron.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {


    @Resource
    private EbookService ebookService;

    @GetMapping("/list1")
    public List<Ebook> list() {
        return ebookService.list();
    }
}
