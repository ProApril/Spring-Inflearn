package hello.core.singleton;

public class SingletonService {

    // 싱글톤의 기본 구조
    // 싱글톤은 가급적 읽기만 가능한게 좋다.

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    // 싱글톤 기본구조 끝

}
