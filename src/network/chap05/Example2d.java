package network.chap05;

class SumTaskD implements Runnable{
	int from, to;
	long result = -1;
	
	public SumTaskD(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public void run() {
		long sum = 0;
		for (int i = from; i <= to; ++i)
			sum += i;
		result = sum;
	}
	
	public long getResult() {
		return result;
	}
}

public class Example2d {
	public static void main(String[] args) throws InterruptedException{
		int from = 1, to = 5000000;	
		SumTaskC sumTask = new SumTaskC(from, to);
		Thread thread = new Thread(sumTask);
		thread.start();
		while(sumTask.getResult() == -1)
			Thread.sleep(100);
		System.out.print(from + "부터 " + to + " 까지 합계는 ");
		System.out.print(sumTask.getResult());
	}
}
