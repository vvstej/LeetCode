package medium;

import java.util.ArrayList;
import java.util.List;

public class PowerSets {

	public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
		List<List<Integer>> powerSet = new ArrayList<>();
		List<Integer> selectedSoFar = new ArrayList<>();
		recurse(inputSet, 0, selectedSoFar, powerSet);
		return powerSet;
	}

	private static void recurse(List<Integer> inputSet, int toBeSelected, List<Integer> selectedSoFar,
			List<List<Integer>> powerSet) {
		if(toBeSelected == inputSet.size()) {
			powerSet.add(new ArrayList<>(selectedSoFar));
			return;
		}
		selectedSoFar.add(inputSet.get(toBeSelected));
		recurse(inputSet, toBeSelected + 1, selectedSoFar, powerSet);
		selectedSoFar.remove(selectedSoFar.size()-1);
		recurse(inputSet, toBeSelected +1 , selectedSoFar, powerSet);
		
	}
	
	public static void main(String[] arg) {
		PowerSets sets = new PowerSets();
		List<Integer> inputSet = new ArrayList<>();
		inputSet.add(0);
		inputSet.add(1);
		inputSet.add(2);
		sets.generatePowerSet(inputSet);
	}
	
}
