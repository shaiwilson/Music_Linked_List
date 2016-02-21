import java.util.List;
import java.util.Iterator;
import java.util.Iterator;

public class MusicLinkedList implements MusicList
{

	/*----------------------------------------------------- */
	/* Private Data Members -- LinkedList                   */
	/*----------------------------------------------------- */

	private LinkedList head;
	private LinkedList tail;
	private int length;
	int numChannels = 0;
	int numSamples = 0;
	float sampleRate = 0;
	private LinkedList tempChannel;
	private LinkedList tempSample;
	MusicLinkedList SoundList;
	
	/*----------------------------------------------------- */
	/* Constructor -- LinkedList                            */
	/*----------------------------------------------------- */

	public MusicLinkedList() 
	{
		head = tail = null;
		length = 0;
		tempChannel = tempSample = new LinkedList();
	}
	
	/*----------------------------------------------------- */
	/* Public Methods -- LinkedList                         */
	/*----------------------------------------------------- */

	public void clear() 
	{
		head.setNextChannel(null);
		tail = head;
		length = 0;
	}

	public int size() 
	{
		return length;
	}
	
	public void addSample(float sampleRate)
	{
		if (head == null)
		{
			head = new LinkedList(sampleRate, null, null);
			tail = head;
		}
		else
		{
			tail.setNextSample(new LinkedList(sampleRate, null, null));
			tail = tail.nextSample();
		}
		
		numSamples++;
	}
	

	public void addSamplesMulti(float samples[]) 
	{
		LinkedList temp1 = new LinkedList(samples[0], null, null);
		LinkedList temp2 = temp1;
		
			for (int  i = 0; i < numChannels; i++)
			{
//				current.setNextChannel(new LinkedList(samples[i], null, null));
//				current = current.getNextSample();
				temp2.setNextChannel(new LinkedList(samples[i], null, null));
				temp2 = temp2.nextChannel();
			}
			if (head == null){
				head = temp1;
				tail = head;
				numSamples++;
			} else {
				LinkedList temp3 = temp1;
				for (int i=0; i < numChannels;i++)
				{
					tail.setNextSample(temp3);
					tail = tail.nextChannel();
					temp3 = temp3.nextChannel();
				}
				tail = temp1;
				numSamples++;
			
			}	
		} 


	public float getNextSample()
	{
		LinkedList tmp = head.nextSample;
		for (int i = 0; i < length; i++)
		{
			tmp = tmp.nextSample;
		}
		return tmp.samples;
	}
	
	public LinkedList getNextChannel()
	{
		LinkedList tmp = head.nextChannel;
		for (int i = 0; i < length; i++)
		{
			tmp = tmp.nextChannel;
		}
		return tmp.nextChannel();
	}


	public InnerIterator listIterator() 
	{
		return new InnerIterator(0);
	}


	public IteratorMulti listIterator(int nextChannel) 
	{
		return new IteratorMulti(nextChannel);
	}


	/*----------------------------------------------------- */
	/* Nested class -- Link                                 */
	/*----------------------------------------------------- */


	public class LinkedList{

		/*----------------------------------------------------- */
		/*  Private Data Members -- Link                        */ 
		/*----------------------------------------------------- */

		private float samples;
		private LinkedList nextSample;
		private LinkedList nextChannel;

		/*----------------------------------------------------- */
		/*  Constructors -- Link                                */ 
		/*----------------------------------------------------- */

		public LinkedList(Float samples, LinkedList nextSample, LinkedList nextChannel) {
			this.samples = samples;
			this.nextSample = nextSample;
			this.nextChannel = nextChannel;
			
		}

		public LinkedList() { }

		/*----------------------------------------------------- */
		/*  Access Methods -- Link                              */ 
		/*----------------------------------------------------- */

		public LinkedList nextSample() {
			return nextSample; 
		}
		
		public LinkedList nextChannel(){
			return nextChannel; 
		}

		public void setNextSample(LinkedList nextelem) {
			nextSample = nextelem;
		}
		
		public void setNextChannel(LinkedList nextelem) {
			nextChannel = nextelem;
		}
	}

	/*----------------------------------------------------- */
	/* Nested class -- InnerIterator                        */
	/*----------------------------------------------------- */

	private class InnerIterator implements Iterator<Float>{

		/*----------------------------------------------------- */
		/*  Private Data Members -- InnerIterator               */ 
		/*----------------------------------------------------- */

		private LinkedList current;
		private LinkedList temp;
		
		/*----------------------------------------------------- */
		/*  Constructor -- InnerIterator                        */ 
		/*----------------------------------------------------- */

		public InnerIterator(int index) 
		{
			current = head;
			
			for (int i = 0; i < index; i++)
			{
				temp = current.nextChannel();
			}
		}

		/*----------------------------------------------------- */
		/* Public Methods -- InnerIterator                      */
		/*----------------------------------------------------- */
		
		@Override
		public Float next() 
		{

			current = temp;
			current = current.nextSample();
			return temp.samples;
			
		}

		public boolean hasNext()
		{
			return current != null && current.nextSample != null;
		}

	}
	
	/*----------------------------------------------------- */
	/* Nested class -- IteratorMulti                       */
	/*----------------------------------------------------- */

	private class IteratorMulti implements Iterator<float[]>{

		/*----------------------------------------------------- */
		/*  Private Data Members -- InnerIterator               */ 
		/*----------------------------------------------------- */

		private LinkedList current;
		private LinkedList temp;
		
		/*----------------------------------------------------- */
		/*  Constructor -- InnerIterator                        */ 
		/*----------------------------------------------------- */

		public IteratorMulti(int index) 
		{
			current = head;
			
			for (int i = 0; i < index; i++)
			{
				temp = current.nextChannel();	
			}
		}

		/*----------------------------------------------------- */
		/* Public Methods -- InnerIterator                      */
		/*----------------------------------------------------- */
		
		@Override
		public float[] next() 
		{
			temp = current;
			
			current = current.nextSample();
			return temp.samples;
		}

		public boolean hasNext()
		{
			return current != null && current.nextChannel != null;
		}
	}
}


