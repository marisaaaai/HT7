/* Universidad del Valle de Guatemala
Maria Isabel Montoya 19169
Hoja de Trabajo No. 7
Main*/
/**
* This program translates a text that the user creates from english to spanish, using associations from words on another text that the user created
in ordeer to do a binary search and be able to translate every single word
*/
//Se importan los paquetes necesarios 
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.*; 
import java.util.Collection;
public class main{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	//We create the hashtable that will help with the associations needed for the dictionary
		Map<String,String> associations = new TreeMap<String,String>();
		//In here we will keep the keys of our map that we will create
		ArrayList<String> ingles = new ArrayList<String>();
		//In here we will keep the values of our map that we will create
		ArrayList<String> espanol = new ArrayList<String>();	
		//We instance our binaryTree to do the search on our dictionary
		BinaryTree myTree = new BinaryTree();
		//we begin readig the different files needed
		File dictxt = new File("diccionario.txt");
		File texttxt = new File("texto.txt");
		String linea ="";
		Scanner s = null;
		Scanner s1 = null;
		ArrayList<String> words = new ArrayList<String>();
		try{
			//we begin by reading our dictionary
			s = new Scanner(dictxt);
			int num = 0;
			while(s.hasNextLine()){
				linea = s.nextLine();
				//we remove all the parethesis
				linea = linea.replaceAll("\\(","");
				linea = linea.replaceAll("\\)","");
				String[] lector = linea.split(",");//we split the string in order to have [englis,spanish on our new arraylist]
				//we add the elemnts of our array into our words arraylist
				ingles.add(lector[0]);
				espanol.add(lector[1]);
				num++;
			}
			s.close();//we close the file
			s1= new Scanner(texttxt);//we read the text to translate
			String translate1 = s1.nextLine();
			String translate=translate1.toLowerCase();//we change every word to a lower case in order to not hace errors
			String[] translateSplit = translate.split(" ");
			//we create our map from the binarytree
			associations = myTree.asc(ingles,espanol,num);
			//We create a variable with the translation that has been made
			String translation = myTree.translation(translateSplit,associations);
			System.out.println("************************************************");
			System.out.println("Lo que usted ingreso para traducir: ");
			System.out.println(translate1);
			System.out.println();
			System.out.println("Traducido:");
			System.out.println(translation);
			System.out.println();
			System.out.println("Recorrido en orden del arbol (diccionario usado): ");
			System.out.println(associations);
			System.out.println();
			System.out.println("Gracias por usar nuestro programa");
			System.out.println("************************************************");
		}
		catch(Exception ex){
			System.out.println("Mensaje de error: "+ex);
		}
	}
}