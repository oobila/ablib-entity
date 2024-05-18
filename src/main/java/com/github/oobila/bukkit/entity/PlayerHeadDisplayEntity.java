package com.github.oobila.bukkit.entity;

import lombok.experimental.Delegate;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.inventory.ItemStack;

public class PlayerHeadDisplayEntity extends NodeEntity<ItemDisplay> implements ItemDisplay {

    @Delegate(types = ItemDisplay.class, excludes = Entity.class)
    private final ItemDisplay itemDisplay;

    public PlayerHeadDisplayEntity(Location location, ItemStack nonPlayerSkull,
                            CustomEntityBehaviour<NodeEntity<ItemDisplay>> behaviour) {
        super((ItemDisplay) location.getWorld().spawnEntity(location, EntityType.ITEM_DISPLAY), behaviour);
        this.itemDisplay = getEntity();
        setItemStack(nonPlayerSkull);
    }
}
