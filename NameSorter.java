/*Andrew id:jinghuah  name:Jinghua Huang*/

package lab1;

import java.util.Arrays;
import java.util.Scanner;

/**NameSorter class takes n number of names in the form of string inputs 
 * from the user. It then asks user for which name to search for. 
 * It sorts the names entered by the user, and then prints the 
 * position of the search-name in the sorted list of the names, 
 * if it is found.
 */

public class NameSorter {
	Scanner input = new Scanner(System.in);
	
	/**getNameInputs takes an int parameter n and creates an array of size n. 
	 * It then asks user to Enter n names that get stored in the array. 
	 * It uses the helper method toTitleCase() to convert all names to Title case. 
	 * It returns the array filled with names entered by the user.
	 */
	String[] getNameInputs(int n) {
		//write your code here
		String[] str = new String[n];
		input.nextLine();//当输入3，按下回车，next()只保留了3，并没有保留回车
		for(int i =0; i<n;i++) {
			System.out.println("Enter name"+ " "+(i+1));//如果没有上面的input.nextLine(),那么str[0]=回车，str[1]时才让你输入
			str[i]=input.nextLine();//还有一种办法，就是这里直接写成input.next()
			str[i]=toTitleCase(str[i]);//注意，直接写成toTitleCase是不可以的，因为str[i]还是没有
		}
	
		return str;
	}
	
	/**toTitleCase() takes one string argument as name and returns the string in title case. 
	 * If the name is null or the string is empty, it returns null.
	 */
	String toTitleCase(String name) {
		//write your code here
		if(name==null || name.isEmpty()) return null;
		/*char first = name.charAt(0);
		name = name.substring(1, name.length());
		name = name.toLowerCase();
		if(first>='a' && first<='z') 
			first = Character.toUpperCase(first);
		name = first+name;*/
		name = name.toLowerCase();
		char[] ch = name.toCharArray();//虽然不能改变String里面的任何一个字符，
		                              //但是可以用toCharArray 这个函数把name拆分掉变为字符数组，这个时候就可以改变其中的一个值了
		if(ch[0]>='a'&&ch[0]<='z')
			ch[0]=Character.toUpperCase(ch[0]);
		
		name=new String(ch);//再把这个数组还回去
		return name;
	}

	/**sortAndSearch() takes two arguments. The first is an array of strings and the second
	 * is a searchString. The method first sorts the array in increasing alphabetical order, 
	 * and prints it in that order.
	 * It then searches for the searchString in a case-insensitive way. If the searchString is found,
	 * it returns the position of the searchString according to the sorted list. 
	 * If it is not found, then it returns -1.
	 */
	int sortAndsearch(String[] strings, String searchString) {
		//write your code here
		System.out.println("*** names in sorted***");
		if(strings==null) return -1;	
		
		Arrays.sort(strings);
		int position=-1;
		for(int i=0;i<strings.length;i++) {
			System.out.println((i+1)+". "+strings[i]);
			if(strings[i].equalsIgnoreCase(searchString)) 
				position = i;
		}
		
		return position;
	}

	/**DO NOT CHANGE THIS METHOD */
	public static void main(String[] args) {
		NameSorter ns = new NameSorter();
		System.out.println("*** How many names to store? ***");
		int n = ns.input.nextInt();
		if (n > 0) {
			String[] names = ns.getNameInputs(n);
			
			System.out.println("*** Enter the name to search ***");
			String name = ns.input.next();
			
			int position = ns.sortAndsearch(names, name);
			
			if (position >=0 ) System.out.println(name + " found at position " + (position+1));
			
			else System.out.println("Sorry! " + name + " not found!");
			
		} else System.out.println("Good Bye!");
	}
}
