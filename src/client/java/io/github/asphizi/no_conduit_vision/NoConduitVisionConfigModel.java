package io.github.asphizi.no_conduit_vision;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;

@Modmenu(modId = NoConduitVisionClient.MOD_ID)
@Config(name = NoConduitVisionClient.MOD_ID, wrapperName = "NoConduitVisionConfig")
public class NoConduitVisionConfigModel {
    public boolean conduitVisionEnabled = false;
}
