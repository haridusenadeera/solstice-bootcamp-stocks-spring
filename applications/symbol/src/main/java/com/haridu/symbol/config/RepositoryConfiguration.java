package com.haridu.symbol.config;

import com.haridu.symbol.entity.Symbol;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;


/**
 * Spring Data REST does not expose IDs by default through the REST endpoint.
 * Therefore, customize Symbol entity to expose it's ID.
 */
@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Symbol.class);
    }
}