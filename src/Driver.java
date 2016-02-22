
import java.util.Iterator;

public class Driver {
 
  public static void main(String[] args) {
	MusicLinkedList list = new MusicLinkedList(2.0, 2);
//	MusicLinkedList list2 = new MusicLinkedList(3.5, 3);
 
    list.addSample(7);
    list.addSample(4);
    
    Iterator<Float> itr =  list.iterator(2);
    System.out.println("does this work before while");
	  while(itr.hasNext()) {
	  System.out.println("does this work after while");  
	  float curr =  itr.next();
	  System.out.println(curr);
	}
  }
}