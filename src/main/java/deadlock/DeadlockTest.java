package deadlock;

public class DeadlockTest {
    /**
     * 死锁产生的4个必要条件
     *     1、互斥：某种资源一次只允许一个进程访问，即该资源一旦分配给某个进程，其他进程就不能再访问，直到该进程访问结束。
     *     2、占有且等待：一个进程本身占有资源（一种或多种），同时还有资源未得到满足，正在等待其他进程释放该资源。
     *     3、不可抢占：别人已经占有了某项资源，你不能因为自己也需要该资源，就去把别人的资源抢过来。
     *     4、循环等待：t1占有resource1,t2占有resource2，形成等待环路
     *
     */
    public static void main(String[] args) {
        Integer resource1 = 1;
        Integer resource2 = 2;
        new Thread(() -> {
            //while(true) {
                synchronized (resource1) {
                    System.out.println("线程1申请了资源1-value:"+resource1);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resource2){
                        System.out.println("线程1申请了资源2-value:" + resource2);
                    }
                }

            //}
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //while(true) {
                    synchronized (resource2) {
                        System.out.println("线程2申请了资源2-value:"+resource2);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (resource1){
                            System.out.println("线程2申请了资源1-value:" + resource1);
                        }
                    }


                //}
            }
        }).start();

    }
}
