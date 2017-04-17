package net.darkhax.curio.api.curio;

import javax.annotation.Nonnull;

import net.darkhax.curio.api.type.CurioType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * This implementation of ICurio is used as a base for curio which contains other curio. This
 * implementation delegates the majority of calls to the contained curio.
 */
public abstract class CurioComposite implements ICurio {

    /**
     * A non null list of held curio. Used for
     * {@link #getContainedCurio(ItemStack, EntityLivingBase)}.
     */
    private final NonNullList<ICurio> heldCurio = NonNullList.create();

    /**
     * Adds a curio to the composite.
     *
     * @param curio The curio to add.
     */
    public void addCurio (@Nonnull ICurio curio) {

        this.heldCurio.add(curio);
    }

    /**
     * Removes a curio from the composite.
     *
     * @param curio The curio to remove.
     */
    public void removeCurio (@Nonnull ICurio curio) {

        this.heldCurio.remove(curio);
    }

    @Override
    public boolean canEquip (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer, CurioType type) {

        for (final ICurio curio : this.heldCurio)
            if (!curio.canEquip(stack, wearer, type))
                return false;

        return true;
    }

    @Override
    public boolean canRemove (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer, CurioType type) {

        for (final ICurio curio : this.heldCurio)
            if (!curio.canRemove(stack, wearer, type))
                return false;

        return true;
    }

    @Override
    public void onEquipped (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer, CurioType type) {

        for (final ICurio curio : this.heldCurio)
            curio.onEquipped(stack, wearer, type);
    }

    @Override
    public void onRemoved (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer, CurioType type) {

        for (final ICurio curio : this.heldCurio)
            curio.onRemoved(stack, wearer, type);
    }

    @Override
    public void onUpdate (@Nonnull ItemStack stack, @Nonnull EntityLivingBase weaer) {

        for (final ICurio curio : this.heldCurio)
            curio.onUpdate(stack, weaer);
    }

    @Override
    public NonNullList<ICurio> getContainedCurio (@Nonnull ItemStack stack, @Nonnull EntityLivingBase weaer) {

        return this.heldCurio;
    }
}