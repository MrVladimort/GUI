package zadanie2;

public class StringTask implements Runnable {
	volatile TaskState ts;
	String result, text;
	int count;
	Thread task;
	
	public StringTask(String text, int count) {
		this.result = "";
		this.text = text;
		this.count = count;
		this.ts = TaskState.CREATED;
	}

	public TaskState getState() {
		return this.ts;
	}

	public void start(){
		this.task = new Thread(this);
		this.task.start();
	}
	
	public boolean isDone() {
		return this.ts == TaskState.READY || this.ts == TaskState.ABORTED;
	}

	public String getResult() {
		return this.result;
	}

	@Override
	public void run() {
        this.ts = TaskState.RUNNING;
        	
       	for(int i = 0; i < this.count && !this.task.isInterrupted(); i++)
       		this.result += this.text;
        	
        if(this.result.length() == this.count)
       		this.ts = TaskState.READY;
  	}

	public void abort() {
		this.task.interrupt();
		this.ts = TaskState.ABORTED;
	}
}