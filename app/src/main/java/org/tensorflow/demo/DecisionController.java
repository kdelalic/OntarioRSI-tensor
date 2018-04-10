package org.tensorflow.demo;

import java.util.ArrayList;

public class DecisionController {
	//questionnaire : ArrayList<Integer>
	//mapillary: String[]
	//tensorflow: int

	ArrayList<Integer> questionnaireData;
	String[] mapillaryRawData;
	int tensorflowData;

	public DecisionController (ArrayList<Integer> results, String[] mapillary, int result){
		this.questionnaireData = (ArrayList<Integer>) results.clone();
		this.mapillaryRawData = mapillary;
		this.tensorflowData = result;
	}
	
	
	public String comeToConsensus() {
		// take tensorflow result and check if it's in questionnaire and mapillary arrays
		
		// compare to questionnaire data
		for (int i = 0; i < questionnaireData.size(); i++) {
			if (tensorflowData == questionnaireData.get(i).intValue()) 
				 return translateConsensus(i);
		}
		
		// mapillary stuff
		int[] map = new int[mapillaryRawData.length];
		translateMapData(map);
		for (int i = 0; i < map.length; i++) {
			if (tensorflowData == map[i])
				return translateConsensus(i);
		}
		// if it's in neither of the other two agents' data, display 'unidentifiable sign'
		return "Unidentifiable sign!";
	}


	
	public String translateConsensus(int i) {
		switch (i) {
			case 0: return "Speed limit of 20";
			case 1: return "Speed limit of 30";
			case 2: return "Speed limit of 50";
			case 3: return "Speed limit of 60";
			case 4: return "Speed limit of 70";
			case 5: return "Speed limit of 80";
			case 6: return "End of 80 speed limit";
			case 7: return "Speed limit of 100";
			case 8: return "Speed limit of 120";
			
			case 9: return "No passing";
			case 10: return "No passing by vehicle over 3.5t";
			case 11: return "Priority to through traffic";
			case 12: return "Priority road";
			case 13: return "Yield";
			case 14: return "Stop";
			case 15: return "No motorized vehicles (of any type)";
			case 16: return "No trucks permitted";
			case 17: return "Do not enter";
			case 18: return "Danger point";
			
			case 19: return "Dangerous curve to the left";
			case 20: return "Dangerous curve to the right";
			case 21: return "Double curves, first to left";
			case 22: return "Bumpy road";
			case 23: return "Slippery road";
			case 24: return "Road narrows on right";
			case 25: return "Construction ahead";
			case 26: return "Traffic signals have primary priority";
			
			case 27: return "Pedestrians possible";
			case 28: return "Children possible";
			case 29: return "Bicycles possible";
			case 30: return "Snow or ice possible ahead";
			case 31: return "Wild animals possible";
			
			case 32: return "End of previous limitation";
			
			case 33: return "Must turn right";
			case 34: return "Must turn left";
			case 35: return "Must go straight";
			case 36: return "Must go straight or right";
			case 37: return "Must go straight or left";
			case 38: return "Keep right of traffic barrier";
			case 39: return "Keep left of traffic barrier";
			case 40: return "Roundabout";
			
			case 41: return "End of no passing";
			case 42: return "End of no passing by vehicles over 3.5t";
			
			default: return "Unidentifiable sign! Q.";
		}
	}

	public void translateMapData(int[] mapData) {
		for (int i = 0; i < mapData.length; i++) {
			switch(mapillaryRawData[i]) {
				
				case "regulatory--maximum-speed-limit-20--g1": mapData[i] = 0; //return "Speed limit of 20";
				case "regulatory--maximum-speed-limit-30--g1": mapData[i] = 1; //return "Speed limit of 30";
				case "regulatory--maximum-speed-limit-50--g1": mapData[i] = 2; //return "Speed limit of 50";
				case "regulatory--maximum-speed-limit-60--g1": mapData[i] = 3; //return "Speed limit of 60";
				case "regulatory--maximum-speed-limit-70--g1": mapData[i] = 4; //return "Speed limit of 70";
				case "regulatory--maximum-speed-limit-80--g1": mapData[i] = 5; //return "Speed limit of 80";
				// case 6: return "End of 80 speed limit";
				case "regulatory--maximum-speed-limit-100--g1": mapData[i] = 7; //return "Speed limit of 100";
				case "regulatory--maximum-speed-limit-120--g1": mapData[i] = 8; //return "Speed limit of 120";
				
				case "regulatory--no-overtaking--g1": mapData[i] = 9; //return "No passing";
				case "regulatory--no-overtaking-by-heavy-goods-vehicles--g1": mapData[i] = 10; //return "No passing by vehicle over 3.5t";
				case "regulatory--priority-road--g2": mapData[i] = 11; //return "Priority to through traffic";
				case "regulatory--priority-road--g1": mapData[i] = 12; //return "Priority road";
				case "regulatory--yield--g1": mapData[i] = 13; //return "Yield";
				case "regulatory--stop--g1": mapData[i] = 14; //return "Stop";
				// case 15: return "No motorized vehicles (of any type)";
				case "regulatory--no-heavy-goods-vehicles--g1": mapData[i] = 16; //return "No trucks permitted";
				case "regulatory--no-entry--g1": mapData[i] = 17; //return "Do not enter";
				case "warning--other-danger--g1": mapData[i] = 18; //return "Danger point";
				
				case "warning--curve-left--g1": mapData[i] = 19; //return "Dangerous curve to the left";
				case "warning--curve-right--g1": mapData[i] = 20; //return "Dangerous curve to the right";
				case "warning--double-curve-first-left--g1": mapData[i] = 21; //return "Double curves, first to left";
				case "warning--road-bump--g1": mapData[i] = 22; //return "Bumpy road";
				case "warning--slippery-road-surface--g1": mapData[i] = 23; //return "Slippery road";
				case "warning--road-narrows-right--g1": mapData[i] = 24; //return "Road narrows on right";
				case "warning--roadworks--g1": mapData[i] = 25; //return "Construction ahead";
				case "warning--traffic-signals--g1": mapData[i] = 26; //return "Traffic signals have primary priority";
				
				case "warning--pedestrians-crossing--g1": mapData[i] = 27; //return "Pedestrians possible";
				case "warning--children--g1": mapData[i] = 28; //return "Children possible";
				case "warning--bicycles-crossing--g1": mapData[i] = 29; //return "Bicycles possible";
				case "warning--icy-road--g1": mapData[i] = 30; //return "Snow or ice possible ahead";
				case "warning--wild-animals--g1": mapData[i] = 31; //return "Wild animals possible";
				
				//case 32: return "End of previous limitation";
				
				case "regulatory--turn-right-ahead--g1": mapData[i] = 33; //return "Must turn right";
				case "regulatory--turn-left-ahead--g1": mapData[i] = 34; //return "Must turn left";
				case "regulatory--go-straight--g1": mapData[i] = 35; //return "Must go straight";
				case "regulatory--go-straight-or-turn-right--g1": mapData[i] = 36; //return "Must go straight or right";
				case "regulatory--go-straight-or-turn-left--g1": mapData[i] = 37; //return "Must go straight or left";
				case "regulatory--keep-right--g1": mapData[i] = 38; //return "Keep right of traffic barrier";
				case "regulatory--keep-left--g1": mapData[i] = 39; //return "Keep left of traffic barrier";
				case "regulatory--roundabout--g1": mapData[i] = 40; //return "Roundabout";
				
				case "regulatory--no-overtaking--g4": mapData[i] = 41; //return "End of no passing";
				//case 42: return "End of no passing by vehicles over 3.5t";
			}
		}
	}
}

