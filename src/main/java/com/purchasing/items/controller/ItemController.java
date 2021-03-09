package com.purchasing.items.controller;


import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purchasing.items.exception.ItemException;
import com.purchasing.items.model.Items;
import com.purchasing.items.service.ItemService;

/**
 * @author sundar
 *
 */
@RestController
@RequestMapping(value = "/item",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ItemController {
	@Autowired
	ItemService itemService;

	private final Logger log = LoggerFactory.getLogger(getClass());

	public static String generateUniqueID() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 19);
	}

	@GetMapping(path="/getAllItem")
	public List<Items> getAllItem() throws ItemException {
		String uniqueId = generateUniqueID();
		log.info("{} - item/getItem - starts",uniqueId);
		log.info("{} - item/getItem - ends",uniqueId);
		return itemService.getAllItem(uniqueId);
	}

	@GetMapping("/getItem/{itemid}")
	public Items getItemById(@PathVariable("itemid") int price) throws ItemException {
		String uniqueId = generateUniqueID();
		log.info("{} - item/getItem/itemid - starts",uniqueId);
		log.info("{} - item/getItem/itemid - ends",uniqueId);
		return itemService.getItemById(price,uniqueId);
	}

	@GetMapping("/getItem/{itemOne}/{itemTwo}")
	public List<Items> getItemById(@PathVariable("itemOne") int priceFrom,@PathVariable("itemTwo") int priceTo) throws ItemException {
		String uniqueId = generateUniqueID();
		log.info("{} - item/getItemById/itemOne/itemTwo - starts",uniqueId);
		log.info("{} - item/getItemById/itemOne/itemTwo - ends",uniqueId);
		return itemService.getItemById(priceFrom,priceTo,uniqueId);
	}

}
