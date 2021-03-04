import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Read1 {
	Stack<CharSequence> brackets = new Stack<CharSequence>();
	Scanner scan = new Scanner(System.in);
	String opens = "{[(<";
	String close = "}])>";
	Map<CharSequence, CharSequence> match = new HashMap<CharSequence, CharSequence>();
boolean k= true;
	public Read1() {

	
		match.put("}", "{");
		match.put(")", "(");
		match.put("]", "[");
		match.put(">", "<");
		while(k) {
		CharSequence ch = ReadInput();
		AddOrRemove(ch);
System.out.println(brackets);
	}}

	public CharSequence ReadInput() {
		CharSequence str = scan.next();
		//char c1 = str.charAt(0);
		return str;
	}

	public void AddOrRemove(CharSequence ch) {
		if(opens.contains(ch)) {
			brackets.push(ch);
			
		}
		else if (close.contains(ch)) {
			CharSequence ch1 =  brackets.peek();
			CharSequence ch2 = match.get(ch1);
			System.out.println(ch+","+ch1+","+ch2);
			if(ch2 == ch) {
				brackets.pop();
			}
			else
				System.out.println("Error: clossing bracket "+ch+" doesnot match with "+ch1);
		}
		else System.out.println("Error: invalid Character");
		
	}

	public static void main(String[] args) {
		new Read1();

	}

}
