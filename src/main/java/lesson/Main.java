package lesson;

public class Main  {
    public static void main(String[] args) throws InterruptedException {
        // є декілька способі реалізації потоків
//    1. через класс який реалізує Runnable
//   створення потоку - як аргумент ми повинні передати обєкт типу Runnable - це інтерфейс з методом run() - він є функціональним
        Runnable runnable = () -> {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
        };
        Thread thread1 = new Thread(runnable, "thread-1");
        Thread thread2 = new Thread(runnable, "thread-2");
        Thread thread3 = new Thread(runnable, "thread-3");

        // Потік ніколи не починається з run - завжди зі start
        // якщо запустити run():
//        thread.run();
        //main: 0
        //main: 1
        //main: 2
        //main: 3
        //main: 4
//        ми не запустили потік - а просто викликали метод (main - це назва головного потоку)


//        АСИНХРОННІСТЬ..........................................................................................................

        //це приклад Asynchronous model in multi-threaded env. with provides paralelism concurency
        // кожна із тасок всеодно бються за місце під сонцем
//        thread1.start();
//        thread2.start();
//        thread3.start();

//        СИНХРОННІСТЬ...........................................................................................................

        // join звертається до потоку main (потік в якому він викликається) - спочатку Я завершу свою роботу а потім ти продовжуй свою роботу

//        thread1.start();
//        thread1.join();
//        thread2.start();
//        thread3.start();
//  System.out.println("code after threads in doc");
  // мейн зупиняється на джойні і жде коли він завершить
        // свою роботу після чого відкриє в нас по суті 3потоки - мейн і два треда працюютьпаралельно


        // Синхронність дає змогу позбутися конкуренції і наші таски будуть виконуватися послідовно
//        thread1.start();
//        System.out.println("code after first start");
//        thread1.join();
//        System.out.println("code after first join");
//        thread2.start();
//        thread2.join();
//        thread3.start();
//        thread3.join();
//        System.out.println("code after last join");
        //join необхідно ставити перед стартом наступного потоку
        // цей метод дає потоку найвищий пріорітет

    }
}
