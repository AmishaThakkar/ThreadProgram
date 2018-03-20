import net.openhft.affinity.AffinityLock;

public class ThreadAA{

public void no_priority() {
	// TODO Auto-generated method stub
	long startTime = System.currentTimeMillis();
	ThreadA a=new ThreadA();
	System.out.println("Time of Thread A without Priority");	
	
	Thread t=new Thread(a);
	t.start();
	
	Thread t1=new Thread(a);
	t1.start();
	long stopTime = System.currentTimeMillis();
	System.out.println(stopTime - startTime);
	
}
public void with_priority() {
	// TODO Auto-generated method stub
	long startTime3 = System.currentTimeMillis();
	System.out.println("Time of Thread A with Priority");	
	ThreadA a=new ThreadA();
	Thread t=new Thread(a);
	Thread t1=new Thread(a);
	t.setPriority(Thread.MIN_PRIORITY);
	t1.setPriority(Thread.MAX_PRIORITY);
	
	t.start();
	
	
	t1.start();
	long stopTime3 = System.currentTimeMillis();
	System.out.println(stopTime3 - startTime3);
	
}

public void with_core() {
	// TODO Auto-generated method stub
	long startTime5 = System.currentTimeMillis();
	System.out.println("Time of Thread A with core affinity");	
	ThreadA a=new ThreadA();
	
	  AffinityLock al=AffinityLock.acquireCore();
	  try{
	  System.out.println("Assigning CPU 1 to thread A ");
	  Thread t=new Thread(a);
	  t.start();
		  }
	  finally
	  {al.release();}
	  
	  
	  AffinityLock al1=AffinityLock.acquireCore();
	  try{
	  System.out.println("Assigning CPU 2 to thread A ");
	  Thread t1=new Thread(a);
	 t1.start(); 
	  }
	  finally
	  {al1.release();}
	  
	  long stopTime5 = System.currentTimeMillis();
	  System.out.println(stopTime5 - startTime5);
	 	
}

}
