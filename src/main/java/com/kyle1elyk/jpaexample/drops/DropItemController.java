package com.kyle1elyk.jpaexample.drops;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/drops")
public class DropItemController {

    private final DropItemRepository dropItemRepository;

    @PostMapping
    String postDrop(@RequestBody DropItem dropItem) {
        DropItem dropItemSaved = dropItemRepository.save(dropItem);

        return "Saved " + dropItemSaved.getName() + " with ID " + dropItemSaved.getId();
    }

    @GetMapping("/{id}")
    DropItemDTO getDrop(@PathVariable Integer id) {

        return DropItemMapper.INSTANCE.toDTO(dropItemRepository.findById(id).orElse(null));
    }

}
