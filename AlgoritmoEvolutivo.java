import java.util.*;


class Horario{
	private String salon;
	private Profesor profesor;
	private int horas;
	
	public Horario(String salonArg, Profesor profesorArg, int horasArgs){
		this.salon=salonArg;
		this.profesorArg=profesorArg;
		this.horas=horasArgs;
	}
	public String getSalon(){
		return this.salon;
	}
	public Profesor getProfesor(){
		return this.profesores;
	}
	public int getHoras(){
		return this.horas;
	}
}

class Profesor{
	private String nombre;
	private int prioridad;
	
	public Profesor(String argNombre, int argPrioridad){
		this.nombre=argNombre;
		this.prioridad=argPrioridad;
	}
	public int getPrioridad(){
		return this.prioridad;
	}
	public String getNombre(){
		return this.nombre;
	}
}

public class AlgoritmoEvolutivo {
	private List<Horario> muestra;
	private int tamanoMuestra;
	private int numeroGeneracion;
	
	public AlgoritmoEvolutivo(int tamanoMuestra, int numeroGeneracion) {
		this.tamanoMuestra= tamanoMuestra;
		this.numeroGeneracion = numeroGeneracion;
		this.muestra = new ArrayList<>();
	}
	public void ejecutar() {
		inicializarMuestra();
		for (int i = 0; i < numeroGeneracion; i++) {
			List<Horario> seleccionados = seleccionar();
			List<Horario> nodo = cruzar(seleccionados);
			mutar(nodo);
			reemplazarMuestra(nodo);
		}
		Horario mejorHorario = getMejorHorario();
		// Imprimir el mejor horario
		System.out.println("Mejor horario: " + mejorHorario);
	}
	private void inicializarMuestra() {
		for (int i = 0; i < tamanoMuestra; i++) {
			Horario horario = new Horario(); // Generar un horario aleatorio
			muestra.add(horario);
		}
	}
	private List<Horario> seleccionar() {
		// Implementar horarios basada en aptitud
	}
	private List<Horario> cruzar(List<Horario> seleccionados) {
		List<Horario> nodo = new ArrayList<>();
		System.out.println("AQUI CRUZAMOS NODOS");
		return nodo;
	}
	private void mutar(List<Horario> nodo) {
		System.out.println("AQUI MUTAR");
	}
	private void reemplazarMuestra(List<Horario> nodo) {
		// Reemplazar la población actual con los hijos
		muestra.clear();
		muestra.addAll(nodo);
	}
	private Horario getMejorHorario() {
		// obtención del mejor horario
		System.out.println("MEJOR-HORARIO");
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Tamaño de la muestra: ");
		int tam = scanner.nextInt();
		
		System.out.println("Numero de generaciones: ");
		int gen = scanner.nextInt();
		
		AlgoritmoEvolutivo(tam, gen);
		ejecutar();
	
	}
}