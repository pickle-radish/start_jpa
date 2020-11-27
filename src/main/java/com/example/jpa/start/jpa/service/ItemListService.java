package com.example.jpa.start.jpa.service;

import com.example.jpa.start.jpa.dto.ItemListRequestDTO;
import com.example.jpa.start.jpa.dto.ItemListResponseDTO;
import com.example.jpa.start.jpa.repository.ItemListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemListService {

    private final ItemListRepository repository;

    public ItemListResponseDTO save(ItemListRequestDTO requestDto) {
        return new ItemListResponseDTO(repository.save(requestDto.toEntity()));
    }
}
