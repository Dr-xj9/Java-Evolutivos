import java.util.*;

class Horario {
    private String salon;
    private Profesor profesor;
    private int horas;
    private String materia;

    public Horario(String salonArg, Profesor profesorArg, int horasArgs, String materiaArg) {
        this.salon = salonArg;
        this.profesor = profesorArg;
        this.horas = horasArgs;
        this.materia = materiaArg;
    }

    public String getMateria() {
        return this.materia;
    }

    public String getSalon() {
        return this.salon;
    }

    public Profesor getProfesor() {
        return this.profesor;
    }

    public int getHoras() {
        return this.horas;
    }

    @Override
    public String toString() {
        return "Materia: " + materia + ", Salon: " + salon + ", Profesor: " + profesor.getNombre() + ", Horas: " + horas;
    }
}

class Profesor {
    private String nombre;
    private int prioridad;

    public Profesor(String argNombre, int argPrioridad) {
        this.nombre = argNombre;
        this.prioridad = argPrioridad;
    }

    public int getPrioridad() {
        return this.prioridad;
    }

    public String getNombre() {
        return this.nombre;
    }
}

public class AlgoritmoEvolutivo{
    private List<Horario> muestra;
    private int tamanoMuestra;
    private int numeroGeneracion;

    public AlgoritmoEvolutivo(int tamanoMuestra, int numeroGeneracion) {
        this.tamanoMuestra = tamanoMuestra;
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
        System.out.println("Mejor horario: " + mejorHorario);
    }

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
            scanner.nextLine(); // Limpiar el buffer
            System.out.println("Materia: ");
            String materia = scanner.nextLine();
            Horario horario = new Horario(salon, p, horas, materia);
            muestra.add(horario);
        }
    }

    private List<Horario> seleccionar() {
        Random rand = new Random();
        List<Horario> seleccionados = new ArrayList<>();
        for (int i = 0; i < tamanoMuestra; i++) {
            if (rand.nextInt(2) == 1) {
                seleccionados.add(this.muestra.get(i));
            }
        }
        return seleccionados;
    }

    private List<Horario> cruzar(List<Horario> seleccionados) {
        List<Horario> nodo = new ArrayList<>();
        for (int i = 0; i < seleccionados.size(); i += 2) {
            if (i + 1 < seleccionados.size()) {
                // Cruzar dos horarios seleccionados
                Horario padre1 = seleccionados.get(i);
                Horario padre2 = seleccionados.get(i + 1);
                // Crear nuevos horarios combinando propiedades de los padres
                Horario hijo = new Horario(
                        padre1.getSalon(),
                        padre1.getProfesor(), // Puedes decidir aleatoriamente o basado en prioridad
                        (padre1.getHoras() + padre2.getHoras()) / 2, // Promedio de horas
                        padre1.getMateria() // Puedes decidir aleatoriamente
                );
                nodo.add(hijo);
            }
        }
        return nodo;
    }

    private void mutar(List<Horario> nodo) {
        Random rand = new Random();
        for (Horario horario : nodo) {
            if (rand.nextInt(10) < 2) { // 20% de probabilidad de mutación
                // Cambiar aleatoriamente la materia o el salón
                horario = new Horario(
                        "NuevoSalon" + rand.nextInt(100), // Cambia a un nuevo salón
                        horario.getProfesor(),
                        horario.getHoras(),
                        "NuevaMateria" + rand.nextInt(100) // Cambia a una nueva materia
                );
            }
        }
    }

    private void reemplazarMuestra(List<Horario> nodo) {
        muestra.clear();
        muestra.addAll(nodo);
    }

    private Horario getMejorHorario() {
        // Obtención del mejor horario (puedes implementar una lógica más compleja)
        return muestra.stream()
                .max(Comparator.comparingInt(h -> h.getProfesor().getPrioridad()))
                .orElse(null);
    }
	
    public static void main(String[] args) {
        AlgoritmoEvolutivo aev;
		Interfaz i = new Interfaz();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tamaño de la muestra: ");
        int tam = scanner.nextInt();
        System.out.println("Numero de generaciones: ");
        int gen = scanner.nextInt();
        aev = new AlgoritmoEvolutivo(tam, gen);
        aev.ejecutar();
    }	
}
