public class Counter {

  long count = 0;

  public synchronized void inc() { // changed this to synchronized method
      count++;
  }

  public long getCount() {
      return count;
  }
}