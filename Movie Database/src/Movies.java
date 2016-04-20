import java.util.*;
public class Movies {

	private String title;
	private String rating;
	private int year;
	private int length;
	private double starsRating;
	//ArrayList <String> actors = new ArrayList <String> ();
	 ArrayList <String> actors = new ArrayList <String>();
	
	public Movies (String t, int y, String r, int len, double sR, ArrayList<String> names) {
		title = t;
		year = y;
		rating = r;
		length = len;
		starsRating = sR;
		actors = names;
		
	}
	
	public String getTitle () {
		return title;
	}
	
	public void setTitle (String t) {
		title = t;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setRating (String r) {
		rating = r;
	}
	
	public int getYear () {
		return year;
	}
	
	public void setYear (int y) {
		year = y;
	}
	
	public int getLength () {
		return length;
	}
	
	public void setLenth (int l) {
		length = l;
	}
	
	public double getSR () {
		return starsRating;
	}
	
	public void setSR (double sr) {
		starsRating = sr;
	}
	
	public String getActors () {
		String a = "";
		for (int i = 0; i < actors.size(); i ++) {
			a = "-" + a +actors.get(i) + "-";
		}
		return a;
	}
	
	public void addActors (String name) {
		actors.add(name);
	}
	
	public void removeActors (String name) {
		actors.remove(name);
	}
	@Override
	public String toString () {
		String s = "";
		return s = "Title: " + title + "\nRating: " + rating + "\nRelease Year: " + year
				+ "\nLength: " + length + "\nAudience Rating: " + starsRating
				+ "\nActors: " + getActors() + "\n" + "\n";
	}
	
	/**
	 * Compare the implicit variable to the explicit variable
	 * @param w		the explicit variable that is being compare with
	 * @return		an integer, 0 for equal, negative if two are in order, and positive is they are out of order
	 */
	public int compareTo(Movies s){
		//String compare = s;
		int result = this.title.compareToIgnoreCase(s.getTitle());
		
		return result;
	}
	
//	public int compareTo(String s){
//		//String compare = s;
//		int result = this.title.compareToIgnoreCase(s);
//		
//		return result;
//	}
}
