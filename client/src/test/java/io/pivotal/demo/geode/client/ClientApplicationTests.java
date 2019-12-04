package io.pivotal.demo.geode.client;

import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Region;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ClientApplicationTests {

    @Autowired
    private GemFireCache cache;

    @Autowired
    @Qualifier("customer")
    private Region customerRegion;

    @Test
    void contextLoads() {
        assertThat(cache).isNotNull();
        assertThat(customerRegion).isNotNull();
    }

}