package pers.ljf.spring.debug;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.entity.MyBeanPostProcessor;
import pers.ljf.spring.debug.entity.MyDestructionAwareBeanPostProcessor;
import pers.ljf.spring.debug.selfeditor.Address;
import pers.ljf.spring.debug.selfeditor.AddressPropertyEditor;
import pers.ljf.spring.debug.selfeditor.MyPropertyEditorRegistrar;
import pers.ljf.spring.debug.xml.MyDefaultBeanDefinitionDocumentReader;
import pers.ljf.spring.debug.xml.MyXmlBeanDefinitionReader;

import java.io.IOException;

/**
 * @author: ljf
 * @date: 2021/3/25 19:38
 * @description: 实现initPropertySources方法
 * 实现spring的扩展形式
 * 1.通过重写ClassPathXMLApplicationContext中的方法，添加自己自定义的类
 * 2.通过xml文件注入一些自定义的类
 * @modified By：
 * @version: $ 1.0
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {


	public MyClassPathXmlApplicationContext(String... configLocations) {
		super(configLocations);
	}

	@Override
	protected void initPropertySources() {
		System.out.println("invoke initPropertySources method");
		getEnvironment().setRequiredProperties("username");
	}

	@Override
	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
		//允许覆盖同名称的不同定义的对象
		this.setAllowBeanDefinitionOverriding(true);
		//允许bean之间的循环依赖
		this.setAllowCircularReferences(true);
		super.customizeBeanFactory(beanFactory);

		//添加bean注销是调用的BeanPostProcessor
		beanFactory.addBeanPostProcessor(new MyDestructionAwareBeanPostProcessor());
		//添加BeanPostProcessor处理器，在对象实例化的init-method标签前后调用
		beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());
		//自定义bean对象属性解析器 下面方式任选其一
		beanFactory.registerCustomEditor(Address.class, AddressPropertyEditor.class);
//		beanFactory.addPropertyEditorRegistrar(new MyPropertyEditorRegistrar());
	}

	@Override
	protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
		// Create a new XmlBeanDefinitionReader for the given BeanFactory.
		XmlBeanDefinitionReader beanDefinitionReader = new MyXmlBeanDefinitionReader(beanFactory);

		//添加解析xml文件前后的处理方法
		beanDefinitionReader.setDocumentReaderClass(MyDefaultBeanDefinitionDocumentReader.class);

		// Configure the bean definition reader with this context's
		// resource loading environment.
		beanDefinitionReader.setEnvironment(this.getEnvironment());
		beanDefinitionReader.setResourceLoader(this);
		beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(this));

		// Allow a subclass to provide custom initialization of the reader,
		// then proceed with actually loading the bean definitions.
		initBeanDefinitionReader(beanDefinitionReader);
		loadBeanDefinitions(beanDefinitionReader);
	}
}
