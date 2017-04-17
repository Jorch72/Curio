package net.darkhax.curio.inventory;

import net.darkhax.curio.api.CurioUtils;
import net.darkhax.curio.api.type.CurioType;
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

        return CurioUtils.isCurio(stack);
    }

    @Override
    public boolean canTakeStack (EntityPlayer player) {

        return CurioUtils.canRemove(this.entity, this.type, this.getStack(), this);
    }

    @Override
    public void putStack (ItemStack stack) {

        CurioUtils.onCurioRemoved(this.entity, this.type, stack, this);
        super.putStack(stack);
        CurioUtils.onCurioEquip(this.entity, this.type, stack, this);
    }

    @Override
    public int getSlotStackLimit () {

        return this.type.getStackSize();
    }
}