package final1213;

import java.util.InputMismatchException;

public class CandidateEvent {
	private enum ID {GG, ZZ};
	
	final ID event_channel_id;
	final double event_energy;
	
	public CandidateEvent(String input_channel_id, double input_energy) {
		if (input_channel_id == "GG") {event_channel_id = ID.GG;} 
		else if (input_channel_id == "ZZ") {event_channel_id = ID.ZZ;}
		else {throw new InputMismatchException("ERROR: Invalid Channel ID. It must be either GG or ZZ.");}
		event_energy = input_energy;
	}

	public ID getEvent_channel_id() {
		return event_channel_id;
	}

	public double getEvent_energy() {
		return event_energy;
	}
	
	
}
