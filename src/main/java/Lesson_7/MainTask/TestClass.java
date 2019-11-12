package Lesson_7.MainTask;

class TestClass implements SuperTest {

    @Test(priority = 5)
    void method1() {
        System.out.println("test method 1");
    }

    @Test(priority = 1)
    void method2() {
        System.out.println("test method 2");
    }

    @Test(priority = 2)
    void method8() {
        System.out.println("test method 8");
    }

    @Test(priority = 9)
    void method9() {
        System.out.println("test method 9");
    }

    @Test(priority = 4)
    void method7() {
        System.out.println("test method 7");
    }

    @AfterSuite
    void method3() {
        System.out.println("AfterSuite method 3");
    }

    @BeforeSuite
    void method4() {
        System.out.println("BeforeSuite method 4");
    }

    @Test
    void method5() {
        System.out.println("test method 5");
    }
}
