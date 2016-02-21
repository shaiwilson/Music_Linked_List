import java.util.List;
import java.util.Iterator;

public class MusicLinkedList implements MusicList
{

	/*----------------------------------------------------- */
	/* Private Data Members -- Node                   */
	/*----------------------------------------------------- */

	private Node head = null;
	private Node tail;
	private int length = 0;
	int numChannels = 0;
	int numSamples = 0;
	double sampleRate = 0;
	MusicLinkedList SoundList;
	
	/*----------------------------------------------------- */
	/* Constructor -- Node                            */
	/*----------------------------------------------------- */

	public MusicLinkedList(int channels) 
	{
		numChannels = channels;
		System.out.println("numChannels : " + numChannels);
		
	}
	
	public MusicLinkedList(double sampleRate, int numChannels) 
	{
		this.sampleRate = sampleRate;
		this.numChannels = numChannels;
		System.out.println("numChannels : " + numChannels);
		
	}
	
	/*----------------------------------------------------- */
	/* Public Methods -- Node                         */
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

	public float getNextSample()
	{
		Node tmp = head.nextSample;
		for (int i = 0; i < length; i++)
		{
			tmp = tmp.nextSample;
		}
		return tmp.samples;
	}
	
	public Node getNextChannel()
	{
		Node tmp = head.nextChannel;
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

	public int getNumChannels() {
		return numChannels;
	}
	
	/**
	 * Returns the sample rate, in samples per second
	 * @return The sample rate, in samples per second
	 */
	public float getSampleRate() {
		return 0;
	}
	
	
	/**
	 * Returns the number of samples in the MusicList
	 * @return The number of samples in the MusicList.
	 */
	public int getNumSamples() {
		return numSamples;
	}
	
	/**
	 * Returns The duration of the sound, in seconds.
	 * @return  the duration of the sound, in seconds.
	 */
	public float getDuration() {
		return 0;
	}
	
	/**
	 * Add an echo effect to the SoundList.  
	 * @param delay The time (in seconds) before the echo starts
	 * @param percent The percent falloff of the echo (0.5 is 50 percent volume, 0.25 is
	 *        25 percent volume, and so on.  All samples should be clipped to the range -1 .. 1
	 */
	public void addEcho(float delay, float percent) {
	}
	
	/**
	 * Reverse the SoundList.  
	 */
	public void reverse() {
	}
	
	/**
	 * Change the speed of the sound.   
	 * @param percentChange  How much to change the speed.  1.0 is no change, 2.0 doubles the speed (and the pitch), 0.5 
	 * cuts the speed in half (and lowers the pitch)
	 */
	public void changeSpeed(float percentChange) {
	}
	
	/**
	 * Change the sample rate of the SoundList.  This will increase (or decrease) the number of samples in the list, based on
	 * the new rate.  The total time (and pitch) of the sound should remain the same. (Though of course you will lose information
	 * if the new sample rate is lower than the old sample rate)
	 * @param newRate the new sampling rate
	 */
	public void changeSampleRate(float newRate) {
	}
	
	/**
	 * Add a single sample to the end of the SoundList.  Throws an exception if the soundlist has more than 1 channel 
	 * @param sample The sample to add
	 */
	public void addSample(float sample) {
		
		System.out.println("sample is : " + sample);
		if (head == null)
		{
			head = new Node(sample, null, null);
			tail = head;
		}
		else
		{
			tail.setNextSample(new Node(sample, null, null));
			tail = tail.nextSample();
		}
		
		numSamples++;
	}
	
	/**
	 * Adds a single sample for each channel to the end of the SoundList.  Throws an exception if the size of the sample 
	 * array is not the same as the number of channels in the sound list
	 * @param sample Array of samples (one for each channel) to add to the end of the SoundList
	 */
	
	
	public void addSample(float sample[]) {
		
		Node temp1 = new Node(sample[0], null, null);
		Node temp2 = temp1;
		
			for (int  i = 0; i < numChannels; i++)
			{
//				current.setNextChannel(new Node(samples[i], null, null));
//				current = current.getNextSample();
				temp2.setNextChannel(new Node(sample[i], null, null));
				temp2 = temp2.nextChannel();
			}
			if (head == null){
				head = temp1;
				tail = head;
				numSamples++;
			} else {
				Node temp3 = temp1;
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
	
	/**
	 * Return an iterator that traverses the entire sample, returning an array floats (one for each channel)
	 * @return iterator
	 */
	public Iterator<float[]> iterator() {
		return null;
	}
	
	/**
	 * Return an iterator that traverses a single channel of the list
	 * @param channel The channel to traverse
	 * @return the iterator to traverse the list
	 */
	public Iterator<Float> iterator(int channel) {
		return null;
	}
	
	/**
	 * Trim the Soundlist, by removing all samples before the startTime, and all samples past the duration.
	 * Note that if a SoundList represents an 8 second sound, and we call clip(4,2), the new SoundList will be
	 * a 2-second sound (from seconds 4-6 in the old SoundList)
	 * @param startTime Time to start (in seconds)
	 * @param duration Duration (in seconds)
	 */
	public void clip(float startTime, float duration) {
	}
	
	/**
	 * Splice a new SoundList into this soundList.  Both SoundLists will be modified.  If the sampleRate of the
	 * clipToSplice is not the same as this sampleList, it will be modified to match the current soundList.
	 * @param startSpliceTime Time to start the splice
	 * @param clipToSplice The other SoundClip to splice in.  
	 */
	public void spliceIn(float startSpliceTime, MusicList clipToSplice) {
	}
	
	/**
	 * Combine all channels into a single channel, by adding together all channels into a single channel.
	 * @param allowClipping If allowClipping is true, then values greater than 1.0 or less than -1.0 after the 
	 * addition are clipped to fit in the range.  If allowClipping is false, then if any values are greater than 1.0
	 * or less than -1.0, the entire sample is rescaled  to fit in the range.
	 */
	public void makeMono(boolean allowClipping) {
	}

	/**
	 * Combines this SoundList with a new soundlist, by adding the samples together.  This SoundList
	 * is modified. 
	 * @param clipToCombine  The clip to combine with this clip
	 * @param allowClipping  If allowClipping is true, then values greater than 1.0 or less than -1.0 after the 
	 * addition are clipped to fit in the range.  If allowClipping is false, then the entire sample is rescaled  
	 */
	public void combine(MusicList clipToCombine, boolean allowClipping) {
	}
	
	/**
	 * Returns a clone of this SoundList
	 * @return The cloned SoundList
	 */
	public MusicList clone() {
		return null;
	}

	/*----------------------------------------------------- */
	/* Nested class -- Link                                 */
	/*----------------------------------------------------- */


	public class Node{

		/*----------------------------------------------------- */
		/*  Private Data Members -- Link                        */ 
		/*----------------------------------------------------- */

		private float samples;
		private Node nextSample;
		private Node nextChannel;

		/*----------------------------------------------------- */
		/*  Constructors -- Link                                */ 
		/*----------------------------------------------------- */

		public Node(Float samples, Node nextSample, Node nextChannel) {
			this.samples = samples;
			this.nextSample = nextSample;
			this.nextChannel = nextChannel;
			
		}
//
//		public Node(double d, int i) { }

		/*----------------------------------------------------- */
		/*  Access Methods -- Link                              */ 
		/*----------------------------------------------------- */

		public Node nextSample() {
			return nextSample; 
		}
		
		public Node nextChannel(){
			return nextChannel; 
		}

		public void setNextSample(Node nextelem) {
			nextSample = nextelem;
		}
		
		public void setNextChannel(Node nextelem) {
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

		private Node current;
		private Node temp;
		
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

		private Node current;
		private Node temp;
		
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


