package net.darkhax.curio.api.capabilities;

import net.darkhax.curio.Curio;
import net.darkhax.curio.api.curio.ICurio;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class CapabilityProviderCurio implements ICapabilityProvider {

    private final ICurio curio;

    public CapabilityProviderCurio (ICurio curio) {

        this.curio = curio;
    }

    @Override
    public boolean hasCapability (Capability<?> capability, EnumFacing facing) {

        return capability == Curio.CAPABILITY_CURIO;
    }

    @Override
    public <T> T getCapability (Capability<T> capability, EnumFacing facing) {

        return capability == Curio.CAPABILITY_CURIO ? (T) this.curio : null;
    }

}
