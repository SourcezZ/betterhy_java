package com.betterhy.db;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * @author Source
 */
public class MapperBeanNameGenerator implements BeanNameGenerator{

	@Override
	public String generateBeanName(BeanDefinition definition,
			BeanDefinitionRegistry registry) {
		return definition.getBeanClassName();
	}

}
