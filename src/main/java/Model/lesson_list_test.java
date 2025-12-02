package Model;

import java.util.ArrayList;

import Dao.Divination_Dao;
import Dao.Divination_Logic;

public class lesson_list_test {

	public static void main(String[] args) {
		
		Divination_Dao dd = new Divination_Dao();
		
		ArrayList<Divination> dl = dd.DivinationfindAll();
		
		Divination_Logic dlogic = new Divination_Logic();
		
		Divination d = dlogic.divination_execute();
		
		System.out.println(d.getDivination_txt());
	}
}
