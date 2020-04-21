package test;

import java.util.List;

import model.GetMutterListLogic;
import model.Mutter;

public class TestDAO {

	public static void main(String[] args) {
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		for(Mutter mutter : mutterList){
		System.out.println(mutter.getUserName()+":"+ mutter.getText());
		}
	}

}
