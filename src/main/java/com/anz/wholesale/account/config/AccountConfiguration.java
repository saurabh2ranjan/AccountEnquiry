package com.anz.wholesale.account.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.anz.wholesale.account.domain")
@EnableJpaRepositories(basePackages = "com.anz.wholesale.account.repository")
public class AccountConfiguration {
}
