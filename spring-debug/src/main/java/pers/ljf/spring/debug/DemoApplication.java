package pers.ljf.spring.debug;


import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;

import groovy.util.logging.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.lang.Nullable;
import pers.ljf.spring.debug.entity.Person;
import pers.ljf.spring.debug.entity.PersonAware;
import pers.ljf.spring.debug.entity.PersonLifecycle;
import pers.ljf.spring.debug.selfeditor.Customer;


/**
 * @author: ljf
 * @date: 2021/3/24 6:40
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
@Slf4j
public class DemoApplication {
	static class Demo01ApplicationContext extends ClassPathXmlApplicationContext {
		static {
			//添加系统属性，保证在解析context中的configLocation的占位符时，可以获取相应属性
			System.setProperty("p001", "a");
			System.out.println("添加系统属性p001");
		}

		public Demo01ApplicationContext(String... configLocations) throws BeansException {

			super(configLocations);
		}

		@Override
		protected void initPropertySources() {
			//验证必要属性，可以从命令行中输入，加入必要属性集
			//命令行添加属性 -Dproperty=value
			getEnvironment().setRequiredProperties("p001");
			getEnvironment().setRequiredProperties("p002");
		}

		@Override
		protected void customizeBeanFactory(@NotNull DefaultListableBeanFactory beanFactory) {
			setAllowBeanDefinitionOverriding(false);
			setAllowCircularReferences(false);
			super.customizeBeanFactory(beanFactory);

		}
	}

	static HashMap<Class<?>, Map<String, Field>> class2Field = new HashMap<>();

	static Field getFieldFromParent(String fieldName, Class<?> clazz) {
		Map<String, Field> stringFieldMap = class2Field.computeIfAbsent(clazz, aClass -> {
			HashMap<String, Field> fieldHashMap = new HashMap<>();
			while (aClass != null) {  // 遍历所有父类字节码对象
				Field[] declaredFields = aClass.getDeclaredFields();
				for (Field field : declaredFields) {
					fieldHashMap.put(field.getName(), field);
				}

				aClass = aClass.getSuperclass();
			}
			return fieldHashMap;
		});

		return stringFieldMap.get(fieldName);


	}

	public static void main(String[] args) throws IllegalAccessException {
		ClassPathXmlApplicationContext context = new Demo01ApplicationContext("spring-${p001}.xml");
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		Person person = context.getBean(Person.class);
		System.out.println(person);


		System.out.println(context.getEnvironment().getProperty("p002"));

		//方法覆盖
		System.out.println(((DefaultListableBeanFactory) context.getBeanFactory()).isAllowBeanDefinitionOverriding());


		Field field = getFieldFromParent("allowCircularReferences", context.getBeanFactory().getClass());
		//反射获取循环依赖的属性值
		assert field != null;
		field.setAccessible(true);
		System.out.println(field.get(context.getBeanFactory()));


	}
}
