package final1213;

import java.util.InputMismatchException;

public class CandidateEvent {
	final String event_channel_id;
	
	final double event_energy;
	
	public CandidateEvent(String input_channel_id, double input_energy) {
		if (input_channel_id.equals("GG") | input_channel_id.equals("ZZ")) {event_channel_id = input_channel_id;} 
		else {throw new InputMismatchException("ERROR: Invalid Channel ID. It must be either GG or ZZ.");}
		event_energy = input_energy;
	}

	@Override
	public String toString() {
		return "CandidateEvent [event_channel_id=" + event_channel_id
				+ ", event_energy=" + event_energy + "]";
	}
	
}
