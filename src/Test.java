import org.apache.http.entity.ContentProducer;

import java.util.*;


public class Test{
    static class Work extends Thread{
        int num;
        public Work(int num, Map map){
            this.num = num;
        }
        @Override
        public void run() {



        }
    }

    public static void main(String[] args) {
        Map synchMap = Collections.synchronizedMap(new HashMap());
        Work work1 = new Work(1,synchMap);
        Work work2 = new Work(2,synchMap);
        Work work3 = new Work(3,synchMap);
        Work work4 = new Work(4,synchMap);
        Work work5 = new Work(5,synchMap);

        work1.start();
        work2.start();
        work3.start();
        work4.start();
        work5.start();


    }
}
