package Dao;

import java.util.ArrayList;

import Model.Divination;

public class Divination_Logic {
	public Divination divination_execute() {

		String divination_id = "D000";

		int number = (int) (Math.random() * 38) + 1; // 1〜38
		String snum = Integer.toString(number);

		if (number <= 9) {
			divination_id = divination_id + "0" + snum;
		} else {
			divination_id = divination_id + snum;
		}

		Divination_Dao divination = new Divination_Dao();
		ArrayList<Divination> divination_list = divination.DivinationfindAll();

		for (Divination div : divination_list) {
			if (div.getDivination_id().equals(divination_id)) {
				return div;
			}

		}
		return null;
	}
}
