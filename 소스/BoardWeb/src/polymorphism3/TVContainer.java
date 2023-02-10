package polymorphism3;

// Factory 패턴이 적용된 클래스
public class TVContainer {

	public Object getBean(String id) {
		if(id.equals("lg")) {
			return new LgTV();
		} else if(id.equals("samsung")) {
			return new SamsungTV();
		} else if(id.equals("google")) {
			return new GoogleTV();
		}
		return null;
	}
}
