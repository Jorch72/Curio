package net.darkhax.curio.api.curio;

import javax.annotation.Nonnull;

import net.darkhax.curio.api.type.ICurioType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public interface ICurio {
    
    /**
     * Gets the type of curio that this is. This is primarily used for determining which slots
     * the item can be placed in, however other mods can use this for different purposes.
     * 
     * @param stack The ItemStack context of the item being checked.
     * @return The type of curio.
     */
    ICurioType getType (@Nonnull ItemStack stack);
    
    /**
     * Checks if the curio can be equipped by the player.
     * 
     * @param stack The ItemStack context of the item being equipped.
     * @param wearer The entity trying to equip the item.
     * @return Whether or not the item could be equipped.
     */
    // TODO add slot context
    default boolean canEquip (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer) {
        
        return true;
    }
    
    /**
     * Checks if the curio can be removed by the player.
     * 
     * @param stack The ItemStack context of the item being removed.
     * @param wearer The entity trying to remove the item.
     * @return Whether or not the item could be removed.
     */
    // TODO add slot context
    default boolean canRemove (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer) {
        
        return true;
    }
    
    /**
     * Called when the item is equipped.
     * 
     * @param stack The ItemStack context of the item being equipped.
     * @param wearer The entity trying to equip the item.
     */
    // TODO add slot context
    default void onEquipped (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer) {
        
    }
    
    /**
     * Called when the item is removed.
     * 
     * @param stack The ItemStack context of the item being removed.
     * @param wearer The entity trying to remove the item.
     */
    // TODO add slot context
    default void onRemoved (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer) {
        
    }
    
    /**
     * Called every tick that an entity has the curio equipped.
     * 
     * @param stack The ItemStack context of the item being worn.
     * @param weaer The entity wearing the item.
     */
    default void onUpdate (@Nonnull ItemStack stack, @Nonnull EntityLivingBase weaer) {
        
    }
    
    /**
     * Gets a non null list of ICurio objects which are contained within this one. This allows
     * for one curio item to mimic the effects of other items, or for effects to be hot
     * swapable and not depend on an Item.
     * 
     * @param stack The ItemStack context of the curio item.
     * @param weaer The entity accessing the contained curio.
     * @return A non null list of ICurio that are contained within this one.
     */
    default NonNullList<ICurio> getContainedCurio (@Nonnull ItemStack stack, @Nonnull EntityLivingBase weaer) {
        
        return NonNullList.create();
    }
}