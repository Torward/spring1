package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.model.Item;
import ru.gb.model.Manufacturer;
import ru.gb.service.ItemService;
import ru.gb.service.ManufacturerService;


@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
@Controller
public class ItemController {

    private final ItemService itemService;
    private final ManufacturerService manufacturerService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("product", new Item());
        return "create-item";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processForm(Item item) {
        Manufacturer manufacturer = manufacturerService.findById(item.getManufacturer().getId());
        System.out.println(manufacturer);
        if (item.getId() == null) {
            item = Item.builder()
                    .title(item.getTitle())
                    .cost(item.getCost())
                    .date(item.getDate())
                    .manufacturer(manufacturer)
                    .build();
            itemService.save(item);
        } else {
            itemService.edit(item);
        }
        return "item-list";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String geProductId(Model model, @PathVariable Long id) {
        Item item = itemService.findById(id);
        model.addAttribute("product", item);
        return "item";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllItem(Model model) {
        model.addAttribute("products", itemService.findAll());
        return "item-list";
    }
    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editById(Model model, @RequestParam Long id) {
        model.addAttribute("product", itemService.findById(id));
        return "create-item";
    }
}
