
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProducerConsumer {
    Random random = new Random();
    
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    //queue size 10 olana kadar devam edecek
    //arrayBlockingQueue threadlerle güvenilir bir şekilde çalışıyor
    
    
    public void produce() {
        
        while (true) {
            //sonsuza giden bir döngü oluşturdum
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            try {
                Integer value =  random.nextInt(100);
            
                queue.put(value);
                //değeri ArrayBlockingQueue ye atmak için put kullanılıyor
                
                System.out.println("Producer Üretiyor : " + value);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }
    public void consume(){
        //producer ve consumer sleep değerlerini değiştirerek farkli sonuçlar elde edebilirsin
        
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                Integer value =  queue.take();
                //kuyruğun başındaki değeri almak için kullanılıyor
                System.out.println("Consumer tüketiyor : " + value);
                
                System.out.println("Queue Size: " + queue.size());
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
        }
    }
   
    
    
}
