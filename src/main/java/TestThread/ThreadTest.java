package TestThread;

/**
 * Created by panting1 on 2017/8/6.
 */
public class ThreadTest {
    public void run() {
        try{
            RunnableImpl runnable =  new RunnableImpl();
            Thread t = new Thread(runnable,"1-thread");
            t.start();
            for (int i=0 ; i< 5; i++){
                System.out.println("ThreadTest " + i);
                Thread.sleep(100);
            }

            t.join();

            System.out.println("ThreadTest  exit");
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
