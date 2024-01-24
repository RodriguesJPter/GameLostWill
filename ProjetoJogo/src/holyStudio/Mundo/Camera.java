package holyStudio.Mundo;

public class Camera {

	public static int x,y;


	public static int Clamp (int inicio, int minimo , int maximo) {
		if (inicio < minimo) {
			inicio = minimo;
		}

		if (inicio > maximo) {
			inicio = maximo;
		}

		return inicio;
	}

}
