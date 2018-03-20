import java.util.Random;

public class ThreadB implements Runnable {/*ThreadB is CPU intensive which is sorting random numbers
                                            in an array*/
	public void run(){
for(int i=0;i<=1000000000;i++)
{       Random rgen = new Random();  // Random number generator
        int[] nums = new int[10];  //array to store 10 random integers (1-10)

        //--- Initialize the array to the ints 1-10
        for (int j=0; j<nums.length; j++) {
            nums[j] = j;
        }

        //--- Shuffle by exchanging each element randomly
        for (int j=0; j<nums.length; j++) {
            int randomPosition = rgen.nextInt(nums.length);
            int temp = nums[j];
            nums[j] = nums[randomPosition];
            nums[randomPosition] = temp;
        }

        //Print results
        for (int j = 0; j < nums.length; j++){
        //System.out.print(nums[i]);
        System.out.print("");
	}
}	}}
