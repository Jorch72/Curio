package net.darkhax.curio.api.type;

import net.darkhax.curio.api.CurioUtils;
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
     * Checks if the Curio can be equipped in a slot of this type. By default, this is only if
     * {@link ICurio#getType(ItemStack)} returns this type.
     *
     * NOTE: This method is not the only factor in checking if a Curio can be equipped. If
     * you're calling this method, please use
     * {@link CurioUtils#canEquip(EntityLivingBase, CurioType, ItemStack, net.darkhax.curio.inventory.SlotCurio)}
     * instead.
     *
     * @param curio The Curio being equipped.
     * @param stack The ItemStack context of the item being equipped.
     * @param wearer The entity trying to equip the item.
     * @return Whether or not the Curio can be equipped.
     */
    public boolean canEquip (ICurio curio, ItemStack stack, EntityLivingBase wearer) {

        return this == curio.getType(stack);
    }

    /**
     * Checks if the Curio can be removed from a slot of this type. By default this is always
     * true.
     *
     * NOTE: This method is not the only factor in checking if a Curio can be removed. If
     * you're calling this method, please use
     * {@link CurioUtils#canRemove(EntityLivingBase, CurioType, ItemStack, net.darkhax.curio.inventory.SlotCurio)}
     * instead.
     *
     * @param curio The Curio being removed.
     * @param stack The ItemStack context of the item being removed.
     * @param wearer The entity removing the item.
     * @return Whether or not the Curio can be removed.
     */
    public boolean canRemove (ICurio curio, ItemStack stack, EntityLivingBase wearer) {

        return true;
    }

    /**
     * Called when a Curio is equipped to a slot of this type.
     *
     * NOTE: This method is not the only equip hook. Please use
     * {@link CurioUtils#onCurioEquip(EntityLivingBase, CurioType, ItemStack, net.darkhax.curio.inventory.SlotCurio)}
     * instead.
     *
     * @param curio The Curio being equipped.
     * @param stack The ItemStack context of the Curio being equipped.
     * @param wearer The entity that equipped the item.
     */
    public void onEquip (ICurio curio, ItemStack stack, EntityLivingBase wearer) {

    }

    /**
     * Called when a Curio is removed to a slot of this type.
     *
     * NOTE: This method is not the only remove hook. Please use
     * {@link CurioUtils#onCurioRemoved(EntityLivingBase, CurioType, ItemStack, net.darkhax.curio.inventory.SlotCurio)}
     * instead.
     *
     * @param curio The Curio being removed.
     * @param stack The ItemStack context of the Curio being removed.
     * @param wearer The entity that equipped the item.
     */
    public void onRemove (ICurio curio, ItemStack stack, EntityLivingBase wearer) {

    }
}