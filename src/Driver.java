
import java.util.Iterator;

public class Driver {
 
  public static void main(String[] args) {
	MusicLinkedList list = new MusicLinkedList(2.0, 2);
//	MusicLinkedList list2 = new MusicLinkedList(3.5, 3);
 
    list.addSample(7);
    list.addSample(4);
    
    Iterator<Float> itr =  list.iterator(1);
	  while(itr.hasNext()) {
	  float curr =  itr.next();
	  System.out.println(curr);
	}
  }
}