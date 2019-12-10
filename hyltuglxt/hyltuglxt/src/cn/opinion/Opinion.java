package cn.opinion;

public class Opinion {
	public static boolean sky(String in) {
		if(in.equals(""))
		return true;
		else
		return false;
	}
	public static boolean sky(int in) {
		if(String.valueOf(in).equals(""))
		return true;
		else
		return false;
	}
	public static boolean low(String in) {
		if(in!=null&&!"".equals(in.trim()))
		return true;
		else
		return false;
	}
	public static boolean low(int in) {
		String str = String.valueOf(in);
		if(str!=null&&!"".equals(str.trim()))
		return true;
		else
		return false;
	}
	
}
