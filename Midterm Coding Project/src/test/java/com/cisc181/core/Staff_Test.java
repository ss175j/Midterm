package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cisc181.eNums.eTitle;


public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void test() throws PersonException{
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		Calendar date = Calendar.getInstance();
		date.set(1980, 1, 1);
		Staff s1 = new Staff("Jie", "L", "Li", date.getTime(),
				"address1", "(111)-111-1111", "email1", "", 1, 6000, null,
				eTitle.MRS);
		Staff s2 = new Staff("Zhen", "Yi", "Li", date.getTime(),
				"address2", "(123)-456-789", "email2", "", 2, 6100, null,
				eTitle.MS);
		Staff s3 = new Staff("Xing", "MU", "Cheng", date.getTime(),
				"address3", "(999)-999-9999", "email3", "", 3, 6200, null,
				eTitle.MR);
		Staff s4 = new Staff("Wei", "Jia", "Shi", date.getTime(),
				"address4", "(777)-777-7777", "email4", "", 4, 6300, null,
				eTitle.MR);
		Staff s5 = new Staff("Sheng", "zi", "Zhong", date.getTime(),
				"address5", "(000)-000-0000", "email5", "", 5, 6400, null,
				eTitle.MS);
		staffs.add(s1);
		staffs.add(s2);
		staffs.add(s3);
		staffs.add(s4);
		staffs.add(s5);
		double sum = 0;
		for (Staff staff : staffs) {
			sum += staff.getSalary();
		}
		// Test equal
		assertEquals(6200, sum / 5, 0);
	}


}
