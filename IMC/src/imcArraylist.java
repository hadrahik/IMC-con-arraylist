
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class imcArraylist {
	
	String nombre="";
	Double peso, talla, imc;
	int telefono = 0;
	
	ArrayList<String> nombres = new ArrayList<>();
	ArrayList<String> resultado = new ArrayList<>();
	
	public void menu() {
		
		int opcion;
		do {
			
		opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opcion\n" +
		"1 - Agregar pacientes\n" +
		"2 - Consultar paciente\n" + 
		"3 - Eliminacion de registros\n" +
		"4 - Actualizar registros\n" +
		"5 - Imprimir resultados\n"+
		"6 - salir\n"));
		
		switch (opcion) {
		case 1:
			registros();
			break;
			
		case 2:
			consultarNombre();
			break;
			
		case 3: 
			eliminacion();
			break;
			
		case 4:
			actualizarNombre();
			break;
			
		case 5: 
			imprimirResultados();
			break;
		case 6:
			JOptionPane.showInternalMessageDialog(null, 
					"-----------------------------------------------\n"+
					"Que tenga un buen dia,\n"+
					"gracias por confiar en nosotros\n"+
					"-----------------------------------------------"
					);
			break;
		default:
			JOptionPane.showInternalMessageDialog(null, 
					"-----------------------------------------------\n"+
					"por favor ingrse un numero del 1 al 6 \n"+
					"-----------------------------------------------"
					);
			break;
		}
		
		} while (opcion != 6);
		
	}
	
	



	public void registros() {
		
		String nuevoPaciente ="";
		
		do {
			
			nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente");
			nombres.add(nombre);
			peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese peso del paciente"));
			talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese estatura del paciente"));
			porcentajeIMC();
			
			nuevoPaciente = JOptionPane.showInputDialog("¿Desea agregar un nuevo paciente?\n " + "Ingrese si para seguir\n");
			
		} while (nuevoPaciente.equalsIgnoreCase("si"));
		
	}
	
	
	public void consultarNombre() {
		
		String consulta = JOptionPane.showInputDialog("Ingrese el nombre del paciente a consultar");
		
		if(nombres.contains(consulta)) {
			
		for (int i = 0; i < nombres.size(); i++) {
			
			if(nombres.get(i).equalsIgnoreCase(consulta)) {
				JOptionPane.showInternalMessageDialog(null,consulta + 
						" si existe en el sistema\n"+
				"Y tiene como resultado = "+resultado.get(i));
				}
			}
		}else {
			JOptionPane.showInternalMessageDialog(null,"El paciente "+consulta+ " no existe" );
		}
	}
	
	public void eliminacion(){
		
		JOptionPane.showInternalMessageDialog(null,"Usuarios en sistema: " + nombres);
		String consulta = JOptionPane.showInputDialog("Ingrese el nombre del paciente a eliminar");
		
		if(nombres.contains(consulta)) {
			for (int i = 0; i < nombres.size(); i++) {
				if(nombres.get(i).equalsIgnoreCase(consulta)) {
					nombres.remove(consulta);
					JOptionPane.showInternalMessageDialog(null,"El paciente ha sido eliminado del sistema" + nombres);
				}			
			}
		}else {	
			JOptionPane.showInternalMessageDialog(null,"El paciente no existe");		
		}
	}
	
	
	
	
	
	public void porcentajeIMC() {
		imc= 0.0;
		imc=peso/(talla*talla);
		
		String result="";
		
		if (imc<18) {
			result=("Anorexia");
		}else if (imc>=18 && imc <20) {
			result=("Delgadez");
		}else if (imc>=20 && imc <27) {
			result=("Normalidad");
		}else if (imc>=27 && imc <30) {
			result=("Obesidad 1");
		}else if (imc>=30 && imc <35) {
			result=("Obesidad 2");
		}else if (imc>=35 && imc <40) {
			result=("Obesidad 3");
		}else if (imc>=40) {
			result=("Obesidad Morbida");
		}
		
		resultado.add(result);
		JOptionPane.showInternalMessageDialog(null,"El Resultado es: "+result);
		}
	
	
	private void imprimirResultados() {
		if (nombres.isEmpty()) {
	        JOptionPane.showInternalMessageDialog(null, "No hay resultados disponibles");
	    } else {
	    	for (int i = 0; i < nombres.size(); i++) {
				JOptionPane.showInternalMessageDialog(null,"********RESULTADOS**********\n"+
				nombres.get(i)+", resultado: "+resultado.get(i)+"\n"+
						"*****************************");
			}
	    }
	}
		
	public void actualizarNombre() {
		
		JOptionPane.showInternalMessageDialog(null,"Usuarios en sistema: " + nombres);
		
		String paciente = JOptionPane.showInputDialog("Ingrese el nombre del paciente que desea actualizar");
			
		
		
		if (nombres.contains(paciente)) {
			for (int i = 0; i < nombres.size(); i++) {
				if (nombres.get(i).equalsIgnoreCase(paciente)) {
					nombres.remove(paciente);
					nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente actualizado");
					nombres.add(nombre);
					JOptionPane.showInternalMessageDialog(null,"El paciente ha sido actualizado correctamente");
				}
				
			}
		}else {
			JOptionPane.showInternalMessageDialog(null,"El paciente no existe en el sistema");
		}
	}
	
}
