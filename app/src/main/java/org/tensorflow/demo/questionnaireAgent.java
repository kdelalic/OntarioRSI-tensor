package org.tensorflow.demo;

import java.util.ArrayList;

/**
 * Created by Kshitij on 2018-04-08.
 */

public class questionnaireAgent {
    public ArrayList<Integer> questionnaireAgent() {
        MainActivity choices = new MainActivity();
        String colour = choices.colorChoice;
        String shape = choices.shapeChoice;
        String desc = choices.descChoice;
        ArrayList<Integer> answer = new ArrayList<Integer>();

        if (colour.equals("Red")) { 						// RED
            if (shape.equals("Triangle")) { 					// TRIANGLE
                if (desc.equals("Animal")) {						// ANIMAL
                    answer.add(31);
                } else if (desc.equals("Arrows")) {					// ARROWS
                    answer.add(11);
                    answer.add(19);
                    answer.add(20);
                    answer.add(21);
                } else if (desc.equals("People")) {					// PEOPLE
                    answer.add(25);
                    answer.add(27);
                    answer.add(28);
                } else if (desc.equals("Inanimate object")) {		// INANIMATE OBJECT
                    answer.add(18);
                    answer.add(22);
                    answer.add(24);
                    answer.add(26);
                    answer.add(30);
                } else if (desc.equals("Vehicle")) {				// VEHICLE
                    answer.add(23);
                    answer.add(29);
                } else {											// UPSIDE DOWN
                    answer.add(13);
                }
            } else if (shape.equals("Ring/Circle")) {			// RING/CIRCLE
                if (desc.equals("Number")) {						// NUMBER
                    for (int i = 0; i < 9; i++)
                        answer.add(i);
                } else if (desc.equals("Vehicle")) {				// VEHICLE
                    answer.add(15);
                    answer.add(16);
                } else if (desc.equals("Two Vehicles")) {			// TWO VEHICLES
                    answer.add(9);
                    answer.add(10);
                } else {											// WHITE LINE
                    answer.add(17);
                }
            } else {											// OCTAGON
                answer.add(14);
            }
        } else if (colour.equals("Yellow")) { 			// YELLOW
            answer.add(12);
        } else if (colour.equals("Blue")) {				// BLUE
            for (int i = 33; i < 41; i++)
                answer.add(i);
        } else { 										//GREY
            if (desc.equals("No Image"))					// NO IMAGE
                answer.add(32);
            else {											// TWO VEHICLES
                answer.add(41);
                answer.add(42);
            }
        }

        return answer;
    }

}
