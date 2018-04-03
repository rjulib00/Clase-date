/**
 *
 * @author Rodri Feles
 */
public class main {
    public static void main(String [] args)
	{
		Date fechaEjemplo = new Date(3, 4, 2018);
                if(fechaEjemplo.isSameYear(2017))
                    System.out.println("Es el mismo año");
                else
                    System.out.println("No es el mismo año");
                System.out.println(fechaEjemplo.queMesEs());
                if(fechaEjemplo.diasValidos()){
                    System.out.println("Los dias introducidos, para este mes, son validos");
                    fechaEjemplo.estacion();
                    fechaEjemplo.mesesRestantes();
                    fechaEjemplo.imprimerFechaSimple();
                    fechaEjemplo.imprimerFechaExtensa();
                    fechaEjemplo.hastaFinMes();
                    //System.out.println("Meses parecidos: ");
                    fechaEjemplo.mesesParecidos();
                    //System.out.println("fin meses parecidos");
                    System.out.println(fechaEjemplo.diasPasados());
                    System.out.println(fechaEjemplo.fechaRandomDoWhile());

                    if(fechaEjemplo.isSameDayIf(11, 3, 2018))
                        System.out.println("Es el mismo dia");
                    else
                        System.out.println("No es el mismo dia");

                    Date fechaAux = new Date(3, 1, 2018);
                    if(fechaEjemplo.isSame(fechaAux))
                        System.out.println("Es la misma fecha");
                    else
                        System.out.println("No es la misma fecha");
                    System.out.println(fechaEjemplo.calcularDiaSemana());
                    //System.out.println(fechaEjemplo.calcularDiaSemana(fechaEjemplo.getDay(), fechaEjemplo.getMonth(), fechaEjemplo.getYear()));
                }
                else
                    System.out.println("Los dias introducidos, para este mes, no son validos");
                
	}
}
