package gomip.core.singleton;

public class SingletonService {
    // 클래스 레벨에 올라가기 때문에 딱 한개만 존재하게 된다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService() {
    }

    public void login() {
        System.out.println("싱글톤이지요");
    }
}
