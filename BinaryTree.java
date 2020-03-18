/* Universidad del Valle de Guatemala
Maria Isabel Montoya 19169
Hoja de Trabajo No. 7
BinaryTree*/
import java.util.ArrayList; 
import java.util.*; 
import java.util.Collection;

/**
* Codigo extraido de: Duane A. Bailey(18/03/2020)Data Structures in Java for the Principled Programmer. Seventh edition (source code), Williams College
*
*/
public class BinaryTree<E>{
	
	protected E val; // value associated with node
	protected BinaryTree<E> parent; // parent of node
	protected BinaryTree<E> left, right; // children of node
	List<String> lista = new ArrayList<String>();
	
	
	public BinaryTree()
	// post: constructor that generates an empty node
	{
		val = null;
		parent = null; left = right = this;
	}
	
	public BinaryTree(E value)
	// post: returns a tree referencing value and two empty subtrees
	{
		val = value;
		right = left = new BinaryTree<E>();
		setLeft(left);
		setRight(right);
	}
	
	private void setRight(BinaryTree<E> right2) {
		// TODO Auto-generated method stub
		
	}

	public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
	// post: returns a tree referencing value and two subtrees
	{
		val = value;
		if (left == null) { left = new BinaryTree<E>(); }
		setLeft(left);
		if (right == null) { right = new BinaryTree<E>(); }
		setRight(right);
	}
	
	public BinaryTree<E> left()
	// post: returns reference to (possibly empty) left subtree
	{
		return left;
	}
	
	public BinaryTree<E> parent() {
		return null;
	}
	// post: returns reference to parent node, or null
	
	public void setLeft(BinaryTree<E> newLeft)
	// post: sets left subtree to newLeft
	// re-parents newLeft if not null
	{
		if (isEmpty()) return;
		if (left != null && left.parent() == this) left.setParent(null);
		left = newLeft;
		left.setParent(this);
	}
	
	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void setParent(BinaryTree<E> newParent)
	// post: re-parents this node to parent reference, or null
	{
		if (!isEmpty()) {
		parent = newParent;
		}
	}
	/**
	*parametros: Ingles y español, lista de string
	* num, a number that represents the size of the dictionary
	*/
	//crea un mapa con llaves las palabras en ingles y sus valores son su traduccion a español	
	public Map<String,String> asc(ArrayList<String> ingles, ArrayList<String> espanol, int num){
		Map<String, String> myMap = new TreeMap<String, String>();
		for(int i =0; i<num; i++){
			myMap.put(ingles.get(i), espanol.get(i));//Ingresa los valores al mapa
		}
		Set set = myMap.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()){
			Map.Entry me = (Map.Entry)i.next();
		}
		return myMap;
	}
	/**
	* parametros:
	*		- Lista con los valores a traducir
	*		- Mapa con el diccionario
	*/
	public String translation(String[] translateSplit, Map<String, String> asc){
		String translation ="";//Aqui se guardara toda la variable, la oracion traducida
		String support="";
		int size = translateSplit.length;//It has de size of the array that contains the words that we wish to translate
		for(int i=0;i<size;i++){
			//If our map that is our dictionary contains the key we define 'support' as our word in spanish 
			if(asc.containsKey(translateSplit[i])==true) {
				support=asc.get(translateSplit[i]);
			}
			else{
				//If the word is not on our map it means that we dont know the translation so our support will be *word in english*
				support=("*")+translateSplit[i]+("*");
			}
			//we join all of the words that have been translated
			translation= translation + " " + support;
		}
		//we return the translation
		return translation;
	}
}
	