package testing;

public class NameString {
	public static void main(String[] args) {
		System.out.println("Ari" == "ari");
		System.out.println(new String("Ari") == new String("Ari"));
		System.out.println(new String("Ari").equals(new String("Ari")));
	}
}
