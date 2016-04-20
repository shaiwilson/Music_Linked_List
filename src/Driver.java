import java.util.Iterator;

public class Driver {
 
  public static void main(String[] args) {
	MusicLinkedList list = new MusicLinkedList(2.0, 2);
//	MusicLinkedList list2 = new MusicLinkedList(3.5, 3);
 
    list.addSample(7);
    list.addSample(4);
    list.addSample(8);
    
    Iterator<float[]> itr =  list.iterator();
    float[] curr;
	while(itr.hasNext()) {  
	System.out.println(itr.next());
	  
	  
	}
  }
}
