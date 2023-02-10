package polymorphism3;

import java.util.Collection;
import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionUser {

	public static void main(String[] args) {
		// Spring �����̳ʸ� �����Ѵ�. 
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("applicationContext.xml");
		
		// �����̳ʷκ��� �ʿ��� ��ü�� ȹ��(Lookup)�Ѵ�.
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		Properties props = bean.getAddressList();
		
		System.out.println("�̸� ���");
		Collection<Object> nameList = props.keySet();
		for (Object name : nameList) {
			System.out.println("---> " + name.toString());
		}
		
		System.out.println("�ּ� ���");
		Collection<Object> addressList = props.values();
		for (Object address : addressList) {
			System.out.println("---> " + address.toString());
		}
		
		// �����̳ʸ� �����Ѵ�.
		container.close();
	}

}
