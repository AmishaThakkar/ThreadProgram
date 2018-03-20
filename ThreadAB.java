import net.openhft.affinity.AffinityLock;

public class ThreadAB {
	public void no_priority() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		ThreadA a=new ThreadA();
		System.out.println("Time of Thread AB without Priority");	
		Thread t=new Thread(a);
		t.start();
		
		
		ThreadB b=new ThreadB();
		Thread t1=new Thread(b);
		t1.start();
		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime);
		
	}
	public void with_priority() {
		// TODO Auto-generated method stub
		long startTime3 = System.currentTimeMillis();
		System.out.println("Time of Thread AB with Priority");	
		ThreadA a=new ThreadA();
		ThreadB b=new ThreadB();
		Thread t=new Thread(a);
		Thread t1=new Thread(b);
		t.setPriority(Thread.MAX_PRIORITY);
		t1.setPriority(Thread.MIN_PRIORITY);
			
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
		 ThreadB b=new ThreadB();
		 		 
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
		  System.out.println("Assigning CPU 2 to thread B ");
		  Thread t1=new Thread(b);
		 t1.start(); 
		  }
		  finally
		  {al1.release();}
		  
		  long stopTime5 = System.currentTimeMillis();
		  System.out.println(stopTime5 - startTime5);
		 	
	}
}
