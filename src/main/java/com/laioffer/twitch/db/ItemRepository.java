package com.laioffer.twitch.db;

import com.laioffer.twitch.db.entity.ItemEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ItemRepository extends ListCrudRepository<ItemEntity, Long> {
    // SELECT * FROM items WHERE twitch_id = twitchId
    // The method name is important! You can't change!
    // find -> SELECT, ByTwitchId -> WHERE condition
    ItemEntity findByTwitchId(String twitchId);

}
