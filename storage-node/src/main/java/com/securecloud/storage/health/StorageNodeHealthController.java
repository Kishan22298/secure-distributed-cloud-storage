
package com.securecloud.storage.health;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageNodeHealthController {

    @GetMapping("/api/v1/health")
    public Map<String, String> health() {
        return Map.of(
                "service", "storage-node",
                "status", "UP"
        );
    }
}
