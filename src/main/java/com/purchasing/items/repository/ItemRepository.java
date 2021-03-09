package com.purchasing.items.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purchasing.items.model.Items;


/**
 * @author sundar
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<Items, Integer>{


}
