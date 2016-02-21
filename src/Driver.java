public class Driver {
 
  public static void main(String[] args) {
	MusicLinkedList list = new MusicLinkedList(2.0, 2);
//	MusicLinkedList list2 = new MusicLinkedList(3.5, 3);
 

    list.addSample(7);
    System.out.println(list);
    list.addSample(4);
    System.out.println(list);
    
//    Iterator itr = tmp.iterator();
//    while(itr.hasNext()) {
//      int num = itr.next();
//      System.out.println(num);
//    }
//    
   
  } 
}