import java.util.*;


class Horario{
	private String salon;
	private Profesor profesor;
	private int horas;
	private String materia;
	
	public Horario(String salonArg, Profesor profesorArg, int horasArgs, String materiaArg){
		this.salon=salonArg;
		this.profesor=profesorArg;
		this.horas=horasArgs;
		this.materia=materiaArg;
	}
	
	public String getMateria(){
		return this.materia;
	}
	
	public String getSalon(){
		return this.salon;
	}
	public Profesor getProfesor(){
		return this.profesor;
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
			System.out.println("Miku");
		}
		//Horario mejorHorario = getMejorHorario();
		// Imprimir el mejor horario
		//System.out.println("Mejor horario: " + mejorHorario);
	}
	/*public Horario getMejorHorario(){
		return this.muestra[0];
	}
	*/
	
	private void inicializarMuestra() {
		Profesor p;
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < tamanoMuestra; i++) {
			
			System.out.println("Salon: ");
			String salon = scanner.nextLine();
			
			System.out.println("Nombre Profesor: ");
			String nombre = scanner.nextLine();
			
			System.out.println("Prioridad: ");
			int prioridad = scanner.nextInt();
			
			p = new Profesor(nombre, prioridad);
			
			System.out.println("Horas: ");
			int horas = scanner.nextInt();
			
			System.out.println("Materia: ");
			String materia = scanner.nextLine();
			
			Horario horario = new Horario(salon, p, horas, materia); // Generar un horario aleatorio
			muestra.add(horario);
		}
	}
	
	private List<Horario> seleccionar() {
		// Implementar horarios basada en aptitud
		Random rand = new Random();
		List<Horario> seleccionados = new ArrayList();
		
		for(int i=0; i<tamanoMuestra; i++){
			if(rand.nextInt(2) == 1){
				seleccionados.add(this.muestra[i]);
			}
		}
		
		return seleccionados;
		
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
	/*
	private Horario getMejorHorario() {
		// obtención del mejor horario
		System.out.println("MEJOR-HORARIO");
	}
	*/
	public static void main(String[] args){
		
		AlgoritmoEvolutivo aev;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Tamaño de la muestra: ");
		int tam = scanner.nextInt();
		
		System.out.println("Numero de generaciones: ");
		int gen = scanner.nextInt();
		
		aev = new AlgoritmoEvolutivo(tam, gen);
		aev.ejecutar();
	
	}
}