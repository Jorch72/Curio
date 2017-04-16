package net.darkhax.curio.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import net.darkhax.curio.api.curio.ICurio;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class CurioUtils {

    /**
     * The capability for ICurio. Feel free to use this one, or make your own.
     */
    @CapabilityInject(ICurio.class)
    public static Capability<ICurio> CAPABILITY_CURIO = null;
    
    public static boolean isCurio (@Nonnull ItemStack stack) {

        return !stack.isEmpty() && stack.hasCapability(CAPABILITY_CURIO, null);
    }

    public static List<ICurio> getCurioForStack (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer) {

        return isCurio(stack) ? stack.getCapability(CAPABILITY_CURIO, null).getContainedCurio(stack, wearer) : new ArrayList<>();
    }
}