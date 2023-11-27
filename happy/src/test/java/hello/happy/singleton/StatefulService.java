package hello.happy.singleton;

public class StatefulService { // Ctrl + Shift + T = 테스트 작성

//    private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

}
