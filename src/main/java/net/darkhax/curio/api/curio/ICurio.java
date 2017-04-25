package net.darkhax.curio.api.curio;

import javax.annotation.Nonnull;

import net.darkhax.curio.api.CurioUtils;
import net.darkhax.curio.api.type.CurioType;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This interface is used to define a curio. Curio are capability based, so you should not be
 * adding this to your item class! Curio is designed with the effect of the item being seperate
 * from the actual item, to allow for modular interactions. Because of the modularity, you
 * should anticipate that the ItemStack passed may not be for the item your expected. In cases
 * where a specific item is absolutely required, you should do a check for your conditions and
 * do nothing if the check fails.
 */
public interface ICurio {

    /**
     * Gets the type of curio that this is. This is primarily used for determining which slots
     * the item can be placed in, however other mods can use this for different purposes.
     *
     * @param stack The ItemStack context of the item being checked.
     * @return The type of curio.
     */
    CurioType getType (@Nonnull ItemStack stack);

    /**
     * Checks if the curio can be equipped by the player.
     *
     * NOTE: This method is not the only factor in checking if a Curio can be equipped. If
     * you're calling this method, please use
     * {@link CurioUtils#canEquip(EntityLivingBase, CurioType, ItemStack, net.darkhax.curio.inventory.SlotCurio)}
     * instead.
     *
     * @param stack The ItemStack context of the item being equipped.
     * @param wearer The entity trying to equip the item.
     * @param type The type of slot being interacted with.
     * @return Whether or not the item could be equipped.
     */
    default boolean canEquip (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer, @Nonnull CurioType type) {

        return true;
    }

    /**
     * Checks if the curio can be removed by the player.
     *
     * NOTE: This method is not the only factor in checking if a Curio can be removed. If
     * you're calling this method, please use
     * {@link CurioUtils#canRemove(EntityLivingBase, CurioType, ItemStack, net.darkhax.curio.inventory.SlotCurio)}
     * instead.
     *
     * @param stack The ItemStack context of the item being removed.
     * @param wearer The entity trying to remove the item.
     * @param type The type of slot being interacted with.
     * @return Whether or not the item could be removed.
     */
    default boolean canRemove (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer, @Nonnull CurioType type) {

        return true;
    }

    /**
     * Called when the item is equipped.
     *
     * NOTE: This method is not the only equip hook. Please use
     * {@link CurioUtils#onCurioEquip(EntityLivingBase, CurioType, ItemStack, net.darkhax.curio.inventory.SlotCurio)}
     * instead.
     *
     * @param stack The ItemStack context of the item being equipped.
     * @param wearer The entity trying to equip the item.
     * @param type The type of slot being interacted with.
     */
    default void onEquipped (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer, @Nonnull CurioType type) {

    }

    /**
     * Called when the item is removed.
     *
     * NOTE: This method is not the only remove hook. Please use
     * {@link CurioUtils#onCurioRemoved(EntityLivingBase, CurioType, ItemStack, net.darkhax.curio.inventory.SlotCurio)}
     * instead.
     *
     * @param stack The ItemStack context of the item being removed.
     * @param wearer The entity trying to remove the item.
     * @param type The type of slot being interacted with.
     */
    default void onRemoved (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer, @Nonnull CurioType type) {

    }

    /**
     * Called every tick that an entity has the curio equipped.
     *
     * @param stack The ItemStack context of the item being worn.
     * @param weaer The entity wearing the item.
     */
    default void onUpdate (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer) {

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

    /**
     * Checks if the curio can be applied to the passed ItemStack. If your curio only works on
     * certain items, you will want to add that here. By default all items are applicable.
     *
     * @param stack The ItemStack that is being tested for compatibility.
     * @return Whether or not the curio can be applied to the stack.
     */
    default boolean isApplicable (@Nonnull ItemStack stack) {

        return true;
    }

    /**
     * Called when the wearer is rendered while having this curio.
     *
     * @param stack The ItemStack context of the curio item.
     * @param wearer The entity wearing the curio.
     * @param partialTicks The partial ticks.
     * @return The model for this curio. Null will set the model to nothing, and it will be
     *         skipped.
     */
    @SideOnly(Side.CLIENT)
    default ModelBiped render (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer, float partialTicks) {

        return null;
    }
}