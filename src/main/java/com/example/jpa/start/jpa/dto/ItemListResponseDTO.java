package com.example.jpa.start.jpa.dto;

import com.example.jpa.start.jpa.entity.ItemList;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemListResponseDTO {

    private Integer itemId;
    private String itemCategory;
    private String itemName;

    public ItemListResponseDTO(ItemList entity) {
        this.itemId = entity.getItemId();
        this.itemCategory = entity.getItemCategory();
        this.itemName = entity.getItemName();

    }
}
