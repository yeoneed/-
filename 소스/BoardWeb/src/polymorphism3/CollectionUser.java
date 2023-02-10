package polymorphism3;

import java.util.Collection;
import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionUser {

	public static void main(String[] args) {
		// Spring 컨테이너를 생성한다. 
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("applicationContext.xml");
		
		// 컨테이너로부터 필요한 객체를 획득(Lookup)한다.
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		Properties props = bean.getAddressList();
		
		System.out.println("이름 목록");
		Collection<Object> nameList = props.keySet();
		for (Object name : nameList) {
			System.out.println("---> " + name.toString());
		}
		
		System.out.println("주소 목록");
		Collection<Object> addressList = props.values();
		for (Object address : addressList) {
			System.out.println("---> " + address.toString());
		}
		
		// 컨테이너를 종료한다.
		container.close();
	}

}
