import net.openhft.affinity.AffinityLock;

public class ThreadBB {
	public void no_priority() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		ThreadB a=new ThreadB();
		System.out.println("Time of Thread B without Priority");	
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
		System.out.println("Time of Thread B with Priority");	
		ThreadB a=new ThreadB();
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
		System.out.println("Time of Thread B with core affinity");	
		ThreadB a=new ThreadB();
		
		  
		 AffinityLock al=AffinityLock.acquireCore();
		  try{
		  System.out.println("Assigning CPU 1 to thread B ");
		  Thread t=new Thread(a);
		  t.start();
			  }
		  finally
		  {al.release();}
		  
		  
		  AffinityLock al1=AffinityLock.acquireCore();
		  try{
		  System.out.println("Assigning CPU 2 to thread B ");
		  Thread t1=new Thread(a);
		 t1.start(); 
		  }
		  finally
		  {al1.release();}
		  
		  long stopTime5 = System.currentTimeMillis();
		  System.out.println(stopTime5 - startTime5);
		 	
	}

}
