package com.example.jpa.start.jpa.contorller;

import com.example.jpa.start.jpa.dto.ItemListRequestDTO;
import com.example.jpa.start.jpa.dto.ItemListResponseDTO;
import com.example.jpa.start.jpa.service.ItemListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/jpa/api/v2")
public class ItemListController {

    private final ItemListService service;

    @PostMapping("/item")
    public ItemListResponseDTO save(ItemListRequestDTO requestDto) {
        return service.save(requestDto);
    }
}
