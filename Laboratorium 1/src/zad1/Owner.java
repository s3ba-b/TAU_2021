package zad1;

import java.lang.UnsupportedOperationException;

public class Owner {
	private String _Name;
	private String _Surname;
	
	public Owner(String Name, String surname) {
		_Name = Name;
		_Surname = surname;
	}
	
	public String Name() {
		return _Name;
	}
	
	public String Surname() {
		return _Surname;
	}
	
	public void NotImplementedMethod() {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
}
