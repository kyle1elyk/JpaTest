package com.kyle1elyk.jpaexample.drops;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/drops")
@Slf4j
public class DropItemController {

    private final DropItemRepository dropItemRepository;

    @PostMapping
    String postDrop(@RequestBody DropItem dropItem) {
        DropItem dropItemSaved = dropItemRepository.save(dropItem);

        log.info("Saved {}", dropItemSaved);

        return "Saved " + dropItemSaved.getName() + " with ID " + dropItemSaved.getId();
    }

    @GetMapping("/{id}")
    DropItemDTO getDrop(@PathVariable Integer id) {

        DropItemDTO dropItemDTO = DropItemMapper.INSTANCE.toDTO(dropItemRepository.findById(id).orElse(null));

        log.info("GET {}: {}", id, dropItemDTO);

        return dropItemDTO;
    }

}
