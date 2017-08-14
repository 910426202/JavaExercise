package TestThread;

/**
 * Created by panting1 on 2017/8/6.
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run(){
        for (int i=0; i < 5; i++){
            System.out.println(i);
            try{
                Thread.sleep(100);//ms
            }catch (Exception e){
                System.out.println(e.toString());
            }

        }
    }
}
