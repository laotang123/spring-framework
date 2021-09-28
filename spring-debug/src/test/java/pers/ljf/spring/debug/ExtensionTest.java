package pers.ljf.spring.debug;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.entity.Person;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: ljf
 * @date: 2021/9/26 9:41
 * @description: 扩展的测试
 * @modified By:
 * @version: $ 1.0
 */
public class ExtensionTest {
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

	/**
	 * 测试applicationContext的扩展
	 */
	@Test
	public void test01() throws IllegalAccessException {
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
