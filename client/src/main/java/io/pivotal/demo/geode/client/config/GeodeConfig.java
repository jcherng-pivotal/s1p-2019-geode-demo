package io.pivotal.demo.geode.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.geode.config.annotation.EnableClusterAware;

@Configuration
@EnableEntityDefinedRegions(basePackages = "io.pivotal.demo.geode.client.model")
@EnableGemfireRepositories(basePackages = "io.pivotal.demo.geode.client.repository")
@EnableClusterAware
public class GeodeConfig {

}