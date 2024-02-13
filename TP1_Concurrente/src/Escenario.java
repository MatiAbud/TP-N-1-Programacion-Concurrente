
public class Escenario {
	private static Integer N=6;
	public static void main(String[] args) {
		
		//////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////GRANULARIDAD FINA/////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
		/*
		for(int i=0; i<N;i++) {
			System.out.println(i%(N/2));
		}*/
		long inicio;
		long fin;
		inicio= System.nanoTime();
		ListaEnlazada l= new ListaEnlazada();
		for(int i=0; i<(N/2)+1;i++) {
			new Thread(new HiloA(i,l,1)).start(); 
		}
		for(int i=0; i<(N/2)-1;i++) {
			new Thread(new HiloB(i,l,1)).start(); 
		}
		//PAUSA PARA QUE TODOS LOS HILOS TERMINEN DE EJECUTAR
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//VERIFICACION DE NODOS EN LA LISTA, LOS VALORES NULL SON LAS BANDERAS 
		l.imprimir();
		fin=System.nanoTime();
		long total=fin-inicio;
		System.out.println("Sincronizacion de granularidad fina: "+ total +" ns");
		
		
		//////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////SINCRONIZACIÓN OPTIMISTA/////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
		
		inicio= System.nanoTime();
		ListaEnlazada l2= new ListaEnlazada();
		for(int i=0; i<(N/2)+1;i++) {
			new Thread(new HiloA(i,l2,2)).start(); 
		}
		for(int i=0; i<(N/2)-1;i++) {
			new Thread(new HiloB(i,l2,2)).start(); 
		}
		//PAUSA PARA QUE TODOS LOS HILOS TERMINEN DE EJECUTAR
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//VERIFICACION DE NODOS EN LA LISTA, LOS VALORES NULL SON LAS BANDERAS 
		l2.imprimir();
		fin=System.nanoTime();
		total=fin-inicio;
		System.out.println("Sincronizacion optimista: "+ total +" ns");
	
		//////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////SIN LOCKS/////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
		
		inicio= System.nanoTime();
		ListaEnlazada l3= new ListaEnlazada();
		for(int i=0; i<(N/2)+1;i++) {
			new Thread(new HiloA(i,l3,3)).start(); 
		}
		for(int i=0; i<(N/2)-1;i++) {
			new Thread(new HiloB(i,l3,3)).start(); 
		}
		//PAUSA PARA QUE TODOS LOS HILOS TERMINEN DE EJECUTAR
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//VERIFICACION DE NODOS EN LA LISTA, LOS VALORES NULL SON LAS BANDERAS 
		l3.imprimir();
		fin=System.nanoTime();
		total=fin-inicio;
		System.out.println("Sin locks: "+ total +" ns");	
	
	
	}
	
	}


