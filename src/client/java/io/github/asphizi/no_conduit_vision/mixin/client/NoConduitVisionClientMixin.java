package io.github.asphizi.no_conduit_vision.mixin.client;

import io.github.asphizi.no_conduit_vision.NoConduitVisionClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LightmapTextureManager.class)
public abstract class NoConduitVisionClientMixin {
	@Redirect(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;hasStatusEffect(Lnet/minecraft/registry/entry/RegistryEntry;)Z", ordinal = 1))
	public boolean returnFalse(ClientPlayerEntity entity, RegistryEntry<StatusEffect> registryEntry) {
		return entity.hasStatusEffect(StatusEffects.CONDUIT_POWER) && NoConduitVisionClient.isConduitVisionEnabled();
	}
}