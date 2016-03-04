package test;

import model.SudokuModel;
import model.SudokuModel_v2;

public class TestModel {

	public static void main(String[] args) {
		SudokuModel sm = new SudokuModel();
//		sm.setValue(0, 0, 9);
//		sm.setValue(1, 0, 6);
		
		sm.setValue(0, 1, 4);
//		sm.setValue(3, 1, 5);
		sm.setValue(4, 1, 1);
//		sm.setValue(7, 1, 2);

		sm.setValue(1, 2, 3);
		sm.setValue(3, 2, 9);
		sm.setValue(7, 2, 8);
		
		sm.setValue(1, 3, 2);
		sm.setValue(5, 3, 7);
//		sm.setValue(4, 3, 6);
		
		sm.setValue(0, 4, 1);
		sm.setValue(2, 4, 7);
		sm.setValue(8, 4, 5);
		
		sm.setValue(0, 5, 8);
		sm.setValue(3, 5, 5);
		sm.setValue(5, 5, 4);
		sm.setValue(7, 5, 6);
		
//		sm.setValue(0, 6, 8);
//		sm.setValue(7, 6, 9);
//		sm.setValue(8, 6, 6);
		
		sm.setValue(0, 7, 6);
		sm.setValue(1, 7, 8);
		sm.setValue(3, 7, 3);
		
		sm.setValue(2, 8, 9);
		sm.setValue(4, 8, 7);
		sm.setValue(6, 8, 5);
		sm.setValue(8, 8, 1);
		System.out.println(sm.printSudoku());
		System.out.println(sm.solveMatrix());
		System.out.println(sm.printSudoku());
	}

}
