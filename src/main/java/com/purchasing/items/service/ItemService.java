package com.purchasing.items.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purchasing.items.exception.ItemException;
import com.purchasing.items.model.Items;
import com.purchasing.items.repository.ItemRepository;

/**
 * @author sundar
 *
 */
@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	public List<Items> getAllItem(String uniqueId) throws ItemException {
		log.info("{} - getAllItems - starts",uniqueId);
		List<Items> itemList = new ArrayList<>();
		List<Items>	resultList= new ArrayList<>();
		itemList = itemRepository.findAll();
		log.info("{} - getAllItems - Ends",uniqueId);
		if(itemList.isEmpty()) {
			throw new ItemException("ITEMS_NOTAVAILABLE");
		} else if(itemList.size() > 1){
			resultList = itemList.stream().sorted(Comparator.comparing(Items::getPrice).reversed())
					.collect(Collectors.toList());
			return resultList;
		} else {
			return itemList;
		}
	}

	public Items getItemById(int itemId, String uniqueId) throws ItemException {
		log.info("{} - item/getItemById/itemid - starts",uniqueId);
		Optional<Items> optionalItemList =itemRepository.findById(itemId);
		log.info("{} - item/getItemById/itemid - Ends",uniqueId);
		if(optionalItemList.isPresent()){
			return optionalItemList.get();
		} else {
			throw new ItemException("INVALID_ITEM_ID");
		}		
	}

	public List<Items> getItemById(int itemOne, int itemTwo, String uniqueId) throws ItemException {
		log.info("{} - item/getItemById/itemOne/itemTwo - starts",uniqueId);
		List<Integer> idList = new ArrayList<>();
		List<Items> itemList = new ArrayList<>();
		idList.add(itemOne);
		idList.add(itemTwo);
		itemList = itemRepository.findAllById(idList);
		log.info("{} - item/getItemById/itemOne/itemTwo - Ends",uniqueId);
		if(itemList.isEmpty()) {
			throw new ItemException("INVALID_ITEM_ID'S");
		}else {
			return itemList;
		}
	}
}
