package io.springframework.common.config;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

/**
 * 根据Class无参构造函数创建Bean并注入容器的注射器
 *
 * @author Wilson
 */
@Slf4j
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties("spring.common.injector")
public class ClassBeanInjector implements ApplicationContextAware {
	private ConfigurableListableBeanFactory beanFactory;
	/**
	 * 需注入的无参构造Class列表
	 */
	@Setter
	private List<Class<?>> classes;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (applicationContext instanceof AbstractRefreshableApplicationContext) {
			beanFactory = ((AbstractRefreshableApplicationContext) applicationContext).getBeanFactory();
		} else {
			beanFactory = ((GenericApplicationContext) applicationContext).getBeanFactory();
		}
	}

	@PostConstruct
	public void init() {
		Optional.ofNullable(classes)
				.filter(classes -> !classes.isEmpty())
				.ifPresent(classes -> classes.forEach(clz -> {
					try {
						//Class<?> clz = Class.forName(clazz);
						String beanName = StringUtils.uncapitalize(clz.getSimpleName());
						beanFactory.registerSingleton(beanName, clz.newInstance());
					} catch (InstantiationException | IllegalAccessException e) {
						log.error("Class {} can't find no args constructor.", clz, e);
					}
					log.info("All classes of {} already registered an instance in container", classes.toString()
							.replaceAll("class\\s", ""));
				}));
	}

}
