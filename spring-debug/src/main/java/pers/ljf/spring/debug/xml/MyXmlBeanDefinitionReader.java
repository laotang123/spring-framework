package pers.ljf.spring.debug.xml;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.BeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.DocumentLoader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author: ljf
 * @date: 2021/3/27 20:49
 * @description: 在xml解析前做一定处理
 * 实现父类模板方法(空方法)
 * @modified By:
 * @version: $ 1.0
 */
public class MyXmlBeanDefinitionReader extends XmlBeanDefinitionReader {
	/**
	 * Create new XmlBeanDefinitionReader for the given bean factory.
	 *
	 * @param registry the BeanFactory to load bean definitions into,
	 *                 in the form of a BeanDefinitionRegistry
	 */
	public MyXmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
		super(registry);
	}

	@Override
	public void setDocumentReaderClass(Class<? extends BeanDefinitionDocumentReader> documentReaderClass) {
		super.setDocumentReaderClass(documentReaderClass);
	}
}
