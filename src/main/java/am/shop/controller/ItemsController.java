package am.shop.controller;

import am.shop.model.Items;
import am.shop.model.dto.response.ItemsInfoPaser;
import am.shop.service.ItemsService;
import am.shop.util.exceptions.BadRequestException;
import am.shop.util.exceptions.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping("/{id}")
    public Items getById(@PathVariable long id) throws NotFoundExcaption {
        return itemsService.getById(id);
    }

    @GetMapping
    public List<Items> getByAll() throws NotFoundExcaption {
        return itemsService.getByAll();
    }

    @PostMapping
    public ResponseEntity<Void> crateItems(@Valid @RequestBody Items items) throws BadRequestException {
        itemsService.crateItems(items);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("edit-items")
    public ResponseEntity<Void> editItems(@Valid @RequestBody Items items) throws BadRequestException {
        itemsService.editItems(items);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/search")
    public ResponseEntity<List<ItemsInfoPaser>> search(@RequestParam(required = false) String name,
                                                       @RequestParam(required = false) String brand,
                                                       @RequestParam(required = false) String category) {
        return ResponseEntity.ok(itemsService.search(name,brand,category));
    }

    @GetMapping("/priceExpensive")
    public ResponseEntity<List<ItemsInfoPaser>> priceExpensive(@RequestParam BigDecimal price){
        return ResponseEntity.ok(itemsService.priceExpensive(price));
    }

    @GetMapping("/priceCheap")
    public ResponseEntity<List<ItemsInfoPaser>> priceCheap(@RequestParam BigDecimal price){
        return ResponseEntity.ok(itemsService.priceCheap(price));
    }

    @GetMapping("/page")
    public ResponseEntity<?> pageRequest(@PageableDefault Pageable pageable){
         return ResponseEntity.ok(itemsService.pageRequest(pageable));
    }

}
