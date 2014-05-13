package com.example.leagueofcounters;

public class Champion 
{
	public int id;
	
	public String name;
	public String cR;
	
	public String pStyle;
	public String roles;
	
	public String i1;
	public String i1R;
	public String i2;
	public String i2R;
	public String i3;
	public String i3R;
	public String i4;
	public String i4R;
	public String i5;
	public String i5R;
	public String i6;
	public String i6R;
	
	public String str1;
	public String s1R;
	public String str2;
	public String s2R;
	public String str3;
	public String s3R;
	
	public String weak1;
	public String w1R;
	public String weak2;
	public String w2R;
	public String weak3;
	public String w3R;
	
	public double rating;
		
	public Champion(){
		
	}
	
	public Champion(String nm, String cRi, 
			String style, String role, 
			String i1i, String ir1, 
			String i2i, String ir2, 
			String i3i, String ir3, 
			String i4i, String ir4, 
			String i5i, String ir5, 
			String i6i, String ir6, 
			String s1, String sr1,
			String s2, String sr2, 
			String s3, String sr3, 
			String w1, String wr1,
			String w2, String wr2, 
			String w3, String wr3,
			Double rate)
	
	{
		id=0;
		
		name = nm;
		cR = cRi;
		
		pStyle = style;
		roles = role;
		
		i1 = i1i;
		i1R = ir1;
		
		i2 = i2i;
		i2R = ir2;
		
		i3 = i3i;
		i3R = ir3;
		
		i4 = i4i;
		i4R = ir4;
		
		i5 = i5i;
		i5R = ir5;
		
		i6 = i6i;
		i6R = ir6;
		
		str1 = s1;
		s1R = sr1;
		
		str2 = s2;
		s2R = sr2;
		
		str3 = s3;
		s3R = sr3;
		
		weak1 = w1;
		w1R = wr1;
		
		weak2 = w2;
		w2R = wr2;
		
		weak3 = w3;
		w3R = wr3;
		
		rating = rate;
			
	}

}
