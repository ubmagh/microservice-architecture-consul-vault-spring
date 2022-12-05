package me.ubmagh.billingservice.web;

import lombok.AllArgsConstructor;
import me.ubmagh.billingservice.config.Config;
import me.ubmagh.billingservice.config.VaultConfig;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ConfigRestController {

    private Config config;
    private VaultConfig vaultConfig;

    @GetMapping("/config")
    public Map<String, Object> getConfig(){
        return Map.of("vaultConfig", vaultConfig, "consulConfig", config);
    }
}
