package polymorphism3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// Spring �����̳ʸ� �����Ѵ�. 
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("applicationContext.xml");
		
		// �����̳ʷκ��� �ʿ��� ��ü�� ȹ��(Lookup)�Ѵ�.
		TV tv = (TV) container.getBean("tv");
		tv.powerOn();		
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
		
		// �����̳ʸ� �����Ѵ�.
		container.close();
	}

}
