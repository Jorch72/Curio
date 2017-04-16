package net.darkhax.curio.inventory;

import net.darkhax.curio.api.curio.ICurio;
import net.darkhax.curio.api.type.CurioType;
import net.darkhax.curio.lib.Utilities;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotCurio extends SlotItemHandler {

    private final EntityLivingBase entity;
    private final CurioType type;

    public SlotCurio (EntityLivingBase entity, CurioType type, IItemHandler handler, int index, int x, int y) {

        super(handler, index, x, y);
        this.entity = entity;
        this.type = type;
    }

    @Override
    public boolean isItemValid (ItemStack stack) {

        for (final ICurio curio : Utilities.getCurioForStack(stack, this.entity))
            if (!this.type.isCurioValid(curio, stack, this.entity))
                return false;
            
        return true;
    }

    @Override
    public boolean canTakeStack (EntityPlayer player) {

        for (final ICurio curio : Utilities.getCurioForStack(this.getStack(), this.entity))
            if (!curio.canRemove(this.getStack(), this.entity))
                return false;
            
        return true;
    }

    @Override
    public void putStack (ItemStack stack) {

        if (this.getHasStack())
            for (final ICurio curio : Utilities.getCurioForStack(this.getStack(), this.entity))
                curio.onRemoved(this.getStack(), this.entity);
            
        super.putStack(stack);

        if (this.getHasStack())
            for (final ICurio curio : Utilities.getCurioForStack(this.getStack(), this.entity))
                curio.onEquipped(this.getStack(), this.entity);
    }

    @Override
    public int getSlotStackLimit () {

        return this.type.getStackSize();
    }
}
