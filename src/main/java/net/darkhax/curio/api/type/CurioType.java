package net.darkhax.curio.api.type;

import net.darkhax.curio.api.curio.ICurio;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CurioType {

    /**
     * The id for the Curio type.
     */
    private final ResourceLocation identifier;

    /**
     * The default amount of slots for this type.
     */
    private final int baseAmount;

    public CurioType (ResourceLocation identifier, int baseAmount) {

        this.identifier = identifier;
        this.baseAmount = baseAmount;
    }

    /**
     * Gets the id for the Curio type.
     *
     * @return The id for the Curio type.
     */
    public ResourceLocation getIdentifier () {

        return this.identifier;
    }

    /**
     * Gets the amount of slots that should be added.
     *
     * @param entity The entity accessing the slots.
     * @return The amount of slots of this type that should be added to the inventory.
     */
    public int getAmount (EntityLivingBase entity) {

        return this.baseAmount;
    }

    /**
     * Gets the max stack size for an item in a slot of this type.
     *
     * @return The max stack size for this slot type.
     */
    public int getStackSize () {

        return 1;
    }

    /**
     * Checks if a curio is valid for inserting into the slot.
     *
     * @param curio The Curio being equipped;
     * @param stack The ItemStack being equipped.
     * @param wearer The entity trying to equip.
     * @return Whether or not the curio is valid for the slot. By default, this requires that
     *         the slot type match this, and the curio returning true in
     *         {@link ICurio#canEquip(ItemStack, EntityLivingBase)}.
     */
    public boolean isCurioValid (ICurio curio, ItemStack stack, EntityLivingBase wearer) {

        return this == curio.getType(stack) && curio.canEquip(stack, wearer);
    }
}