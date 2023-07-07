package org.github.laziness.infrastructure;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@ActiveProfiles("test")
public class DragonflyContainerIntegration {

    private static final String DRAGONFLY_DOCKER_IMAGE = "docker.dragonflydb.io/dragonflydb/dragonfly";
    protected static final GenericContainer<?> DRAGONFLY;

    static {
        DRAGONFLY = new GenericContainer<>(DockerImageName.parse(DRAGONFLY_DOCKER_IMAGE))
                        .withExposedPorts(6379)
                        .withReuse(true)
                        .withCommand("--cache_mode=true");

        DRAGONFLY.start();
    }

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.redis.host", DRAGONFLY::getHost);
        registry.add("spring.data.redis.port",
                () -> String.valueOf(DRAGONFLY.getMappedPort(6379))
        );
    }
}
