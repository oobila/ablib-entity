package com.github.oobila.bukkit.entity;

import lombok.experimental.Delegate;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

public class PlayerHeadEntity extends NodeEntity<ArmorStand, PlayerHeadEntity> implements ArmorStand{

    @Delegate(types = ArmorStand.class, excludes = Entity.class)
    private final ArmorStand armorStand;

    public PlayerHeadEntity(Location location, ItemStack nonPlayerSkull,
                            CustomEntityBehaviour<PlayerHeadEntity> behaviour) {
        super((ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND), behaviour);
        this.armorStand = getEntity();
        getEquipment().setHelmet(nonPlayerSkull);
        setVisible(false);
        setSilent(true);
    }
}