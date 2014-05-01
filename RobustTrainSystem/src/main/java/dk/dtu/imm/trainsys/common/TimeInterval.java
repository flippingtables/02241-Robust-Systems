package dk.dtu.imm.trainsys.common;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.ReadableInstant;

public class TimeInterval {

	public static final ReadableInstant INSTANT = null; // null means today

	private /*@ spec_public @*/ DateTime start;
	private /*@ spec_public @*/ DateTime end;

	public static void main(String[] args){
		TimeInterval t = new TimeInterval();
	}
	
	public TimeInterval() {
		this((LocalTime) null, null);
	}

	/**
	 * @param from
	 *            - null or a time (null = left unbounded == LocalTime.MIDNIGHT)
	 * @param to
	 *            - null or a time (null = right unbounded)
	 * @throws IllegalArgumentException
	 *             if invalid (to is before from)
	 */
	
	//@ assignable start,end;
	//@ ensures start!=null && end!=null && end.isAfter(start);
	public TimeInterval(LocalTime from, LocalTime to)
			throws IllegalArgumentException {
			this(from == null ? null : from.toDateTime(INSTANT), to == null ? null
				: to.toDateTime(INSTANT));
		
	}

	/**
	 * create interval spanning multiple days possibly.
	 * 
	 * @param start
	 *            - start distinct time
	 * @param end
	 *            - end distinct time
	 * @throws IllegalArgumentException
	 *             - if start > end. start must be <= end
	 */
	//@ assignable this.start,this.end;
	//@ ensures this.start!=null && this.end!=null && this.end.isAfter(this.start);
	public TimeInterval(DateTime start, DateTime end)
			throws IllegalArgumentException {
		this.start = start;
		this.end = end;
		if (start != null && end != null && start.isAfter(end))
			throw new IllegalArgumentException(
					"start must be less or equal to end");
	}

	public /*@ pure @*/ DateTime getStart() {
		return start;
	}

	public /*@ pure @*/ DateTime getEnd() {
		return end;
	}

	public /*@ pure @*/ boolean isEndUndefined() {
		return end == null;
	}

	public /*@ pure @*/ boolean isStartUndefined() {
		return start == null;
	}

	public /*@ pure @*/ boolean isUndefined() {
		return isEndUndefined() && isStartUndefined();
	}

	public /*@ pure @*/  boolean overlaps(TimeInterval other) {
		return (start == null || (other.end == null || start
				.isBefore(other.end)))
				&& (end == null || (other.start == null || other.start
						.isBefore(end)));
	}

	public /*@ pure @*/  boolean contains(TimeInterval other) {
		return ((start != null && other.start != null && !start
				.isAfter(other.start)) || (start == null))
				&& ((end != null && other.end != null && !other.end
						.isAfter(end)) || (end == null));
	}

	public /*@ pure @*/ boolean contains(LocalTime other) {
		return contains(other == null ? null : other.toDateTime(INSTANT));
	}

	public /*@ pure @*/ boolean containsEnd(DateTime other) {
		if (other == null) {
			return end == null;
		} else {
			return (start == null || !other.isBefore(start))
					&& (end == null || !other.isAfter(end));
		}
	}

	public /*@ pure @*/ boolean contains(DateTime other) {
		if (other == null) {
			return start == null;
		} else {
			return (start == null || !other.isBefore(start))
					&& (end == null || other.isBefore(end));
		}
	}

	@Override
	// @ ensures \result != null && !(\result.length() == 0);
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("TimeInterval");
		sb.append("{start=").append(start);
		sb.append(", end=").append(end);
		sb.append('}');
		return sb.toString();
	}
}
