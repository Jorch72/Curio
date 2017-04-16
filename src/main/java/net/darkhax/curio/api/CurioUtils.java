package net.darkhax.curio.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import net.darkhax.curio.Curio;
import net.darkhax.curio.api.curio.ICurio;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class CurioUtils {

    public static boolean isCurio (@Nonnull ItemStack stack) {

        return !stack.isEmpty() && stack.hasCapability(Curio.CAPABILITY_CURIO, null);
    }

    public static List<ICurio> getCurioForStack (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer) {

        return isCurio(stack) ? stack.getCapability(Curio.CAPABILITY_CURIO, null).getContainedCurio(stack, wearer) : new ArrayList<>();
    }
}