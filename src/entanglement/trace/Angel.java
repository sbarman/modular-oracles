/**
 * 
 */
package entanglement.trace;

import java.util.Arrays;


/**
 * Represents an angel that generates values in a given set of {@linkplain Traces}.
 * 
 * @specfield traces: Traces
 * @specfield id: String
 * @specfield maxValue: int
 * @invariant maxValue >= 0
 * @invariant all a: Angel - this | a.traces = this.traces => a.id != this.id
 * @author etorlak
 */
public final class Angel {

	private final String id;
	private final int maxValue;
	
	private Angel(String id, int maxValue) {
		if (maxValue < 0) 
			throw new IllegalArgumentException("Maximum value generated by an angel cannot be negative: " + maxValue);
		this.id = id;
		this.maxValue = maxValue;
	}
	
	/** 
	 * Returns an array of Angels such that the maximum value of the ith angel is given by the
	 * ith value.  This method assumes that all values in the string are non-negative.
	 * @return an array of Angels with the given maximum values 
	 **/
	static Angel[] angels(int[] maxVals) { 
		final Angel[] angels = new Angel[maxVals.length];
		for(int i = 0; i < maxVals.length; i++) { 
			final int maxVal = maxVals[i];
			if (maxVal < 0) 
				throw new IllegalArgumentException("Maximum value generated by an angel cannot be negative: " + Arrays.toString(maxVals));
			angels[i] = new Angel("a"+i, maxVal);
		}
		return angels;
	}
	
	/**
	 * Returns the maximum value generated by this angel in this.traces.
	 * @return this.maxValue
	 */
	public int maxValue() { return maxValue; }
	
	/**
	 * Returns the unique id of this angel in this.traces.
	 * @return this.id
	 */
	public String id() { return id; }
	
	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	public String toString() { return id + "::[0.." + maxValue + "]"; }
}
