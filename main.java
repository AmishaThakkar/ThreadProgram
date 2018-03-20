
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadAA a=new ThreadAA();/*Class ThreadAA contains functionalities which computes time 
		                          assigning no priority to threads,assigning threads to different cores
		                          (same core)and assigning different priorities(even equal) to the thread pair.*/
		a.no_priority();
		a.with_core();
		a.with_priority();
		
		ThreadBB b=new ThreadBB();/*Class ThreadBB contains functionalities which computes time 
                                    assigning no priority to threads,assigning threads to different cores
                                    (same core)and assigning different priorities(even equal) to the thread pair.*/
	    b.no_priority();
		b.with_core();
		b.with_priority(); 
		
		ThreadAB ab=new ThreadAB();/*Class ThreadAB contains functionalities which computes time 
                                     assigning no priority to threads,assigning threads to different cores
                                    (same core)and assigning different priorities(even equal) to the thread pair.*/
		ab.no_priority();
		ab.with_core();
		ab.with_priority();
	}

}
