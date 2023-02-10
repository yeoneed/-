package polymorphism3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	
	// 1. �ݵ�� Speaker Ÿ���� ��ü�� �޸𸮿� �����ؾ� �Ѵ�. 
	// 2. �ݵ�� Speaker Ÿ���� ��ü�� �޸� ������ �����ؾ� �Ѵ�. 
	@Autowired // Type Injection
	//@Qualifier("sony")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV ����");
	}
	public void powerOn() {
		System.out.println("LgTV---���� �Ҵ�.");
	}
	public void powerOff() {
		System.out.println("LgTV---���� ����.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
