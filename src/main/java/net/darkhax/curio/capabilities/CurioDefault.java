package net.darkhax.curio.capabilities;

import net.darkhax.curio.api.curio.ICurio;
import net.darkhax.curio.api.type.CurioType;
import net.minecraft.item.ItemStack;

/**
 * This is the default implementation of ICurio. Forge requires that capabilities provide a
 * default class which can be used to make default instances. There isn't really anything
 * special here, and you should not try to extend or use this class in your mods.
 */
public class CurioDefault implements ICurio {

    @Override
    public CurioType getType (ItemStack stack) {

        // TODO no null
        return null;
    }
}