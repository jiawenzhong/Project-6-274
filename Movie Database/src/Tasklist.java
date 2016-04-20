import java.io.*;
import java.util.*;
/**
 * 
 * @author jiawen
 *
 */
public class Tasklist {

	public static void main(String[] args) {
		//construct a new BST to store movies
		BST movieList = new BST ();
		
		Scanner input = new Scanner(System.in);

		//read in the information from the file
		try {
			Scanner read = new Scanner (new File ("movies.txt"));
			do{
				ArrayList <String> names = new ArrayList <String> ();
				String data = read.nextLine();
				String [] separate = data.split("/");
				String title = separate[0];
				//System.out.println(title);
				int year = Integer.parseInt(separate[1]);
				//System.out.println(year);
				String rating = separate[2];
				int length = Integer.parseInt(separate[3]);
				double starsR = Double.parseDouble(separate[4]);
				String actors = separate[5];
				//add the actors' name into the arraylist
				String [] sepActors = actors.split(",");
				for (int i = 0; i < sepActors.length; i ++) {
					names.add(sepActors [i]);
				}

				movieList.add(new Movies(title, year, rating, length, starsR, names));
				//System.out.println("actors: " + names);
			} while (read.hasNextLine());

		} catch (FileNotFoundException n) {}

		// TODO Auto-generated method stub
		boolean done = false;
		int menuInput = 0;
		while(!done) {
			menu();
			menuInput = CheckInput.checkInt(1, 7);
			switch(menuInput){
			case 1://add a new movie
				ArrayList <String> names = new ArrayList <String> ();
				System.out.println("Please enter the title");
				String title = input.nextLine();
				System.out.println("Please enter the release year");
				int year = CheckInput.checkInt(1000, 2016);
				System.out.println("Please enter the rating");
				String rating = input.nextLine();
				System.out.println("Please enter the length of the movie");
				int length = CheckInput.checkInt();
				System.out.println("Please enter the audience rating");
				int starsR = CheckInput.checkInt(1, 10);
				System.out.println("Please enter the actors of the movie");
				System.out.println("Follow this format: name,name");
				System.out.println("If you don't remember the actor, press space and enter");
				String actors = input.nextLine();
				if (!actors.isEmpty()) {
					String [] sepActors = actors.split(",");
					for (int i = 0; i < sepActors.length; i ++) {
						names.add(sepActors [i]);
					}
				}
				movieList.add(new Movies(title, year, rating, length, starsR, names));
				
				break;

			case 2: //delete movie
				System.out.println("Please enter the movie you would like to delete.");
				String movieTitle = input.nextLine();
				movieList.remove(movieTitle);
				break;

			case 3://add actor to movie
				System.out.println("Please enter the movie that you would like to edit");
				String movieName = input.nextLine().trim();
				Movies movie = new Movies(movieName, 0, null, 0, 0.0, null);
				Node found = new Node (movieList.search(movie).getMovie());
				System.out.println(movieList.search(movie).getMovie());
				System.out.println("Please enter the names of the actors");
				System.out.println("Please follow this format: fn ln, fn ln");
				String actorNames = input.nextLine();
				found.getMovie().addActors(actorNames);
				System.out.println(found.getMovie());
				
				
				break;

			case 4: //delete actor from movie
				System.out.println("Please enter the movie that you would like to edit");
				String movieName2 = input.nextLine().trim();
				Movies movie2 = new Movies(movieName2, 0, null, 0, 0.0, null);
				Node found2= new Node (movieList.search(movie2).getMovie());
				System.out.println(movieList.search(movie2).getMovie());
				System.out.println("Please enter the names of the actors");
				System.out.println("Please follow this format: fn ln, fn ln");
				String actorNames2 = input.nextLine();
				found2.getMovie().removeActors(actorNames2);
				System.out.println(found2.getMovie());
				
				break;

			case 5://display all movie
				movieList.printBST();

				break;

			case 6://find movies
				break;

			case 7: //Quit the program
				movieList.writeToFile();
				System.out.println("Game end");
				done = true;
				break;
			default:System.out.println("Please enter a number according to the menu.");
			break;
			}
		}

	}

	/**
	 * display  menu
	 */
	public static void menu () {
		System.out.println("");
		System.out.println("1. Add a new movie");
		System.out.println("2. Delete a movie");
		System.out.println("3. Add actors to a movie");
		System.out.println("4. Delete actors from a movie");
		System.out.println("5. Display all movies.");
		System.out.println("6. Find movies");
		System.out.println("7. Quit");
	}

//	/**
//	 * Write the movies back to the file
//	 * @param data		the data stored in the BST
//	 */
//	public static void writeToFile(BST data) {
//		Scanner read = new Scanner (System.in);
//		try{
//			PrintWriter writer = new PrintWriter("movies.txt");
//			if (data. != null) {
//				this.getLeft().write(out);
//				out.write(this.data());
//				if (this.getRight() != null) this.getRight().write(out);
//				writer.close();
//			}catch (FileNotFoundException a){
//				System.out.println("File was not found");
//			}
//		}
//
//	}
}
