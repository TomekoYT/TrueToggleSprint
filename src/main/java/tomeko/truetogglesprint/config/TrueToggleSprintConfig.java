package tomeko.truetogglesprint.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.*;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.platform.YACLPlatform;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import tomeko.truetogglesprint.utils.Constants;

import java.awt.Color;

public class TrueToggleSprintConfig {
    public static final ConfigClassHandler<TrueToggleSprintConfig> CONFIG = ConfigClassHandler.createBuilder(TrueToggleSprintConfig.class)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(YACLPlatform.getConfigDir().resolve(Constants.MOD_ID + ".json"))
                    .build())
            .build();

    @SerialEntry
    public static boolean toggleSprintEnabled = false;
    @SerialEntry
    public static String toggleSprintText = "Sprint Toggled";
    @SerialEntry
    public static Color toggleSprintTextColor = Color.WHITE;
    @SerialEntry
    public static boolean toggleSprintTextShadowEnabled = false;
    @SerialEntry
    public static float toggleSprintTextWidthPercentage = 10F;
    @SerialEntry
    public static float toggleSprintTextHeightPercentage = 10F;

    public static Screen configScreen(Screen parent) {
        return YetAnotherConfigLib.create(CONFIG, ((defaults, config, builder) -> builder
                .title(Text.literal(Constants.MOD_NAME))

                .category(ConfigCategory.createBuilder()
                        .name(Text.literal("Toggle Sprint Config"))

                        .option(Option.<String>createBuilder()
                                .name(Text.literal("Text"))
                                .binding(defaults.toggleSprintText, () -> config.toggleSprintText, newVal -> config.toggleSprintText = newVal)
                                .controller(opt -> StringControllerBuilder.create(opt))
                                .build())
                        .option(Option.<Color>createBuilder()
                                .name(Text.literal("Color"))
                                .binding(defaults.toggleSprintTextColor, () -> config.toggleSprintTextColor, newVal -> config.toggleSprintTextColor = newVal)
                                .controller(opt -> ColorControllerBuilder.create(opt))
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Text.literal("Text Shadow"))
                                .binding(defaults.toggleSprintTextShadowEnabled, () -> config.toggleSprintTextShadowEnabled, newVal -> config.toggleSprintTextShadowEnabled = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .option(Option.<Float>createBuilder()
                                .name(Text.literal("Position X"))
                                .binding(defaults.toggleSprintTextWidthPercentage, () -> config.toggleSprintTextWidthPercentage, newVal -> config.toggleSprintTextWidthPercentage = newVal)
                                .controller(opt -> FloatSliderControllerBuilder.create(opt)
                                        .formatValue(value -> Text.literal(String.format("%,.0f", value) + "%"))
                                        .range(0F, 100F)
                                        .step(1F))
                                .build())
                        .option(Option.<Float>createBuilder()
                                .name(Text.literal("Position Y"))
                                .binding(defaults.toggleSprintTextHeightPercentage, () -> config.toggleSprintTextHeightPercentage, newVal -> config.toggleSprintTextHeightPercentage = newVal)
                                .controller(opt -> FloatSliderControllerBuilder.create(opt)
                                        .formatValue(value -> Text.literal(String.format("%,.0f", value) + "%"))
                                        .range(0F, 100F)
                                        .step(1F))
                                .build())
                        .build())

        )).generateScreen(parent);
    }

    public static void register() {
        TrueToggleSprintConfig.CONFIG.load();
    }
}
