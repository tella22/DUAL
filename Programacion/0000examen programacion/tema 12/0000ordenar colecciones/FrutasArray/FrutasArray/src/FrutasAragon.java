import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class FrutasAragon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruit[] fruits = new Fruit[4];

		fruits[0] = (new Fruit("Pineapple", "  ", 3));
		fruits[1] = (new Fruit("Apple", "  ", 5));
		fruits[2] = (new Fruit("Orange", "  ", 10));
		fruits[3] = (new Fruit("Banana", "  ", 34));

		Arrays.sort(fruits);

		int i=0;
		for(Fruit temp: fruits){
			System.out.println("fruits " + ++i + " : " + temp.toString());
		}

		System.out.println("\nUtilizamos Comparator\n");
		Arrays.sort(fruits, FruitNameComparator);
		
		i=0;
		for(Fruit temp: fruits){
			System.out.println("fruits " + ++i + " : " + temp.getFruitName() 
								+ ", Quantity : " + temp.getQuantity());
		}

	}
	
	public static Comparator<Fruit> FruitNameComparator = new Comparator<Fruit>() {

	    public int compare(Fruit fruit1, Fruit fruit2) {

	      String fruitName1 = fruit1.getFruitName().toUpperCase();
	      String fruitName2 = fruit2.getFruitName().toUpperCase();

	      //ascending order
	      return fruitName1.compareTo(fruitName2);

	      //descending order
	      //return fruitName2.compareTo(fruitName1);
	    }

	};

}
