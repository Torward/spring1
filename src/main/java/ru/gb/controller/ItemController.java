package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.model.Item;
import ru.gb.service.ItemService;


@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
@Controller
public class ItemController {

    private final ItemService itemService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("product", new Item());
        return "create-item";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processForm(Item item) {
        if (item.getId() == null) {
            itemService.save(item);
        } else {
            itemService.edit(item);
        }
        return "redirect:/product/all";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getMessageId(Model model, @PathVariable Integer id) {
        Item item = itemService.findById(id);
        model.addAttribute("product", item);
        return "item";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllItem(Model model) {
        model.addAttribute("products", itemService.findAll());
        return "item-list";
    }
}
