package polymorphism3;

public class SamsungTV implements TV {
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV ����");
	}
	public void ��������ʱ�ȭ() {
		System.out.println("---> ��������ʱ�ȭ() ȣ��");
		this.price = 1700000;
	}
	public void �ڿ�����() {
		System.out.println("---> �ڿ�����() ȣ��");
		this.price = 0;
	}
	public void powerOn() {
		System.out.println("SamsungTV---���� �Ҵ�." + price);
	}
	public void powerOff() {
		System.out.println("SamsungTV---���� ����.");
	}
	public void volumeUp() {
		System.out.println("SamsungTV---�Ҹ� �ø���.");
	}
	public void volumeDown() {
		System.out.println("SamsungTV---�Ҹ� ������.");
	}
}
