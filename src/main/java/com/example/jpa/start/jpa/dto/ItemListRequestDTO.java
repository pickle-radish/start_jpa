package com.example.jpa.start.jpa.dto;


import com.example.jpa.start.jpa.entity.ItemList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemListRequestDTO {

    private String itemCategory;
    private String itemName;

    public ItemList toEntity() {
         return ItemList.builder()
                .itemCategory(itemCategory)
                .itemName(itemName)
                .build();
    }
}
