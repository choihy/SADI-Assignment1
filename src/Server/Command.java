package Server;

public class Command
{
	// login
	public static final int nameTaken = 1001;
	public static final int connectFail = 1002;
	public static final int connectSuccess = 1003;
	// game 
	public static final int call = 2001;
	public static final int pass = 2002;
	public static final int win = 2003;
	public static final int lose = 2004;
	public static final int start = 2005;
	// menu
	public static final int join = 2006;
	public static final int observe = 2007;
	public static final int create = 2008;
	public static final int send = 2009;
	// character
	public static final int observer = 3000;
	public static final int player1 = 3001;
	public static final int player2 = 3002;
	
	public static final int stop = 9999;
}
