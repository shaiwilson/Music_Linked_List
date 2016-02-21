

public class Driver {
 
  public static void main(String[] args) {
    LinkedList list = new LinkedList(2.0, 1);
    LinkedList list2 = new LinkedList(3.5, 3);
 
    float channel[] = new float[1, 2, 3];
    float channel2[] = new float[1, 2, 3];
    float channel3[] = new float[1, 2, 3];
    
    list.addSample(1);
    list.addSample(2);
    list.addSample(3);
 
    System.out.println("list = " + list);
    System.out.println();
  
  } 
}